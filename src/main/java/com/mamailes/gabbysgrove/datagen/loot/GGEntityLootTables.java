package com.mamailes.gabbysgrove.datagen.loot;


import net.minecraft.core.HolderLookup;
import net.minecraft.data.loot.EntityLootSubProvider;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.NestedLootTable;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;

import java.util.stream.Stream;
//
//public class GGEntityLootTables extends EntityLootSubProvider {
//
//    protected GGEntityLootTables(HolderLookup.Provider provider) {
//        super(FeatureFlags.REGISTRY.allFlags(), provider);
//    }
//
//    @Override
//    public void generate() {
//
//        add(GGEntities.PLACEHOLDER_MOTH.get(), fromEntityLootTable(EntityType.CREEPER));
//    }
//
//    public LootTable.Builder fromEntityLootTable(EntityType<?> parent) {
//        return LootTable.lootTable()
//                .withPool(LootPool.lootPool()
//                        .setRolls(ConstantValue.exactly(1))
//                        .add(NestedLootTable.lootTableReference(parent.getDefaultLootTable())));
//    }
//
//    @Override
//    protected Stream<EntityType<?>> getKnownEntityTypes() {
//        return GGEntities.ENTITIES.getEntries()
//                .stream()
//                .map(e -> (EntityType<?>) e.value());
//    }


//}
