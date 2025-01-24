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
        add(ModItems.FLINT_AXE, "Flint Axe")

        add(ModCreativeModeTabs.TAB_TITLE, "Very Fun Mod")
    }
}