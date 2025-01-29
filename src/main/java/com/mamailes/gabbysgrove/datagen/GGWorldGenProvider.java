package com.mamailes.gabbysgrove.datagen;

import com.mamailes.gabbysgrove.GabbysGrove;
import com.mamailes.gabbysgrove.init.GGBiomeModifiers;
import com.mamailes.gabbysgrove.init.GGConfiguredFeatures;
import com.mamailes.gabbysgrove.init.GGPlacedFeatures;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.DatapackBuiltinEntriesProvider;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

public class GGWorldGenProvider extends DatapackBuiltinEntriesProvider {
    public static final RegistrySetBuilder BUILDER = new RegistrySetBuilder()

            .add(Registries.CONFIGURED_FEATURE, GGConfiguredFeatures::bootstrap)
            .add(Registries.PLACED_FEATURE, GGPlacedFeatures::bootstrap)
            .add(NeoForgeRegistries.Keys.BIOME_MODIFIERS, GGBiomeModifiers::bootstrap);

    public GGWorldGenProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, BUILDER, Set.of(GabbysGrove.MODID));
    }
}