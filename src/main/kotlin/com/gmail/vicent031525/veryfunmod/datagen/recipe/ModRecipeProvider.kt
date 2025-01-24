package com.gmail.vicent031525.veryfunmod.datagen.recipe

import com.gmail.vicent031525.veryfunmod.item.ModItems
import net.minecraft.core.HolderLookup
import net.minecraft.core.registries.Registries
import net.minecraft.data.PackOutput
import net.minecraft.data.recipes.RecipeCategory
import net.minecraft.data.recipes.RecipeOutput
import net.minecraft.data.recipes.RecipeProvider
import net.minecraft.data.recipes.ShapedRecipeBuilder
import net.minecraft.world.item.Items
import java.util.concurrent.CompletableFuture

class ModRecipeProvider(registries: HolderLookup.Provider, output: RecipeOutput) : RecipeProvider(registries, output) {
    override fun buildRecipes() {
        ShapedRecipeBuilder.shaped(registries.lookupOrThrow(Registries.ITEM), RecipeCategory.TOOLS, ModItems.FLINT_AXE)
            .pattern("X")
            .pattern("#")
            .define('X', Items.FLINT)
            .define('#', Items.STICK)
            .unlockedBy("has_flint", has(Items.FLINT))
            .save(output)

        ShapedRecipeBuilder.shaped(registries.lookupOrThrow(Registries.ITEM), RecipeCategory.BUILDING_BLOCKS, Items.COBBLESTONE)
            .pattern("XX")
            .pattern("XX")
            .define('X', ModItems.ROCK)
            .unlockedBy("has_flint", has(ModItems.ROCK))
            .save(output)
    }

    class Runner(output: PackOutput, registries: CompletableFuture<HolderLookup.Provider>) :
        RecipeProvider.Runner(output, registries) {
        override fun getName(): String {
            return "ModRecipes"
        }

        override fun createRecipeProvider(provider: HolderLookup.Provider, output: RecipeOutput): RecipeProvider {
            return ModRecipeProvider(provider, output)
        }
    }
}