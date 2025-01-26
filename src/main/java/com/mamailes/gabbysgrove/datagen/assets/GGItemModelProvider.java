package com.mamailes.gabbysgrove.datagen.assets;


import com.mamailes.gabbysgrove.GabbysGrove;
import com.mamailes.gabbysgrove.init.GGBlocks;
import com.mamailes.gabbysgrove.init.GGItems;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.client.model.generators.ItemModelBuilder;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.client.model.generators.loaders.ItemLayerModelBuilder;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;

import static com.mamailes.gabbysgrove.GabbysGrove.prefix;


public class GGItemModelProvider extends ItemModelProvider {
    public GGItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, GabbysGrove.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {

//PINK SAPPHIRE//
        basicItem(GGItems.PINK_SAPPHIRE_SHARDS.get());
        generated(GGBlocks.PINK_SAPPHIRE_CLUSTER.getId().getPath(), prefix("block/" + GGBlocks.PINK_SAPPHIRE_CLUSTER.getId().getPath()));
        generated(GGBlocks.LARGE_PINK_SAPPHIRE_BUD.getId().getPath(), prefix("block/" + GGBlocks.LARGE_PINK_SAPPHIRE_BUD.getId().getPath()));
        generated(GGBlocks.MEDIUM_PINK_SAPPHIRE_BUD.getId().getPath(), prefix("block/" + GGBlocks.MEDIUM_PINK_SAPPHIRE_BUD.getId().getPath()));
        generated(GGBlocks.SMALL_PINK_SAPPHIRE_BUD.getId().getPath(), prefix("block/" + GGBlocks.SMALL_PINK_SAPPHIRE_BUD.getId().getPath()));

        toBlockModel(GGBlocks.PINK_SAPPHIRE_BLOCK.get(), prefix("block/pink_sapphire_block"));
        toBlockModel(GGBlocks.BUDDING_PINK_SAPPHIRE_BLOCK.get(), prefix("block/budding_pink_sapphire_block"));


//PINK SAPPHIRE TOOLS//
        handheldItem(GGItems.PINK_SAPPHIRE_AXE.get());
        handheldItem(GGItems.PINK_SAPPHIRE_HOE.get());
        handheldItem(GGItems.PINK_SAPPHIRE_SWORD.get());
        handheldItem(GGItems.PINK_SAPPHIRE_SHOVEL.get());
        handheldItem(GGItems.PINK_SAPPHIRE_HAMMER.get());

//TREES//

    //LEAVES, SAPLING//
        toBlockModel(GGBlocks.FLOWERING_LEAVES.get(), prefix("block/flowering_leaves"));
        saplingItem(GGBlocks.CHROMATIC_SAPLING);

    //LOGS, WOODS, PLANKS//
        toBlockModel(GGBlocks.CHROMATIC_LOG.get(), prefix("block/chromatic_log"));
        toBlockModel(GGBlocks.STRIPPED_CHROMATIC_LOG.get(), prefix("block/stripped_chromatic_log"));
        toBlockModel(GGBlocks.CHROMATIC_WOOD.get(), prefix("block/chromatic_wood"));
        toBlockModel(GGBlocks.STRIPPED_CHROMATIC_WOOD.get(), prefix("block/stripped_chromatic_wood"));

        toBlockModel(GGBlocks.CHROMATIC_PLANKS.get(), prefix("block/chromatic_planks"));

    //BUILDING BLOCKS//
        toBlockModel(GGBlocks.CHROMATIC_STAIRS .get(), prefix("block/chromatic_stairs"));
        toBlockModel(GGBlocks.CHROMATIC_SLAB .get(), prefix("block/chromatic_slab"));
        fenceItem(GGBlocks.CHROMATIC_FENCE, GGBlocks.CHROMATIC_PLANKS);
        toBlockModel(GGBlocks.CHROMATIC_FENCE_GATE.get(), prefix("block/chromatic_fence_gate"));
        toBlockModel(GGBlocks.CHROMATIC_PRESSURE_PLATE.get(), prefix("block/chromatic_pressure_plate"));
        buttonItem(GGBlocks.CHROMATIC_BUTTON, GGBlocks.CHROMATIC_PLANKS);
        toBlockModel(GGBlocks.CHROMATIC_BOOKSHELF.get(), prefix("block/chromatic_bookshelf"));

        basicItem(GGBlocks.CHROMATIC_DOOR.asItem());
        toBlockModel(GGBlocks.CHROMATIC_TRAPDOOR.get(),prefix("block/chromatic_trapdoor_bottom"));


        //FLOWERS//
        generated(GGBlocks.BLEEDING_HEARTS.getId().getPath(), prefix("block/bleeding_hearts"));
        generated(GGBlocks.HIBISCUS.getId().getPath(), prefix("block/hibiscus"));
        generated(GGBlocks.PRICKLY_PEAR_CACTUS.getId().getPath(), prefix("block/prickly_pear_cactus"));
        generated(GGBlocks.GREEN_LACE_PRIMROSE.getId().getPath(), prefix("block/green_lace_primrose"));
        generated(GGBlocks.GREEN_GAMBLER_HELLEBORUS.getId().getPath(), prefix("block/green_gambler_helleborus"));
        generated(GGBlocks.TURQUOISE_IXIA.getId().getPath(), prefix("block/turquoise_ixia"));
        generated(GGBlocks.BLUE_CHICORY.getId().getPath(), prefix("block/blue_chicory"));
        generated(GGBlocks.BLUE_SAGE_SALVIA.getId().getPath(), prefix("block/blue_sage_salvia"));
        generated(GGBlocks.VERBENA_LANAI.getId().getPath(), prefix("block/verbena_lanai"));
        generated(GGBlocks.SNAPDRAGON.getId().getPath(), prefix("block/snapdragon"));
        generated(GGBlocks.GERBERA_DAISY.getId().getPath(), prefix("block/gerbera_daisy"));
        generated(GGBlocks.MOONFLOWER_CACTUS.getId().getPath(), prefix("block/moonflower_cactus"));
        generated(GGBlocks.WHITE_SAGE_SALVIA.getId().getPath(), prefix("block/white_sage_salvia"));
        generated(GGBlocks.ANGEL_WINGS_SENECIO.getId().getPath(), prefix("block/angel_wings_senecio"));
        generated(GGBlocks.PENNY_BLACK.getId().getPath(), prefix("block/penny_black"));
        generated(GGBlocks.CYMBIDIUM.getId().getPath(), prefix("block/cymbidium"));

        generated(GGBlocks.RHODOTUS.getId().getPath(), prefix("block/rhodotus"));
        generated(GGBlocks.DEATH_CAP.getId().getPath(), prefix("block/death_cap"));
        generated(GGBlocks.PARROT_WAXCAP.getId().getPath(), prefix("block/parrot_waxcap"));
        generated(GGBlocks.PIXIES_PARASOL.getId().getPath(), prefix("block/pixies_parasol"));
        generated(GGBlocks.AMETHYST_DECEIVER.getId().getPath(), prefix("block/amethyst_deceiver"));
    }



    private ItemModelBuilder generated(String name, ResourceLocation... layers) {
        return buildItem(name, "item/generated", 0, layers);
    }

    private ItemModelBuilder buildItem(String name, String parent, int emissivity, ResourceLocation... layers) {
        ItemModelBuilder builder = withExistingParent(name, parent);
        for (int i = 0; i < layers.length; i++) {
            builder = builder.texture("layer" + i, layers[i]);
        }
        if (emissivity > 0) builder = builder.customLoader(ItemLayerModelBuilder::begin).emissive(emissivity, emissivity, 0).renderType("minecraft:translucent", 0).end();
        return builder;
    }

    public void buttonItem(DeferredBlock<?> block, DeferredBlock<Block> baseBlock) {
        this.withExistingParent(block.getId().getPath(), mcLoc("block/button_inventory"))
                .texture("texture",  ResourceLocation.fromNamespaceAndPath(GabbysGrove.MODID,
                        "block/" + baseBlock.getId().getPath()));
    }

    public void fenceItem(DeferredBlock<?> block, DeferredBlock<Block> baseBlock) {
        this.withExistingParent(block.getId().getPath(), mcLoc("block/fence_inventory"))
                .texture("texture",  ResourceLocation.fromNamespaceAndPath(GabbysGrove.MODID,
                        "block/" + baseBlock.getId().getPath()));
    }

    private ItemModelBuilder saplingItem(DeferredBlock<Block> item) {
        return withExistingParent(item.getId().getPath(),
                ResourceLocation.parse("item/generated")).texture("layer0",
                ResourceLocation.fromNamespaceAndPath(GabbysGrove.MODID,"block/" + item.getId().getPath()));
    }

    private void toBlock(Block b) {
        toBlockModel(b, BuiltInRegistries.BLOCK.getKey(b).getPath());
    }

    private void toBlockModel(Block b, String model) {
        toBlockModel(b, prefix("block/" + model));
    }

    private void toBlockModel(Block b, ResourceLocation model) {
        withExistingParent(BuiltInRegistries.BLOCK.getKey(b).getPath(), model);
    }
}
