package com.mamailes.gabbysgrove.datagen.loot;

import com.mamailes.gabbysgrove.init.GGBlocks;
import com.mamailes.gabbysgrove.init.GGItems;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;

import java.util.Set;

public class GGLootTableProvider extends BlockLootSubProvider {
    public GGLootTableProvider(HolderLookup.Provider registries) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), registries);
    }

    @Override
    protected void generate() {

        //LEAVES, SAPLING//
        this.add(GGBlocks.FLOWERING_LEAVES.get(), block ->
                createLeavesDrops(block, GGBlocks.CHROMATIC_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));
        dropSelf(GGBlocks.CHROMATIC_SAPLING.get());

        //LOGS, WOODS, PLANKS//
        dropSelf(GGBlocks.CHROMATIC_LOG.get());
        dropSelf(GGBlocks.CHROMATIC_WOOD.get());
        dropSelf(GGBlocks.STRIPPED_CHROMATIC_LOG.get());
        dropSelf(GGBlocks.STRIPPED_CHROMATIC_WOOD.get());
        dropSelf(GGBlocks.CHROMATIC_PLANKS.get());

        //WOOD BUILDING BLOCKS//
        dropSelf(GGBlocks.CHROMATIC_STAIRS.get());
        dropSelf(GGBlocks.CHROMATIC_FENCE.get());
        dropSelf(GGBlocks.CHROMATIC_FENCE_GATE.get());
        dropSelf(GGBlocks.CHROMATIC_PRESSURE_PLATE.get());
        dropSelf(GGBlocks.CHROMATIC_BUTTON.get());
        dropSelf(GGBlocks.CHROMATIC_TRAPDOOR.get());
        add(GGBlocks.CHROMATIC_DOOR.get(), block -> createDoorTable(GGBlocks.CHROMATIC_DOOR.get()));
        add(GGBlocks.CHROMATIC_SLAB.get(),block -> createSlabItemTable(GGBlocks.CHROMATIC_SLAB.get()));
        this.add(GGBlocks.CHROMATIC_BOOKSHELF.get(), createSingleItemTableWithSilkTouch(GGBlocks.CHROMATIC_BOOKSHELF.get(), Items.BOOK, ConstantValue.exactly(3.0F)));


        //PINK SAPPHIRE//
        dropSelf(GGBlocks.PINK_SAPPHIRE_BLOCK.get());
        dropOther(GGBlocks.BUDDING_PINK_SAPPHIRE_BLOCK.get(), Blocks.AIR);

        dropWhenSilkTouch(GGBlocks.LARGE_PINK_SAPPHIRE_BUD.get());
        dropWhenSilkTouch(GGBlocks.MEDIUM_PINK_SAPPHIRE_BUD.get());
        dropWhenSilkTouch(GGBlocks.SMALL_PINK_SAPPHIRE_BUD.get());
        add(GGBlocks.PINK_SAPPHIRE_CLUSTER.get(),
                block -> createMultipleOreDrops(GGBlocks.PINK_SAPPHIRE_CLUSTER.get(), GGItems.PINK_SAPPHIRE_SHARDS.get(), 2, 5));


    }

    protected LootTable.Builder createMultipleOreDrops(Block pBlock, Item item, float minDrops, float maxDrops) {
        HolderLookup.RegistryLookup<Enchantment> registrylookup = this.registries.lookupOrThrow(Registries.ENCHANTMENT);
        return this.createSilkTouchDispatchTable(pBlock,
                this.applyExplosionDecay(pBlock, LootItem.lootTableItem(item)
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(minDrops, maxDrops)))
                        .apply(ApplyBonusCount.addOreBonusCount(registrylookup.getOrThrow(Enchantments.FORTUNE)))));
    }
    @Override
    protected Iterable<Block> getKnownBlocks() {
        return GGBlocks.BLOCKS.getEntries().stream().map(Holder::value)::iterator;
    }
}
