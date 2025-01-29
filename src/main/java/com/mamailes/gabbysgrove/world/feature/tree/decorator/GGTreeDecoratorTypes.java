package com.mamailes.gabbysgrove.world.feature.tree.decorator;

import com.mamailes.gabbysgrove.GabbysGrove;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecoratorType;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;
import net.minecraft.world.level.levelgen.placement.PlacementModifierType;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;


public final class GGTreeDecoratorTypes {


    public static final DeferredRegister<TreeDecoratorType<?>> TREE_DECORATORS = DeferredRegister.create(Registries.TREE_DECORATOR_TYPE, GabbysGrove.MODID);
    public static final DeferredRegister<PlacementModifierType<?>> PLACEMENT_MODIFIERS = DeferredRegister.create(Registries.PLACEMENT_MODIFIER_TYPE, GabbysGrove.MODID);


    public static final DeferredHolder<TreeDecoratorType<?>, TreeDecoratorType<GGTrunkVineDecorator>> TREE_ROOTS = TREE_DECORATORS.register("tree_roots", () -> new TreeDecoratorType<>(GGTrunkVineDecorator.CODEC));
    public static final DeferredHolder<TreeDecoratorType<?>, TreeDecoratorType<GGLeafVineDecorator>> DANGLING_DECORATOR = TREE_DECORATORS.register("dangle_from_tree_decorator", () -> new TreeDecoratorType<>(GGLeafVineDecorator.CODEC));

    //goofy but needed
    private static <P extends PlacementModifier> DeferredHolder<PlacementModifierType<?>, PlacementModifierType<P>> registerPlacer(String name, Supplier<PlacementModifierType<P>> factory) {
        return PLACEMENT_MODIFIERS.register(name, factory);
    }
}