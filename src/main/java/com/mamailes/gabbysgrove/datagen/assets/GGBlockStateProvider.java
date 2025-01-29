package com.mamailes.gabbysgrove.datagen.assets;


import com.mamailes.gabbysgrove.GabbysGrove;
import com.mamailes.gabbysgrove.init.GGBlocks;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;


public class GGBlockStateProvider extends BlockStateProvider {
    public GGBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, GabbysGrove.MODID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {

        //LEAVES, SAPLING//
        leavesBlock(GGBlocks.FLOWERING_LEAVES);
        crossBlock(GGBlocks.CHROMATIC_SAPLING);



        //LOGS, WOODS, PLANKS//
        logBlock(((RotatedPillarBlock) GGBlocks.CHROMATIC_LOG.get()));
        axisBlock(((RotatedPillarBlock) GGBlocks.CHROMATIC_WOOD.get()), blockTexture(GGBlocks.CHROMATIC_LOG.get()), blockTexture(GGBlocks.CHROMATIC_LOG.get()));
        logBlock(((RotatedPillarBlock) GGBlocks.STRIPPED_CHROMATIC_LOG.get()));
        axisBlock(((RotatedPillarBlock) GGBlocks.STRIPPED_CHROMATIC_WOOD.get()), blockTexture(GGBlocks.STRIPPED_CHROMATIC_LOG.get()), blockTexture(GGBlocks.STRIPPED_CHROMATIC_LOG.get()));
blockWithItem(GGBlocks.CHROMATIC_PLANKS);

        //CHROMATIC WOOD BUILDING BLOCKS//
        stairsBlock(GGBlocks.CHROMATIC_STAIRS.get(), blockTexture(GGBlocks.CHROMATIC_PLANKS.get()));
        slabBlock(GGBlocks.CHROMATIC_SLAB.get(), blockTexture(GGBlocks.CHROMATIC_PLANKS.get()), blockTexture(GGBlocks.CHROMATIC_PLANKS.get()));

        buttonBlock(GGBlocks.CHROMATIC_BUTTON.get(), blockTexture(GGBlocks.CHROMATIC_PLANKS.get()));
        pressurePlateBlock(GGBlocks.CHROMATIC_PRESSURE_PLATE.get(), blockTexture(GGBlocks.CHROMATIC_PLANKS.get()));

        fenceBlock(GGBlocks.CHROMATIC_FENCE.get(), blockTexture(GGBlocks.CHROMATIC_PLANKS.get()));
        fenceGateBlock(GGBlocks.CHROMATIC_FENCE_GATE.get(), blockTexture(GGBlocks.CHROMATIC_PLANKS.get()));

        blockWithItem(GGBlocks.CHROMATIC_BOOKSHELF);

        doorBlockWithRenderType(GGBlocks.CHROMATIC_DOOR.get(), modLoc("block/doors/chromatic_door_bottom"), modLoc("block/doors/chromatic_door_top"), "cutout");
        trapdoorBlockWithRenderType(GGBlocks.CHROMATIC_TRAPDOOR.get(), modLoc("block/chromatic_trapdoor"), true, "cutout");


//PINK SAPPHIRE//
        blockWithItem(GGBlocks.PINK_SAPPHIRE_BLOCK);
        blockWithItem(GGBlocks.BUDDING_PINK_SAPPHIRE_BLOCK);
        crossBlock(GGBlocks.PINK_SAPPHIRE_CLUSTER);
        crossBlock(GGBlocks.LARGE_PINK_SAPPHIRE_BUD);
        crossBlock(GGBlocks.MEDIUM_PINK_SAPPHIRE_BUD);
        crossBlock(GGBlocks.SMALL_PINK_SAPPHIRE_BUD);


//FLOWERS//
        simpleBlockWithItem(GGBlocks.BLEEDING_HEARTS.get(), models().cross(blockTexture(GGBlocks.BLEEDING_HEARTS.get()).getPath(),
                blockTexture(GGBlocks.BLEEDING_HEARTS.get())).renderType("cutout"));

        simpleBlockWithItem(GGBlocks.HIBISCUS.get(), models().cross(blockTexture(GGBlocks.HIBISCUS.get()).getPath(),
                blockTexture(GGBlocks.HIBISCUS.get())).renderType("cutout"));

        simpleBlockWithItem(GGBlocks.PRICKLY_PEAR_CACTUS.get(), models().cross(blockTexture(GGBlocks.PRICKLY_PEAR_CACTUS.get()).getPath(),
                blockTexture(GGBlocks.PRICKLY_PEAR_CACTUS.get())).renderType("cutout"));

        simpleBlockWithItem(GGBlocks.GREEN_LACE_PRIMROSE.get(), models().cross(blockTexture(GGBlocks.GREEN_LACE_PRIMROSE.get()).getPath(),
                blockTexture(GGBlocks.GREEN_LACE_PRIMROSE.get())).renderType("cutout"));

        simpleBlockWithItem(GGBlocks.GREEN_GAMBLER_HELLEBORUS.get(), models().cross(blockTexture(GGBlocks.GREEN_GAMBLER_HELLEBORUS.get()).getPath(),
                blockTexture(GGBlocks.GREEN_GAMBLER_HELLEBORUS.get())).renderType("cutout"));

        simpleBlockWithItem(GGBlocks.TURQUOISE_IXIA.get(), models().cross(blockTexture(GGBlocks.TURQUOISE_IXIA.get()).getPath(),
                blockTexture(GGBlocks.TURQUOISE_IXIA.get())).renderType("cutout"));

        simpleBlockWithItem(GGBlocks.BLUE_CHICORY.get(), models().cross(blockTexture(GGBlocks.BLUE_CHICORY.get()).getPath(),
                blockTexture(GGBlocks.BLUE_CHICORY.get())).renderType("cutout"));

        simpleBlockWithItem(GGBlocks.BLUE_SAGE_SALVIA.get(), models().cross(blockTexture(GGBlocks.BLUE_SAGE_SALVIA.get()).getPath(),
                blockTexture(GGBlocks.BLUE_SAGE_SALVIA.get())).renderType("cutout"));

        simpleBlockWithItem(GGBlocks.VERBENA_LANAI.get(), models().cross(blockTexture(GGBlocks.VERBENA_LANAI.get()).getPath(),
                blockTexture(GGBlocks.VERBENA_LANAI.get())).renderType("cutout"));

        simpleBlockWithItem(GGBlocks.SNAPDRAGON.get(), models().cross(blockTexture(GGBlocks.SNAPDRAGON.get()).getPath(),
                blockTexture(GGBlocks.SNAPDRAGON.get())).renderType("cutout"));

        simpleBlockWithItem(GGBlocks.GERBERA_DAISY.get(), models().cross(blockTexture(GGBlocks.GERBERA_DAISY.get()).getPath(),
                blockTexture(GGBlocks.GERBERA_DAISY.get())).renderType("cutout"));

        simpleBlockWithItem(GGBlocks.MOONFLOWER_CACTUS.get(), models().cross(blockTexture(GGBlocks.MOONFLOWER_CACTUS.get()).getPath(),
                blockTexture(GGBlocks.MOONFLOWER_CACTUS.get())).renderType("cutout"));

        simpleBlockWithItem(GGBlocks.WHITE_SAGE_SALVIA.get(), models().cross(blockTexture(GGBlocks.WHITE_SAGE_SALVIA.get()).getPath(),
                blockTexture(GGBlocks.WHITE_SAGE_SALVIA.get())).renderType("cutout"));

        simpleBlockWithItem(GGBlocks.ANGEL_WINGS_SENECIO.get(), models().cross(blockTexture(GGBlocks.ANGEL_WINGS_SENECIO.get()).getPath(),
                blockTexture(GGBlocks.ANGEL_WINGS_SENECIO.get())).renderType("cutout"));

        simpleBlockWithItem(GGBlocks.PENNY_BLACK.get(), models().cross(blockTexture(GGBlocks.PENNY_BLACK.get()).getPath(),
                blockTexture(GGBlocks.PENNY_BLACK.get())).renderType("cutout"));

        simpleBlockWithItem(GGBlocks.CYMBIDIUM.get(), models().cross(blockTexture(GGBlocks.CYMBIDIUM.get()).getPath(),
                blockTexture(GGBlocks.CYMBIDIUM.get())).renderType("cutout"));

        simpleBlockWithItem(GGBlocks.RHODOTUS.get(), models().cross(blockTexture(GGBlocks.RHODOTUS.get()).getPath(),
                blockTexture(GGBlocks.RHODOTUS.get())).renderType("cutout"));

        simpleBlockWithItem(GGBlocks.DEATH_CAP.get(), models().cross(blockTexture(GGBlocks.DEATH_CAP.get()).getPath(),
                blockTexture(GGBlocks.DEATH_CAP.get())).renderType("cutout"));

        simpleBlockWithItem(GGBlocks.PARROT_WAXCAP.get(), models().cross(blockTexture(GGBlocks.PARROT_WAXCAP.get()).getPath(),
                blockTexture(GGBlocks.PARROT_WAXCAP.get())).renderType("cutout"));

        simpleBlockWithItem(GGBlocks.PIXIES_PARASOL.get(), models().cross(blockTexture(GGBlocks.PIXIES_PARASOL.get()).getPath(),
                blockTexture(GGBlocks.PIXIES_PARASOL.get())).renderType("cutout"));

        simpleBlockWithItem(GGBlocks.AMETHYST_DECEIVER.get(), models().cross(blockTexture(GGBlocks.AMETHYST_DECEIVER.get()).getPath(),
                blockTexture(GGBlocks.AMETHYST_DECEIVER.get())).renderType("cutout"));




        //POTTED FLOWERS//

        simpleBlock(GGBlocks.BLEEDING_HEARTS_POTTED.get(), models().withExistingParent(GGBlocks.BLEEDING_HEARTS_POTTED.getId().getPath(),
                "block/flower_pot_cross").renderType("cutout").texture("plant", blockTexture(GGBlocks.BLEEDING_HEARTS.get())));

        simpleBlock(GGBlocks.HIBISCUS_POTTED.get(), models().withExistingParent(GGBlocks.HIBISCUS_POTTED.getId().getPath(),
                "block/flower_pot_cross").renderType("cutout").texture("plant", blockTexture(GGBlocks.HIBISCUS.get())));

        simpleBlock(GGBlocks.PRICKLY_PEAR_CACTUS_POTTED.get(), models().withExistingParent(GGBlocks.PRICKLY_PEAR_CACTUS_POTTED.getId().getPath(),
                "block/flower_pot_cross").renderType("cutout").texture("plant", blockTexture(GGBlocks.PRICKLY_PEAR_CACTUS.get())));

        simpleBlock(GGBlocks.GREEN_LACE_PRIMROSE_POTTED.get(), models().withExistingParent(GGBlocks.GREEN_LACE_PRIMROSE_POTTED.getId().getPath(),
                "block/flower_pot_cross").renderType("cutout").texture("plant", blockTexture(GGBlocks.GREEN_LACE_PRIMROSE.get())));

        simpleBlock(GGBlocks.GREEN_GAMBLER_HELLEBORUS_POTTED.get(), models().withExistingParent(GGBlocks.GREEN_GAMBLER_HELLEBORUS_POTTED.getId().getPath(),
                "block/flower_pot_cross").renderType("cutout").texture("plant", blockTexture(GGBlocks.GREEN_GAMBLER_HELLEBORUS.get())));

        simpleBlock(GGBlocks.TURQUOISE_IXIA_POTTED.get(), models().withExistingParent(GGBlocks.TURQUOISE_IXIA_POTTED.getId().getPath(),
                "block/flower_pot_cross").renderType("cutout").texture("plant", blockTexture(GGBlocks.TURQUOISE_IXIA.get())));

        simpleBlock(GGBlocks.BLUE_CHICORY_POTTED.get(), models().withExistingParent(GGBlocks.BLUE_CHICORY_POTTED.getId().getPath(),
                "block/flower_pot_cross").renderType("cutout").texture("plant", blockTexture(GGBlocks.BLUE_CHICORY.get())));

        simpleBlock(GGBlocks.BLUE_SAGE_SALVIA_POTTED.get(), models().withExistingParent(GGBlocks.BLUE_SAGE_SALVIA_POTTED.getId().getPath(),
                "block/flower_pot_cross").renderType("cutout").texture("plant", blockTexture(GGBlocks.BLUE_SAGE_SALVIA.get())));

        simpleBlock(GGBlocks.VERBENA_LANAI_POTTED.get(), models().withExistingParent(GGBlocks.VERBENA_LANAI_POTTED.getId().getPath(),
                "block/flower_pot_cross").renderType("cutout").texture("plant", blockTexture(GGBlocks.VERBENA_LANAI.get())));

        simpleBlock(GGBlocks.SNAPDRAGON_POTTED.get(), models().withExistingParent(GGBlocks.SNAPDRAGON_POTTED.getId().getPath(),
                "block/flower_pot_cross").renderType("cutout").texture("plant", blockTexture(GGBlocks.SNAPDRAGON.get())));

        simpleBlock(GGBlocks.GERBERA_DAISY_POTTED.get(), models().withExistingParent(blockTexture(GGBlocks.GERBERA_DAISY_POTTED.get()).getPath(),
                "block/flower_pot_cross").renderType("cutout").texture("plant",blockTexture(GGBlocks.GERBERA_DAISY.get())));

        simpleBlock(GGBlocks.MOONFLOWER_CACTUS_POTTED.get(), models().withExistingParent(GGBlocks.MOONFLOWER_CACTUS_POTTED.getId().getPath(),
                "block/flower_pot_cross").renderType("cutout").texture("plant", blockTexture(GGBlocks.MOONFLOWER_CACTUS.get())));

        simpleBlock(GGBlocks.WHITE_SAGE_SALVIA_POTTED.get(), models().withExistingParent(GGBlocks.WHITE_SAGE_SALVIA_POTTED.getId().getPath(),
                "block/flower_pot_cross").renderType("cutout").texture("plant", blockTexture(GGBlocks.WHITE_SAGE_SALVIA.get())));

        simpleBlock(GGBlocks.ANGEL_WINGS_SENECIO_POTTED.get(), models().withExistingParent(GGBlocks.ANGEL_WINGS_SENECIO_POTTED.getId().getPath(),
                "block/flower_pot_cross").renderType("cutout").texture("plant", blockTexture(GGBlocks.ANGEL_WINGS_SENECIO.get())));

        simpleBlock(GGBlocks.PENNY_BLACK_POTTED.get(), models().withExistingParent(GGBlocks.PENNY_BLACK_POTTED.getId().getPath(),
                "block/flower_pot_cross").renderType("cutout").texture("plant", blockTexture(GGBlocks.PENNY_BLACK.get())));

        simpleBlock(GGBlocks.CYMBIDIUM_POTTED.get(), models().withExistingParent(GGBlocks.CYMBIDIUM_POTTED.getId().getPath(),
                "block/flower_pot_cross").renderType("cutout").texture("plant", blockTexture(GGBlocks.CYMBIDIUM.get())));


        simpleBlock(GGBlocks.RHODOTUS_POTTED.get(), models().withExistingParent(GGBlocks.RHODOTUS_POTTED.getId().getPath(),
                "block/flower_pot_cross").renderType("cutout").texture("plant", blockTexture(GGBlocks.RHODOTUS.get())));

        simpleBlock(GGBlocks.DEATH_CAP_POTTED.get(), models().withExistingParent(GGBlocks.DEATH_CAP_POTTED.getId().getPath(),
                "block/flower_pot_cross").renderType("cutout").texture("plant", blockTexture(GGBlocks.DEATH_CAP.get())));

        simpleBlock(GGBlocks.PARROT_WAXCAP_POTTED.get(), models().withExistingParent(GGBlocks.PARROT_WAXCAP_POTTED.getId().getPath(),
                "block/flower_pot_cross").renderType("cutout").texture("plant", blockTexture(GGBlocks.PARROT_WAXCAP.get())));

        simpleBlock(GGBlocks.PIXIES_PARASOL_POTTED.get(), models().withExistingParent(GGBlocks.PIXIES_PARASOL_POTTED.getId().getPath(),
                "block/flower_pot_cross").renderType("cutout").texture("plant", blockTexture(GGBlocks.PIXIES_PARASOL.get())));

        simpleBlock(GGBlocks.AMETHYST_DECEIVER_POTTED.get(), models().withExistingParent(GGBlocks.AMETHYST_DECEIVER_POTTED.getId().getPath(),
                "block/flower_pot_cross").renderType("cutout").texture("plant", blockTexture(GGBlocks.AMETHYST_DECEIVER.get())));


        //POTTED SAPLINGS//
        simpleBlock(GGBlocks.CHROMATIC_SAPLING_POTTED.get(), models().withExistingParent(GGBlocks.CHROMATIC_SAPLING_POTTED.getId().getPath(),
                "block/flower_pot_cross").renderType("cutout").texture("plant", blockTexture(GGBlocks.CHROMATIC_SAPLING.get())));


    }

    private void crossBlock(DeferredBlock<Block> blockRegistryObject) {
        simpleBlock(blockRegistryObject.get(),
                models().cross(BuiltInRegistries.BLOCK.getKey(blockRegistryObject.get()).getPath(), blockTexture(blockRegistryObject.get())).renderType("cutout"));
    }

    private void leavesBlock(DeferredBlock<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(),
                models().singleTexture(BuiltInRegistries.BLOCK.getKey(blockRegistryObject.get()).getPath(), ResourceLocation.parse("minecraft:block/leaves"),
                        "all", blockTexture(blockRegistryObject.get())).renderType("cutout"));
    }











    private void blockWithItem(DeferredBlock<?> deferredBlock) {
        simpleBlockWithItem(deferredBlock.get(), cubeAll(deferredBlock.get()));
    }

    private void blockItem(DeferredBlock<?> deferredBlock) {
        simpleBlockItem(deferredBlock.get(), new ModelFile.UncheckedModelFile("gabbysgrove:block/" + deferredBlock.getId().getPath()));
    }

    private void blockItem(DeferredBlock<?> deferredBlock, String appendix) {
        simpleBlockItem(deferredBlock.get(), new ModelFile.UncheckedModelFile("gabbyssgrove:block/" + deferredBlock.getId().getPath() + appendix));
    }
}