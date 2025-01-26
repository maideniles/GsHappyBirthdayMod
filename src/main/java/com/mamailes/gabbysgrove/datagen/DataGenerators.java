package com.mamailes.gabbysgrove.datagen;

import com.mamailes.gabbysgrove.GabbysGrove;
import com.mamailes.gabbysgrove.datagen.assets.GGBlockStateProvider;
import com.mamailes.gabbysgrove.datagen.assets.GGItemModelProvider;
import com.mamailes.gabbysgrove.datagen.loot.GGLootTableProvider;
import com.mamailes.gabbysgrove.datagen.recipe.GGRecipeProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.data.event.GatherDataEvent;


import java.util.Collections;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@EventBusSubscriber(modid = GabbysGrove.MODID, bus = EventBusSubscriber.Bus.MOD)
public class DataGenerators {
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        PackOutput packOutput = generator.getPackOutput();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();

        generator.addProvider(event.includeServer(), new GGRecipeProvider(packOutput,lookupProvider));
        generator.addProvider(event.includeServer(), new LootTableProvider(packOutput, Collections.emptySet(),
                List.of(new LootTableProvider.SubProviderEntry(GGLootTableProvider::new, LootContextParamSets.BLOCK)), lookupProvider));

        generator.addProvider(event.includeClient(), new GGBlockStateProvider(packOutput, existingFileHelper));
        generator.addProvider(event.includeClient(), new GGItemModelProvider(packOutput, existingFileHelper));
        generator.addProvider(event.includeServer(), new GGWorldGenProvider(packOutput, lookupProvider));


       GGBlockTagProvider blockTagGenerator = generator.addProvider(event.includeServer(),
                new GGBlockTagProvider(packOutput, lookupProvider, existingFileHelper));

        generator.addProvider(event.includeServer(), new GGItemTagProvider(packOutput, lookupProvider, blockTagGenerator.contentsGetter(), existingFileHelper));
    }
}
