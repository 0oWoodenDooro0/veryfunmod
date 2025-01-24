package com.gmail.vicent031525.veryfunmod.datagen.tag

import com.gmail.vicent031525.veryfunmod.VeryFunMod
import com.gmail.vicent031525.veryfunmod.item.ModItems
import com.gmail.vicent031525.veryfunmod.tag.ModTags
import net.minecraft.core.HolderLookup
import net.minecraft.data.PackOutput
import net.minecraft.data.tags.ItemTagsProvider
import net.minecraft.tags.ItemTags
import net.minecraft.world.item.Items
import net.minecraft.world.level.block.Block
import java.util.concurrent.CompletableFuture

class ModItemTagsProvider(
    output: PackOutput,
    lookupProvider: CompletableFuture<HolderLookup.Provider>,
    blockTags: CompletableFuture<TagLookup<Block>>
) : ItemTagsProvider(output, lookupProvider, blockTags, VeryFunMod.ID) {
    override fun addTags(lookupProvider: HolderLookup.Provider) {
        tag(ModTags.Items.FLINT_TOOL_MATERIALS).add(Items.FLINT)
        tag(ItemTags.AXES).add(ModItems.FLINT_AXE)
    }
}