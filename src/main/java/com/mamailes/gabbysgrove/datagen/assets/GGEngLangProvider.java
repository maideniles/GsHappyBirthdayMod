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
        add("creativeTabs.gg", "Gabby's Grove");

//ITEMS//

        //PINK SAPPHIRE//
        addItem(GGItems.PINK_SAPPHIRE_SHARDS,"pink Sapphire Shards");

        //PINK SAPPHIRE TOOLS//
        addItem(GGItems.PINK_SAPPHIRE_SWORD, "Pink Sapphire Sword");
        addItem(GGItems.PINK_SAPPHIRE_AXE, "pink Sapphire Axe");
        addItem(GGItems.PINK_SAPPHIRE_PICKAXE, "Pink Sapphire Pickaxe");
        addItem(GGItems.PINK_SAPPHIRE_HAMMER, "Pink Sapphire Hammer");
        addItem(GGItems.PINK_SAPPHIRE_SHOVEL, "Pink Sapphire Shovel");
        addItem(GGItems.PINK_SAPPHIRE_HOE, "Pink Sapphire Hoe");
        addItem(GGItems.MOTH_SPAWN_EGG, "Moth Spawn Egg");

//BLOCKS//

        //PINK_SAPPHIRE//
        addBlock(GGBlocks.PINK_SAPPHIRE_BLOCK, "Pink Sapphire Block");
        addBlock(GGBlocks.BUDDING_PINK_SAPPHIRE_BLOCK, "Budding Pink Sapphire Block");
        addBlock(GGBlocks.PINK_SAPPHIRE_CLUSTER, "Pink Sapphire Cluster");
        addBlock(GGBlocks.LARGE_PINK_SAPPHIRE_BUD, "Large Pink Sapphire Bud");
        addBlock(GGBlocks.MEDIUM_PINK_SAPPHIRE_BUD, "Medium Pink Sapphire Bud");
        addBlock(GGBlocks.SMALL_PINK_SAPPHIRE_BUD, "Small Pink Sapphire Bud");

        //CHROMATIC TREE BLOCKS//
        addBlock(GGBlocks.FLOWERING_LEAVES, "Flowering Leaves");
        addBlock(GGBlocks.CHROMATIC_SAPLING, "Chromatic Sapling");
        addBlock(GGBlocks.FLOWERING_VINE, "Flowering Vine");


        addBlock(GGBlocks.CHROMATIC_LOG, "Chromatic Log");
        addBlock(GGBlocks.CHROMATIC_WOOD, "Chromatic Wood");
        addBlock(GGBlocks.STRIPPED_CHROMATIC_LOG, "Stripped Chromatic Log");
        addBlock(GGBlocks.STRIPPED_CHROMATIC_WOOD, "Stripped Chromatic Wood");
        addBlock(GGBlocks.CHROMATIC_PLANKS, "Chromatic Planks");

        //CHROMATIC WOOD BUILDING BLOCKS//
        addBlock(GGBlocks.CHROMATIC_STAIRS, "Chromatic Stairs");
        addBlock(GGBlocks.CHROMATIC_SLAB, "Chromatic Slab");
        addBlock(GGBlocks.CHROMATIC_FENCE, "Chromatic Fence");
        addBlock(GGBlocks.CHROMATIC_FENCE_GATE, "Chromatic Fence_Gate");
        addBlock(GGBlocks.CHROMATIC_PRESSURE_PLATE, "Chromatic Pressure Plate");
        addBlock(GGBlocks.CHROMATIC_BUTTON, "Chromatic Button");
        addBlock(GGBlocks.CHROMATIC_BOOKSHELF, "chromatic Bookshelf");
        addBlock(GGBlocks.CHROMATIC_DOOR, "Chromatic Door");
        addBlock(GGBlocks.CHROMATIC_TRAPDOOR, "Chromatic Trapdoor");

        //FLOWERS//
        addBlock(GGBlocks.BLEEDING_HEARTS, "Bleeding Hearts");
        addBlock(GGBlocks.HIBISCUS, "Hibiscus");
        addBlock(GGBlocks.PRICKLY_PEAR_CACTUS, "Prickly Pear Cactus");
        addBlock(GGBlocks.GREEN_LACE_PRIMROSE, "Green Lace Primrose");
        addBlock(GGBlocks.GREEN_GAMBLER_HELLEBORUS, "Green Gambler Helleborus");
        addBlock(GGBlocks.TURQUOISE_IXIA, "Turquoise Ixia");
        addBlock(GGBlocks.BLUE_CHICORY, "Blue Chicory");
        addBlock(GGBlocks.BLUE_SAGE_SALVIA, "Blue Sage Salvia");
        addBlock(GGBlocks.VERBENA_LANAI, "Verbena Lanai");
        addBlock(GGBlocks.SNAPDRAGON, "Snapdragon");
        addBlock(GGBlocks.GERBERA_DAISY, "Gerbera Daisy");
        addBlock(GGBlocks.MOONFLOWER_CACTUS, "Moonflower Cactus");
        addBlock(GGBlocks.WHITE_SAGE_SALVIA, "White Sage Salvia");
        addBlock(GGBlocks.STARGAZER_LILY, "Stargazer Lily");
        addBlock(GGBlocks.PENNY_BLACK, "Penny Black");
        addBlock(GGBlocks.CYMBIDIUM, "Cymbidium");

        addBlock(GGBlocks.RHODOTUS, "Rhodotus");
        addBlock(GGBlocks.DEATH_CAP, "Death Cap");
        addBlock(GGBlocks.PARROT_WAXCAP, "Parrot Wax Cap");
        addBlock(GGBlocks.PIXIES_PARASOL, "Pixies Parasol");
        addBlock(GGBlocks.AMETHYST_DECEIVER, "Amethyst Deceiver");

        //ENTITIES//

        //MOTH//
          addEntityType(GGEntities.MOTH,"Giant Lunar Moth");

    }

}