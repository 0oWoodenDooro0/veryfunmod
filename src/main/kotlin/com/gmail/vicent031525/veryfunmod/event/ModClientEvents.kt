package com.gmail.vicent031525.veryfunmod.event

import com.gmail.vicent031525.veryfunmod.VeryFunMod
import com.gmail.vicent031525.veryfunmod.dataattachment.ModDataAttachments
import com.gmail.vicent031525.veryfunmod.gui.ModLevelWidget
import net.minecraft.client.Minecraft
import net.minecraft.client.gui.screens.inventory.InventoryScreen
import net.neoforged.api.distmarker.Dist
import net.neoforged.bus.api.SubscribeEvent
import net.neoforged.fml.common.EventBusSubscriber
import net.neoforged.fml.common.Mod
import net.neoforged.neoforge.client.event.ScreenEvent

@Mod(VeryFunMod.ID)
@EventBusSubscriber(bus = EventBusSubscriber.Bus.GAME, value = [Dist.CLIENT])
object ModClientEvents {
    @SubscribeEvent
    fun onScreenRender(event: ScreenEvent.Render.Post) {
        val screen = event.screen
        val guiGraphics = event.guiGraphics
        if (screen is InventoryScreen) {
            val player = Minecraft.getInstance().player!!
            val exp = player.getData(ModDataAttachments.MINING_EXP)
            val maxExp = player.getData(ModDataAttachments.MINING_MAX_EXP)
            val level = player.getData(ModDataAttachments.MINING_LEVEL)
            ModLevelWidget().render(guiGraphics, (exp / maxExp.toFloat()), level)
        }
    }
}