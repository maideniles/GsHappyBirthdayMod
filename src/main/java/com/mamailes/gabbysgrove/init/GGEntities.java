package com.mamailes.gabbysgrove.init;

import com.mamailes.gabbysgrove.GabbysGrove;
import com.mamailes.gabbysgrove.entity.Moth;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class GGEntities {

    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(BuiltInRegistries.ENTITY_TYPE, GabbysGrove.MODID);


    public static final float MOTH_WIDTH = 2.0F;
    public static final float MOTH_HEIGHT = 2.0F;
    public static final DeferredHolder<EntityType<?>, EntityType<Moth>> MOTH =
            ENTITY_TYPES.register("moth", () -> EntityType.Builder.of(Moth::new, MobCategory.CREATURE)
                    .sized(MOTH_WIDTH, MOTH_HEIGHT).clientTrackingRange(10).updateInterval(3).build("moth"));

    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}
