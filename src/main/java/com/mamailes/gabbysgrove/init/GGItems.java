package com.mamailes.gabbysgrove.init;

import com.mamailes.gabbysgrove.GabbysGrove;
import com.mamailes.gabbysgrove.item.GGHammerItem;
import net.minecraft.world.item.*;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.common.DeferredSpawnEggItem;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;


public class GGItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(GabbysGrove.MODID);

    public static final DeferredItem<Item> PINK_SAPPHIRE_SHARDS = ITEMS.register("pink_sapphire_shard",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<SwordItem> PINK_SAPPHIRE_SWORD = ITEMS.register("pink_sapphire_sword",
            () -> new SwordItem(GGToolTiers.PINK_SAPPHIRE, new Item.Properties()
                    .attributes(SwordItem.createAttributes(GGToolTiers.PINK_SAPPHIRE, 5, -2.4f))));
    public static final DeferredItem<PickaxeItem> PINK_SAPPHIRE_PICKAXE = ITEMS.register("pink_sapphire_pickaxe",
            () -> new PickaxeItem(GGToolTiers.PINK_SAPPHIRE, new Item.Properties()
                    .attributes(PickaxeItem.createAttributes(GGToolTiers.PINK_SAPPHIRE, 1.0F, -2.8f))));
    public static final DeferredItem<ShovelItem> PINK_SAPPHIRE_SHOVEL = ITEMS.register("pink_sapphire_shovel",
            () -> new ShovelItem(GGToolTiers.PINK_SAPPHIRE, new Item.Properties()
                    .attributes(ShovelItem.createAttributes(GGToolTiers.PINK_SAPPHIRE, 1.5F, -3.0f))));
    public static final DeferredItem<AxeItem> PINK_SAPPHIRE_AXE = ITEMS.register("pink_sapphire_axe",
            () -> new AxeItem(GGToolTiers.PINK_SAPPHIRE, new Item.Properties()
                    .attributes(AxeItem.createAttributes(GGToolTiers.PINK_SAPPHIRE, 6.0F, -3.2f))));
    public static final DeferredItem<HoeItem> PINK_SAPPHIRE_HOE = ITEMS.register("pink_sapphire_hoe",
            () -> new HoeItem(GGToolTiers.PINK_SAPPHIRE, new Item.Properties()
                    .attributes(HoeItem.createAttributes(GGToolTiers.PINK_SAPPHIRE, 0F, -3.0f))));

    public static final DeferredItem<GGHammerItem> PINK_SAPPHIRE_HAMMER = ITEMS.register("pink_sapphire_hammer",
            () -> new GGHammerItem(GGToolTiers.PINK_SAPPHIRE, new Item.Properties()
                    .attributes(PickaxeItem.createAttributes(GGToolTiers.PINK_SAPPHIRE, 7F, -3.5f))));

    public static final DeferredItem<Item> MOTH_SPAWN_EGG = ITEMS.register("moth_spawn_egg",
            () -> new DeferredSpawnEggItem(GGEntities.MOTH, 38656, 16711697, (new Item.Properties())));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
