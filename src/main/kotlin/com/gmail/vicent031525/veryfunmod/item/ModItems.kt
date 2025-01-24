package com.gmail.vicent031525.veryfunmod.item

import com.gmail.vicent031525.veryfunmod.VeryFunMod
import com.gmail.vicent031525.veryfunmod.material.ModMaterials
import net.minecraft.core.registries.Registries
import net.minecraft.resources.ResourceKey
import net.minecraft.world.item.AxeItem
import net.minecraft.world.item.Item
import net.neoforged.bus.api.IEventBus
import net.neoforged.neoforge.registries.DeferredRegister
import thedarkcolour.kotlinforforge.neoforge.forge.getValue

object ModItems {
    val ITEMS: DeferredRegister.Items = DeferredRegister.createItems(VeryFunMod.ID)

    val ROCK: Item by ITEMS.register("rock") { name ->
        Item(Item.Properties().setId(ResourceKey.create(Registries.ITEM, name)))
    }

    val FLINT_AXE: AxeItem by ITEMS.register("flint_axe") { name ->
        AxeItem(
            ModMaterials.FLINT,
            3f,
            -3.3f,
            Item.Properties().setId(ResourceKey.create(Registries.ITEM, name))
        )
    }

    fun register(eventBus: IEventBus) {
        ITEMS.register(eventBus)
    }
}