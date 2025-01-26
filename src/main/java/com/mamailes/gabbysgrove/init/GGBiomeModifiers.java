package com.mamailes.gabbysgrove.init;


import com.mamailes.gabbysgrove.GabbysGrove;
import com.mamailes.gabbysgrove.world.GGBiomes;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.neoforged.neoforge.common.world.BiomeModifier;
import net.neoforged.neoforge.common.world.BiomeModifiers;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

public class GGBiomeModifiers {

    public static final ResourceKey<BiomeModifier> ADD_CHROMATIC_TREES = registerKey("add_chromatic_trees");
    public static final ResourceKey<BiomeModifier> ADD_OAK_TREES = registerKey("add_oak_trees");


  //PLACEHOLDER//
   // public static final ResourceKey<BiomeModifier> SPAWN_MOTH = registerKey("spawn_moth");

    public static void bootstrap(BootstrapContext<BiomeModifier> context) {
        var placedFeatures = context.lookup(Registries.PLACED_FEATURE);
        var biomes = context.lookup(Registries.BIOME);


//        context.register(ADD_OAK_TREES, new BiomeModifiers.AddFeaturesBiomeModifier(
//                HolderSet.direct(biomes.getOrThrow(GGBiomes.GABBYS_GROVE)),
//                HolderSet.direct(placedFeatures.getOrThrow(VegetationPlacements.TREES_BIRCH_AND_OAK)),
//                GenerationStep.Decoration.VEGETAL_DECORATION));

        context.register(ADD_CHROMATIC_TREES, new BiomeModifiers.AddFeaturesBiomeModifier(
                HolderSet.direct(biomes.getOrThrow(GGBiomes.GABBYS_GROVE)),
                HolderSet.direct(placedFeatures.getOrThrow(GGPlacedFeatures.CHROMATIC_PLACEMENT)),
                GenerationStep.Decoration.VEGETAL_DECORATION));


        //PLACEHOLDER//
//        context.register(SPAWN_MOTH,
//                new BiomeModifiers.AddSpawnsBiomeModifier(
//                        // The biome(s) to spawn the mobs within
//                        biomes.getOrThrow(Tags.Biomes.IS_OVERWORLD),
//                        // The spawners of the entities to add
//                        List.of(
//                                new MobSpawnSettings.SpawnerData(PLACEHOLDERGGEntities.MOTH_PLACEHOLDDER.get(), 10, 1, 1)
//
//                        )
//                )
//        );
    }



    private static ResourceKey<BiomeModifier> registerKey(String name) {
        return ResourceKey.create(NeoForgeRegistries.Keys.BIOME_MODIFIERS, GabbysGrove.prefix(name));
    }
}

