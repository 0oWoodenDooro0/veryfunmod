package com.gmail.vicent031525.veryfunmod.network

import com.gmail.vicent031525.veryfunmod.VeryFunMod
import io.netty.buffer.ByteBuf
import net.minecraft.network.codec.ByteBufCodecs
import net.minecraft.network.codec.StreamCodec
import net.minecraft.network.protocol.common.custom.CustomPacketPayload
import net.minecraft.resources.ResourceLocation

data class LevelExpData(val exp: Int, val level: Int, val maxExp: Int) : CustomPacketPayload {
    companion object {
        val TYPE =
            CustomPacketPayload.Type<LevelExpData>(
                ResourceLocation.fromNamespaceAndPath(
                    VeryFunMod.ID,
                    "level_exp_data"
                )
            )

        val STREAM_CODEC: StreamCodec<ByteBuf, LevelExpData> = StreamCodec.composite(
            ByteBufCodecs.INT,
            LevelExpData::exp,
            ByteBufCodecs.INT,
            LevelExpData::level,
            ByteBufCodecs.INT,
            LevelExpData::maxExp,
            ::LevelExpData
        )
    }

    override fun type(): CustomPacketPayload.Type<out CustomPacketPayload> {
        return TYPE
    }
}