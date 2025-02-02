package com.gmail.vicent031525.veryfunmod.particle

import net.minecraft.client.multiplayer.ClientLevel
import net.minecraft.client.particle.*
import net.minecraft.core.particles.SimpleParticleType
import kotlin.random.Random

class MissAttackParticle(
    level: ClientLevel,
    xCoord: Double,
    yCoord: Double,
    zCoord: Double,
    spriteSet: SpriteSet,
    xd: Double,
    yd: Double,
    zd: Double
) : TextureSheetParticle(level, xCoord, yCoord, zCoord, xd, yd, zd) {
    init {
        gravity = 0.2f
        friction = 0.9f
        quadSize *= 5f
        lifetime = (60.0 / (Random.nextDouble() * 0.8 + 1.2)).toInt();
        setSpriteFromAge(spriteSet)
        rCol = 1f
        gCol = 1f
        bCol = 1f
    }

    override fun getRenderType(): ParticleRenderType {
        return ParticleRenderType.PARTICLE_SHEET_TRANSLUCENT
    }
}

class MissAttackParticleProvider(private val sprites: SpriteSet) : ParticleProvider<SimpleParticleType> {
    override fun createParticle(
        type: SimpleParticleType,
        level: ClientLevel,
        x: Double,
        y: Double,
        z: Double,
        dx: Double,
        dy: Double,
        dz: Double
    ): Particle {
        return MissAttackParticle(level, x, y, z, sprites, dx, dy, dz)
    }
}
