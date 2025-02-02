package com.gmail.vicent031525.veryfunmod.datagen

import com.gmail.vicent031525.veryfunmod.VeryFunMod
import com.gmail.vicent031525.veryfunmod.datagen.globallootmodifier.ModGlobalLootModifierProvider
import com.gmail.vicent031525.veryfunmod.datagen.language.ModLanguageProvider
import com.gmail.vicent031525.veryfunmod.datagen.loottable.ModBlockLootTableProvider
import com.gmail.vicent031525.veryfunmod.datagen.model.ModModelProvider
import com.gmail.vicent031525.veryfunmod.datagen.particledescription.ModParticleDescriptionProvider
import com.gmail.vicent031525.veryfunmod.datagen.recipe.ModRecipeProvider
import com.gmail.vicent031525.veryfunmod.datagen.tag.ModBlockTagsProvider
import com.gmail.vicent031525.veryfunmod.datagen.tag.ModItemTagsProvider
import net.minecraft.data.loot.LootTableProvider
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets
import net.neoforged.bus.api.SubscribeEvent
import net.neoforged.fml.common.EventBusSubscriber
import net.neoforged.fml.common.Mod
import net.neoforged.neoforge.data.event.GatherDataEvent

@Mod(VeryFunMod.ID)
@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
object ModDataGenerators {
    @SubscribeEvent
    fun register(event: GatherDataEvent.Client) {
        val lookUpProvider = event.lookupProvider
        val generator = event.generator
        val output = generator.packOutput
        event.addProvider(ModRecipeProvider.Runner(output, lookUpProvider))
        event.addProvider(ModGlobalLootModifierProvider(output, lookUpProvider))
        event.addProvider(
            LootTableProvider(
                output,
                emptySet(),
                listOf(LootTableProvider.SubProviderEntry(::ModBlockLootTableProvider, LootContextParamSets.BLOCK)),
                lookUpProvider
            )
        )
        event.addProvider(ModModelProvider(output))
        event.addProvider(ModLanguageProvider(output))
        val blockTagsProvider = ModBlockTagsProvider(output, lookUpProvider)
        event.addProvider(blockTagsProvider)
        event.addProvider(ModItemTagsProvider(output, lookUpProvider, blockTagsProvider.contentsGetter()))
        event.addProvider(ModParticleDescriptionProvider(output))
    }
}