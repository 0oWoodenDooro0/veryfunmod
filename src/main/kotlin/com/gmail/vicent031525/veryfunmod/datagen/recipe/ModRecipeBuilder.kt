package com.gmail.vicent031525.veryfunmod.datagen.recipe

import net.minecraft.advancements.Criterion
import net.minecraft.data.recipes.RecipeBuilder
import net.minecraft.data.recipes.RecipeOutput
import net.minecraft.resources.ResourceKey
import net.minecraft.world.item.Item
import net.minecraft.world.item.crafting.Recipe

class ModRecipeBuilder: RecipeBuilder {
    override fun unlockedBy(p0: String, p1: Criterion<*>): RecipeBuilder {
        TODO("Not yet implemented")
    }

    override fun group(p0: String?): RecipeBuilder {
        TODO("Not yet implemented")
    }

    override fun getResult(): Item {
        TODO("Not yet implemented")
    }

    override fun save(p0: RecipeOutput, p1: ResourceKey<Recipe<*>>) {
        TODO("Not yet implemented")
    }
}