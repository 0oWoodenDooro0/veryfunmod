package com.gmail.vicent031525.veryfunmod.datagen.tag

import com.gmail.vicent031525.veryfunmod.VeryFunMod
import com.gmail.vicent031525.veryfunmod.tag.ModTags
import net.minecraft.core.HolderLookup
import net.minecraft.data.PackOutput
import net.minecraft.tags.BlockTags
import net.neoforged.neoforge.common.Tags
import net.neoforged.neoforge.common.data.BlockTagsProvider
import java.util.concurrent.CompletableFuture

class ModBlockTagsProvider(output: PackOutput, lookupProvider: CompletableFuture<HolderLookup.Provider>) :
    BlockTagsProvider(output, lookupProvider, VeryFunMod.ID) {
    override fun addTags(lookupProvider: HolderLookup.Provider) {
        tag(ModTags.Blocks.INCORRECT_FOR_FLINT_TOOL).addTag(BlockTags.NEEDS_DIAMOND_TOOL)
            .addTag(BlockTags.NEEDS_IRON_TOOL).addTag(BlockTags.NEEDS_STONE_TOOL)
        tag(ModTags.Blocks.NEEDS_FLINT_TOOL).addTag(BlockTags.LOGS)
        tag(BlockTags.MINEABLE_WITH_AXE).addTag(BlockTags.LOGS)
        tag(ModTags.Blocks.MINING_LEVEL_0).addTag(BlockTags.LEAVES).addTag(Tags.Blocks.FLOWERS)
            .addTag(BlockTags.REPLACEABLE)
        tag(ModTags.Blocks.MINING_LEVEL_1).addTag(ModTags.Blocks.MINING_LEVEL_0).addTag(BlockTags.MINEABLE_WITH_SHOVEL)
        tag(ModTags.Blocks.MINING_EXP_1).addTag(BlockTags.LEAVES)
        tag(ModTags.Blocks.MINING_EXP_2).addTag(BlockTags.DIRT).addTag(BlockTags.SAND).addTag(Tags.Blocks.GRAVELS)
    }
}