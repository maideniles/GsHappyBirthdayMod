package com.mamailes.gabbysgrove.init;

import com.mamailes.gabbysgrove.GabbysGrove;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class GGTags {
    public static class Blocks {
        public static final TagKey<Block> NEEDS_PINK_SAPPHIRE_TOOL = createTag("needs_pink_sapphire_tool");
        public static final TagKey<Block> INCORRECT_FOR_PINK_SAPPHIRE_TOOL = createTag("incorrect_for_pink_sapphire_tool");



        private static TagKey<Block> createTag(String name) {
            return BlockTags.create(ResourceLocation.fromNamespaceAndPath(GabbysGrove.MODID, name));
        }
    }

    public static class Items {
         public static final TagKey<Item> CHROMATIC_LOGS = createTag("chromatic_logs");

        private static TagKey<Item> createTag(String name) {
            return ItemTags.create(ResourceLocation.fromNamespaceAndPath(GabbysGrove.MODID, name));
        }
    }
}
