package com.mamailes.gabbysgrove.init;

import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.common.SimpleTier;

public class GGToolTiers {
    public static final Tier PINK_SAPPHIRE = new SimpleTier(GGTags.Blocks.INCORRECT_FOR_BISMUTH_TOOL,
            1400, 4f, 3f, 28, () -> Ingredient.of(GGItems.PINK_SAPPHIRE_SHARDS.get()));

}
