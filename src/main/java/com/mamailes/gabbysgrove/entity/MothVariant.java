package com.mamailes.gabbysgrove.entity;

import com.mamailes.gabbysgrove.init.GGMothVariants;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.Holder;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.resources.RegistryFileCodec;
import net.minecraft.resources.ResourceLocation;

public class MothVariant {
    private final ResourceLocation texture;
    private final ResourceLocation fullTexture;

    public MothVariant(ResourceLocation texture){
        this.texture = texture;
        this.fullTexture = fullTextureId(texture);
    }

    private static ResourceLocation fullTextureId(ResourceLocation texture) {
        return texture.withPath((p_335262_) -> "textures/" + p_335262_ + ".png");
    }

    public ResourceLocation texture() {
        return this.fullTexture;
    }

    public static final Codec<MothVariant> DIRECT_CODEC = RecordCodecBuilder.create((instance) ->
            instance.group(ResourceLocation.CODEC.fieldOf("texture").forGetter(mv -> mv.texture))
                    .apply(instance, MothVariant::new));
    public static final StreamCodec<RegistryFriendlyByteBuf, MothVariant> DIRECT_STREAM_CODEC = StreamCodec.composite(ResourceLocation.STREAM_CODEC, MothVariant::texture, MothVariant::new);
    public static final Codec<Holder<MothVariant>> CODEC = RegistryFileCodec.create(GGMothVariants.MOTH_VARIANT_REGISTRY_KEY, DIRECT_CODEC);
    public static final StreamCodec<RegistryFriendlyByteBuf, Holder<MothVariant>> STREAM_CODEC = ByteBufCodecs.holder(GGMothVariants.MOTH_VARIANT_REGISTRY_KEY, DIRECT_STREAM_CODEC);
}
