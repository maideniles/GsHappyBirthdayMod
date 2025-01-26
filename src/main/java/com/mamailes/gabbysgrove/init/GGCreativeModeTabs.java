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

                        output.accept(GGBlocks.FLOWERING_LEAVES.get());

                    })
                    .build());


    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }



}


