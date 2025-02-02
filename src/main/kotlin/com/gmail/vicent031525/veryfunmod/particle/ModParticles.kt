package com.gmail.vicent031525.veryfunmod.particle

import com.gmail.vicent031525.veryfunmod.VeryFunMod
import net.minecraft.core.particles.ParticleType
import net.minecraft.core.particles.SimpleParticleType
import net.minecraft.core.registries.Registries
import net.neoforged.bus.api.IEventBus
import net.neoforged.neoforge.registries.DeferredHolder
import net.neoforged.neoforge.registries.DeferredRegister

object ModParticles {
    private val PARTICLE_TYPES: DeferredRegister<ParticleType<*>> =
        DeferredRegister.create(Registries.PARTICLE_TYPE, VeryFunMod.ID)

    val MISS_ATTACK_PARTICLE: DeferredHolder<ParticleType<*>, SimpleParticleType> = PARTICLE_TYPES.register("miss_attack_particle") { -> SimpleParticleType(false) }

    fun register(eventBues: IEventBus) {
        PARTICLE_TYPES.register(eventBues)
    }
}