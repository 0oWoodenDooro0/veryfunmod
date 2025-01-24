package com.gmail.vicent031525.veryfunmod.event

import com.gmail.vicent031525.veryfunmod.VeryFunMod
import com.gmail.vicent031525.veryfunmod.tag.ModTags
import net.neoforged.bus.api.SubscribeEvent
import net.neoforged.fml.common.EventBusSubscriber
import net.neoforged.fml.common.Mod
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent

@Mod(VeryFunMod.ID)
@EventBusSubscriber(bus = EventBusSubscriber.Bus.GAME)
object ModEvents {
    @SubscribeEvent
    fun onPlayerMine(event: PlayerInteractEvent.LeftClickBlock) {
        val player = event.entity
        val level = event.level
        if (!player.isCreative && !level.getBlockState(event.pos).`is`(ModTags.Blocks.MINEABLE_LEVEL_1)) {
            event.isCanceled = true
        }
    }
}