package com.gmail.vicent031525.veryfunmod.event

import com.gmail.vicent031525.veryfunmod.VeryFunMod
import com.gmail.vicent031525.veryfunmod.dataattachment.ModDataAttachments
import com.gmail.vicent031525.veryfunmod.network.LevelExpData
import com.gmail.vicent031525.veryfunmod.particle.ModParticles
import com.gmail.vicent031525.veryfunmod.tag.ModTags
import net.minecraft.server.level.ServerLevel
import net.minecraft.server.level.ServerPlayer
import net.neoforged.api.distmarker.Dist
import net.neoforged.bus.api.SubscribeEvent
import net.neoforged.fml.common.EventBusSubscriber
import net.neoforged.fml.common.Mod
import net.neoforged.neoforge.event.entity.player.AttackEntityEvent
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent
import net.neoforged.neoforge.network.PacketDistributor


@Mod(VeryFunMod.ID)
@EventBusSubscriber(bus = EventBusSubscriber.Bus.GAME, value = [Dist.CLIENT, Dist.DEDICATED_SERVER])
object ModServerEvents {
    @SubscribeEvent
    fun onPlayerMine(event: PlayerInteractEvent.LeftClickBlock) {
        val player = event.entity
        if (player.isCreative) return
        val level = event.level
        val levelMap = mapOf(0 to ModTags.Blocks.MINING_LEVEL_0, 1 to ModTags.Blocks.MINING_LEVEL_1)
        var miningLevel = player.getData(ModDataAttachments.MINING_LEVEL)
        val block = level.getBlockState(event.pos)
        if (!block.`is`(levelMap.getOrDefault(miningLevel, ModTags.Blocks.MINING_LEVEL_1))) {
            event.isCanceled = true
        } else if (!event.level.isClientSide && event.action == PlayerInteractEvent.LeftClickBlock.Action.STOP) {
            val miningExp = player.getData(ModDataAttachments.MINING_EXP)
            var miningMaxExp = player.getData(ModDataAttachments.MINING_MAX_EXP)
            var newExp = miningExp
            if (block.`is`(ModTags.Blocks.MINING_EXP_1)) {
                newExp += 1
            } else if (block.`is`(ModTags.Blocks.MINING_EXP_2)) {
                newExp += 2
            }
            if (newExp != miningExp) {
                if (newExp >= miningMaxExp) {
                    newExp -= miningMaxExp
                    miningLevel += 1
                    miningMaxExp *= 2
                }
                player.setData(ModDataAttachments.MINING_EXP, newExp)
                player.setData(ModDataAttachments.MINING_LEVEL, miningLevel)
                player.setData(ModDataAttachments.MINING_MAX_EXP, miningMaxExp)
                PacketDistributor.sendToPlayer(
                    player as ServerPlayer, LevelExpData(newExp, miningLevel, miningMaxExp)
                )
            }
        }
    }

    @SubscribeEvent
    fun onPlayerDamage(event: AttackEntityEvent) {
        val player = event.entity
        if (player.level().isClientSide) return
        if (player.random.nextFloat() < 0.90f) {
            val target = event.target
            (player.level() as ServerLevel).sendParticles(
                ModParticles.MISS_ATTACK_PARTICLE.get(),
                target.x,
                target.getY(1.0),
                target.z,
                1,
                0.0,
                0.0,
                0.0,
                1.0
            )
            event.isCanceled = true
        }
    }
}