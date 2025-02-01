package com.gmail.vicent031525.veryfunmod.network

import com.gmail.vicent031525.veryfunmod.VeryFunMod.LOGGER
import net.neoforged.neoforge.network.handling.IPayloadContext
import org.apache.logging.log4j.Level

object ServerPayloadHandler {
    fun handleDataOnNetwork(data: LevelExpData, context: IPayloadContext) {
        LOGGER.log(Level.INFO, "Server Side Network")
    }
}