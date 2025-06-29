package de.kyrohpaneup.linkcraftapi.connection;

import io.netty.buffer.ByteBuf;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class DataPacket implements IMessage {
    private String data;

    public DataPacket() {}

    public DataPacket(String data) {
        this.data = data;
    }

    @Override
    public void fromBytes(ByteBuf buf) {
        try {
            // ByteBuf zu ByteArrayInputStream konvertieren
            ByteArrayInputStream bais = new ByteArrayInputStream(buf.array());
            DataInputStream in = new DataInputStream(bais);

            // Erst die Länge lesen, dann die Daten
            int length = in.readInt();
            byte[] bytes = new byte[length];
            in.readFully(bytes);
            this.data = new String(bytes, StandardCharsets.UTF_8);
        } catch (IOException e) {
            this.data = "ERROR: " + e.getMessage();
        }
    }

    @Override
    public void toBytes(ByteBuf buf) {
        byte[] bytes = data.getBytes(StandardCharsets.UTF_8);
        buf.writeInt(bytes.length);
        buf.writeBytes(bytes);
    }

    public String getData() {
        return data;
    }
}
