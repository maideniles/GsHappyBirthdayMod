package com.mamailes.gabbysgrove.datagen.assets;


import com.mamailes.gabbysgrove.GabbysGrove;
import com.mamailes.gabbysgrove.init.GGBlocks;
import com.mamailes.gabbysgrove.init.GGEntities;
import com.mamailes.gabbysgrove.init.GGItems;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.LanguageProvider;

public class GGEngLangProvider extends LanguageProvider {

    public GGEngLangProvider(PackOutput output) {
        super(output, GabbysGrove.MODID, "en_us");
    }

    @Override
    protected void addTranslations() {

//ADD CREATIVE TAB TRANSLATION//
        add("creativeTab.gg", "Gabby's Grove");

//ITEMS//

        //PINK SAPPHIRE//
        addItem(GGItems.PINK_SAPPHIRE_SHARDS,"pink_sapphire_shards");

        //PINK SAPPHIRE TOOLS//
        addItem(GGItems.PINK_SAPPHIRE_SWORD, "pink_sapphire_sword");
        addItem(GGItems.PINK_SAPPHIRE_AXE, "pink_sapphire_axe");
        addItem(GGItems.PINK_SAPPHIRE_PICKAXE, "pink_sapphire_pickaxe");
        addItem(GGItems.PINK_SAPPHIRE_HAMMER, "pink_sapphire_hammer");
        addItem(GGItems.PINK_SAPPHIRE_SHOVEL, "pink_sapphire_shovel");
        addItem(GGItems.PINK_SAPPHIRE_HOE, "pink_sapphire_hoe");

//BLOCKS//

        //PINK_SAPPHIRE//
        addBlock(GGBlocks.PINK_SAPPHIRE_BLOCK, "pink_sapphire_block");
        addBlock(GGBlocks.BUDDING_PINK_SAPPHIRE_BLOCK, "budding_pink_sapphire_block");
        addBlock(GGBlocks.PINK_SAPPHIRE_CLUSTER, "pink_sapphire_cluster");
        addBlock(GGBlocks.LARGE_PINK_SAPPHIRE_BUD, "large_pink_sapphire_bud");
        addBlock(GGBlocks.MEDIUM_PINK_SAPPHIRE_BUD, "medium_pink_sapphire_bud");
        addBlock(GGBlocks.SMALL_PINK_SAPPHIRE_BUD, "small_pink_sapphire_bud");

        //CHROMATIC TREE BLOCKS//
        addBlock(GGBlocks.FLOWERING_LEAVES, "flowering_leaves");
        addBlock(GGBlocks.CHROMATIC_SAPLING, "chromatic_sapling");

        addBlock(GGBlocks.CHROMATIC_LOG, "chromatic_log");
        addBlock(GGBlocks.CHROMATIC_WOOD, "chromatic_wood");
        addBlock(GGBlocks.STRIPPED_CHROMATIC_LOG, "stripped_chromatic_log");
        addBlock(GGBlocks.STRIPPED_CHROMATIC_WOOD, "stripped_chromatic_wood");
        addBlock(GGBlocks.CHROMATIC_PLANKS, "chromatic_planks");

        //CHROMATIC WOOD BUILDING BLOCKS//
        addBlock(GGBlocks.CHROMATIC_STAIRS, "chromatic_stairs");
        addBlock(GGBlocks.CHROMATIC_SLAB, "chromatic_slab");
        addBlock(GGBlocks.CHROMATIC_FENCE, "chromatic_fence");
        addBlock(GGBlocks.CHROMATIC_FENCE_GATE, "chromatic_fence_gate");
        addBlock(GGBlocks.CHROMATIC_PRESSURE_PLATE, "chromatic_pressure_plate");
        addBlock(GGBlocks.CHROMATIC_BUTTON, "chromatic_button");
        addBlock(GGBlocks.CHROMATIC_BOOKSHELF, "chromatic_bookshelf");
        addBlock(GGBlocks.CHROMATIC_DOOR, "chromatic_door");
        addBlock(GGBlocks.CHROMATIC_TRAPDOOR, "chromatic_trapdoor");

    //ENTITIES//

        //MOTH//
        this.addEntityType(GGEntities.MOTH,"Moth");
        this.addItem(GGItems.MOTH_SPAWN_EGG, "Moth Spawn Egg");

    }

}