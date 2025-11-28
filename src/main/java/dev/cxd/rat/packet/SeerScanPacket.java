package dev.cxd.rat.packet;

import net.minecraft.network.PacketByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.network.packet.CustomPayload;
import net.minecraft.util.Identifier;

import static dev.cxd.rat.RolesAmongTheTrain.MOD_ID;

public record SeerScanPacket() implements CustomPayload {
    public static final CustomPayload.Id<SeerScanPacket> ID = new CustomPayload.Id<>(Identifier.of(MOD_ID, "seer_scan"));
    public static final PacketCodec<PacketByteBuf, SeerScanPacket> CODEC = PacketCodec.of(
            (value, buf) -> {},
            buf -> new SeerScanPacket()
    );

    @Override
    public Id<? extends CustomPayload> getId() {
        return ID;
    }
}
