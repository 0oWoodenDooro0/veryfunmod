package com.gmail.vicent031525.veryfunmod.lootmodifier

import com.gmail.vicent031525.veryfunmod.VeryFunMod
import net.neoforged.bus.api.IEventBus
import net.neoforged.neoforge.registries.DeferredRegister
import net.neoforged.neoforge.registries.NeoForgeRegistries

object ModLootModifiers {
    private val GLOBAL_LOOT_MODIFIER_SERIALIZERS =
        DeferredRegister.create(NeoForgeRegistries.Keys.GLOBAL_LOOT_MODIFIER_SERIALIZERS, VeryFunMod.ID)
    val MOD_LOOT_MODIFIER =
        GLOBAL_LOOT_MODIFIER_SERIALIZERS.register("mod_loot_modifier", { -> ReplaceLootModifier.CODEC })

    fun register(bus: IEventBus) {
        GLOBAL_LOOT_MODIFIER_SERIALIZERS.register(bus)
    }
}