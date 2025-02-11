package com.gmail.vicent031525.veryfunmod

import com.gmail.vicent031525.veryfunmod.block.ModBlocks
import com.gmail.vicent031525.veryfunmod.creativetab.ModCreativeModeTabs
import com.gmail.vicent031525.veryfunmod.dataattachment.ModDataAttachments
import com.gmail.vicent031525.veryfunmod.item.ModItems
import com.gmail.vicent031525.veryfunmod.lootmodifier.ModLootModifiers
import com.gmail.vicent031525.veryfunmod.network.ClientPayloadHandler
import com.gmail.vicent031525.veryfunmod.network.LevelExpData
import com.gmail.vicent031525.veryfunmod.network.ServerPayloadHandler
import com.gmail.vicent031525.veryfunmod.particle.MissAttackParticleProvider
import com.gmail.vicent031525.veryfunmod.particle.ModParticles
import net.minecraft.client.Minecraft
import net.neoforged.bus.api.SubscribeEvent
import net.neoforged.fml.common.EventBusSubscriber
import net.neoforged.fml.common.Mod
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent
import net.neoforged.fml.event.lifecycle.FMLDedicatedServerSetupEvent
import net.neoforged.neoforge.client.event.RegisterParticleProvidersEvent
import net.neoforged.neoforge.network.event.RegisterPayloadHandlersEvent
import net.neoforged.neoforge.network.handling.DirectionalPayloadHandler
import net.neoforged.neoforge.network.registration.HandlerThread
import org.apache.logging.log4j.Level
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger
import thedarkcolour.kotlinforforge.neoforge.forge.MOD_BUS
import thedarkcolour.kotlinforforge.neoforge.forge.runForDist

/**
 * Main mod class.
 *
 * An example for blocks is in the `blocks` package of this mod.
 */
@Mod(VeryFunMod.ID)
@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
object VeryFunMod {
    const val ID = "veryfunmod"

    // the logger for our mod
    val LOGGER: Logger = LogManager.getLogger(ID)

    init {
        LOGGER.log(Level.INFO, "Hello world!")

        // Register the KDeferredRegister to the mod-specific event bus
        ModBlocks.register(MOD_BUS)
        ModItems.register(MOD_BUS)
        ModParticles.register(MOD_BUS)
        ModCreativeModeTabs.register(MOD_BUS)
        ModLootModifiers.register(MOD_BUS)
        ModDataAttachments.register(MOD_BUS)

        val obj = runForDist(clientTarget = {
            MOD_BUS.addListener(::onClientSetup)
            Minecraft.getInstance()
        }, serverTarget = {
            MOD_BUS.addListener(::onServerSetup)
            "test"
        })

        println(obj)
    }

    /**
     * This is used for initializing client specific
     * things such as renderers and keymaps
     * Fired on the mod specific event bus.
     */
    private fun onClientSetup(event: FMLClientSetupEvent) {
        LOGGER.log(Level.INFO, "Initializing client...")
    }

    /**
     * Fired on the global Forge bus.
     */
    private fun onServerSetup(event: FMLDedicatedServerSetupEvent) {
        LOGGER.log(Level.INFO, "Server starting...")
    }

    @SubscribeEvent
    fun onCommonSetup(event: FMLCommonSetupEvent) {
        LOGGER.log(Level.INFO, "Hello! This is working!")
    }

    @SubscribeEvent
    fun registerPayload(event: RegisterPayloadHandlersEvent) {
        val payloadRegistrar = event.registrar("1").executesOn(HandlerThread.NETWORK)
        payloadRegistrar.playBidirectional(
            LevelExpData.TYPE,
            LevelExpData.STREAM_CODEC,
            DirectionalPayloadHandler(
                ClientPayloadHandler::handleDataOnNetwork,
                ServerPayloadHandler::handleDataOnNetwork
            )
        )
    }

    @SubscribeEvent
    fun registerParticle(event: RegisterParticleProvidersEvent) {
        event.registerSpriteSet(ModParticles.MISS_ATTACK_PARTICLE.get(), ::MissAttackParticleProvider)
    }
}
