package com.gmail.vicent031525.veryfunmod.datagen.language

import com.gmail.vicent031525.veryfunmod.VeryFunMod
import com.gmail.vicent031525.veryfunmod.block.ModBlocks
import com.gmail.vicent031525.veryfunmod.creativetab.ModCreativeModeTabs
import com.gmail.vicent031525.veryfunmod.item.ModItems
import net.minecraft.data.PackOutput
import net.neoforged.neoforge.common.data.LanguageProvider

class ModLanguageProvider(output: PackOutput) : LanguageProvider(output, VeryFunMod.ID, "en_us") {
    override fun addTranslations() {
        add(ModBlocks.EXAMPLE_BLOCK.get(), "Example Block")

        add(ModBlocks.EXAMPLE_BLOCK.asItem(), "Example Block")
        add(ModItems.ROCK, "Rock")
        add(ModItems.WOODEN_AXE_HEAD, "Wooden Axe Head")
        add(ModItems.WOODEN_HOE_HEAD, "Wooden Hoe Head")
        add(ModItems.WOODEN_PICK_HEAD, "Wooden Pick Head")
        add(ModItems.WOODEN_SHOVEL_HEAD, "Wooden Shovel Head")
        add(ModItems.WOODEN_SWORD_HEAD, "Wooden Sword Head")
        add(ModItems.FLINT_KNIFE, "Flint Knife")

        add(ModCreativeModeTabs.TAB_TITLE, "Very Fun Mod")
    }
}