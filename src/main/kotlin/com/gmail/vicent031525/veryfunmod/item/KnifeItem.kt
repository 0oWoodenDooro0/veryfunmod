package com.gmail.vicent031525.veryfunmod.item

import com.gmail.vicent031525.veryfunmod.tag.ModTags
import net.minecraft.world.InteractionHand
import net.minecraft.world.InteractionResult
import net.minecraft.world.entity.LivingEntity
import net.minecraft.world.entity.player.Player
import net.minecraft.world.item.*
import net.minecraft.world.level.Level

class KnifeItem(material: ToolMaterial, attackDamage: Float, attackSpeed: Float, properties: Properties) :
    Item(material.applyToolProperties(properties, ModTags.Blocks.MINABLE_WITH_KNIFE, attackDamage, attackSpeed)) {
    override fun getUseAnimation(stack: ItemStack): ItemUseAnimation {
        return ItemUseAnimation.BRUSH
    }

    override fun getUseDuration(stack: ItemStack, entity: LivingEntity): Int {
        return 160
    }

    override fun use(level: Level, player: Player, hand: InteractionHand): InteractionResult {
        if (player.offhandItem.item != Items.STICK) return InteractionResult.FAIL
        player.startUsingItem(InteractionHand.MAIN_HAND)
        return InteractionResult.CONSUME
    }

    override fun finishUsingItem(stack: ItemStack, level: Level, livingEntity: LivingEntity): ItemStack {
        if (level.isClientSide) return stack
        if (livingEntity !is Player) return stack
        val itemStack = livingEntity.offhandItem
        if (itemStack.item != Items.STICK) return stack
        livingEntity.addItem(
            when (livingEntity.random.nextInt(5)) {
                0 -> ItemStack(ModItems.WOODEN_AXE_HEAD)
                1 -> ItemStack(ModItems.WOODEN_HOE_HEAD)
                2 -> ItemStack(ModItems.WOODEN_PICK_HEAD)
                3 -> ItemStack(ModItems.WOODEN_SHOVEL_HEAD)
                else -> ItemStack(ModItems.WOODEN_SWORD_HEAD)
            }
        )
        itemStack.shrink(1)
        stack.damageValue += 1
        livingEntity.releaseUsingItem()
        return stack
    }
}