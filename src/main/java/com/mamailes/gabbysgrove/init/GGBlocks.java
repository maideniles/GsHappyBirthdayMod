package com.mamailes.gabbysgrove.init;

import com.mamailes.gabbysgrove.GabbysGrove;
import com.mamailes.gabbysgrove.block.*;
import com.mamailes.gabbysgrove.world.feature.tree.GGTreeGrowers;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.DoubleHighBlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

public class GGBlocks {

    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(GabbysGrove.MODID);

//TREE BLOCKS//

    //LOGS, WOODS//
    public static final DeferredBlock<Block> CHROMATIC_LOG = registerBlock("chromatic_log",
            () -> new GGFlammableRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LOG)));
    public static final DeferredBlock<Block> CHROMATIC_WOOD = registerBlock("chromatic_wood",
            () -> new GGFlammableRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD)));
    public static final DeferredBlock<Block> STRIPPED_CHROMATIC_LOG = registerBlock("stripped_chromatic_log",
            () -> new GGFlammableRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_LOG)));
    public static final DeferredBlock<Block> STRIPPED_CHROMATIC_WOOD = registerBlock("stripped_chromatic_wood",
            () -> new GGFlammableRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));

    //PLANKS//
    public static final DeferredBlock<Block> CHROMATIC_PLANKS = registerBlock("chromatic_planks",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)) {
                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 20;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 5;
                }
            });

    //LEAVES//
    public static final DeferredBlock<Block> FLOWERING_LEAVES = registerBlock("flowering_leaves",
            () -> new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES)) {
                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 60;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 30;
                }
            });

    //SAPLING//
    public static final DeferredBlock<Block> CHROMATIC_SAPLING = registerBlock("chromatic_sapling",
            () -> new SaplingBlock(GGTreeGrowers.CHROMATIC, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SAPLING)));

    //CHROMATIC BUILDING BLOCKS//
    public static final DeferredBlock<StairBlock> CHROMATIC_STAIRS = registerBlock("chromatic_stairs",
            () -> new StairBlock(GGBlocks.CHROMATIC_PLANKS.get().defaultBlockState(),
                    BlockBehaviour.Properties.of().strength(2f).requiresCorrectToolForDrops()));

    public static final DeferredBlock<SlabBlock> CHROMATIC_SLAB = registerBlock("chromatic_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of().strength(2f).requiresCorrectToolForDrops()));

    public static final DeferredBlock<PressurePlateBlock> CHROMATIC_PRESSURE_PLATE = registerBlock("chromatic_pressure_plate",
            () -> new PressurePlateBlock(GGBlockSetTypes.CHROMATIC_SET, BlockBehaviour.Properties.of().strength(2f).requiresCorrectToolForDrops()));

    public static final DeferredBlock<ButtonBlock> CHROMATIC_BUTTON = registerBlock("chromatic_button",
            () -> new ButtonBlock(GGBlockSetTypes.CHROMATIC_SET, 20, BlockBehaviour.Properties.of().strength(2f).requiresCorrectToolForDrops().noCollission()));

    public static final DeferredBlock<FenceBlock> CHROMATIC_FENCE = registerBlock("chromatic_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.of().strength(2f).requiresCorrectToolForDrops()));

    public static final DeferredBlock<FenceGateBlock> CHROMATIC_FENCE_GATE = registerBlock("chromatic_fence_gate",
            () -> new FenceGateBlock(WoodType.ACACIA, BlockBehaviour.Properties.of().strength(2f).requiresCorrectToolForDrops()));

    public static final DeferredBlock<DoorBlock> CHROMATIC_DOOR = registerDoubleBlockItem("chromatic_door",
            () -> new DoorBlock(GGBlockSetTypes.CHROMATIC_SET, BlockBehaviour.Properties.of().strength(2f).requiresCorrectToolForDrops().noOcclusion()));

    public static final DeferredBlock<TrapDoorBlock> CHROMATIC_TRAPDOOR = registerBlock("chromatic_trapdoor",
            () -> new TrapDoorBlock(GGBlockSetTypes.CHROMATIC_SET, BlockBehaviour.Properties.of().strength(2f).requiresCorrectToolForDrops().noOcclusion()));

    public static final DeferredBlock<Block> CHROMATIC_BOOKSHELF = registerBlock("chromatic_bookshelf",
            ()-> new GGBookshelfBlock(BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).strength(1.5f)));


    //PINK SAPPHIRE BLOCKS//
    public static final DeferredBlock<Block> PINK_SAPPHIRE_BLOCK = registerBlock("pink_sapphire_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(4f).requiresCorrectToolForDrops().sound(SoundType.AMETHYST)));

    public static final DeferredBlock<Block> BUDDING_PINK_SAPPHIRE_BLOCK = registerBlock("budding_pink_sapphire_block",
            () -> new GGBuddingPinkSapphireBlock(BlockBehaviour.Properties.of()
                    .strength(4f).requiresCorrectToolForDrops().sound(SoundType.AMETHYST)));

    public static final DeferredBlock<Block> PINK_SAPPHIRE_CLUSTER = registerBlock("pink_sapphire_cluster",
            () -> new AmethystClusterBlock(7.0F, 3.0F,BlockBehaviour.Properties.of()
                    .strength(4f).requiresCorrectToolForDrops().sound(SoundType.AMETHYST)));

    public static final DeferredBlock<Block>LARGE_PINK_SAPPHIRE_BUD = registerBlock("large_pink_sapphire_bud",
            () -> new AmethystClusterBlock(5.0F, 3.0F,BlockBehaviour.Properties.of()
            .strength(4f).requiresCorrectToolForDrops().sound(SoundType.AMETHYST).lightLevel((p_152629_) -> {return 4;})));

    public static final DeferredBlock<Block>MEDIUM_PINK_SAPPHIRE_BUD = registerBlock("medium_pink_sapphire_bud",
            () -> new AmethystClusterBlock(4.0F, 3.0F, BlockBehaviour.Properties.of()
                    .strength(4f).requiresCorrectToolForDrops().sound(SoundType.AMETHYST).lightLevel((p_152629_) -> {return 2;})));

    public static final DeferredBlock<Block>SMALL_PINK_SAPPHIRE_BUD = registerBlock("small_pink_sapphire_bud",
            () -> new AmethystClusterBlock(3.0F, 3.0F, BlockBehaviour.Properties.of()
                    .strength(4f).requiresCorrectToolForDrops().sound(SoundType.AMETHYST).lightLevel((p_152629_) -> {return 1;})));

    //FLOWERS//
    //FLOWERS//
    public static final DeferredBlock<Block> BLEEDING_HEARTS = registerBlock("bleeding_hearts",
            () -> new GGFlowerBlock(BlockBehaviour.Properties.of().strength(2.0F).noOcclusion().noCollission().instabreak().sound(SoundType.CROP)));

    public static final DeferredBlock<Block> HIBISCUS = registerBlock("hibiscus",
            () -> new GGFlowerBlock(BlockBehaviour.Properties.of().strength(2.0F).noOcclusion().noCollission().instabreak().sound(SoundType.CROP)));

    public static final DeferredBlock<Block> PRICKLY_PEAR_CACTUS = registerBlock("prickly_pear_cactus",
            () -> new GGCactusBlock(BlockBehaviour.Properties.of().strength(2.0F).noOcclusion().noCollission().instabreak().sound(SoundType.CROP)));

    public static final DeferredBlock<Block> GREEN_LACE_PRIMROSE = registerBlock("green_lace_primrose",
            () -> new GGFlowerBlock(BlockBehaviour.Properties.of().strength(2.0F).noOcclusion().noCollission().instabreak().sound(SoundType.CROP)));

    public static final DeferredBlock<Block> GREEN_GAMBLER_HELLEBORUS = registerBlock("green_gambler_helleborus",
            () -> new GGFlowerBlock(BlockBehaviour.Properties.of().strength(2.0F).noOcclusion().noCollission().instabreak().sound(SoundType.CROP)));

    public static final DeferredBlock<Block> TURQUOISE_IXIA = registerBlock("turquoise_ixia",
            () -> new GGFlowerBlock(BlockBehaviour.Properties.of().strength(2.0F).noOcclusion().noCollission().instabreak().sound(SoundType.CROP)));

    public static final DeferredBlock<Block> BLUE_CHICORY = registerBlock("blue_chicory",
            () -> new GGFlowerBlock(BlockBehaviour.Properties.of().strength(2.0F).noOcclusion().noCollission().instabreak().sound(SoundType.CROP)));

    public static final DeferredBlock<Block> BLUE_SAGE_SALVIA = registerBlock("blue_sage_salvia",
            () -> new GGFlowerBlock(BlockBehaviour.Properties.of().strength(2.0F).noOcclusion().noCollission().instabreak().sound(SoundType.CROP)));

    public static final DeferredBlock<Block> VERBENA_LANAI = registerBlock("verbena_lanai",
            () -> new GGFlowerBlock(BlockBehaviour.Properties.of().strength(2.0F).noOcclusion().noCollission().instabreak().sound(SoundType.CROP)));

    public static final DeferredBlock<Block> SNAPDRAGON = registerBlock("snapdragon",
            () -> new GGFlowerBlock(BlockBehaviour.Properties.of().strength(2.0F).noOcclusion().noCollission().instabreak().sound(SoundType.CROP)));

    public static final DeferredBlock<Block> GERBERA_DAISY = registerBlock("gerbera_daisy",
            () -> new GGFlowerBlock(BlockBehaviour.Properties.of().strength(2.0F).noOcclusion().noCollission().instabreak().sound(SoundType.CROP)));

    public static final DeferredBlock<Block> MOONFLOWER_CACTUS = registerBlock("moonflower_cactus",
            () -> new GGCactusBlock(BlockBehaviour.Properties.of().strength(2.0F).noOcclusion().noCollission().instabreak().sound(SoundType.CROP)));

    public static final DeferredBlock<Block> WHITE_SAGE_SALVIA = registerBlock("white_sage_salvia",
            () -> new GGFlowerBlock(BlockBehaviour.Properties.of().strength(2.0F).noOcclusion().noCollission().instabreak().sound(SoundType.CROP)));

    public static final DeferredBlock<Block> ANGEL_WINGS_SENECIO = registerBlock("angel_wings_senecio",
            () -> new GGFlowerBlock(BlockBehaviour.Properties.of().strength(2.0F).noOcclusion().noCollission().instabreak().sound(SoundType.CROP)));

    public static final DeferredBlock<Block> PENNY_BLACK = registerBlock("penny_black",
            () -> new GGFlowerBlock(BlockBehaviour.Properties.of().strength(2.0F).noOcclusion().noCollission().instabreak().sound(SoundType.CROP)));

    public static final DeferredBlock<Block> CYMBIDIUM = registerBlock("cymbidium",
            () -> new GGFlowerBlock(BlockBehaviour.Properties.of().strength(2.0F).noOcclusion().noCollission().instabreak().sound(SoundType.CROP)));

    //MUSHROOMS//
    public static final DeferredBlock<Block> RHODOTUS = registerBlock("rhodotus",
            () -> new GGFlowerBlock(BlockBehaviour.Properties.of().strength(2.0F).noOcclusion().noCollission().instabreak().sound(SoundType.CROP)));

    public static final DeferredBlock<Block> DEATH_CAP = registerBlock("death_cap",
            () -> new GGFlowerBlock(BlockBehaviour.Properties.of().strength(2.0F).noOcclusion().noCollission().instabreak().sound(SoundType.CROP)));

    public static final DeferredBlock<Block> PARROT_WAXCAP = registerBlock("parrot_waxcap",
            () -> new GGFlowerBlock(BlockBehaviour.Properties.of().strength(2.0F).noOcclusion().noCollission().instabreak().sound(SoundType.CROP)));

    public static final DeferredBlock<Block> PIXIES_PARASOL = registerBlock("pixies_parasol",
            () -> new GGFlowerBlock(BlockBehaviour.Properties.of().strength(2.0F).noOcclusion().noCollission().instabreak().sound(SoundType.CROP)));

    public static final DeferredBlock<Block> AMETHYST_DECEIVER = registerBlock("amethyst_deceiver",
            () -> new GGFlowerBlock(BlockBehaviour.Properties.of().strength(2.0F).noOcclusion().noCollission().instabreak().sound(SoundType.CROP)));

//POTTED FLOWERS//

    public static final DeferredBlock<Block> BLEEDING_HEARTS_POTTED = BLOCKS.register("bleeding_hearts_potted",
            () -> new FlowerPotBlock(() -> ((FlowerPotBlock) Blocks.FLOWER_POT), GGBlocks.BLEEDING_HEARTS,
                    BlockBehaviour.Properties.ofFullCopy((Blocks.POTTED_ALLIUM)).noOcclusion()));

    public static final DeferredBlock<Block> HIBISCUS_POTTED = BLOCKS.register("hibiscus_potted",
            () -> new FlowerPotBlock(() -> ((FlowerPotBlock) Blocks.FLOWER_POT),HIBISCUS,
                    BlockBehaviour.Properties.ofFullCopy((Blocks.POTTED_ALLIUM)).noOcclusion()));

    public static final DeferredBlock<Block> PRICKLY_PEAR_CACTUS_POTTED = BLOCKS.register("prickly_pear_cactus_potted",
            () -> new FlowerPotBlock(() -> ((FlowerPotBlock) Blocks.FLOWER_POT),PRICKLY_PEAR_CACTUS,
                    BlockBehaviour.Properties.ofFullCopy((Blocks.POTTED_ALLIUM)).noOcclusion()));

    public static final DeferredBlock<Block> GREEN_LACE_PRIMROSE_POTTED = BLOCKS.register("green_lace_primrose_potted",
            () -> new FlowerPotBlock(() -> ((FlowerPotBlock) Blocks.FLOWER_POT),GREEN_LACE_PRIMROSE,
                    BlockBehaviour.Properties.ofFullCopy((Blocks.POTTED_ALLIUM)).noOcclusion()));

    public static final DeferredBlock<Block> GREEN_GAMBLER_HELLEBORUS_POTTED = BLOCKS.register("green_gambler_helleborus_potted",
            () -> new FlowerPotBlock(() -> ((FlowerPotBlock) Blocks.FLOWER_POT),GREEN_GAMBLER_HELLEBORUS,
                    BlockBehaviour.Properties.ofFullCopy((Blocks.POTTED_ALLIUM)).noOcclusion()));

    public static final DeferredBlock<Block> TURQUOISE_IXIA_POTTED = BLOCKS.register("turquoise_ixia_potted",
            () -> new FlowerPotBlock(() -> ((FlowerPotBlock) Blocks.FLOWER_POT),TURQUOISE_IXIA,
                    BlockBehaviour.Properties.ofFullCopy((Blocks.POTTED_ALLIUM)).noOcclusion()));

    public static final DeferredBlock<Block> BLUE_CHICORY_POTTED = BLOCKS.register("blue_chicory_potted",
            () -> new FlowerPotBlock(() -> ((FlowerPotBlock) Blocks.FLOWER_POT),BLUE_CHICORY,
                    BlockBehaviour.Properties.ofFullCopy((Blocks.POTTED_ALLIUM)).noOcclusion()));

    public static final DeferredBlock<Block> BLUE_SAGE_SALVIA_POTTED = BLOCKS.register("blue_sage_salvia_potted",
            () -> new FlowerPotBlock(() -> ((FlowerPotBlock) Blocks.FLOWER_POT),BLUE_SAGE_SALVIA,
                    BlockBehaviour.Properties.ofFullCopy((Blocks.POTTED_ALLIUM)).noOcclusion()));

    public static final DeferredBlock<Block> VERBENA_LANAI_POTTED = BLOCKS.register("verbena_lanai_potted",
            () -> new FlowerPotBlock(() -> ((FlowerPotBlock) Blocks.FLOWER_POT),VERBENA_LANAI,
                    BlockBehaviour.Properties.ofFullCopy((Blocks.POTTED_ALLIUM)).noOcclusion()));

    public static final DeferredBlock<Block> SNAPDRAGON_POTTED = BLOCKS.register("snapdragon_potted",
            () -> new FlowerPotBlock(() -> ((FlowerPotBlock) Blocks.FLOWER_POT),SNAPDRAGON,
                    BlockBehaviour.Properties.ofFullCopy((Blocks.POTTED_ALLIUM)).noOcclusion()));

    public static final DeferredBlock<Block> GERBERA_DAISY_POTTED = BLOCKS.register("gerbera_daisy_potted",
            () -> new FlowerPotBlock(() -> ((FlowerPotBlock) Blocks.FLOWER_POT),GERBERA_DAISY,
                    BlockBehaviour.Properties.ofFullCopy((Blocks.POTTED_ALLIUM)).noOcclusion()));

    public static final DeferredBlock<Block> MOONFLOWER_CACTUS_POTTED = BLOCKS.register("moonflower_cactus_potted",
            () -> new FlowerPotBlock(() -> ((FlowerPotBlock) Blocks.FLOWER_POT),MOONFLOWER_CACTUS,
                    BlockBehaviour.Properties.ofFullCopy((Blocks.POTTED_ALLIUM)).noOcclusion()));

    public static final DeferredBlock<Block> WHITE_SAGE_SALVIA_POTTED = BLOCKS.register("white_sage_salvia_potted",
            () -> new FlowerPotBlock(() -> ((FlowerPotBlock) Blocks.FLOWER_POT),WHITE_SAGE_SALVIA,
                    BlockBehaviour.Properties.ofFullCopy((Blocks.POTTED_ALLIUM)).noOcclusion()));

    public static final DeferredBlock<Block> ANGEL_WINGS_SENECIO_POTTED = BLOCKS.register("angel_wings_senecio_potted",
            () -> new FlowerPotBlock(() -> ((FlowerPotBlock) Blocks.FLOWER_POT),ANGEL_WINGS_SENECIO,
                    BlockBehaviour.Properties.ofFullCopy((Blocks.POTTED_ALLIUM)).noOcclusion()));

    public static final DeferredBlock<Block> PENNY_BLACK_POTTED = BLOCKS.register("penny_black_potted",
            () -> new FlowerPotBlock(() -> ((FlowerPotBlock) Blocks.FLOWER_POT),PENNY_BLACK,
                    BlockBehaviour.Properties.ofFullCopy((Blocks.POTTED_ALLIUM)).noOcclusion()));

    public static final DeferredBlock<Block> CYMBIDIUM_POTTED = BLOCKS.register("cymbidium_potted",
            () -> new FlowerPotBlock(() -> ((FlowerPotBlock) Blocks.FLOWER_POT),CYMBIDIUM,
                    BlockBehaviour.Properties.ofFullCopy((Blocks.POTTED_ALLIUM)).noOcclusion()));

    public static final DeferredBlock<Block> RHODOTUS_POTTED = BLOCKS.register("rhodotus_potted",
            () -> new FlowerPotBlock(() -> ((FlowerPotBlock) Blocks.FLOWER_POT),RHODOTUS,
                    BlockBehaviour.Properties.ofFullCopy((Blocks.POTTED_ALLIUM)).noOcclusion()));

    public static final DeferredBlock<Block> DEATH_CAP_POTTED = BLOCKS.register("death_cap_potted",
            () -> new FlowerPotBlock(() -> ((FlowerPotBlock) Blocks.FLOWER_POT),DEATH_CAP,
                    BlockBehaviour.Properties.ofFullCopy((Blocks.POTTED_ALLIUM)).noOcclusion()));

    public static final DeferredBlock<Block> PARROT_WAXCAP_POTTED = BLOCKS.register("parrot_waxcap_potted",
            () -> new FlowerPotBlock(() -> ((FlowerPotBlock) Blocks.FLOWER_POT),PARROT_WAXCAP,
                    BlockBehaviour.Properties.ofFullCopy((Blocks.POTTED_ALLIUM)).noOcclusion()));

    public static final DeferredBlock<Block> PIXIES_PARASOL_POTTED = BLOCKS.register("pixies_parasol_potted",
            () -> new FlowerPotBlock(() -> ((FlowerPotBlock) Blocks.FLOWER_POT),PIXIES_PARASOL,
                    BlockBehaviour.Properties.ofFullCopy((Blocks.POTTED_ALLIUM)).noOcclusion()));

    public static final DeferredBlock<Block> AMETHYST_DECEIVER_POTTED = BLOCKS.register("amethyst_deceiver_potted_potted",
            () -> new FlowerPotBlock(() -> ((FlowerPotBlock) Blocks.FLOWER_POT),AMETHYST_DECEIVER,
                    BlockBehaviour.Properties.ofFullCopy((Blocks.POTTED_ALLIUM)).noOcclusion()));

    public static final DeferredBlock<Block> CHROMATIC_SAPLING_POTTED = BLOCKS.register("chromatic_sapling_potted",
            () -> new FlowerPotBlock(() -> ((FlowerPotBlock) Blocks.FLOWER_POT),CHROMATIC_SAPLING,
                    BlockBehaviour.Properties.ofFullCopy((Blocks.POTTED_ALLIUM)).noOcclusion()));





    public static <T extends Block> DeferredBlock<T> registerBlock(String name, com.google.common.base.Supplier<T> block) {
        DeferredBlock<T> ret = BLOCKS.register(name, block);
        GGItems.ITEMS.register(name, () -> new BlockItem(ret.get(), new Item.Properties()));
        return ret;
    }

    public static <T extends Block> DeferredBlock<T> registerDoubleBlockItem(String name, java.util.function.Supplier<T> block) {
        DeferredBlock<T> ret = BLOCKS.register(name, block);
        GGItems.ITEMS.register(name, () -> new DoubleHighBlockItem(ret.get(), new Item.Properties()));
        return ret;
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }

}
