package com.mamailes.gabbysgrove.world.feature.tree.decorator;


import com.mamailes.gabbysgrove.block.GGVineBlock;
import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.SimpleStateProvider;
import net.minecraft.world.level.levelgen.feature.treedecorators.LeaveVineDecorator;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecorator;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecoratorType;

public class GGTrunkVineDecorator extends TreeDecorator {
    private static final SimpleStateProvider EMPTY = BlockStateProvider.simple(Blocks.AIR.defaultBlockState());

    public static final MapCodec<GGTrunkVineDecorator> CODEC = Codec.floatRange(0.0F, 1.0F)
            .fieldOf("probability")
            .xmap(GGTrunkVineDecorator::new, p_226037_ -> p_226037_.probability);
    private final float probability;

    public GGTrunkVineDecorator(float p_226031_) {
        this.probability = p_226031_;
    }




    protected TreeDecoratorType<?> type() {
        return GGTreeDecoratorTypes.TREE_ROOTS.get();
    }


    public void placeVine(BlockPos pos, BooleanProperty property, Context context) {
        context.setBlock(pos, Blocks.GLOW_LICHEN.defaultBlockState().setValue(property, true));
    }

    public void place(Context context) {
        RandomSource randomsource = context.random();
        context.logs().forEach((p_226075_) -> {
            if (randomsource.nextInt(3) > 0) {
                BlockPos blockpos = p_226075_.west();
                if (context.isAir(blockpos)) {
                    this.placeVine(blockpos, GGVineBlock.EAST,context);
                }
            }

            if (randomsource.nextInt(3) > 0) {
                BlockPos blockpos1 = p_226075_.east();
                if (context.isAir(blockpos1)) {
                    this.placeVine(blockpos1, GGVineBlock.WEST,context);
                }
            }

            if (randomsource.nextInt(3) > 0) {
                BlockPos blockpos2 = p_226075_.north();
                if (context.isAir(blockpos2)) {
                    this.placeVine(blockpos2, GGVineBlock.SOUTH,context);
                }
            }

            if (randomsource.nextInt(3) > 0) {
                BlockPos blockpos3 = p_226075_.south();
                if (context.isAir(blockpos3)) {
                    this.placeVine(blockpos3, GGVineBlock.NORTH,context);
                }
            }

        });
    }
}