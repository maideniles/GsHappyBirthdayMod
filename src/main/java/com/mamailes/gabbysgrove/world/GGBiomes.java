package com.mamailes.gabbysgrove.world;

import com.mamailes.gabbysgrove.GabbysGrove;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;

public class GGBiomes
{
    public static final ResourceKey<Biome> HOT_RED = register("hot_red");
    public static final ResourceKey<Biome> GABBYS_GROVE = register("gabbys_grove");

    private static ResourceKey<Biome> register(String name)
    {
        return ResourceKey.create(Registries.BIOME, ResourceLocation.fromNamespaceAndPath(GabbysGrove.MODID, name));
    }
}
