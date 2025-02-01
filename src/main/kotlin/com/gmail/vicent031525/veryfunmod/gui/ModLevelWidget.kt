package com.gmail.vicent031525.veryfunmod.gui

import com.gmail.vicent031525.veryfunmod.VeryFunMod
import net.minecraft.client.Minecraft
import net.minecraft.client.gui.GuiGraphics
import net.minecraft.client.gui.components.StringWidget
import net.minecraft.client.renderer.RenderType
import net.minecraft.network.chat.Component
import net.minecraft.resources.ResourceLocation
import net.minecraft.util.Mth

class ModLevelWidget {
    private val backgroundWidth = 112
    private val backgroundHeight = 5
    private val miningLevelBackground = ResourceLocation.fromNamespaceAndPath(VeryFunMod.ID, "mining_level_background")
    private val miningLevelProgress = ResourceLocation.fromNamespaceAndPath(VeryFunMod.ID, "mining_level_progress")

    fun render(guiGraphics: GuiGraphics, progress: Float, level: Int) {
        val levelX = guiGraphics.guiWidth() - (guiGraphics.guiWidth() - 176) / 2 - backgroundWidth - 2
        val levelY = (guiGraphics.guiHeight() - 166) / 2 - 6
        val textX = (guiGraphics.guiWidth() - 176) / 2 + 2
        val textY = (guiGraphics.guiHeight() - 166) / 2 - 6
        guiGraphics.blitSprite(
            RenderType::guiTextured,
            miningLevelBackground,
            backgroundWidth,
            backgroundHeight,
            0,
            0,
            levelX,
            levelY,
            backgroundWidth,
            backgroundHeight
        )
        guiGraphics.blitSprite(
            RenderType::guiTextured,
            miningLevelProgress,
            backgroundWidth,
            backgroundHeight,
            0,
            0,
            levelX,
            levelY,
            Mth.lerpDiscrete(progress, 0, backgroundWidth),
            backgroundHeight
        )
        StringWidget(textX, textY, 56, 5, Component.literal("mining"), Minecraft.getInstance().font).render(
            guiGraphics, 0, 0, 0f
        )
        StringWidget(
            levelX,
            levelY,
            backgroundWidth,
            backgroundHeight,
            Component.literal(level.toString()),
            Minecraft.getInstance().font
        ).render(guiGraphics, 0, 0, 0f)
    }
}