package com.mamailes.gabbysgrove.init;

import com.mamailes.gabbysgrove.GabbysGrove;
import com.mamailes.gabbysgrove.entity.MothVariant;
import net.minecraft.core.Holder;
import net.minecraft.network.syncher.EntityDataSerializer;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

public class GGEntityDataSerializers {
    private static final DeferredRegister<EntityDataSerializer<?>> ENTITY_DATA_SERIALIZERS = DeferredRegister.create(NeoForgeRegistries.ENTITY_DATA_SERIALIZERS, GabbysGrove.MODID);

    public static final DeferredHolder<EntityDataSerializer<?>, EntityDataSerializer<Holder<MothVariant>>> MOTH_VARIANT = ENTITY_DATA_SERIALIZERS.register("moth_variant", () -> EntityDataSerializer.forValueType(MothVariant.STREAM_CODEC));

    public static void register(IEventBus modEventBus){
        ENTITY_DATA_SERIALIZERS.register(modEventBus);
    }
}
