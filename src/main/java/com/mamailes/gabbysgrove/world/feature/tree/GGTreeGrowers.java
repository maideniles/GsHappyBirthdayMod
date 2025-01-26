package com.mamailes.gabbysgrove.world.feature.tree;

import com.mamailes.gabbysgrove.init.GGConfiguredFeatures;
import net.minecraft.world.level.block.grower.TreeGrower;

import java.util.Optional;

public class GGTreeGrowers {

    public static final TreeGrower CHROMATIC = new TreeGrower("chromatic_tree",
            Optional.empty(),
            Optional.of(GGConfiguredFeatures.CHROMATIC_KEY),
            Optional.empty());
}
