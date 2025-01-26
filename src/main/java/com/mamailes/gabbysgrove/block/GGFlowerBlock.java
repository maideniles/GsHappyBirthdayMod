package com.mamailes.gabbysgrove.block;


import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.BushBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;


public class GGFlowerBlock extends BushBlock {
    public static final MapCodec<GGFlowerBlock> CODEC = simpleCodec(GGFlowerBlock::new);

    protected static final VoxelShape SHAPE = Block.box(4.0D, 0.0D, 4.0D, 12.0D, 12.0D, 12.0D);

    public GGFlowerBlock(Properties p_51021_) {
        super(p_51021_);
    }

    @Override
    protected MapCodec<? extends BushBlock> codec() {
        return CODEC;
    }

    public VoxelShape getShape(BlockState state, BlockGetter p_48946_, BlockPos p_48947_, CollisionContext p_48948_) {

        return SHAPE;
    }

    @Override
    protected boolean mayPlaceOn(BlockState p_51042_, BlockGetter p_51043_, BlockPos p_51044_) {
        return p_51042_.is(BlockTags.DIRT) || p_51042_.is(Blocks.DIRT);
    }

    @Override
    protected boolean canSurvive(BlockState pState, LevelReader pLevel, BlockPos pPos) {
        BlockPos blockpos = pPos.below();
        if (pState.getBlock() == this){
            net.neoforged.neoforge.common.util.TriState soilDecision = pLevel.getBlockState(pPos.below()).canSustainPlant(pLevel, pPos.below(), Direction.UP, pState);
            if (!soilDecision.isDefault()) return soilDecision.isTrue();
            return super.canSurvive(pState, pLevel, pPos);
        }
        return this.mayPlaceOn(pLevel.getBlockState(blockpos), pLevel, blockpos);
    }

}

