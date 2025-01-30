package com.mamailes.gabbysgrove.init;

import com.mamailes.gabbysgrove.GabbysGrove;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;

import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.GeodeBlockSettings;
import net.minecraft.world.level.levelgen.GeodeCrackSettings;
import net.minecraft.world.level.levelgen.GeodeLayerSettings;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.GeodeConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.RandomPatchConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.NoiseProvider;
import net.minecraft.world.level.levelgen.synth.NormalNoise;

import java.util.List;

public class GGConfiguredFeatures {


    //PINK_SAPPHIRE GEODE//
    public static final ResourceKey<ConfiguredFeature<?, ?>> PINK_SAPPHIRE_GEODE_KEY = registerKey("pink_sapphire_geode");


    //TREES//
    public static final ResourceKey<ConfiguredFeature<?, ?>> CHROMATIC_KEY = registerKey("chromatic_tree");

    //FLOWERS//
    public static final ResourceKey<ConfiguredFeature<?, ?>> FLOWERS_OVERWORLD = registerKey("gg_flowers_overworld");
    public static final ResourceKey<ConfiguredFeature<?, ?>> CHROMATIC_BUSH = registerKey("chromatic_bush");


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
    public static final ResourceKey<ConfiguredFeature<?, ?>> STARGAZER_LILY = registerKey("stargazer_lily");
    public static final ResourceKey<ConfiguredFeature<?, ?>> PENNY_BLACK = registerKey("paperwhite");
    public static final ResourceKey<ConfiguredFeature<?, ?>> CYMBIDIUM = registerKey("white_poinsettia");

    public static final ResourceKey<ConfiguredFeature<?, ?>> RHODOTUS = registerKey("rhodotus");
    public static final ResourceKey<ConfiguredFeature<?, ?>> DEATH_CAP = registerKey("death_cap");
    public static final ResourceKey<ConfiguredFeature<?, ?>> PARROT_WAXCAP = registerKey("parrot_wax_cap");
    public static final ResourceKey<ConfiguredFeature<?, ?>> PIXIES_PARASOL = registerKey("pixies_parasol");
    public static final ResourceKey<ConfiguredFeature<?, ?>> AMETHYST_DECEIVER = registerKey("amethyst_deceiver");


    //FLOWERS//

    public static void bootstrap(BootstrapContext<ConfiguredFeature<?, ?>> context) {
        HolderGetter<ConfiguredFeature<?, ?>> features = context.lookup(Registries.CONFIGURED_FEATURE);


        register(context, PINK_SAPPHIRE_GEODE_KEY, Feature.GEODE,
                new GeodeConfiguration(new GeodeBlockSettings(BlockStateProvider.simple(Blocks.AIR),
                        BlockStateProvider.simple(GGBlocks.PINK_SAPPHIRE_BLOCK.get()),
                        BlockStateProvider.simple(GGBlocks.BUDDING_PINK_SAPPHIRE_BLOCK.get()),
                        BlockStateProvider.simple(Blocks.CALCITE),
                        BlockStateProvider.simple(Blocks.SMOOTH_BASALT),

                        List.of(GGBlocks.SMALL_PINK_SAPPHIRE_BUD.get().defaultBlockState(),
                                GGBlocks.MEDIUM_PINK_SAPPHIRE_BUD.get().defaultBlockState(),
                                GGBlocks.LARGE_PINK_SAPPHIRE_BUD.get().defaultBlockState(),
                                GGBlocks.PINK_SAPPHIRE_CLUSTER.get().defaultBlockState()),

                        BlockTags.FEATURES_CANNOT_REPLACE,
                        BlockTags.GEODE_INVALID_BLOCKS),

                        new GeodeLayerSettings(1.7D, 2.2D, 3.2D, 4.2D),
                        new GeodeCrackSettings(0.95D, 2.0D, 2), 0.35D, 0.083D,
                        true, UniformInt.of(4, 6),
                        UniformInt.of(3, 4), UniformInt.of(1, 2),
                        -16, 16, 0.05D, 1));


        context.register(CHROMATIC_KEY, new ConfiguredFeature<>(Feature.TREE, GGTreeConfigurations.CHROMATIC_KEY));

//FLOWERS//
        register(context, BLEEDING_HEARTS, Feature.RANDOM_PATCH,
                FeatureUtils.simplePatchConfiguration(Feature.SIMPLE_BLOCK,
                        new SimpleBlockConfiguration(BlockStateProvider.simple(GGBlocks.BLEEDING_HEARTS.get()
                                .defaultBlockState())
                        ), List.of(Blocks.GRASS_BLOCK)));

        register(context, HIBISCUS, Feature.RANDOM_PATCH,
                FeatureUtils.simplePatchConfiguration(Feature.SIMPLE_BLOCK,
                        new SimpleBlockConfiguration(BlockStateProvider.simple(GGBlocks.HIBISCUS.get()
                                .defaultBlockState())
                        ), List.of(Blocks.GRASS_BLOCK)));

        register(context, PRICKLY_PEAR_CACTUS, Feature.RANDOM_PATCH,
                FeatureUtils.simplePatchConfiguration(Feature.SIMPLE_BLOCK,
                        new SimpleBlockConfiguration(BlockStateProvider.simple(GGBlocks.PRICKLY_PEAR_CACTUS.get()
                                .defaultBlockState())
                        ), List.of(Blocks.SAND, Blocks.RED_SAND)));

        register(context, GREEN_LACE_PRIMROSE, Feature.RANDOM_PATCH,
                FeatureUtils.simplePatchConfiguration(Feature.SIMPLE_BLOCK,
                        new SimpleBlockConfiguration(BlockStateProvider.simple(GGBlocks.GREEN_LACE_PRIMROSE.get()
                                .defaultBlockState())
                        ), List.of(Blocks.GRASS_BLOCK)));

        register(context, GREEN_GAMBLER_HELLEBORUS, Feature.RANDOM_PATCH,
                FeatureUtils.simplePatchConfiguration(Feature.SIMPLE_BLOCK,
                        new SimpleBlockConfiguration(BlockStateProvider.simple(GGBlocks.GREEN_GAMBLER_HELLEBORUS.get()
                                .defaultBlockState())
                        ), List.of(Blocks.GRASS_BLOCK)));

        register(context, TURQUOISE_IXIA, Feature.RANDOM_PATCH,
                FeatureUtils.simplePatchConfiguration(Feature.SIMPLE_BLOCK,
                        new SimpleBlockConfiguration(BlockStateProvider.simple(GGBlocks.TURQUOISE_IXIA.get()
                                .defaultBlockState())
                        ), List.of(Blocks.GRASS_BLOCK)));

        register(context, BLUE_CHICORY, Feature.RANDOM_PATCH,
                FeatureUtils.simplePatchConfiguration(Feature.SIMPLE_BLOCK,
                        new SimpleBlockConfiguration(BlockStateProvider.simple(GGBlocks.BLUE_CHICORY.get()
                                .defaultBlockState())
                        ), List.of(Blocks.GRASS_BLOCK)));

        register(context, BLUE_SAGE_SALVIA, Feature.RANDOM_PATCH,
                FeatureUtils.simplePatchConfiguration(Feature.SIMPLE_BLOCK,
                        new SimpleBlockConfiguration(BlockStateProvider.simple(GGBlocks.BLUE_SAGE_SALVIA.get()
                                .defaultBlockState())
                        ), List.of(Blocks.GRASS_BLOCK)));

        register(context, VERBENA_LANAI, Feature.RANDOM_PATCH,
                FeatureUtils.simplePatchConfiguration(Feature.SIMPLE_BLOCK,
                        new SimpleBlockConfiguration(BlockStateProvider.simple(GGBlocks.VERBENA_LANAI.get()
                                .defaultBlockState())
                        ), List.of(Blocks.GRASS_BLOCK)));

        register(context, SNAPDRAGON, Feature.RANDOM_PATCH,
                FeatureUtils.simplePatchConfiguration(Feature.SIMPLE_BLOCK,
                        new SimpleBlockConfiguration(BlockStateProvider.simple(GGBlocks.SNAPDRAGON.get()
                                .defaultBlockState())
                        ), List.of(Blocks.GRASS_BLOCK)));

        register(context, GERBERA_DAISY, Feature.RANDOM_PATCH,
                FeatureUtils.simplePatchConfiguration(Feature.SIMPLE_BLOCK,
                        new SimpleBlockConfiguration(BlockStateProvider.simple(GGBlocks.GERBERA_DAISY.get()
                                .defaultBlockState())
                        ), List.of(Blocks.GRASS_BLOCK)));

        register(context, MOONFLOWER_CACTUS, Feature.RANDOM_PATCH,
                FeatureUtils.simplePatchConfiguration(Feature.SIMPLE_BLOCK,
                        new SimpleBlockConfiguration(BlockStateProvider.simple(GGBlocks.MOONFLOWER_CACTUS.get()
                                .defaultBlockState())
                        ), List.of(Blocks.SAND, Blocks.RED_SAND)));

        register(context, WHITE_SAGE_SALVIA, Feature.RANDOM_PATCH,
                FeatureUtils.simplePatchConfiguration(Feature.SIMPLE_BLOCK,
                        new SimpleBlockConfiguration(BlockStateProvider.simple(GGBlocks.WHITE_SAGE_SALVIA.get()
                                .defaultBlockState())
                        ), List.of(Blocks.GRASS_BLOCK)));

        register(context, STARGAZER_LILY, Feature.RANDOM_PATCH,
                FeatureUtils.simplePatchConfiguration(Feature.SIMPLE_BLOCK,
                        new SimpleBlockConfiguration(BlockStateProvider.simple(GGBlocks.STARGAZER_LILY.get()
                                .defaultBlockState())
                        ), List.of(Blocks.GRASS_BLOCK)));

        register(context, PENNY_BLACK, Feature.RANDOM_PATCH,
                FeatureUtils.simplePatchConfiguration(Feature.SIMPLE_BLOCK,
                        new SimpleBlockConfiguration(BlockStateProvider.simple(GGBlocks.PENNY_BLACK.get()
                                .defaultBlockState())
                        ), List.of(Blocks.GRASS_BLOCK)));

        register(context, CYMBIDIUM, Feature.RANDOM_PATCH,
                FeatureUtils.simplePatchConfiguration(Feature.SIMPLE_BLOCK,
                        new SimpleBlockConfiguration(BlockStateProvider.simple(GGBlocks.CYMBIDIUM.get()
                                .defaultBlockState())
                        ), List.of(Blocks.GRASS_BLOCK)));

        register(context, RHODOTUS, Feature.RANDOM_PATCH,
                FeatureUtils.simplePatchConfiguration(Feature.SIMPLE_BLOCK,
                        new SimpleBlockConfiguration(BlockStateProvider.simple(GGBlocks.RHODOTUS.get()
                                .defaultBlockState())
                        ), List.of(Blocks.GRASS_BLOCK)));

        register(context, DEATH_CAP, Feature.RANDOM_PATCH,
                FeatureUtils.simplePatchConfiguration(Feature.SIMPLE_BLOCK,
                        new SimpleBlockConfiguration(BlockStateProvider.simple(GGBlocks.DEATH_CAP.get()
                                .defaultBlockState())
                        ), List.of(Blocks.GRASS_BLOCK)));

        register(context, PARROT_WAXCAP, Feature.RANDOM_PATCH,
                FeatureUtils.simplePatchConfiguration(Feature.SIMPLE_BLOCK,
                        new SimpleBlockConfiguration(BlockStateProvider.simple(GGBlocks.PARROT_WAXCAP.get()
                                .defaultBlockState())
                        ), List.of(Blocks.GRASS_BLOCK)));

        register(context, PIXIES_PARASOL, Feature.RANDOM_PATCH,
                FeatureUtils.simplePatchConfiguration(Feature.SIMPLE_BLOCK,
                        new SimpleBlockConfiguration(BlockStateProvider.simple(GGBlocks.PIXIES_PARASOL.get()
                                .defaultBlockState())
                        ), List.of(Blocks.GRASS_BLOCK)));

        register(context, AMETHYST_DECEIVER, Feature.RANDOM_PATCH,
                FeatureUtils.simplePatchConfiguration(Feature.SIMPLE_BLOCK,
                        new SimpleBlockConfiguration(BlockStateProvider.simple(GGBlocks.AMETHYST_DECEIVER.get()
                                .defaultBlockState())
                        ), List.of(Blocks.GRASS_BLOCK)));


        FeatureUtils.register(
                context, FLOWERS_OVERWORLD, Feature.FLOWER,
                new RandomPatchConfiguration(96, 6, 2,
                        PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK,
                                new SimpleBlockConfiguration(
                                        new NoiseProvider(2345L,
                                                new NormalNoise.NoiseParameters(0, 1.0),
                                                0.020833334F,
                                                List.of(
                                                        GGBlocks.BLEEDING_HEARTS.get().defaultBlockState(),
                                                        GGBlocks.HIBISCUS.get().defaultBlockState(),
                                                        GGBlocks.GREEN_LACE_PRIMROSE.get().defaultBlockState(),
                                                        GGBlocks.GREEN_GAMBLER_HELLEBORUS.get().defaultBlockState(),
                                                        GGBlocks.TURQUOISE_IXIA.get().defaultBlockState(),
                                                        GGBlocks.BLUE_CHICORY.get().defaultBlockState(),
                                                        GGBlocks.BLUE_SAGE_SALVIA.get().defaultBlockState(),
                                                        GGBlocks.VERBENA_LANAI.get().defaultBlockState(),
                                                        GGBlocks.SNAPDRAGON.get().defaultBlockState(),
                                                        GGBlocks.GERBERA_DAISY.get().defaultBlockState(),
                                                        GGBlocks.WHITE_SAGE_SALVIA.get().defaultBlockState(),
                                                        GGBlocks.STARGAZER_LILY.get().defaultBlockState(),
                                                        GGBlocks.PENNY_BLACK.get().defaultBlockState(),
                                                        GGBlocks.CYMBIDIUM.get().defaultBlockState()
                                                )
                                        )
                                )
                        )
                )
        );



        context.register(CHROMATIC_BUSH,new ConfiguredFeature<>(Feature.TREE,GGTreeConfigurations.CHROMATIC_BUSH_KEY));
    }
    private static RandomPatchConfiguration grassPatch(BlockStateProvider p_195203_, int p_195204_) {
        return FeatureUtils.simpleRandomPatchConfiguration(p_195204_, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(p_195203_)));
    }

    public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, ResourceLocation.fromNamespaceAndPath(GabbysGrove.MODID, name));
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstrapContext<ConfiguredFeature<?, ?>> context,
                                                                                          ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }




}
