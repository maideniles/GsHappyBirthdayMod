package com.mamailes.gabbysgrove.init;

import com.google.common.collect.ImmutableList;
import com.mamailes.gabbysgrove.GabbysGrove;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.*;

import java.util.List;

public class GGPlacedFeatures {

    public static final ResourceKey<PlacedFeature> PINK_SAPPHIREE_GEODE_PLACEMENT_KEY = registerKey("pink_sapphire_geode_placement");
    public static final ResourceKey<PlacedFeature> CHROMATIC_PLACEMENT = registerKey("chromatic_placement");

  //  public static final ResourceKey<PlacedFeature> FLOWERS_OVERWORLD_PLACEMENT = registerKey("flowers_overworld_placement");


    public static final ResourceKey<PlacedFeature> BLEEDING_HEARTS_PLACEMENT = registerKey("bleeding_hearts");
    public static final ResourceKey<PlacedFeature> HIBISCUS_PLACEMENT = registerKey("hibiscus");
    public static final ResourceKey<PlacedFeature> PRICKLY_PEAR_CACTUS_PLACEMENT = registerKey("prickly_pear_cactus");
    public static final ResourceKey<PlacedFeature> GREEN_LACE_PRIMROSE_PLACEMENT = registerKey("green_lace_primrose");
    public static final ResourceKey<PlacedFeature> GREEN_GAMBLER_HELLEBORUS_PLACEMENT = registerKey("green_gambler_helleborus");
    public static final ResourceKey<PlacedFeature> TURQUOISE_IXIA_PLACEMENT = registerKey("turquoise_ixia");
    public static final ResourceKey<PlacedFeature> BLUE_CHICORY_PLACEMENT = registerKey("blue_chicory");
    public static final ResourceKey<PlacedFeature> BLUE_SAGE_SALVIA_PLACEMENT = registerKey("blue_sage_salvia");
    public static final ResourceKey<PlacedFeature> VERBENA_LANAI_PLACEMENT = registerKey("verbena_lanai");
    public static final ResourceKey<PlacedFeature> SNAPDRAGON_PLACEMENT = registerKey("snapdragon");
    public static final ResourceKey<PlacedFeature> GERBERA_DAISY_PLACEMENT = registerKey("gerbera_daisy");
    public static final ResourceKey<PlacedFeature> MOONFLOWER_CACTUS_PLACEMENT = registerKey("moonflower_cactus");
    public static final ResourceKey<PlacedFeature> WHITE_SAGE_SALVIA_PLACEMENT = registerKey("white_sage_salvia");
    public static final ResourceKey<PlacedFeature> ANGEL_WINGS_SENECIO_PLACEMENT = registerKey("angel_wings_senecio");
    public static final ResourceKey<PlacedFeature> PENNY_BLACK_PLACEMENT = registerKey("paperwhite");
    public static final ResourceKey<PlacedFeature> CYMBIDIUM_PLACEMENT = registerKey("white_poinsettia");

    public static final ResourceKey<PlacedFeature> RHODOTUS_PLACEMENT = registerKey("rhodotus");
    public static final ResourceKey<PlacedFeature> DEATH_CAP_PLACEMENT = registerKey("death_cap");
    public static final ResourceKey<PlacedFeature> PARROT_WAXCAP_PLACEMENT = registerKey("parrot_wax_cap");
    public static final ResourceKey<PlacedFeature> PIXIES_PARASOL_PLACEMENT = registerKey("pixies_parasol");
    public static final ResourceKey<PlacedFeature> AMETHYST_DECEIVER_PLACEMENT = registerKey("amethyst_deceiver");

    public static ResourceKey<PlacedFeature> registerKey(String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE, GabbysGrove.prefix(name));
    }

    public static void bootstrap(BootstrapContext<PlacedFeature> context) {
        HolderGetter<ConfiguredFeature<?, ?>> features = context.lookup(Registries.CONFIGURED_FEATURE);



        HolderGetter<Biome> biomes = context.lookup(Registries.BIOME);

        //GEODE//
        register(context, PINK_SAPPHIREE_GEODE_PLACEMENT_KEY, features.getOrThrow(GGConfiguredFeatures.PINK_SAPPHIRE_GEODE_KEY),
                List.of(RarityFilter.onAverageOnceEvery(50), InSquarePlacement.spread(),
                        HeightRangePlacement.uniform(VerticalAnchor.aboveBottom(6), VerticalAnchor.absolute(50)),
                        BiomeFilter.biome()));


        //TREES//
        context.register(CHROMATIC_PLACEMENT, new PlacedFeature(features.getOrThrow(GGConfiguredFeatures.CHROMATIC_KEY), ModTreeCheckArea(PlacementUtils.countExtra(10, 0.2F, 5), GGBlocks.CHROMATIC_SAPLING.get().defaultBlockState())));

        //FLOWERS//
    //    context.register(FLOWERS_OVERWORLD_PLACEMENT, new PlacedFeature(features.getOrThrow(GGConfiguredFeatures.FLOWERS_OVERWORLD), ImmutableList.<PlacementModifier>builder().add(PlacementUtils.HEIGHTMAP_WORLD_SURFACE, CountPlacement.of(5), InSquarePlacement.spread(), RarityFilter.onAverageOnceEvery(20), BiomeFilter.biome()).build()));


        context.register(BLEEDING_HEARTS_PLACEMENT, new PlacedFeature(features.getOrThrow(GGConfiguredFeatures.BLEEDING_HEARTS), ImmutableList.<PlacementModifier>builder().add(PlacementUtils.HEIGHTMAP_WORLD_SURFACE, CountPlacement.of(2), InSquarePlacement.spread(), RarityFilter.onAverageOnceEvery(60), BiomeFilter.biome()).build()));
        context.register(HIBISCUS_PLACEMENT, new PlacedFeature(features.getOrThrow(GGConfiguredFeatures.HIBISCUS), ImmutableList.<PlacementModifier>builder().add(PlacementUtils.HEIGHTMAP_WORLD_SURFACE, CountPlacement.of(2), InSquarePlacement.spread(), RarityFilter.onAverageOnceEvery(60), BiomeFilter.biome()).build()));
        context.register(PRICKLY_PEAR_CACTUS_PLACEMENT, new PlacedFeature(features.getOrThrow(GGConfiguredFeatures.PRICKLY_PEAR_CACTUS), ImmutableList.<PlacementModifier>builder().add(PlacementUtils.HEIGHTMAP_WORLD_SURFACE, CountPlacement.of(2), InSquarePlacement.spread(), RarityFilter.onAverageOnceEvery(60), BiomeFilter.biome()).build()));
        context.register(GREEN_LACE_PRIMROSE_PLACEMENT, new PlacedFeature(features.getOrThrow(GGConfiguredFeatures.GREEN_LACE_PRIMROSE), ImmutableList.<PlacementModifier>builder().add(PlacementUtils.HEIGHTMAP_WORLD_SURFACE, CountPlacement.of(2), InSquarePlacement.spread(), RarityFilter.onAverageOnceEvery(60), BiomeFilter.biome()).build()));
        context.register(GREEN_GAMBLER_HELLEBORUS_PLACEMENT, new PlacedFeature(features.getOrThrow(GGConfiguredFeatures.GREEN_GAMBLER_HELLEBORUS), ImmutableList.<PlacementModifier>builder().add(PlacementUtils.HEIGHTMAP_WORLD_SURFACE, CountPlacement.of(2), InSquarePlacement.spread(), RarityFilter.onAverageOnceEvery(60), BiomeFilter.biome()).build()));
        context.register(TURQUOISE_IXIA_PLACEMENT, new PlacedFeature(features.getOrThrow(GGConfiguredFeatures.TURQUOISE_IXIA), ImmutableList.<PlacementModifier>builder().add(PlacementUtils.HEIGHTMAP_WORLD_SURFACE, CountPlacement.of(2), InSquarePlacement.spread(), RarityFilter.onAverageOnceEvery(60), BiomeFilter.biome()).build()));
        context.register(BLUE_CHICORY_PLACEMENT, new PlacedFeature(features.getOrThrow(GGConfiguredFeatures.BLUE_CHICORY), ImmutableList.<PlacementModifier>builder().add(PlacementUtils.HEIGHTMAP_WORLD_SURFACE, CountPlacement.of(2), InSquarePlacement.spread(), RarityFilter.onAverageOnceEvery(60), BiomeFilter.biome()).build()));
        context.register(BLUE_SAGE_SALVIA_PLACEMENT, new PlacedFeature(features.getOrThrow(GGConfiguredFeatures.BLUE_SAGE_SALVIA), ImmutableList.<PlacementModifier>builder().add(PlacementUtils.HEIGHTMAP_WORLD_SURFACE, CountPlacement.of(2), InSquarePlacement.spread(), RarityFilter.onAverageOnceEvery(60), BiomeFilter.biome()).build()));
        context.register(VERBENA_LANAI_PLACEMENT, new PlacedFeature(features.getOrThrow(GGConfiguredFeatures.VERBENA_LANAI), ImmutableList.<PlacementModifier>builder().add(PlacementUtils.HEIGHTMAP_WORLD_SURFACE, CountPlacement.of(2), InSquarePlacement.spread(), RarityFilter.onAverageOnceEvery(60), BiomeFilter.biome()).build()));
        context.register(SNAPDRAGON_PLACEMENT, new PlacedFeature(features.getOrThrow(GGConfiguredFeatures.SNAPDRAGON), ImmutableList.<PlacementModifier>builder().add(PlacementUtils.HEIGHTMAP_WORLD_SURFACE, CountPlacement.of(2), InSquarePlacement.spread(), RarityFilter.onAverageOnceEvery(60), BiomeFilter.biome()).build()));
        context.register(GERBERA_DAISY_PLACEMENT, new PlacedFeature(features.getOrThrow(GGConfiguredFeatures.GERBERA_DAISY), ImmutableList.<PlacementModifier>builder().add(PlacementUtils.HEIGHTMAP_WORLD_SURFACE, CountPlacement.of(2), InSquarePlacement.spread(), RarityFilter.onAverageOnceEvery(60), BiomeFilter.biome()).build()));
        context.register(MOONFLOWER_CACTUS_PLACEMENT, new PlacedFeature(features.getOrThrow(GGConfiguredFeatures.MOONFLOWER_CACTUS), ImmutableList.<PlacementModifier>builder().add(PlacementUtils.HEIGHTMAP_WORLD_SURFACE, CountPlacement.of(2), InSquarePlacement.spread(), RarityFilter.onAverageOnceEvery(60), BiomeFilter.biome()).build()));
        context.register(WHITE_SAGE_SALVIA_PLACEMENT, new PlacedFeature(features.getOrThrow(GGConfiguredFeatures.WHITE_SAGE_SALVIA), ImmutableList.<PlacementModifier>builder().add(PlacementUtils.HEIGHTMAP_WORLD_SURFACE, CountPlacement.of(2), InSquarePlacement.spread(), RarityFilter.onAverageOnceEvery(60), BiomeFilter.biome()).build()));
        context.register(ANGEL_WINGS_SENECIO_PLACEMENT, new PlacedFeature(features.getOrThrow(GGConfiguredFeatures.ANGEL_WINGS_SENECIO), ImmutableList.<PlacementModifier>builder().add(PlacementUtils.HEIGHTMAP_WORLD_SURFACE, CountPlacement.of(2), InSquarePlacement.spread(), RarityFilter.onAverageOnceEvery(60), BiomeFilter.biome()).build()));
        context.register(PENNY_BLACK_PLACEMENT, new PlacedFeature(features.getOrThrow(GGConfiguredFeatures.PENNY_BLACK), ImmutableList.<PlacementModifier>builder().add(PlacementUtils.HEIGHTMAP_WORLD_SURFACE, CountPlacement.of(2), InSquarePlacement.spread(), RarityFilter.onAverageOnceEvery(60), BiomeFilter.biome()).build()));
        context.register(CYMBIDIUM_PLACEMENT, new PlacedFeature(features.getOrThrow(GGConfiguredFeatures.CYMBIDIUM), ImmutableList.<PlacementModifier>builder().add(PlacementUtils.HEIGHTMAP_WORLD_SURFACE, CountPlacement.of(2), InSquarePlacement.spread(), RarityFilter.onAverageOnceEvery(60), BiomeFilter.biome()).build()));

        context.register(RHODOTUS_PLACEMENT, new PlacedFeature(features.getOrThrow(GGConfiguredFeatures.RHODOTUS), ImmutableList.<PlacementModifier>builder().add(PlacementUtils.HEIGHTMAP_WORLD_SURFACE, CountPlacement.of(2), InSquarePlacement.spread(), RarityFilter.onAverageOnceEvery(60), BiomeFilter.biome()).build()));
        context.register(DEATH_CAP_PLACEMENT, new PlacedFeature(features.getOrThrow(GGConfiguredFeatures.DEATH_CAP), ImmutableList.<PlacementModifier>builder().add(PlacementUtils.HEIGHTMAP_WORLD_SURFACE, CountPlacement.of(2), InSquarePlacement.spread(), RarityFilter.onAverageOnceEvery(60), BiomeFilter.biome()).build()));
        context.register(PARROT_WAXCAP_PLACEMENT, new PlacedFeature(features.getOrThrow(GGConfiguredFeatures.PARROT_WAXCAP), ImmutableList.<PlacementModifier>builder().add(PlacementUtils.HEIGHTMAP_WORLD_SURFACE, CountPlacement.of(2), InSquarePlacement.spread(), RarityFilter.onAverageOnceEvery(60), BiomeFilter.biome()).build()));
        context.register(PIXIES_PARASOL_PLACEMENT, new PlacedFeature(features.getOrThrow(GGConfiguredFeatures.PIXIES_PARASOL), ImmutableList.<PlacementModifier>builder().add(PlacementUtils.HEIGHTMAP_WORLD_SURFACE, CountPlacement.of(2), InSquarePlacement.spread(), RarityFilter.onAverageOnceEvery(60), BiomeFilter.biome()).build()));
        context.register(AMETHYST_DECEIVER_PLACEMENT, new PlacedFeature(features.getOrThrow(GGConfiguredFeatures.AMETHYST_DECEIVER), ImmutableList.<PlacementModifier>builder().add(PlacementUtils.HEIGHTMAP_WORLD_SURFACE, CountPlacement.of(2), InSquarePlacement.spread(), RarityFilter.onAverageOnceEvery(60), BiomeFilter.biome()).build()));

    }

    private static List<PlacementModifier> ModTreeCheckArea(PlacementModifier count, BlockState sapling) {
        return ImmutableList.of(count, InSquarePlacement.spread(), SurfaceWaterDepthFilter.forMaxDepth(0), PlacementUtils.HEIGHTMAP_OCEAN_FLOOR,  PlacementUtils.filteredByBlockSurvival(sapling.getBlock()), BiomeFilter.biome());
    }

    private static void register(BootstrapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key, Holder<ConfiguredFeature<?, ?>> configuration,
                                 List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }

}

