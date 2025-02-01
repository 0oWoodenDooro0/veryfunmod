package com.gmail.vicent031525.veryfunmod.datagen.recipe

import com.gmail.vicent031525.veryfunmod.item.ModItems
import net.minecraft.core.HolderLookup
import net.minecraft.core.registries.Registries
import net.minecraft.data.PackOutput
import net.minecraft.data.recipes.*
import net.minecraft.world.item.Items
import java.util.concurrent.CompletableFuture

class ModRecipeProvider(registries: HolderLookup.Provider, output: RecipeOutput) : RecipeProvider(registries, output) {
    override fun buildRecipes() {
        ShapedRecipeBuilder.shaped(
            registries.lookupOrThrow(Registries.ITEM), RecipeCategory.TOOLS, ModItems.FLINT_KNIFE
        ).pattern("X").pattern("#").define('X', Items.FLINT).define('#', Items.STICK)
            .unlockedBy("has_flint", has(Items.FLINT)).save(output)

        ShapedRecipeBuilder.shaped(
            registries.lookupOrThrow(Registries.ITEM), RecipeCategory.BUILDING_BLOCKS, Items.COBBLESTONE
        ).pattern("XX").pattern("XX").define('X', ModItems.ROCK).unlockedBy("has_flint", has(ModItems.ROCK))
            .save(output)

        ShapelessRecipeBuilder.shapeless(
            registries.lookupOrThrow(Registries.ITEM), RecipeCategory.TOOLS, Items.WOODEN_AXE
        ).requires(Items.STICK).requires(ModItems.WOODEN_AXE_HEAD)
            .unlockedBy("has_wooden_axe_head", has(ModItems.WOODEN_AXE_HEAD)).save(output)

        ShapelessRecipeBuilder.shapeless(
            registries.lookupOrThrow(Registries.ITEM), RecipeCategory.TOOLS, Items.WOODEN_HOE
        ).requires(Items.STICK).requires(ModItems.WOODEN_HOE_HEAD)
            .unlockedBy("has_wooden_hoe_head", has(ModItems.WOODEN_HOE_HEAD)).save(output)

        ShapelessRecipeBuilder.shapeless(
            registries.lookupOrThrow(Registries.ITEM), RecipeCategory.TOOLS, Items.WOODEN_PICKAXE
        ).requires(Items.STICK).requires(ModItems.WOODEN_PICK_HEAD)
            .unlockedBy("has_wooden_pick_head", has(ModItems.WOODEN_PICK_HEAD)).save(output)

        ShapelessRecipeBuilder.shapeless(
            registries.lookupOrThrow(Registries.ITEM), RecipeCategory.TOOLS, Items.WOODEN_SHOVEL
        ).requires(Items.STICK).requires(ModItems.WOODEN_SHOVEL_HEAD)
            .unlockedBy("has_wooden_shovel_head", has(ModItems.WOODEN_SHOVEL_HEAD)).save(output)

        ShapelessRecipeBuilder.shapeless(
            registries.lookupOrThrow(Registries.ITEM), RecipeCategory.TOOLS, Items.WOODEN_SWORD
        ).requires(Items.STICK).requires(ModItems.WOODEN_SWORD_HEAD)
            .unlockedBy("has_wooden_sword_head", has(ModItems.WOODEN_SWORD_HEAD)).save(output)
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