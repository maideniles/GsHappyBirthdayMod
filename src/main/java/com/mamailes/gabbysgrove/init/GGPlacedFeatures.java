package com.mamailes.gabbysgrove.init;

import com.google.common.collect.ImmutableList;
import com.mamailes.gabbysgrove.GabbysGrove;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.*;

import java.util.List;

public class GGPlacedFeatures {


    public static final ResourceKey<PlacedFeature> CHROMATIC_PLACEMENT = registerKey("chromatic_placement");


    public static ResourceKey<PlacedFeature> registerKey(String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE, GabbysGrove.prefix(name));
    }

    public static void bootstrap(BootstrapContext<PlacedFeature> context) {
        HolderGetter<ConfiguredFeature<?, ?>> features = context.lookup(Registries.CONFIGURED_FEATURE);
        HolderGetter<Biome> biomes = context.lookup(Registries.BIOME);

        context.register(CHROMATIC_PLACEMENT, new PlacedFeature(features.getOrThrow(GGConfiguredFeatures.CHROMATIC_KEY), ModTreeCheckArea(PlacementUtils.countExtra(10, 0.2F, 5), GGBlocks.CHROMATIC_SAPLING.get().defaultBlockState())));

    }

    private static List<PlacementModifier> ModTreeCheckArea(PlacementModifier count, BlockState sapling) {
        return ImmutableList.of(count, InSquarePlacement.spread(), SurfaceWaterDepthFilter.forMaxDepth(0), PlacementUtils.HEIGHTMAP_OCEAN_FLOOR,  PlacementUtils.filteredByBlockSurvival(sapling.getBlock()), BiomeFilter.biome());
    }

}

