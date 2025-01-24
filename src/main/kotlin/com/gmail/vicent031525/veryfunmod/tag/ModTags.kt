package com.gmail.vicent031525.veryfunmod.tag

import com.gmail.vicent031525.veryfunmod.VeryFunMod
import net.minecraft.core.registries.Registries
import net.minecraft.resources.ResourceLocation
import net.minecraft.tags.TagKey
import net.minecraft.world.item.Item
import net.minecraft.world.level.block.Block

object ModTags {
    object Blocks{
        val NEEDS_FLINT_TOOL: TagKey<Block> = TagKey.create(
            Registries.BLOCK,
            ResourceLocation.fromNamespaceAndPath(VeryFunMod.ID, "needs_flint_tool")
        )

        val INCORRECT_FOR_FLINT_TOOL: TagKey<Block> = TagKey.create(
            Registries.BLOCK,
            ResourceLocation.fromNamespaceAndPath(VeryFunMod.ID, "incorrect_for_flint_tool")
        )

        val MINEABLE_LEVEL_1: TagKey<Block> = TagKey.create(
            Registries.BLOCK,
            ResourceLocation.fromNamespaceAndPath(VeryFunMod.ID, "mineable_level_1")
        )
    }
    object Items{
        val FLINT_TOOL_MATERIALS: TagKey<Item> = TagKey.create(
            Registries.ITEM,
            ResourceLocation.fromNamespaceAndPath(VeryFunMod.ID, "flint_tool_materials")
        )
    }
}