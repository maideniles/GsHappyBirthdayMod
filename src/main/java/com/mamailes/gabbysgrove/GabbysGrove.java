package com.mamailes.gabbysgrove;

import com.mamailes.gabbysgrove.init.*;
import com.mamailes.gabbysgrove.world.GGBiomeSurfaceRuleData;
import com.mamailes.gabbysgrove.world.GGRegion1;
import com.mamailes.gabbysgrove.world.GGRegion2;
import com.mamailes.gabbysgrove.world.feature.tree.decorator.GGTreeDecoratorTypes;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.FlowerPotBlock;
import org.slf4j.Logger;

import com.mojang.logging.LogUtils;

import net.minecraft.client.Minecraft;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.event.server.ServerStartingEvent;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import terrablender.api.Regions;
import terrablender.api.SurfaceRuleManager;

import java.util.Locale;

// The value here should match an entry in the META-INF/neoforge.mods.toml file
@Mod(GabbysGrove.MODID)
public class GabbysGrove
{
    // Define mod id in a common place for everything to reference
    public static final String MODID = "gabbysgrove";
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();
    // Create a Deferred Register to hold Blocks which will all be registered under the "examplemod" namespace


    public GabbysGrove(IEventBus modEventBus, ModContainer modContainer)
    {
        // Register the commonSetup method for modloading


        GGParticles.register(modEventBus);
        GGBlocks.register(modEventBus);
        GGItems.register(modEventBus);
        GGCreativeModeTabs.register(modEventBus);
        GGEntities.register(modEventBus);
        GGTreeDecoratorTypes.TREE_DECORATORS.register(modEventBus);

        modEventBus.addListener(this::commonSetup);

        // Register ourselves for server and other game events we are interested in.
        // Note that this is necessary if and only if we want *this* class (GabbysGrove) to respond directly to events.
        // Do not add this line if there are no @SubscribeEvent-annotated functions in this class, like onServerStarting() below.
        NeoForge.EVENT_BUS.register(this);



        // Register our mod's ModConfigSpec so that FML can create and load the config file for us
        modContainer.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {
        event.enqueueWork(() ->
                {

                    event.enqueueWork(() -> {
                        ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(GGBlocks.BLEEDING_HEARTS.getId(), GGBlocks.BLEEDING_HEARTS_POTTED);
                        ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(GGBlocks.HIBISCUS.getId(), GGBlocks.HIBISCUS_POTTED);
                        ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(GGBlocks.PRICKLY_PEAR_CACTUS.getId(), GGBlocks.PRICKLY_PEAR_CACTUS_POTTED);
                        ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(GGBlocks.GREEN_LACE_PRIMROSE.getId(), GGBlocks.GREEN_LACE_PRIMROSE_POTTED);
                        ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(GGBlocks.GREEN_GAMBLER_HELLEBORUS.getId(), GGBlocks.GREEN_GAMBLER_HELLEBORUS_POTTED);
                        ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(GGBlocks.TURQUOISE_IXIA.getId(), GGBlocks.TURQUOISE_IXIA_POTTED);
                        ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(GGBlocks.BLUE_CHICORY.getId(), GGBlocks.BLUE_CHICORY_POTTED);
                        ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(GGBlocks.BLUE_SAGE_SALVIA.getId(), GGBlocks.BLUE_SAGE_SALVIA_POTTED);
                        ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(GGBlocks.VERBENA_LANAI.getId(), GGBlocks.VERBENA_LANAI_POTTED);
                        ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(GGBlocks.SNAPDRAGON.getId(), GGBlocks.SNAPDRAGON_POTTED);
                        ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(GGBlocks.GERBERA_DAISY.getId(), GGBlocks.GERBERA_DAISY_POTTED);
                        ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(GGBlocks.MOONFLOWER_CACTUS.getId(), GGBlocks.MOONFLOWER_CACTUS_POTTED);
                        ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(GGBlocks.WHITE_SAGE_SALVIA.getId(), GGBlocks.WHITE_SAGE_SALVIA_POTTED);
                        ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(GGBlocks.ANGEL_WINGS_SENECIO.getId(), GGBlocks.ANGEL_WINGS_SENECIO_POTTED);
                        ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(GGBlocks.PENNY_BLACK.getId(), GGBlocks.PENNY_BLACK_POTTED);
                        ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(GGBlocks.CYMBIDIUM.getId(), GGBlocks.CYMBIDIUM_POTTED);

                        ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(GGBlocks.RHODOTUS.getId(), GGBlocks.RHODOTUS_POTTED);
                        ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(GGBlocks.DEATH_CAP.getId(), GGBlocks.DEATH_CAP_POTTED);
                        ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(GGBlocks.PARROT_WAXCAP.getId(), GGBlocks.PARROT_WAXCAP_POTTED);
                        ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(GGBlocks.PIXIES_PARASOL.getId(), GGBlocks.PIXIES_PARASOL_POTTED);
                        ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(GGBlocks.AMETHYST_DECEIVER.getId(), GGBlocks.AMETHYST_DECEIVER_POTTED);
                        ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(GGBlocks.CHROMATIC_SAPLING.getId(), GGBlocks.CHROMATIC_SAPLING_POTTED);



                    });

        // Weights are kept intentionally low as we add minimal biomes
        Regions.register(new GGRegion1(ResourceLocation.fromNamespaceAndPath(MODID, "overworld_1"), 2));
        Regions.register(new GGRegion2(ResourceLocation.fromNamespaceAndPath(MODID, "overworld_2"), 2));

        // Register our surface rules
        SurfaceRuleManager.addSurfaceRules(SurfaceRuleManager.RuleCategory.OVERWORLD, MODID, GGBiomeSurfaceRuleData.makeRules());
         });

        // Some common setup code
        LOGGER.info("HELLO FROM COMMON SETUP");

        if (Config.logDirtBlock)
            LOGGER.info("DIRT BLOCK >> {}", BuiltInRegistries.BLOCK.getKey(Blocks.DIRT));

        LOGGER.info(Config.magicNumberIntroduction + Config.magicNumber);

        Config.items.forEach((item) -> LOGGER.info("ITEM >> {}", item.toString()));
    }



    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {
        // Do something when the server starts
        LOGGER.info("HELLO from server starting");
    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @EventBusSubscriber(modid = MODID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {
            // Some client setup code
            LOGGER.info("HELLO FROM CLIENT SETUP");
            LOGGER.info("MINECRAFT NAME >> {}", Minecraft.getInstance().getUser().getName());

            //PLACEHOLDER FOR MOTH RENDERS//
          //  EntityRenderers.register(GGEntities.PLACEHOLDER_MOTH.get(), PlaceHolderMothRenderer::new);

        }
    }

    public static ResourceLocation prefix(String name) {
        return ResourceLocation.fromNamespaceAndPath(MODID, name.toLowerCase(Locale.ROOT));
    }
}
