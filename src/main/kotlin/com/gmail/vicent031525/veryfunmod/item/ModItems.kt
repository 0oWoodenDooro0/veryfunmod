package com.gmail.vicent031525.veryfunmod.item

import com.gmail.vicent031525.veryfunmod.VeryFunMod
import com.gmail.vicent031525.veryfunmod.material.ModMaterials
import net.minecraft.world.item.Item
import net.neoforged.bus.api.IEventBus
import net.neoforged.neoforge.registries.DeferredRegister
import thedarkcolour.kotlinforforge.neoforge.forge.getValue

object ModItems {
    val ITEMS: DeferredRegister.Items = DeferredRegister.createItems(VeryFunMod.ID)

    val ROCK: Item by ITEMS.registerSimpleItem("rock")
    val WOODEN_AXE_HEAD: Item by ITEMS.registerSimpleItem("wooden_axe_head")
    val WOODEN_HOE_HEAD: Item by ITEMS.registerSimpleItem("wooden_hoe_head")
    val WOODEN_PICK_HEAD: Item by ITEMS.registerSimpleItem("wooden_pick_head")
    val WOODEN_SHOVEL_HEAD: Item by ITEMS.registerSimpleItem("wooden_shovel_head")
    val WOODEN_SWORD_HEAD: Item by ITEMS.registerSimpleItem("wooden_sword_head")
    val FLINT_KNIFE: Item by ITEMS.registerItem("flint_knife") { properties ->
        KnifeItem(
            ModMaterials.FLINT, 3.0f, -2.4f, properties
        )
    }

    fun register(eventBus: IEventBus) {
        ITEMS.register(eventBus)
    }
}