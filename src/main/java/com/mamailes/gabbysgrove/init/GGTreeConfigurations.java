package com.mamailes.gabbysgrove.init;

import net.minecraft.util.random.SimpleWeightedRandomList;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FancyFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.ForkingTrunkPlacer;

public class GGTreeConfigurations {

    static SimpleWeightedRandomList.Builder<BlockState> createBlockList() {
        return SimpleWeightedRandomList.builder();
    }


    public static final TreeConfiguration CHROMATIC_KEY = new TreeConfiguration.TreeConfigurationBuilder(
            BlockStateProvider.simple(GGBlocks.CHROMATIC_LOG.get()),
            new ForkingTrunkPlacer(5, 4, 0),
            BlockStateProvider.simple(GGBlocks.FLOWERING_LEAVES.get()),
            new FancyFoliagePlacer(ConstantInt.of(3), ConstantInt.of(2), 2),
            new TwoLayersFeatureSize(2, 0, 2))
            .build();

}
