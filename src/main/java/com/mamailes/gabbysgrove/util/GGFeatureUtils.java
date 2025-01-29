package com.mamailes.gabbysgrove.util;

import com.mamailes.gabbysgrove.GabbysGrove;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;

public class GGFeatureUtils
{
    public static void bootstrap(BootstrapContext<ConfiguredFeature<?, ?>> context)
    {

//        BOPTreeFeatures.bootstrap(context);
//        BOPVegetationFeatures.bootstrap(context);
    }

    public static ResourceKey<ConfiguredFeature<?, ?>> createKey(String name)
    {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, ResourceLocation.fromNamespaceAndPath(GabbysGrove.MODID, name));
    }
}