package com.gmail.vicent031525.veryfunmod.lootmodifier

import com.mojang.serialization.MapCodec
import com.mojang.serialization.codecs.RecordCodecBuilder
import it.unimi.dsi.fastutil.objects.ObjectArrayList
import net.minecraft.core.registries.BuiltInRegistries
import net.minecraft.world.item.Item
import net.minecraft.world.item.ItemStack
import net.minecraft.world.level.storage.loot.LootContext
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition
import net.neoforged.neoforge.common.loot.IGlobalLootModifier
import net.neoforged.neoforge.common.loot.LootModifier


class ReplaceLootModifier(conditionsIn: Array<out LootItemCondition>, private val item: Item) :
    LootModifier(conditionsIn) {
    companion object {
        val CODEC: MapCodec<ReplaceLootModifier> = RecordCodecBuilder.mapCodec { inst ->
            codecStart(inst).and(BuiltInRegistries.ITEM.byNameCodec().fieldOf("item").forGetter { m -> m.item })
                .apply(inst, ::ReplaceLootModifier)
        }
    }

    override fun codec(): MapCodec<out IGlobalLootModifier> {
        return CODEC
    }

    override fun doApply(p0: ObjectArrayList<ItemStack>, p1: LootContext): ObjectArrayList<ItemStack> {
        val drops = ObjectArrayList<ItemStack>()
        drops.add(ItemStack(item))
        return drops
    }
}