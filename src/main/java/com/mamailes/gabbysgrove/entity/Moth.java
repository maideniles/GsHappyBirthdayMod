package com.mamailes.gabbysgrove.entity;

import com.mamailes.gabbysgrove.init.GGEntities;
import com.mamailes.gabbysgrove.init.GGEntityDataSerializers;
import com.mamailes.gabbysgrove.init.GGMothVariants;
import com.mamailes.gabbysgrove.init.GGTags;
import com.mamailes.gabbysgrove.mixin.LivingEntityAccessor;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.RegistryAccess;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.DamageTypeTags;
import net.minecraft.util.Mth;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.BodyRotationControl;
import net.minecraft.world.entity.ai.control.LookControl;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.navigation.FlyingPathNavigation;
import net.minecraft.world.entity.ai.navigation.GroundPathNavigation;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.animal.FlyingAnimal;
import net.minecraft.world.entity.animal.horse.AbstractHorse;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.event.EventHooks;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animation.AnimatableManager;
import software.bernie.geckolib.animation.AnimationController;
import software.bernie.geckolib.animation.RawAnimation;
import software.bernie.geckolib.util.GeckoLibUtil;

import java.util.Objects;
import java.util.Optional;

public class Moth extends TamableAnimal implements GeoEntity, FlyingAnimal, VariantHolder<Holder<MothVariant>>,Saddleable {
    public static final int GROUND_CLEARENCE_THRESHOLD = 3;
    private static final EntityDataAccessor<Holder<MothVariant>> DATA_VARIANT_ID = SynchedEntityData.defineId(Moth.class, GGEntityDataSerializers.MOTH_VARIANT.get());
    private static final RawAnimation IDLE_ANIM = RawAnimation.begin().thenPlay("animation.moth.idle");
    private static final RawAnimation WALK_ANIM = RawAnimation.begin().thenPlay("animation.moth.walk");
    private static final RawAnimation FLY_ANIM = RawAnimation.begin().thenPlay("animation.moth.fly");
    private final AnimatableInstanceCache animatableInstanceCache = GeckoLibUtil.createInstanceCache(this);
    private boolean flying;
    private boolean nearGround;

    private final GroundPathNavigation groundNavigation;
    private final FlyingPathNavigation flyingNavigation;

    private static final EntityDataAccessor<Byte> DATA_ID_FLAGS = SynchedEntityData.defineId(AbstractHorse.class, EntityDataSerializers.BYTE);
    private static final int FLAG_TAME = 2;
    private static final int FLAG_SADDLE = 4;
    private static final int FLAG_BRED = 8;
    private static final int FLAG_EATING = 16;


    public Moth(EntityType<? extends Moth> entityType, Level level) {
        super(entityType, level);
        this.moveControl = new MothMoveController(this);

        this.flyingNavigation = new FlyingPathNavigation(this, level);
        this.groundNavigation = new GroundPathNavigation(this, level);

        this.flyingNavigation.setCanFloat(true);
        this.groundNavigation.setCanFloat(true);

        this.navigation = this.groundNavigation;
    }

    public @NotNull LookControl getLookControl() {
        return this.lookControl;
    }

    public static AttributeSupplier.Builder createAttributes(){
        return Mob.createMobAttributes().add(Attributes.MAX_HEALTH, 20.0D)
                .add(Attributes.FLYING_SPEED, 0.3D)
                .add(Attributes.MOVEMENT_SPEED, 0.3D);
    }

    @Override
    protected void defineSynchedData(SynchedEntityData.Builder builder) {
        super.defineSynchedData(builder);
        RegistryAccess registryaccess = this.registryAccess();
        Registry<MothVariant> registry = registryaccess.registryOrThrow(GGMothVariants.MOTH_VARIANT_REGISTRY_KEY);
        Objects.requireNonNull(registry);
        builder.define(DATA_VARIANT_ID, registry.getHolder(GGMothVariants.DEFAULT).or(registry::getAny).orElseThrow());
    }

    @Override
    public void addAdditionalSaveData(CompoundTag compound) {
        super.addAdditionalSaveData(compound);
        this.getVariant().unwrapKey().ifPresent((variantResourceKey) -> compound.putString("variant", variantResourceKey.location().toString()));
    }

    @Override
    public void readAdditionalSaveData(CompoundTag compound) {
        super.readAdditionalSaveData(compound);
        Optional.ofNullable(ResourceLocation.tryParse(compound.getString("variant")))
                .map((variantLocation) -> ResourceKey.create(GGMothVariants.MOTH_VARIANT_REGISTRY_KEY, variantLocation))
                .flatMap((variantResourceKey) -> this.registryAccess().registryOrThrow(GGMothVariants.MOTH_VARIANT_REGISTRY_KEY).getHolder(variantResourceKey))
                .ifPresent(this::setVariant);
    }

    @Override
    public SpawnGroupData finalizeSpawn(ServerLevelAccessor level, DifficultyInstance difficulty, MobSpawnType spawnType, @Nullable SpawnGroupData spawnGroupData) {
        Holder<MothVariant> spawnVariant = GGMothVariants.getSpawnVariant(this.registryAccess());
        this.setVariant(spawnVariant);
        return super.finalizeSpawn(level, difficulty, spawnType, spawnGroupData);
    }

    @Override
    protected BodyRotationControl createBodyControl() {
        return new MothBodyController(this);
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(1, new FloatGoal(this));
        this.goalSelector.addGoal(1, new TamableAnimal.TamableAnimalPanicGoal(1.5F, DamageTypeTags.PANIC_ENVIRONMENTAL_CAUSES));
        this.goalSelector.addGoal(2, new SitWhenOrderedToGoal(this));
        this.goalSelector.addGoal(3, new LookAtPlayerGoal(this, Player.class, 8.0F));
        this.goalSelector.addGoal(3, new FollowOwnerGoal(this, 1.0F, 10.0F, 2.0F));
        this.goalSelector.addGoal(4, new BreedGoal(this, 1.0));
        this.goalSelector.addGoal(5, new WaterAvoidingRandomStrollGoal(this, 1.0F));
        this.goalSelector.addGoal(6, new LookAtPlayerGoal(this, LivingEntity.class, 8.0F));
        this.goalSelector.addGoal(7, new RandomLookAroundGoal(this));
    }

    @Override
    public void tick() {
        super.tick();

        // Update nearGround state when moving for flight and animation logic
        this.nearGround = this.onGround() || !level().noCollision(
                this,
                new AABB(this.getX(), this.getY(), this.getZ(), this.getX(), this.getY() - (GROUND_CLEARENCE_THRESHOLD * this.getAgeScale()), this.getZ()));

        // update flying state based on the distance to the ground
        boolean flying = this.shouldFly();
        if (flying != this.isFlying()) {
            this.setFlying(flying);

            // update pathfinding method
            if (!this.level().isClientSide) this.setNavigation(flying);
        }
    }

    public boolean shouldFly() {
        if (this.isFlying()) return !this.onGround(); // more natural landings
        return !this.isInWater() && !this.isNearGround();
    }

    @Override
    public boolean isFlying() {
        return this.flying;
    }

    public void setFlying(boolean flying) {
        this.flying = flying;
    }

    public boolean isNearGround() {
        return this.nearGround;
    }

    public void setNavigation(boolean flying) {
        this.navigation = flying ? this.flyingNavigation : this.groundNavigation;
    }

    @Override
    public void travel(Vec3 travelVector) {
        if (this.isFlying()) {
            if (this.isControlledByLocalInstance()) {
                // Move relative to yaw - handled in the move controller or by driver
                this.moveRelative(this.getSpeed(), travelVector);
                this.move(MoverType.SELF, this.getDeltaMovement());
                if (this.getDeltaMovement().lengthSqr() < 0.1F){
                    // Idle hovering
                    this.setDeltaMovement(this.getDeltaMovement().add(0.0F, Math.sin(this.tickCount / 4.0F) * 0.03F, 0.0F));
                }
                this.setDeltaMovement(this.getDeltaMovement().scale(0.9F)); // smoothly slow down
            }

            this.calculateEntityAnimation(true);
        }
        else{
            super.travel(travelVector);
        }
    }

    @Override
    protected Vec3 getRiddenInput(Player driver, Vec3 driverInput) {
        double moveSideways = driverInput.x;
        double moveY = driverInput.y;
        double moveForward = Math.min(Math.abs(driver.zza) + Math.abs(driver.xxa), 1.0F);

        if (this.isFlying() && this.isControlledByLocalInstance()) {
            moveForward = moveForward > 0.0F ? moveForward : 0.0F;
            if (moveForward > 0.0F){
                moveY = -driver.getXRot() / 90.0F; // normalize from -1 to 1
            }
        }

        // Mimic how setSpeed in Mob works:
        // Sets the normal speed variable
        // Set the walk forward variable to the same value
        // So if speed is 0.3, walk forward will also be 0.3 instead of 1.0.
        // So when moveRelative calculates move speed, (walk forward * speed) we get 0.15.
        float speed = this.getRiddenSpeed(driver);
        return new Vec3(moveSideways * speed, moveY * speed, moveForward * speed);
    }

    @Override
    protected void tickRidden(Player driver, Vec3 driverInput) {
        // Rotate head to match driver
        float yaw = driver.yHeadRot;
        if (driverInput.z > 0.0F) // rotate in the direction of the driver's controls
            yaw += (float) Mth.atan2(driver.zza, driver.xxa) * Mth.RAD_TO_DEG - 90.0F;
        this.yHeadRot = yaw;
        this.setXRot(driver.getXRot() * 0.68F);

        // Rotate body towards the head
        this.setYRot(Mth.rotateIfNecessary(this.yHeadRot, this.getYRot(), 4.0F));

        if (this.isControlledByLocalInstance()) {
            if (!this.isFlying() && ((LivingEntityAccessor)driver).gabbysgrove$isJumping()){
                this.jumpFromGround();
            }
        }
    }

    @Override
    protected float getRiddenSpeed(Player driver) {
        return (float) this.getAttributeValue(this.isFlying()? Attributes.FLYING_SPEED : Attributes.MOVEMENT_SPEED);
    }

    @Override
    protected float getJumpPower() {
        // Stronger jumps for easier lift-offs
        return super.getJumpPower(3.0F);
    }

    @Override
    public LivingEntity getControllingPassenger() {
        return this.getFirstPassenger() instanceof LivingEntity driver ? driver : null;
    }

    @Override
    protected Vec3 getPassengerAttachmentPoint(Entity ridden, EntityDimensions dimensions, float partialTick) {
        return new Vec3(0.0D, this.getBbHeight(), (this.isFlying() ? -1.0D : -0.75D) * partialTick)
                .yRot(-this.getYRot() * Mth.DEG_TO_RAD);
    }

    @Override
    public boolean causeFallDamage(float pFallDistance, float pMultiplier, DamageSource pSource) {
        return false;
    }

    @Override
    public InteractionResult mobInteract(Player player, InteractionHand hand) {
        ItemStack itemInHand = player.getItemInHand(hand);

        InteractionResult interactLivingEntity = itemInHand.interactLivingEntity(player, this, hand);
        if (interactLivingEntity.consumesAction()) return interactLivingEntity;

        // Tame
        if (!this.isTame()) {
            if (!this.level().isClientSide && this.isFood(itemInHand)) {
                this.usePlayerItem(player, hand, itemInHand);
                this.tryToTame(player);
                this.setPersistenceRequired();
                return InteractionResult.SUCCESS;
            }

            return InteractionResult.PASS;
        }

        // Sit
        if (player.isSecondaryUseActive()){
            if (this.level().isClientSide) {
                this.navigation.stop();
                this.setOrderedToSit(!this.isOrderedToSit());
                if (this.isOrderedToSit()) this.setTarget(null);
            }
            return InteractionResult.sidedSuccess(level().isClientSide);
        }

        // Ride
        if (!this.isFood(itemInHand) && !this.isBaby()) {
            if (!this.level().isClientSide) {
                this.doPlayerRide(player);
                this.navigation.stop();
                this.setTarget(null);
            }
            this.setOrderedToSit(false);
            this.setInSittingPose(false);
            this.setOrderedToSit(false);
            return InteractionResult.sidedSuccess(level().isClientSide);
        }

        // Breed or Age up
        return super.mobInteract(player, hand);
    }

    private void tryToTame(Player player) {
        if (!EventHooks.onAnimalTame(this, player)) {
            this.tame(player);
            this.navigation.stop();
            this.setTarget(null);
            this.setOrderedToSit(true);
            this.level().broadcastEntityEvent(this, EntityEvent.TAMING_SUCCEEDED);
        } else {
            this.level().broadcastEntityEvent(this, EntityEvent.TAMING_FAILED);
        }
    }

    protected void doPlayerRide(Player player) {
        if (!this.level().isClientSide) {
            player.setYRot(this.getYRot());
            player.setXRot(this.getXRot());
            player.startRiding(this);
        }
    }

    @Override
    public boolean hurt(DamageSource source, float amount) {
        if (this.isInvulnerableTo(source)) {
            return false;
        } else {
            if (!this.level().isClientSide) {
                this.setOrderedToSit(false);
            }

            return super.hurt(source, amount);
        }
    }

    @Override
    public boolean isFood(ItemStack itemStack) {
        return itemStack.is(GGTags.Items.MOTH_FOOD);
    }

    @Override
    public boolean canMate(Animal otherAnimal) {
        if (otherAnimal == this) {
            return false;
        } else if (!this.isTame()) {
            return false;
        } else if (otherAnimal instanceof Moth otherMoth) {
            if (!otherMoth.isTame()) {
                return false;
            } else {
                return !otherMoth.isInSittingPose() && this.isInLove() && otherMoth.isInLove();
            }
        } else {
            return false;
        }
    }

    @Nullable
    @Override
    public AgeableMob getBreedOffspring(ServerLevel serverLevel, AgeableMob otherParent) {
        Moth offspring = GGEntities.MOTH.get().create(serverLevel);
        if (offspring != null && otherParent instanceof Moth otherMoth) {
            if (this.random.nextBoolean()) {
                offspring.setVariant(this.getVariant());
            } else {
                offspring.setVariant(otherMoth.getVariant());
            }

            if (this.isTame()) {
                offspring.setOwnerUUID(this.getOwnerUUID());
                offspring.setTame(true, true);
            }
        }

        return offspring;
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {
        controllers.add(new AnimationController<>(this,0, state -> {
            if(this.isFlying()){
                return state.setAndContinue(FLY_ANIM);
            } else if(state.isMoving()){
                return state.setAndContinue(WALK_ANIM);
            }
            return state.setAndContinue(IDLE_ANIM);
        }));
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return this.animatableInstanceCache;
    }

    public ResourceLocation getTexture() {
        MothVariant variant = this.getVariant().value();
        return variant.texture();
    }

    @Override
    public void setVariant(Holder<MothVariant> mothVariantHolder) {
        this.entityData.set(DATA_VARIANT_ID, mothVariantHolder);
    }

    @Override
    public Holder<MothVariant> getVariant() {
        return this.entityData.get(DATA_VARIANT_ID);
    }


    @Override
    public boolean isSaddleable() {
        return this.isAlive() && !this.isBaby() && this.isTame();
    }

    @Override
    public void equipSaddle(ItemStack itemStack, @Nullable SoundSource soundSource) {

    }

    @Override
    public boolean isSaddled() {
        {
            return this.getFlag(4);
        }
    }

    protected boolean getFlag(int flagId) {
        return (this.entityData.get(DATA_ID_FLAGS) & flagId) != 0;
    }
}
