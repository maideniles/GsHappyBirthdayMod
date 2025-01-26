package com.mamailes.gabbysgrove.init;

import com.mamailes.gabbysgrove.GabbysGrove;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;

import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.RandomPatchConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.NoiseProvider;
import net.minecraft.world.level.levelgen.synth.NormalNoise;

import java.util.List;

public class GGConfiguredFeatures {

    //TREES//
    public static final ResourceKey<ConfiguredFeature<?, ?>> CHROMATIC_KEY = registerKey("chromatic_tree");

    //FLOWERS//
    public static final ResourceKey<ConfiguredFeature<?, ?>> BLEEDING_HEARTS = registerKey("bleeding_hearts");
    public static final ResourceKey<ConfiguredFeature<?, ?>> HIBISCUS = registerKey("hibiscus");
    public static final ResourceKey<ConfiguredFeature<?, ?>> PRICKLY_PEAR_CACTUS = registerKey("prickly_pear_cactus");
    public static final ResourceKey<ConfiguredFeature<?, ?>> GREEN_LACE_PRIMROSE = registerKey("green_lace_primrose");
    public static final ResourceKey<ConfiguredFeature<?, ?>> GREEN_GAMBLER_HELLEBORUS = registerKey("green_gambler_helleborus");
    public static final ResourceKey<ConfiguredFeature<?, ?>> TURQUOISE_IXIA = registerKey("turquoise_ixia");
    public static final ResourceKey<ConfiguredFeature<?, ?>> BLUE_CHICORY = registerKey("blue_chicory");
    public static final ResourceKey<ConfiguredFeature<?, ?>> BLUE_SAGE_SALVIA = registerKey("blue_sage_salvia");
    public static final ResourceKey<ConfiguredFeature<?, ?>> VERBENA_LANAI = registerKey("verbena_lanai");
    public static final ResourceKey<ConfiguredFeature<?, ?>> SNAPDRAGON = registerKey("snapdragon");
    public static final ResourceKey<ConfiguredFeature<?, ?>> GERBERA_DAISY = registerKey("gerbera_daisy");
    public static final ResourceKey<ConfiguredFeature<?, ?>> MOONFLOWER_CACTUS = registerKey("moonflower_cactus");
    public static final ResourceKey<ConfiguredFeature<?, ?>> WHITE_SAGE_SALVIA = registerKey("white_sage_salvia");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ANGEL_WINGS_SENECIO = registerKey("angel_wings_senecio");
    public static final ResourceKey<ConfiguredFeature<?, ?>> PENNY_BLACK = registerKey("paperwhite");
    public static final ResourceKey<ConfiguredFeature<?, ?>> CYMBIDIUM = registerKey("white_poinsettia");

    public static final ResourceKey<ConfiguredFeature<?, ?>> RHODOTUS = registerKey("rhodotus");
    public static final ResourceKey<ConfiguredFeature<?, ?>> DEATH_CAP = registerKey("death_cap");
    public static final ResourceKey<ConfiguredFeature<?, ?>> PARROT_WAXCAP = registerKey("parrot_wax_cap");
    public static final ResourceKey<ConfiguredFeature<?, ?>> PIXIES_PARASOL = registerKey("pixies_parasol");
    public static final ResourceKey<ConfiguredFeature<?, ?>> AMETHYST_DECEIVER = registerKey("amethyst_deceiver");

    //FLOWERS//
    public static final RandomPatchConfiguration BLEEDING_HEARTS_KEY = (new RandomPatchConfiguration(32, 7, 7,
            PlacementUtils.filtered(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(
                            new NoiseProvider(2345L, new NormalNoise.NoiseParameters(0, 1.0D), 0.020833334F, List.of(
                                    GGBlocks.BLEEDING_HEARTS.get().defaultBlockState()))),
                    BlockPredicate.ONLY_IN_AIR_PREDICATE)));

    public static final RandomPatchConfiguration HIBISCUS_KEY = (new RandomPatchConfiguration(32, 7, 7,
            PlacementUtils.filtered(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(
                            new NoiseProvider(2345L, new NormalNoise.NoiseParameters(0, 1.0D), 0.020833334F, List.of(
                                    GGBlocks.HIBISCUS.get().defaultBlockState()))),
                    BlockPredicate.ONLY_IN_AIR_PREDICATE)));

    public static final RandomPatchConfiguration PRICKLY_PEAR_CACTUS_KEY = (new RandomPatchConfiguration(32, 7, 7,
            PlacementUtils.filtered(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(
                            new NoiseProvider(2345L, new NormalNoise.NoiseParameters(0, 1.0D), 0.020833334F, List.of(
                                    GGBlocks.PRICKLY_PEAR_CACTUS.get().defaultBlockState()))),
                    BlockPredicate.ONLY_IN_AIR_PREDICATE)));

    public static final RandomPatchConfiguration GREEN_LACE_PRIMROSE_KEY = (new RandomPatchConfiguration(32, 7, 7,
            PlacementUtils.filtered(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(
                            new NoiseProvider(2345L, new NormalNoise.NoiseParameters(0, 1.0D), 0.020833334F, List.of(
                                    GGBlocks.GREEN_LACE_PRIMROSE.get().defaultBlockState()))),
                    BlockPredicate.ONLY_IN_AIR_PREDICATE)));

    public static final RandomPatchConfiguration GREEN_GAMBLER_HELLEBORUS_KEY = (new RandomPatchConfiguration(32, 7, 7,
            PlacementUtils.filtered(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(
                            new NoiseProvider(2345L, new NormalNoise.NoiseParameters(0, 1.0D), 0.020833334F, List.of(
                                    GGBlocks.GREEN_GAMBLER_HELLEBORUS.get().defaultBlockState()))),
                    BlockPredicate.ONLY_IN_AIR_PREDICATE)));

    public static final RandomPatchConfiguration TURQUOISE_IXIA_KEY = (new RandomPatchConfiguration(32, 7, 7,
            PlacementUtils.filtered(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(
                            new NoiseProvider(2345L, new NormalNoise.NoiseParameters(0, 1.0D), 0.020833334F, List.of(
                                    GGBlocks.TURQUOISE_IXIA.get().defaultBlockState()))),
                    BlockPredicate.ONLY_IN_AIR_PREDICATE)));

    public static final RandomPatchConfiguration BLUE_CHICORY_KEY = (new RandomPatchConfiguration(32, 7, 7,
            PlacementUtils.filtered(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(
                            new NoiseProvider(2345L, new NormalNoise.NoiseParameters(0, 1.0D), 0.020833334F, List.of(
                                    GGBlocks.BLUE_CHICORY.get().defaultBlockState()))),
                    BlockPredicate.ONLY_IN_AIR_PREDICATE)));

    public static final RandomPatchConfiguration BLUE_SAGE_SALVIA_KEY = (new RandomPatchConfiguration(32, 7, 7,
            PlacementUtils.filtered(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(
                            new NoiseProvider(2345L, new NormalNoise.NoiseParameters(0, 1.0D), 0.020833334F, List.of(
                                    GGBlocks.BLUE_SAGE_SALVIA.get().defaultBlockState()))),
                    BlockPredicate.ONLY_IN_AIR_PREDICATE)));

    public static final RandomPatchConfiguration VERBENA_LANAI_KEY = (new RandomPatchConfiguration(32, 7, 7,
            PlacementUtils.filtered(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(
                            new NoiseProvider(2345L, new NormalNoise.NoiseParameters(0, 1.0D), 0.020833334F, List.of(
                                    GGBlocks.VERBENA_LANAI.get().defaultBlockState()))),
                    BlockPredicate.ONLY_IN_AIR_PREDICATE)));

    public static final RandomPatchConfiguration SNAPDRAGON_KEY = (new RandomPatchConfiguration(32, 7, 7,
            PlacementUtils.filtered(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(
                            new NoiseProvider(2345L, new NormalNoise.NoiseParameters(0, 1.0D), 0.020833334F, List.of(
                                    GGBlocks.SNAPDRAGON.get().defaultBlockState()))),
                    BlockPredicate.ONLY_IN_AIR_PREDICATE)));

    public static final RandomPatchConfiguration GERBERA_DAISY_KEY = (new RandomPatchConfiguration(32, 7, 7,
            PlacementUtils.filtered(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(
                            new NoiseProvider(2345L, new NormalNoise.NoiseParameters(0, 1.0D), 0.020833334F, List.of(
                                    GGBlocks.GERBERA_DAISY.get().defaultBlockState()))),
                    BlockPredicate.ONLY_IN_AIR_PREDICATE)));

    public static final RandomPatchConfiguration MOONFLOWER_CACTUS_KEY = (new RandomPatchConfiguration(32, 7, 7,
            PlacementUtils.filtered(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(
                            new NoiseProvider(2345L, new NormalNoise.NoiseParameters(0, 1.0D), 0.020833334F, List.of(
                                    GGBlocks.MOONFLOWER_CACTUS.get().defaultBlockState()))),
                    BlockPredicate.ONLY_IN_AIR_PREDICATE)));

    public static final RandomPatchConfiguration WHITE_SAGE_SALVIA_KEY = (new RandomPatchConfiguration(32, 7, 7,
            PlacementUtils.filtered(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(
                            new NoiseProvider(2345L, new NormalNoise.NoiseParameters(0, 1.0D), 0.020833334F, List.of(
                                    GGBlocks.WHITE_SAGE_SALVIA.get().defaultBlockState()))),

                    BlockPredicate.ONLY_IN_AIR_PREDICATE)));
    public static final RandomPatchConfiguration ANGEL_WINGS_SENECIO_KEY = (new RandomPatchConfiguration(32, 7, 7,
            PlacementUtils.filtered(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(
                            new NoiseProvider(2345L, new NormalNoise.NoiseParameters(0, 1.0D), 0.020833334F, List.of(
                                    GGBlocks.SNAPDRAGON.get().defaultBlockState()))),
                    BlockPredicate.ONLY_IN_AIR_PREDICATE)));

    public static final RandomPatchConfiguration PENNY_BLACK_KEY = (new RandomPatchConfiguration(32, 7, 7,
            PlacementUtils.filtered(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(
                            new NoiseProvider(2345L, new NormalNoise.NoiseParameters(0, 1.0D), 0.020833334F, List.of(
                                    GGBlocks.SNAPDRAGON.get().defaultBlockState()))),
                    BlockPredicate.ONLY_IN_AIR_PREDICATE)));

    public static final RandomPatchConfiguration CYMBIDIUM_KEY = (new RandomPatchConfiguration(32, 7, 7,
            PlacementUtils.filtered(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(
                            new NoiseProvider(2345L, new NormalNoise.NoiseParameters(0, 1.0D), 0.020833334F, List.of(
                                    GGBlocks.CYMBIDIUM.get().defaultBlockState()))),
                    BlockPredicate.ONLY_IN_AIR_PREDICATE)));

    public static final RandomPatchConfiguration RHODOTUS_KEY = (new RandomPatchConfiguration(32, 7, 7,
            PlacementUtils.filtered(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(
                            new NoiseProvider(2345L, new NormalNoise.NoiseParameters(0, 1.0D), 0.020833334F, List.of(
                                    GGBlocks.RHODOTUS.get().defaultBlockState()))),
                    BlockPredicate.ONLY_IN_AIR_PREDICATE)));

    public static final RandomPatchConfiguration DEATH_CAP_KEY = (new RandomPatchConfiguration(32, 7, 7,
            PlacementUtils.filtered(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(
                            new NoiseProvider(2345L, new NormalNoise.NoiseParameters(0, 1.0D), 0.020833334F, List.of(
                                    GGBlocks.DEATH_CAP.get().defaultBlockState()))),
                    BlockPredicate.ONLY_IN_AIR_PREDICATE)));

    public static final RandomPatchConfiguration PARROT_WAX_CAP_KEY = (new RandomPatchConfiguration(32, 7, 7,
            PlacementUtils.filtered(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(
                            new NoiseProvider(2345L, new NormalNoise.NoiseParameters(0, 1.0D), 0.020833334F, List.of(
                                    GGBlocks.PARROT_WAXCAP.get().defaultBlockState()))),
                    BlockPredicate.ONLY_IN_AIR_PREDICATE)));

    public static final RandomPatchConfiguration PIXIES_PARASOL_KEY = (new RandomPatchConfiguration(32, 7, 7,
            PlacementUtils.filtered(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(
                            new NoiseProvider(2345L, new NormalNoise.NoiseParameters(0, 1.0D), 0.020833334F, List.of(
                                    GGBlocks.PIXIES_PARASOL.get().defaultBlockState()))),
                    BlockPredicate.ONLY_IN_AIR_PREDICATE)));

    public static final RandomPatchConfiguration AMETHYST_DECEIVER_KEY = (new RandomPatchConfiguration(32, 7, 7,
            PlacementUtils.filtered(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(
                            new NoiseProvider(2345L, new NormalNoise.NoiseParameters(0, 1.0D), 0.020833334F, List.of(
                                    GGBlocks.AMETHYST_DECEIVER.get().defaultBlockState()))),
                    BlockPredicate.ONLY_IN_AIR_PREDICATE)));

    public static void bootstrap(BootstrapContext<ConfiguredFeature<?, ?>> context) {
        HolderGetter<ConfiguredFeature<?, ?>> features = context.lookup(Registries.CONFIGURED_FEATURE);

        context.register(CHROMATIC_KEY, new ConfiguredFeature<>(Feature.TREE, GGTreeConfigurations.CHROMATIC_KEY));

//FLOWERS//
            context.register(BLEEDING_HEARTS, new ConfiguredFeature<>(Feature.FLOWER, BLEEDING_HEARTS_KEY));
            context.register(HIBISCUS, new ConfiguredFeature<>(Feature.FLOWER, HIBISCUS_KEY));
            context.register(PRICKLY_PEAR_CACTUS, new ConfiguredFeature<>(Feature.FLOWER, PRICKLY_PEAR_CACTUS_KEY));
            context.register(GREEN_LACE_PRIMROSE, new ConfiguredFeature<>(Feature.FLOWER, GREEN_LACE_PRIMROSE_KEY));
            context.register(GREEN_GAMBLER_HELLEBORUS, new ConfiguredFeature<>(Feature.FLOWER, GREEN_GAMBLER_HELLEBORUS_KEY));
            context.register(TURQUOISE_IXIA, new ConfiguredFeature<>(Feature.FLOWER, TURQUOISE_IXIA_KEY));
            context.register(BLUE_CHICORY, new ConfiguredFeature<>(Feature.FLOWER, BLUE_CHICORY_KEY));
            context.register(BLUE_SAGE_SALVIA, new ConfiguredFeature<>(Feature.FLOWER, BLUE_SAGE_SALVIA_KEY));
            context.register(VERBENA_LANAI, new ConfiguredFeature<>(Feature.FLOWER, VERBENA_LANAI_KEY));
            context.register(SNAPDRAGON, new ConfiguredFeature<>(Feature.FLOWER, SNAPDRAGON_KEY));
            context.register(GERBERA_DAISY, new ConfiguredFeature<>(Feature.FLOWER, GERBERA_DAISY_KEY));
            context.register(MOONFLOWER_CACTUS, new ConfiguredFeature<>(Feature.FLOWER, MOONFLOWER_CACTUS_KEY));
            context.register(WHITE_SAGE_SALVIA, new ConfiguredFeature<>(Feature.FLOWER, WHITE_SAGE_SALVIA_KEY));
            context.register(ANGEL_WINGS_SENECIO, new ConfiguredFeature<>(Feature.FLOWER, ANGEL_WINGS_SENECIO_KEY));
            context.register(PENNY_BLACK, new ConfiguredFeature<>(Feature.FLOWER, PENNY_BLACK_KEY));
            context.register(CYMBIDIUM, new ConfiguredFeature<>(Feature.FLOWER, CYMBIDIUM_KEY));

            context.register(RHODOTUS, new ConfiguredFeature<>(Feature.FLOWER, RHODOTUS_KEY));
            context.register(DEATH_CAP, new ConfiguredFeature<>(Feature.FLOWER, DEATH_CAP_KEY));
            context.register(PARROT_WAXCAP, new ConfiguredFeature<>(Feature.FLOWER, PARROT_WAX_CAP_KEY));
            context.register(PIXIES_PARASOL, new ConfiguredFeature<>(Feature.FLOWER, PIXIES_PARASOL_KEY));
            context.register(AMETHYST_DECEIVER, new ConfiguredFeature<>(Feature.FLOWER, AMETHYST_DECEIVER_KEY));

    }

    public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, ResourceLocation.fromNamespaceAndPath(GabbysGrove.MODID, name));
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstrapContext<ConfiguredFeature<?, ?>> context,
                                                                                          ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }


}
