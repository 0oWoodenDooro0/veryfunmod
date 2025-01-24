package com.gmail.vicent031525.veryfunmod.block

import com.gmail.vicent031525.veryfunmod.VeryFunMod
import com.gmail.vicent031525.veryfunmod.item.ModItems
import net.minecraft.core.registries.Registries
import net.minecraft.resources.ResourceKey
import net.minecraft.resources.ResourceLocation
import net.minecraft.world.item.BlockItem
import net.minecraft.world.item.Item
import net.minecraft.world.level.block.Block
import net.minecraft.world.level.block.state.BlockBehaviour
import net.neoforged.bus.api.IEventBus
import net.neoforged.neoforge.registries.DeferredBlock
import net.neoforged.neoforge.registries.DeferredRegister
import java.util.function.Supplier


object ModBlocks {
    val BLOCKS: DeferredRegister.Blocks = DeferredRegister.createBlocks(VeryFunMod.ID)

    val EXAMPLE_BLOCK = registerBlock("example_block") {
        Block(
            BlockBehaviour.Properties.of()
                .setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.parse("example_block")))
        )
    }

    private fun <T : Block> registerBlock(name: String, block: Supplier<T>): DeferredBlock<T> {
        val toReturn = BLOCKS.register(name, block)
        registerBlockItem(name, toReturn)
        return toReturn
    }

    private fun <T : Block> registerBlockItem(name: String, block: DeferredBlock<T>) =
        ModItems.ITEMS.register(name) { id ->
            BlockItem(
                block.get(),
                Item.Properties().setId(ResourceKey.create(Registries.ITEM, id))
            )
        }

    fun register(eventBus: IEventBus) {
        BLOCKS.register(eventBus)
    }
}
