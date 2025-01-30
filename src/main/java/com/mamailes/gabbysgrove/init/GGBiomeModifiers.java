package com.mamailes.gabbysgrove.init;


import com.mamailes.gabbysgrove.GabbysGrove;
import com.mamailes.gabbysgrove.world.GGBiomes;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.world.BiomeModifier;
import net.neoforged.neoforge.common.world.BiomeModifiers;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

import java.util.List;

public class GGBiomeModifiers {

    public static final ResourceKey<BiomeModifier> ADD_CHROMATIC_TREES = registerKey("add_chromatic_trees");

    public static final ResourceKey<BiomeModifier> ADD_PINK_SAPPHIRE_GEODE_OVERWORLD = registerKey("add_pink_sapphire_geode_overworld");

    public static final ResourceKey<BiomeModifier> ADD_FLOWERS_OVERWORLD = registerKey("add_test_flowers_overworld");

    public static final ResourceKey<BiomeModifier> ADD_CHROMATIC_BUSH = registerKey("add_chromatic_bush");


    public static final ResourceKey<BiomeModifier> ADD_BLEEDING_HEARTS_OVERWORLD = registerKey("add_bleeding_hearts_overworld");
    public static final ResourceKey<BiomeModifier> ADD_HIBISCUS_OVERWORLD = registerKey("add_hibiscus_overworld");

    public static final ResourceKey<BiomeModifier> ADD_PRICKLY_PEAR_CACTUS_DESERT = registerKey("add_prickly_pear_cactus_desert");

    public static final ResourceKey<BiomeModifier> ADD_GREEN_LACE_PRIMROSE_OVERWORLD = registerKey("add_green_lace_primrose_overworld");
    public static final ResourceKey<BiomeModifier> ADD_GREEN_GAMBLER_HELLEBORUS_OVERWORLD = registerKey("add_green_gambler_helleborus_overworld");
    public static final ResourceKey<BiomeModifier> ADD_TURQUOISE_IXIA_OVERWORLD = registerKey("add_turquoise_ixia_overworld");
    public static final ResourceKey<BiomeModifier> ADD_BLUE_CHICORY_OVERWORLD = registerKey("add_blue_chicory_overworld");

    public static final ResourceKey<BiomeModifier> ADD_BLUE_SAGE_SALVIA_OVERWORLD = registerKey("add_blue_sage_salvia_overworld");
    public static final ResourceKey<BiomeModifier> ADD_VERBENA_LANAI_OVERWORLD = registerKey("add_verbena_lanai_overworld");
    public static final ResourceKey<BiomeModifier> ADD_SNAPDRAGON_OVERWORLD = registerKey("add_snapdragon_overworld");

    public static final ResourceKey<BiomeModifier> ADD_GERBERA_DAISY_OVERWORLD = registerKey("add_gerbera_daisy_overworld");
    public static final ResourceKey<BiomeModifier> ADD_MOONFLOWER_CACTUS_DESERT = registerKey("add_moonflower_cactus_desert");
    public static final ResourceKey<BiomeModifier> ADD_WHITE_SAGE_SALVIA_OVERWORLD = registerKey("add_white_sage_salvia_overworld");
    public static final ResourceKey<BiomeModifier> ADD_STARGAZER_LILY_OVERWORLD = registerKey("add_angel_wings_senecio_overworld");
    public static final ResourceKey<BiomeModifier> ADD_PENNY_BLACK_OVERWORLD = registerKey("add_penny_black_overworld");
    public static final ResourceKey<BiomeModifier> ADD_CYMBIDIUM_OVERWORLD = registerKey("add_cymbidium_overworld");

    public static final ResourceKey<BiomeModifier> ADD_RHODOTUS_OVERWORLD = registerKey("add_rhodotus_overworld");
    public static final ResourceKey<BiomeModifier> ADD_DEATH_CAP_OVERWORLD = registerKey("add_death_cap_overworld");
    public static final ResourceKey<BiomeModifier> ADD_PARROT_WAXCAP_OVERWORLD = registerKey("add_parrot_waxcap_overworld");
    public static final ResourceKey<BiomeModifier> ADD_PIXIES_PARASOL_OVERWORLD = registerKey("add_pixies_parasol_overworld");
    public static final ResourceKey<BiomeModifier> ADD_AMETHYST_DECEIVER_OVERWORLD = registerKey("add_amethyst_deceiver_overworld");



    public static final ResourceKey<BiomeModifier> ADD_OAK_TREES = registerKey("add_oak_trees");


    //PLACEHOLDER//
     public static final ResourceKey<BiomeModifier> SPAWN_MOTH = registerKey("spawn_moth");

    public static void bootstrap(BootstrapContext<BiomeModifier> context) {
        var placedFeatures = context.lookup(Registries.PLACED_FEATURE);
        var biomes = context.lookup(Registries.BIOME);

        context.register(ADD_PINK_SAPPHIRE_GEODE_OVERWORLD, new BiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
                HolderSet.direct(placedFeatures.getOrThrow(GGPlacedFeatures.PINK_SAPPHIREE_GEODE_PLACEMENT_KEY)),
                GenerationStep.Decoration.VEGETAL_DECORATION));

//        context.register(ADD_OAK_TREES, new BiomeModifiers.AddFeaturesBiomeModifier(
//                HolderSet.direct(biomes.getOrThrow(GGBiomes.GABBYS_GROVE)),
//                HolderSet.direct(placedFeatures.getOrThrow(VegetationPlacements.TREES_BIRCH_AND_OAK)),
//                GenerationStep.Decoration.VEGETAL_DECORATION));

        context.register(ADD_CHROMATIC_TREES, new BiomeModifiers.AddFeaturesBiomeModifier(
                HolderSet.direct(biomes.getOrThrow(GGBiomes.GABBYS_GROVE)),
                HolderSet.direct(placedFeatures.getOrThrow(GGPlacedFeatures.CHROMATIC_PLACEMENT)),
                GenerationStep.Decoration.VEGETAL_DECORATION));

        context.register(ADD_FLOWERS_OVERWORLD, new BiomeModifiers.AddFeaturesBiomeModifier(
                HolderSet.direct(biomes.getOrThrow(GGBiomes.GABBYS_GROVE)),
                HolderSet.direct(placedFeatures.getOrThrow(GGPlacedFeatures.FLOWERS_OVERWORLD_PLACEMENT)),
                GenerationStep.Decoration.VEGETAL_DECORATION));

        context.register(ADD_CHROMATIC_BUSH, new BiomeModifiers.AddFeaturesBiomeModifier(
                HolderSet.direct(biomes.getOrThrow(GGBiomes.GABBYS_GROVE)),
                HolderSet.direct(placedFeatures.getOrThrow(GGPlacedFeatures.CHROMATIC_BUSH_PLACEMENT)),
                GenerationStep.Decoration.VEGETAL_DECORATION));



        //ADD DESERT/HOT PLANTS//
        context.register(ADD_PRICKLY_PEAR_CACTUS_DESERT, new BiomeModifiers.AddFeaturesBiomeModifier(
                HolderSet.direct(biomes.getOrThrow(Biomes.DESERT), biomes.getOrThrow(Biomes.BADLANDS)),
                HolderSet.direct(placedFeatures.getOrThrow(GGPlacedFeatures.PRICKLY_PEAR_CACTUS_PLACEMENT)),
                GenerationStep.Decoration.VEGETAL_DECORATION));

        context.register(ADD_MOONFLOWER_CACTUS_DESERT, new BiomeModifiers.AddFeaturesBiomeModifier(
                HolderSet.direct(biomes.getOrThrow(Biomes.DESERT), biomes.getOrThrow(Biomes.BADLANDS)),
                HolderSet.direct(placedFeatures.getOrThrow(GGPlacedFeatures.MOONFLOWER_CACTUS_PLACEMENT)),
                GenerationStep.Decoration.VEGETAL_DECORATION));

        //ADD OVERWORLD FLOWERS//
        context.register(ADD_BLEEDING_HEARTS_OVERWORLD, new BiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
                HolderSet.direct(placedFeatures.getOrThrow(GGPlacedFeatures.BLEEDING_HEARTS_PLACEMENT)),
                GenerationStep.Decoration.VEGETAL_DECORATION));

        context.register(ADD_HIBISCUS_OVERWORLD, new BiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
                HolderSet.direct(placedFeatures.getOrThrow(GGPlacedFeatures.HIBISCUS_PLACEMENT)),
                GenerationStep.Decoration.VEGETAL_DECORATION));

        context.register(ADD_GREEN_LACE_PRIMROSE_OVERWORLD, new BiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
                HolderSet.direct(placedFeatures.getOrThrow(GGPlacedFeatures.GREEN_LACE_PRIMROSE_PLACEMENT)),
                GenerationStep.Decoration.VEGETAL_DECORATION));

        context.register(ADD_GREEN_GAMBLER_HELLEBORUS_OVERWORLD, new BiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
                HolderSet.direct(placedFeatures.getOrThrow(GGPlacedFeatures.GREEN_GAMBLER_HELLEBORUS_PLACEMENT)),
                GenerationStep.Decoration.VEGETAL_DECORATION));

        context.register(ADD_TURQUOISE_IXIA_OVERWORLD, new BiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
                HolderSet.direct(placedFeatures.getOrThrow(GGPlacedFeatures.TURQUOISE_IXIA_PLACEMENT)),
                GenerationStep.Decoration.VEGETAL_DECORATION));

        context.register(ADD_BLUE_CHICORY_OVERWORLD, new BiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
                HolderSet.direct(placedFeatures.getOrThrow(GGPlacedFeatures.BLUE_CHICORY_PLACEMENT)),
                GenerationStep.Decoration.VEGETAL_DECORATION));

        context.register(ADD_BLUE_SAGE_SALVIA_OVERWORLD, new BiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
                HolderSet.direct(placedFeatures.getOrThrow(GGPlacedFeatures.BLUE_SAGE_SALVIA_PLACEMENT)),
                GenerationStep.Decoration.VEGETAL_DECORATION));

        context.register(ADD_VERBENA_LANAI_OVERWORLD, new BiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
                HolderSet.direct(placedFeatures.getOrThrow(GGPlacedFeatures.VERBENA_LANAI_PLACEMENT)),
                GenerationStep.Decoration.VEGETAL_DECORATION));

        context.register(ADD_SNAPDRAGON_OVERWORLD, new BiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
                HolderSet.direct(placedFeatures.getOrThrow(GGPlacedFeatures.SNAPDRAGON_PLACEMENT)),
                GenerationStep.Decoration.VEGETAL_DECORATION));

        context.register(ADD_GERBERA_DAISY_OVERWORLD, new BiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
                HolderSet.direct(placedFeatures.getOrThrow(GGPlacedFeatures.GERBERA_DAISY_PLACEMENT)),
                GenerationStep.Decoration.VEGETAL_DECORATION));

        context.register(ADD_WHITE_SAGE_SALVIA_OVERWORLD, new BiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
                HolderSet.direct(placedFeatures.getOrThrow(GGPlacedFeatures.WHITE_SAGE_SALVIA_PLACEMENT)),
                GenerationStep.Decoration.VEGETAL_DECORATION));

        context.register(ADD_STARGAZER_LILY_OVERWORLD, new BiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
                HolderSet.direct(placedFeatures.getOrThrow(GGPlacedFeatures.STARGAZER_LILY_PLACEMENT)),
                GenerationStep.Decoration.VEGETAL_DECORATION));

        context.register(ADD_PENNY_BLACK_OVERWORLD, new BiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
                HolderSet.direct(placedFeatures.getOrThrow(GGPlacedFeatures.PENNY_BLACK_PLACEMENT)),
                GenerationStep.Decoration.VEGETAL_DECORATION));

        context.register(ADD_CYMBIDIUM_OVERWORLD, new BiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
                HolderSet.direct(placedFeatures.getOrThrow(GGPlacedFeatures.CYMBIDIUM_PLACEMENT)),
                GenerationStep.Decoration.VEGETAL_DECORATION));



//
////ADD TROPICAL/WARM PLANTS//
//        context.register(ADD_PAPERWHITE_TROPICAL_WARM, new BiomeModifiers.AddFeaturesBiomeModifier(
//                HolderSet.direct(biomes.getOrThrow(Biomes.JUNGLE), biomes.getOrThrow(Biomes.SAVANNA),
//                        biomes.getOrThrow(Biomes.MANGROVE_SWAMP),biomes.getOrThrow(Biomes.PLAINS)),
//                HolderSet.direct(placedFeatures.getOrThrow(HHPlacedFeatures.AMARYLLIS_PLACEMENT)),
//                GenerationStep.Decoration.VEGETAL_DECORATION));
//
//        context.register(ADD_POINSETTIA_TROPICAL, new BiomeModifiers.AddFeaturesBiomeModifier(
//                HolderSet.direct(biomes.getOrThrow(Biomes.JUNGLE), biomes.getOrThrow(Biomes.SAVANNA),
//                        biomes.getOrThrow(Biomes.MANGROVE_SWAMP)),
//                HolderSet.direct(placedFeatures.getOrThrow(HHPlacedFeatures.RED_POINSETTIA_PLACEMENT)),
//                GenerationStep.Decoration.VEGETAL_DECORATION));
//
//        context.register(ADD_WHITE_POINSETTIA_TROPICAL, new BiomeModifiers.AddFeaturesBiomeModifier(
//                HolderSet.direct(biomes.getOrThrow(Biomes.JUNGLE), biomes.getOrThrow(Biomes.SAVANNA),
//                        biomes.getOrThrow(Biomes.MANGROVE_SWAMP)),
//                HolderSet.direct(placedFeatures.getOrThrow(HHPlacedFeatures.WHITE_POINSETTIA_PLACEMENT)),
//                GenerationStep.Decoration.VEGETAL_DECORATION));
//
//        context.register(ADD_POINSETTIA_BUSH_TROPICAL, new BiomeModifiers.AddFeaturesBiomeModifier(
//                HolderSet.direct(biomes.getOrThrow(Biomes.JUNGLE), biomes.getOrThrow(Biomes.SAVANNA),
//                        biomes.getOrThrow(Biomes.MANGROVE_SWAMP)),
//                HolderSet.direct(placedFeatures.getOrThrow(HHPlacedFeatures.RED_POINSETTIA_BUSH_PLACEMENT)),
//                GenerationStep.Decoration.VEGETAL_DECORATION));
//
//        context.register(ADD_WHITE_POINSETTIA_BUSH_TROPICAL, new BiomeModifiers.AddFeaturesBiomeModifier(
//                HolderSet.direct(biomes.getOrThrow(Biomes.JUNGLE), biomes.getOrThrow(Biomes.SAVANNA),
//                        biomes.getOrThrow(Biomes.MANGROVE_SWAMP)),
//                HolderSet.direct(placedFeatures.getOrThrow(HHPlacedFeatures.WHITE_POINSETTIA_BUSH_PLACEMENT)),
//                GenerationStep.Decoration.VEGETAL_DECORATION));
//
////ADD WARM PLANTS//
//        context.register(ADD_MISTLETOE_OAK_WARM, new BiomeModifiers.AddFeaturesBiomeModifier(
//                HolderSet.direct(biomes.getOrThrow(Biomes.PLAINS),biomes.getOrThrow(Biomes.FOREST)),
//                HolderSet.direct(placedFeatures.getOrThrow(HHPlacedFeatures.MISTLETOE_OAK_PLACEMENT)),
//                GenerationStep.Decoration.VEGETAL_DECORATION));
//
//        context.register(ADD_MISTLETOE_BIRCH_WARM, new BiomeModifiers.AddFeaturesBiomeModifier(
//                HolderSet.direct(biomes.getOrThrow(Biomes.PLAINS),biomes.getOrThrow(Biomes.FOREST)),
//                HolderSet.direct(placedFeatures.getOrThrow(HHPlacedFeatures.MISTLETOE_BIRCH_PLACEMENT)),
//                GenerationStep.Decoration.VEGETAL_DECORATION));
//
//        context.register(ADD_CAMELLIA_WARM, new BiomeModifiers.AddFeaturesBiomeModifier(
//                HolderSet.direct(biomes.getOrThrow(Biomes.PLAINS),biomes.getOrThrow(Biomes.FOREST)),
//                HolderSet.direct(placedFeatures.getOrThrow(HHPlacedFeatures.CAMELLIA_PLACEMENT)),
//                GenerationStep.Decoration.VEGETAL_DECORATION));
//
//
////ADD COLD PLANTS//
//        context.register(ADD_CHRISTMAS_ROSE_COLD, new BiomeModifiers.AddFeaturesBiomeModifier(
//                biomes.getOrThrow(Tags.Biomes.IS_COLD),
//                HolderSet.direct(placedFeatures.getOrThrow(HHPlacedFeatures.CHRISTMAS_ROSE_PLACEMENT)),
//                GenerationStep.Decoration.VEGETAL_DECORATION));
//
//        context.register(ADD_WINTERGREEN_COLD, new BiomeModifiers.AddFeaturesBiomeModifier(
//                biomes.getOrThrow(Tags.Biomes.IS_COLD),
//                HolderSet.direct(placedFeatures.getOrThrow(HHPlacedFeatures.WINTERGREEN_PLACEMENT)),
//                GenerationStep.Decoration.VEGETAL_DECORATION));
//
//        context.register(ADD_WINTERBERRY_COLD, new BiomeModifiers.AddFeaturesBiomeModifier(
//                biomes.getOrThrow(Tags.Biomes.IS_COLD),
//                HolderSet.direct(placedFeatures.getOrThrow(HHPlacedFeatures.WINTERBERRY_PLACEMENT)),
//                GenerationStep.Decoration.VEGETAL_DECORATION));
//
//        context.register(ADD_SNOWDROP_COLD, new BiomeModifiers.AddFeaturesBiomeModifier(
//                biomes.getOrThrow(Tags.Biomes.IS_COLD),
//                HolderSet.direct(placedFeatures.getOrThrow(HHPlacedFeatures.SNOWDROP_PLACEMENT)),
//                GenerationStep.Decoration.VEGETAL_DECORATION));
//
//        context.register(ADD_YEW_COLD, new BiomeModifiers.AddFeaturesBiomeModifier(
//                biomes.getOrThrow(Tags.Biomes.IS_COLD),
//                HolderSet.direct(placedFeatures.getOrThrow(HHPlacedFeatures.YEW_PLACEMENT)),
//                GenerationStep.Decoration.VEGETAL_DECORATION));
//












        //PLACEHOLDER//
        context.register(SPAWN_MOTH,
                new BiomeModifiers.AddSpawnsBiomeModifier(
                        // The biome(s) to spawn the mobs within
                        HolderSet.direct(biomes.getOrThrow(GGBiomes.GABBYS_GROVE)),
                        // The spawners of the entities to add
                        List.of(
                                new MobSpawnSettings.SpawnerData(GGEntities.MOTH.get(), 10, 1, 1)

                        )
                )
        );
    }



    private static ResourceKey<BiomeModifier> registerKey(String name) {
        return ResourceKey.create(NeoForgeRegistries.Keys.BIOME_MODIFIERS, GabbysGrove.prefix(name));
    }
}

