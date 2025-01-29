package com.mamailes.gabbysgrove.block;

import com.mamailes.gabbysgrove.init.GGParticles;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import org.jetbrains.annotations.Nullable;


public class GGParticleBlock extends Block {


    public GGParticleBlock(Properties p_55453_) {
        super(p_55453_);
        this.registerDefaultState(this.defaultBlockState());
    }

    public void attack(BlockState p_55467_, Level p_55468_, BlockPos p_55469_, Player p_55470_) {
        interact(p_55467_, p_55468_, p_55469_);
        super.attack(p_55467_, p_55468_, p_55469_, p_55470_);
    }

    public void stepOn(Level p_154299_, BlockPos p_154300_, BlockState p_154301_, Entity p_154302_) {
        if (!p_154302_.isSteppingCarefully()) {
            interact(p_154301_, p_154299_, p_154300_);
        }

        super.stepOn(p_154299_, p_154300_, p_154301_, p_154302_);
    }

    public InteractionResult use(BlockState p_55472_, Level p_55473_, BlockPos p_55474_, Player p_55475_, InteractionHand p_55476_, BlockHitResult p_55477_) {
        if (p_55473_.isClientSide) {
            spawnParticles(p_55473_, p_55474_);
        } else {
            interact(p_55472_, p_55473_, p_55474_);
        }

        ItemStack itemstack = p_55475_.getItemInHand(p_55476_);
        return itemstack.getItem() instanceof BlockItem && (new BlockPlaceContext(p_55475_, p_55476_, itemstack, p_55477_)).canPlace() ? InteractionResult.PASS : InteractionResult.SUCCESS;
    }

    private static void interact(BlockState p_55493_, Level p_55494_, BlockPos p_55495_) {
        spawnParticles(p_55494_, p_55495_);


    }

    public boolean isRandomlyTicking(BlockState p_55486_) {
        return true;
    }



    public void spawnAfterBreak(BlockState p_221907_, ServerLevel p_221908_, BlockPos p_221909_, ItemStack p_221910_, boolean p_221911_) {
        super.spawnAfterBreak(p_221907_, p_221908_, p_221909_, p_221910_, p_221911_);
    }

//


    @Override
    public int getExpDrop(BlockState state, LevelAccessor level, BlockPos pos, @Nullable BlockEntity blockEntity, @Nullable Entity breaker, ItemStack tool) {
        return super.getExpDrop(state, level, pos, blockEntity, breaker, tool);
    }

    public void animateTick(BlockState p_221913_, Level p_221914_, BlockPos p_221915_, RandomSource p_221916_) {

            spawnParticles(p_221914_, p_221915_);


    }

    private static void spawnParticles(Level level, BlockPos pos) {
        RandomSource rand = level.random;
        int i = pos.getX();
        int j = pos.getY();
        int k = pos.getZ();
        double d0 = (double)i + rand.nextDouble();
        double d1 = (double)j + 0.7D;
        double d2 = (double)k + rand.nextDouble();
        level.addParticle(GGParticles.LBG_PARTICLES.get(), d0, d1, d2, 0.0D, 0.0D, 0.0D);
        BlockPos.MutableBlockPos blockpos$mutableblockpos = new BlockPos.MutableBlockPos();

        for(int l = 0; l < 14; ++l) {
            blockpos$mutableblockpos.set(i + Mth.nextInt(rand, -10, 10), j - rand.nextInt(10), k + Mth.nextInt(rand, -10, 10));
            BlockState blockstate = level.getBlockState(blockpos$mutableblockpos);
            if (!blockstate.isCollisionShapeFullBlock(level, blockpos$mutableblockpos)) {
                level.addParticle(GGParticles.LBG_PARTICLES.get(), (double)blockpos$mutableblockpos.getX() + rand.nextDouble(), (double)blockpos$mutableblockpos.getY() + rand.nextDouble(), (double)blockpos$mutableblockpos.getZ() + rand.nextDouble(), 0.0D, 0.0D, 0.0D);
            }
        }

    }


}

