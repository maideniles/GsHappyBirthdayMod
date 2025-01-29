package com.mamailes.gabbysgrove.datagen;


import com.mamailes.gabbysgrove.GabbysGrove;
import com.mamailes.gabbysgrove.init.GGBlocks;
import com.mamailes.gabbysgrove.init.GGTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

import javax.annotation.Nullable;
import java.util.concurrent.CompletableFuture;

public class GGBlockTagProvider extends BlockTagsProvider {
    public GGBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, GabbysGrove.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {

        tag(BlockTags.LEAVES)
                .add(GGBlocks.FLOWERING_LEAVES.get());

        tag(BlockTags.LOGS)
                .add(GGBlocks.CHROMATIC_LOG.get())
                .add(GGBlocks.CHROMATIC_WOOD.get())
                .add(GGBlocks.STRIPPED_CHROMATIC_LOG.get())
                .add(GGBlocks.STRIPPED_CHROMATIC_WOOD.get());

        tag(BlockTags.FENCES)
                .add(GGBlocks.CHROMATIC_FENCE.get());

        tag(BlockTags.WOODEN_FENCES)
        .add(GGBlocks.CHROMATIC_FENCE.get());

        tag(BlockTags.WOODEN_DOORS)
                .add(GGBlocks.CHROMATIC_DOOR.get());


        tag(BlockTags.MINEABLE_WITH_AXE)
                .add(GGBlocks.CHROMATIC_LOG.get())
                .add(GGBlocks.CHROMATIC_WOOD.get())
                .add(GGBlocks.STRIPPED_CHROMATIC_LOG.get())
                .add(GGBlocks.STRIPPED_CHROMATIC_WOOD.get())
                .add(GGBlocks.CHROMATIC_PLANKS.get())
                .add(GGBlocks.CHROMATIC_STAIRS.get())
                .add(GGBlocks.CHROMATIC_SLAB.get())
                .add(GGBlocks.CHROMATIC_FENCE.get())
                .add(GGBlocks.CHROMATIC_FENCE_GATE.get())
                .add(GGBlocks.CHROMATIC_PRESSURE_PLATE.get())
                .add(GGBlocks.CHROMATIC_BUTTON.get())
                .add(GGBlocks.CHROMATIC_DOOR.get())
                .add(GGBlocks.CHROMATIC_TRAPDOOR.get())
                .add(GGBlocks.CHROMATIC_BOOKSHELF.get());

        tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(GGBlocks.PINK_SAPPHIRE_BLOCK.get())
                .add(GGBlocks.BUDDING_PINK_SAPPHIRE_BLOCK.get())
                .add(GGBlocks.PINK_SAPPHIRE_CLUSTER.get())
                .add(GGBlocks.LARGE_PINK_SAPPHIRE_BUD.get())
                .add(GGBlocks.MEDIUM_PINK_SAPPHIRE_BUD.get())
                .add(GGBlocks.SMALL_PINK_SAPPHIRE_BUD.get());


    }

}