package com.mamailes.gabbysgrove.init;


import com.mamailes.gabbysgrove.GabbysGrove;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;


public class GGCreativeModeTabs {

    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, GabbysGrove.MODID);


    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> GG = CREATIVE_MODE_TABS.register("gg", () -> CreativeModeTab.builder()
            .title(Component.translatable("creativeTabs.gg"))
            .icon(() -> new ItemStack(GGBlocks.FLOWERING_LEAVES.get()))
            .displayItems((parameters, output) -> {

                output.accept(GGBlocks.PINK_SAPPHIRE_BLOCK.get());
                output.accept(GGBlocks.BUDDING_PINK_SAPPHIRE_BLOCK.get());
                output.accept(GGBlocks.PINK_SAPPHIRE_CLUSTER.get());
                output.accept(GGBlocks.LARGE_PINK_SAPPHIRE_BUD.get());
                output.accept(GGBlocks.MEDIUM_PINK_SAPPHIRE_BUD.get());
                output.accept(GGBlocks.SMALL_PINK_SAPPHIRE_BUD.get());


                output.accept(GGItems.PINK_SAPPHIRE_SHARDS.get());
                output.accept(GGItems.PINK_SAPPHIRE_SWORD.get());
                output.accept(GGItems.PINK_SAPPHIRE_AXE.get());
                output.accept(GGItems.PINK_SAPPHIRE_PICKAXE.get());
                output.accept(GGItems.PINK_SAPPHIRE_HAMMER.get());
                output.accept(GGItems.PINK_SAPPHIRE_SHOVEL.get());
                output.accept(GGItems.PINK_SAPPHIRE_HOE.get());

                output.accept(GGItems.MOTH_SPAWN_EGG.get());

                output.accept(GGBlocks.FLOWERING_LEAVES.get());
                output.accept(GGBlocks.FLOWERING_VINE.get());
                output.accept(GGBlocks.CHROMATIC_SAPLING.get());

                output.accept(GGBlocks.CHROMATIC_LOG.get());
                output.accept(GGBlocks.CHROMATIC_WOOD.get());
                output.accept(GGBlocks.STRIPPED_CHROMATIC_LOG.get());
                output.accept(GGBlocks.STRIPPED_CHROMATIC_WOOD.get());

                output.accept(GGBlocks.CHROMATIC_PLANKS.get());
                output.accept(GGBlocks.CHROMATIC_STAIRS.get());
                output.accept(GGBlocks.CHROMATIC_SLAB.get());
                output.accept(GGBlocks.CHROMATIC_BOOKSHELF.get());
                output.accept(GGBlocks.CHROMATIC_FENCE.get());
                output.accept(GGBlocks.CHROMATIC_FENCE_GATE.get());
                output.accept(GGBlocks.CHROMATIC_PRESSURE_PLATE.get());
                output.accept(GGBlocks.CHROMATIC_BUTTON.get());
                output.accept(GGBlocks.CHROMATIC_DOOR.get());
                output.accept(GGBlocks.CHROMATIC_TRAPDOOR.get());

                output.accept(GGBlocks.BLEEDING_HEARTS.get());
                output.accept(GGBlocks.HIBISCUS.get());
                output.accept(GGBlocks.PRICKLY_PEAR_CACTUS.get());
                output.accept(GGBlocks.GREEN_LACE_PRIMROSE.get());
                output.accept(GGBlocks.GREEN_GAMBLER_HELLEBORUS.get());
                output.accept(GGBlocks.TURQUOISE_IXIA.get());
                output.accept(GGBlocks.BLUE_CHICORY.get());
                output.accept(GGBlocks.BLUE_SAGE_SALVIA.get());
                output.accept(GGBlocks.VERBENA_LANAI.get());
                output.accept(GGBlocks.SNAPDRAGON.get());
                output.accept(GGBlocks.GERBERA_DAISY.get());
                output.accept(GGBlocks.MOONFLOWER_CACTUS.get());
                output.accept(GGBlocks.WHITE_SAGE_SALVIA.get());
                output.accept(GGBlocks.STARGAZER_LILY.get());
                output.accept(GGBlocks.PENNY_BLACK.get());
                output.accept(GGBlocks.CYMBIDIUM.get());

                output.accept(GGBlocks.RHODOTUS.get());
                output.accept(GGBlocks.DEATH_CAP.get());
                output.accept(GGBlocks.PARROT_WAXCAP.get());
                output.accept(GGBlocks.PIXIES_PARASOL.get());
                output.accept(GGBlocks.AMETHYST_DECEIVER.get());













            })
            .build());


    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }



}


