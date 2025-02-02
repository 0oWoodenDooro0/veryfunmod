package com.gmail.vicent031525.veryfunmod.datagen.particledescription

import com.gmail.vicent031525.veryfunmod.VeryFunMod
import com.gmail.vicent031525.veryfunmod.particle.ModParticles
import net.minecraft.data.PackOutput
import net.minecraft.resources.ResourceLocation
import net.neoforged.neoforge.common.data.ParticleDescriptionProvider

class ModParticleDescriptionProvider(output: PackOutput) : ParticleDescriptionProvider(output) {
    override fun addDescriptions() {
        sprite(
            ModParticles.MISS_ATTACK_PARTICLE.get(),
            ResourceLocation.fromNamespaceAndPath(VeryFunMod.ID, "miss_attack_particle")
        )
    }
}