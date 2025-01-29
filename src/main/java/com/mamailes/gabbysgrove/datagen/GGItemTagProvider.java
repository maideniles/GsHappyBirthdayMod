package com.mamailes.gabbysgrove.datagen;

import com.mamailes.gabbysgrove.GabbysGrove;
import com.mamailes.gabbysgrove.init.GGBlocks;
import com.mamailes.gabbysgrove.init.GGItems;
import com.mamailes.gabbysgrove.init.GGTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class GGItemTagProvider extends ItemTagsProvider {
    public GGItemTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider,
                             CompletableFuture<TagLookup<Block>> blockTags, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, blockTags, GabbysGrove.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {

        tag(ItemTags.SWORDS)
                .add(GGItems.PINK_SAPPHIRE_SWORD.get());
        tag(ItemTags.PICKAXES)
                .add(GGItems.PINK_SAPPHIRE_PICKAXE.get());
        tag(ItemTags.SHOVELS)
                .add(GGItems.PINK_SAPPHIRE_SHOVEL.get());
        tag(ItemTags.AXES)
                .add(GGItems.PINK_SAPPHIRE_AXE.get());
        tag(ItemTags.HOES)
                .add(GGItems.PINK_SAPPHIRE_HOE.get());

        this.tag(ItemTags.LOGS_THAT_BURN)
                .add(GGBlocks.CHROMATIC_LOG.get().asItem())
                .add(GGBlocks.CHROMATIC_WOOD.get().asItem())
                .add(GGBlocks.STRIPPED_CHROMATIC_LOG.get().asItem())
                .add(GGBlocks.STRIPPED_CHROMATIC_WOOD.get().asItem());

        this.tag(ItemTags.PLANKS)
                .add(GGBlocks.CHROMATIC_PLANKS.asItem());

        tag(GGTags.Items.CHROMATIC_LOGS)
                .add(GGBlocks.CHROMATIC_LOG.get().asItem())
                .add(GGBlocks.CHROMATIC_WOOD.get().asItem())
                .add(GGBlocks.STRIPPED_CHROMATIC_LOG.get().asItem())
                .add(GGBlocks.STRIPPED_CHROMATIC_WOOD.get().asItem());

    }
}