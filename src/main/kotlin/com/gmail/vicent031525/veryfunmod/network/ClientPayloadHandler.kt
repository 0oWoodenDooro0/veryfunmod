package com.gmail.vicent031525.veryfunmod.network

import com.gmail.vicent031525.veryfunmod.dataattachment.ModDataAttachments
import net.neoforged.neoforge.network.handling.IPayloadContext

object ClientPayloadHandler {
    fun handleDataOnNetwork(data: LevelExpData, context: IPayloadContext) {
        val player = context.player()
        player.setData(ModDataAttachments.MINING_EXP, data.exp)
        player.setData(ModDataAttachments.MINING_LEVEL, data.level)
        player.setData(ModDataAttachments.MINING_MAX_EXP, data.maxExp)
    }
}