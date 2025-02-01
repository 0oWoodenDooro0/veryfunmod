package com.gmail.vicent031525.veryfunmod.dataattachment

import com.gmail.vicent031525.veryfunmod.VeryFunMod
import com.mojang.serialization.Codec
import net.neoforged.bus.api.IEventBus
import net.neoforged.neoforge.attachment.AttachmentType
import net.neoforged.neoforge.registries.DeferredHolder
import net.neoforged.neoforge.registries.DeferredRegister
import net.neoforged.neoforge.registries.NeoForgeRegistries

object ModDataAttachments {
    private val ATTACHMENT_TYPES: DeferredRegister<AttachmentType<*>> =
        DeferredRegister.create(NeoForgeRegistries.ATTACHMENT_TYPES, VeryFunMod.ID)
    val MINING_LEVEL: DeferredHolder<AttachmentType<*>, AttachmentType<Int>> =
        ATTACHMENT_TYPES.register("mining_level") { -> AttachmentType.builder { -> 0 }.serialize(Codec.INT).build() }
    val MINING_EXP: DeferredHolder<AttachmentType<*>, AttachmentType<Int>> =
        ATTACHMENT_TYPES.register("mining_exp") { -> AttachmentType.builder { -> 0 }.serialize(Codec.INT).build() }
    val MINING_MAX_EXP: DeferredHolder<AttachmentType<*>, AttachmentType<Int>> =
        ATTACHMENT_TYPES.register("mining_max_exp") { -> AttachmentType.builder { -> 32 }.serialize(Codec.INT).build() }

    fun register(eventbus: IEventBus) {
        ATTACHMENT_TYPES.register(eventbus)
    }
}