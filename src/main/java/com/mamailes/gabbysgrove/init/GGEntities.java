package com.mamailes.gabbysgrove.init;

import com.mamailes.gabbysgrove.GabbysGrove;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

public class GGEntities {

    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(BuiltInRegistries.ENTITY_TYPE, GabbysGrove.MODID);


    //PLACEHOLDER//
//    public static final Supplier<EntityType<PlaceHolderMothEntity>> GECKO =
//            ENTITY_TYPES.register("mothH", () -> EntityType.Builder.of(PlaceHolderMothEntity::new, MobCategory.CREATURE)
//                    .sized(0.75f, 0.35f).build("moth"));

    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}
