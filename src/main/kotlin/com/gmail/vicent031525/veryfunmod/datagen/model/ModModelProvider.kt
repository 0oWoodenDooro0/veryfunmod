package com.gmail.vicent031525.veryfunmod.datagen.model

import com.gmail.vicent031525.veryfunmod.VeryFunMod
import com.gmail.vicent031525.veryfunmod.block.ModBlocks
import com.gmail.vicent031525.veryfunmod.item.ModItems
import net.minecraft.client.data.models.BlockModelGenerators
import net.minecraft.client.data.models.ItemModelGenerators
import net.minecraft.client.data.models.ModelProvider
import net.minecraft.client.data.models.model.ModelTemplates
import net.minecraft.data.PackOutput

class ModModelProvider(output: PackOutput) : ModelProvider(output, VeryFunMod.ID) {
    override fun registerModels(blockModels: BlockModelGenerators, itemModels: ItemModelGenerators) {
        val exampleBlock = ModBlocks.EXAMPLE_BLOCK.get()
        blockModels.createTrivialCube(exampleBlock)

        itemModels.generateFlatItem(ModItems.ROCK, ModelTemplates.FLAT_ITEM)
        itemModels.generateFlatItem(ModItems.WOODEN_AXE_HEAD, ModelTemplates.FLAT_ITEM)
        itemModels.generateFlatItem(ModItems.WOODEN_HOE_HEAD, ModelTemplates.FLAT_ITEM)
        itemModels.generateFlatItem(ModItems.WOODEN_PICK_HEAD, ModelTemplates.FLAT_ITEM)
        itemModels.generateFlatItem(ModItems.WOODEN_SHOVEL_HEAD, ModelTemplates.FLAT_ITEM)
        itemModels.generateFlatItem(ModItems.WOODEN_SWORD_HEAD, ModelTemplates.FLAT_ITEM)
        itemModels.generateFlatItem(ModItems.FLINT_KNIFE, ModelTemplates.FLAT_ITEM)
    }
}