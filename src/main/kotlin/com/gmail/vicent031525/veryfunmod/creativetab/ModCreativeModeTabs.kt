package com.gmail.vicent031525.veryfunmod.creativetab

import com.gmail.vicent031525.veryfunmod.VeryFunMod
import com.gmail.vicent031525.veryfunmod.block.ModBlocks
import com.gmail.vicent031525.veryfunmod.item.ModItems
import net.minecraft.core.registries.Registries
import net.minecraft.network.chat.Component
import net.minecraft.world.item.CreativeModeTab
import net.minecraft.world.item.ItemStack
import net.neoforged.bus.api.IEventBus
import net.neoforged.neoforge.registries.DeferredHolder
import net.neoforged.neoforge.registries.DeferredRegister

object ModCreativeModeTabs {
    private val CREATIVE_MODE_TAB = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, VeryFunMod.ID)

    const val TAB_TITLE = "creativetab.veryfunmod.items"

    val MOD_TAB: DeferredHolder<CreativeModeTab, CreativeModeTab> =
        CREATIVE_MODE_TAB.register("very_fun_tab") { ->
            CreativeModeTab.builder().icon { ItemStack(ModItems.ROCK) }
                .title(Component.translatable(TAB_TITLE))
                .displayItems { _, output ->
                    output.accept(ModItems.ROCK)
                    output.accept(ModBlocks.EXAMPLE_BLOCK)
                    output.accept(ModItems.FLINT_AXE)
                }.build()
        }

    fun register(eventBus: IEventBus) {
        CREATIVE_MODE_TAB.register(eventBus)
    }
}