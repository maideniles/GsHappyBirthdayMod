package com.mamailes.gabbysgrove;

import com.mamailes.gabbysgrove.entity.MothVariant;
import com.mamailes.gabbysgrove.init.*;
import com.mamailes.gabbysgrove.world.GGBiomeSurfaceRuleData;
import com.mamailes.gabbysgrove.world.GGRegion1;
import com.mamailes.gabbysgrove.world.GGRegion2;
import com.mamailes.gabbysgrove.world.feature.tree.decorator.GGTreeDecoratorTypes;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.FlowerPotBlock;
import net.neoforged.neoforge.registries.*;
import org.slf4j.Logger;

import com.mojang.logging.LogUtils;

import net.minecraft.world.level.block.Blocks;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.server.ServerStartingEvent;
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
        GGEntityDataSerializers.register(modEventBus);
        GGTreeDecoratorTypes.TREE_DECORATORS.register(modEventBus);

        modEventBus.addListener(this::commonSetup);
        modEventBus.addListener(this::registerDatapackRegistries);

        // Register ourselves for server and other game events we are interested in.
        // Note that this is necessary if and only if we want *this* class (GabbysGrove) to respond directly to events.
        // Do not add this line if there are no @SubscribeEvent-annotated functions in this class, like onServerStarting() below.
        NeoForge.EVENT_BUS.register(this);



        // Register our mod's ModConfigSpec so that FML can create and load the config file for us
        modContainer.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    private void registerDatapackRegistries(DataPackRegistryEvent.NewRegistry event) {
        event.dataPackRegistry(
                GGMothVariants.MOTH_VARIANT_REGISTRY_KEY,
                MothVariant.DIRECT_CODEC,
                MothVariant.DIRECT_CODEC
        );
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
                        ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(GGBlocks.STARGAZER_LILY.getId(), GGBlocks.STARGAZER_LILY_POTTED);
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
    }



    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {
    }

    public static ResourceLocation prefix(String name) {
        return ResourceLocation.fromNamespaceAndPath(MODID, name.toLowerCase(Locale.ROOT));
    }
}
