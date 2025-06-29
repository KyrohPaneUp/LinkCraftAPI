package de.kyrohpaneup.linkcraftapi.connection;

import de.kyrohpaneup.linkcraftapi.LinkCraftAPI;
import net.minecraft.client.Minecraft;
import net.minecraft.util.ChatComponentText;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class DataPacketHandler implements IMessageHandler<DataPacket, IMessage> {

    ConnectionManager linkCraftAPI = LinkCraftAPI.instance.getConnectionManager();

    @Override
    public IMessage onMessage(DataPacket message, MessageContext ctx) {
        Minecraft.getMinecraft().addScheduledTask(() -> {
            if (Minecraft.getMinecraft().thePlayer != null) {
                Minecraft.getMinecraft().thePlayer.addChatMessage(
                        new ChatComponentText("[LinkCraft] " + message.getData())
                );
                linkCraftAPI.readMessage(message.getData());
            }
        });
        return null;
    }
}
