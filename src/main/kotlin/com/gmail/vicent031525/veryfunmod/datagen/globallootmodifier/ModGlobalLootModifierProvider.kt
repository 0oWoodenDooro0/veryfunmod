package com.gmail.vicent031525.veryfunmod.datagen.globallootmodifier

import com.gmail.vicent031525.veryfunmod.VeryFunMod
import com.gmail.vicent031525.veryfunmod.item.ModItems
import com.gmail.vicent031525.veryfunmod.lootmodifier.ReplaceLootModifier
import net.minecraft.core.HolderLookup
import net.minecraft.data.PackOutput
import net.minecraft.world.level.block.Blocks
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition
import net.neoforged.neoforge.common.conditions.ModLoadedCondition
import net.neoforged.neoforge.common.data.GlobalLootModifierProvider
import java.util.concurrent.CompletableFuture

class ModGlobalLootModifierProvider(output: PackOutput, registries: CompletableFuture<HolderLookup.Provider>) :
    GlobalLootModifierProvider(output, registries, VeryFunMod.ID) {
    override fun start() {
        this.add(
            "example_glm_1", ReplaceLootModifier(
                arrayOf(LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.STONE).build()),
                ModItems.ROCK
            ), listOf(ModLoadedCondition(VeryFunMod.ID))
        )
    }
}