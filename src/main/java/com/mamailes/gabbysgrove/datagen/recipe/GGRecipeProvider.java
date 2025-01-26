package com.mamailes.gabbysgrove.datagen.recipe;

import com.mamailes.gabbysgrove.GabbysGrove;
import com.mamailes.gabbysgrove.init.GGBlocks;
import com.mamailes.gabbysgrove.init.GGItems;
import com.mamailes.gabbysgrove.init.GGTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class GGRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public GGRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    @Override
    protected void buildRecipes(RecipeOutput recipeOutput) {

//BLOCK FROM SHARDS//
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, GGBlocks.PINK_SAPPHIRE_BLOCK.get())
                .pattern("SS")
                .pattern("SS")
                .define('S', GGItems.PINK_SAPPHIRE_SHARDS.get())
                .unlockedBy("has_pink_sapphire", has(GGItems.PINK_SAPPHIRE_SHARDS)).save(recipeOutput);

//SHARDS FROM BLOCK//
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, GGItems.PINK_SAPPHIRE_SHARDS.get(), 4)
                .requires(GGBlocks.PINK_SAPPHIRE_BLOCK.get())
                .unlockedBy("has_pink_sapphire_block", has(GGBlocks.PINK_SAPPHIRE_BLOCK)).save(recipeOutput);

//PLANKS FROM LOGS//
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, GGBlocks.CHROMATIC_PLANKS.get(), 4)
                .requires(Ingredient.of(GGTags.Items.CHROMATIC_LOGS), 1)
                .unlockedBy("has_chromatic_log", has(GGBlocks.CHROMATIC_LOG)).save(recipeOutput);


//WOOD BUILDING BLOCK RECIPES//
        stairBuilder(GGBlocks.CHROMATIC_STAIRS.get(), Ingredient.of(GGBlocks.CHROMATIC_PLANKS)).group("chromatic_planks")
                .unlockedBy("has_chromatic_planks", has(GGBlocks.CHROMATIC_PLANKS)).save(recipeOutput);
        slab(recipeOutput, RecipeCategory.BUILDING_BLOCKS, GGBlocks.CHROMATIC_SLAB.get(), GGBlocks.CHROMATIC_PLANKS.get());

        buttonBuilder(GGBlocks.CHROMATIC_BUTTON.get(), Ingredient.of(GGBlocks.CHROMATIC_PLANKS.get())).group("chromatic_planks")
                .unlockedBy("has_chromatic_planks", has(GGBlocks.CHROMATIC_PLANKS.get())).save(recipeOutput);
        pressurePlate(recipeOutput, GGBlocks.CHROMATIC_PRESSURE_PLATE.get(), GGBlocks.CHROMATIC_PLANKS.get());

        fenceBuilder(GGBlocks.CHROMATIC_FENCE.get(), Ingredient.of(GGBlocks.CHROMATIC_PLANKS.get())).group("chromatic_planks")
                .unlockedBy("has_chromatic_planks", has(GGBlocks.CHROMATIC_PLANKS.get())).save(recipeOutput);
        fenceGateBuilder(GGBlocks.CHROMATIC_FENCE_GATE.get(), Ingredient.of(GGBlocks.CHROMATIC_PLANKS.get())).group("chromatic_planks")
                .unlockedBy("has_chromatic_planks", has(GGBlocks.CHROMATIC_PLANKS.get())).save(recipeOutput);

        doorBuilder(GGBlocks.CHROMATIC_DOOR.get(), Ingredient.of(GGBlocks.CHROMATIC_PLANKS.get())).group("chromatic_planks")
                .unlockedBy("has_chromatic_planks", has(GGBlocks.CHROMATIC_PLANKS.get())).save(recipeOutput);
        trapdoorBuilder(GGBlocks.CHROMATIC_TRAPDOOR.get(), Ingredient.of(GGBlocks.CHROMATIC_PLANKS.get())).group("chromatic_planks")
                .unlockedBy("has_chromatic_planks", has(GGBlocks.CHROMATIC_PLANKS.get())).save(recipeOutput);

        //BOOKSHELF//
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, GGBlocks.CHROMATIC_BOOKSHELF.get())
                .pattern("SSS")
                .pattern("BBB")
                .pattern("SSS")
                .define('S', GGBlocks.CHROMATIC_SLAB.get())
                .define('B', Items.BOOK)
                .unlockedBy("has_pink_sapphire", has(GGItems.PINK_SAPPHIRE_SHARDS)).save(recipeOutput);

       }

//    protected static void oreSmelting(RecipeOutput recipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult,
//                                      float pExperience, int pCookingTIme, String pGroup) {
//        oreCooking(recipeOutput, RecipeSerializer.SMELTING_RECIPE, SmeltingRecipe::new, pIngredients, pCategory, pResult,
//                pExperience, pCookingTIme, pGroup, "_from_smelting");
//    }

//    protected static void oreBlasting(RecipeOutput recipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult,
//                                      float pExperience, int pCookingTime, String pGroup) {
//        oreCooking(recipeOutput, RecipeSerializer.BLASTING_RECIPE, BlastingRecipe::new, pIngredients, pCategory, pResult,
//                pExperience, pCookingTime, pGroup, "_from_blasting");
//    }

    protected static <T extends AbstractCookingRecipe> void oreCooking(RecipeOutput recipeOutput, RecipeSerializer<T> pCookingSerializer, AbstractCookingRecipe.Factory<T> factory,
                                                                       List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pRecipeName) {
        for(ItemLike itemlike : pIngredients) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), pCategory, pResult, pExperience, pCookingTime, pCookingSerializer, factory).group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(recipeOutput, GabbysGrove.MODID + ":" + getItemName(pResult) + pRecipeName + "_" + getItemName(itemlike));
        }
    }
}
