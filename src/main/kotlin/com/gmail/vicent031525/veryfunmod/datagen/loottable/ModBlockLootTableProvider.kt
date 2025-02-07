package com.gmail.vicent031525.veryfunmod.datagen.loottable

import com.gmail.vicent031525.veryfunmod.block.ModBlocks
import net.minecraft.core.HolderLookup
import net.minecraft.data.loot.BlockLootSubProvider
import net.minecraft.world.flag.FeatureFlags
import net.minecraft.world.level.block.Block


class ModBlockLootTableProvider(registries: HolderLookup.Provider) :
    BlockLootSubProvider(setOf(), FeatureFlags.REGISTRY.allFlags(), registries) {
    override fun generate() {
        dropSelf(ModBlocks.EXAMPLE_BLOCK.get())
    }

    override fun getKnownBlocks(): MutableIterable<Block> {
        return ModBlocks.BLOCKS.entries.stream().map { it.value() }.iterator().asSequence().toMutableList()
    }
}