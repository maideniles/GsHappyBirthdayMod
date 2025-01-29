package com.mamailes.gabbysgrove.block;


import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DeadBushBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class GGCactusBlock extends DeadBushBlock {
    protected static final VoxelShape SHAPE = Block.box(-4.0D, 0.0D, -4.0D, 20.0D, 8.0D, 20.0D);


    public GGCactusBlock(Properties p_51021_) {
        super(p_51021_);
    }

    public VoxelShape getShape(BlockState state, BlockGetter p_48946_, BlockPos p_48947_, CollisionContext p_48948_) {

        return SHAPE;
    }

    @Override
    protected boolean mayPlaceOn(BlockState p_52424_, BlockGetter p_52425_, BlockPos p_52426_) {
        return p_52424_.is(Blocks.SAND) || p_52424_.is(Blocks.RED_SAND) || p_52424_.is(Blocks.TERRACOTTA) || p_52424_.is(Blocks.WHITE_TERRACOTTA) || p_52424_.is(Blocks.ORANGE_TERRACOTTA) || p_52424_.is(Blocks.MAGENTA_TERRACOTTA) || p_52424_.is(Blocks.LIGHT_BLUE_TERRACOTTA) || p_52424_.is(Blocks.YELLOW_TERRACOTTA) || p_52424_.is(Blocks.LIME_TERRACOTTA) || p_52424_.is(Blocks.PINK_TERRACOTTA) || p_52424_.is(Blocks.GRAY_TERRACOTTA) || p_52424_.is(Blocks.LIGHT_GRAY_TERRACOTTA) || p_52424_.is(Blocks.CYAN_TERRACOTTA) || p_52424_.is(Blocks.PURPLE_TERRACOTTA) || p_52424_.is(Blocks.BLUE_TERRACOTTA) || p_52424_.is(Blocks.BROWN_TERRACOTTA) || p_52424_.is(Blocks.GREEN_TERRACOTTA) || p_52424_.is(Blocks.RED_TERRACOTTA) || p_52424_.is(Blocks.BLACK_TERRACOTTA);
    }



    public void entityInside(BlockState p_51148_, Level p_51149_, BlockPos p_51150_, Entity p_51151_) {
        p_51151_.hurt(p_51149_.damageSources().cactus(), 1.0F);
    }


}


