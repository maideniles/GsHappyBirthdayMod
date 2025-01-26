package com.mamailes.gabbysgrove.block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

public class GGBookshelfBlock extends Block {


    public GGBookshelfBlock(Properties p_49795_) {
        super(p_49795_);
    }

    @Override
    public float getEnchantPowerBonus(BlockState state, LevelReader world, BlockPos pos) {
        return 1;
    }
}
