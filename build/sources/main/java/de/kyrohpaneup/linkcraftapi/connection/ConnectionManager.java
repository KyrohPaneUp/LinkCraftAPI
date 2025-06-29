package de.kyrohpaneup.linkcraftapi.connection;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import de.kyrohpaneup.linkcraftapi.data.enums.Rank;
import de.kyrohpaneup.linkcraftapi.data.map.MapData;
import de.kyrohpaneup.linkcraftapi.data.map.MapType;
import de.kyrohpaneup.linkcraftapi.data.map.MapTypeData;
import de.kyrohpaneup.linkcraftapi.data.player.LCPlayer;
import de.kyrohpaneup.linkcraftapi.data.rank.Bonus;
import de.kyrohpaneup.linkcraftapi.data.rank.Maze;
import de.kyrohpaneup.linkcraftapi.data.rank.Wolf;
import de.kyrohpaneup.linkcraftapi.data.tag.TagData;
import de.kyrohpaneup.linkcraftapi.data.tag.TagRarity;
import de.kyrohpaneup.linkcraftapi.data.tag.TagRarityData;
import de.kyrohpaneup.linkcraftapi.data.tag.TagType;
import io.netty.buffer.Unpooled;
import net.minecraft.client.Minecraft;
import net.minecraft.network.PacketBuffer;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.internal.FMLProxyPacket;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.relauncher.Side;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ConnectionManager {
    public static final String REQUEST = "LinkCraftRQ";

    public static final String CHANNEL = "LinkCraftAPI";
    public static SimpleNetworkWrapper network;
    public void init() {
        network = NetworkRegistry.INSTANCE.newSimpleChannel(CHANNEL);
        network.registerMessage(
                DataPacketHandler.class,
                DataPacket.class,
                0,
                Side.CLIENT
        );

        NetworkRegistry.INSTANCE.newChannel(REQUEST, new OutboundHandler());
    }

    public void sendToSpigot(String subchannel, String data) {
        ByteArrayOutputStream b = new ByteArrayOutputStream();
        DataOutputStream out = new DataOutputStream(b);

        try {
            out.writeUTF(subchannel);
            out.writeUTF(data);
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        PacketBuffer buffer = new PacketBuffer(Unpooled.wrappedBuffer(b.toByteArray()));
        FMLProxyPacket packet = new FMLProxyPacket(buffer, REQUEST);

        if (Minecraft.getMinecraft().thePlayer != null) {
            Minecraft.getMinecraft().getNetHandler().addToSendQueue(packet);
        }
    }

    public void parseProfileData(String jsonString) {
        try {
            JsonObject root = new JsonParser().parse(jsonString).getAsJsonObject();
            LCPlayer player = Profile.getProfile();

            String rankString = root.get("rank").getAsString();
            String bonusString = root.get("bonus").getAsString();
            String wolfString = root.get("wolf").getAsString();
            String mazeString = root.get("maze").getAsString();
            player.setRank(Rank.getRank(rankString));
            player.setBonus(Bonus.getRank(bonusString));
            player.setWolf(Wolf.getRank(wolfString));
            player.setMaze(Maze.getRank(mazeString));

            player.setHours(root.get("hours").getAsString());
            player.setJumps(root.get("jumps").getAsInt());
            player.setPp(root.get("pp").getAsInt());
            player.setJoinDate(root.get("joindate").getAsString());

            Profile.overwriteProfile(player);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void readMessage(String jsonString) {
        try {
            JsonObject root = new JsonParser().parse(jsonString).getAsJsonObject();

            JsonObject command = root.getAsJsonObject("command");

            switch (command.get("category").getAsString().toLowerCase()) {
                case "tags":
                    switch (command.get("command").getAsString().toLowerCase()) {
                        case "getall":
                            parseTagData(jsonString);
                            break;
                    }
                    break;
                case "general":
                    switch (command.get("command").getAsString().toLowerCase()) {
                        case "getall":
                            Profile.getProfile().setName(command.get("player").getAsString());
                            parseProfileData(jsonString);
                            break;
                    }
                    break;
                case "maps":
                    switch (command.get("command").getAsString().toLowerCase()) {
                        case "getall":
                            parseMapData(jsonString);
                            break;
                    }
                    break;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void parseTagData(String jsonString) {
        try {
            JsonObject root = new JsonParser().parse(jsonString).getAsJsonObject();

            JsonArray typeArray = root.getAsJsonArray("type");
            JsonArray rarityArray = root.getAsJsonArray("rarity");

            List<TagData> tagDataList = new ArrayList<>();
            List<TagRarityData> tagRarityDataList = new ArrayList<>();

            for (JsonElement element : typeArray) {
                JsonObject typeEntry = element.getAsJsonObject();

                String typeName = typeEntry.entrySet().iterator().next().getKey();

                JsonObject typeData = typeEntry.getAsJsonObject(typeName);

                TagData tagData = new TagData();
                tagData.setType(TagType.valueOf(typeName.toUpperCase()));
                tagData.setTotal(typeData.get("total").getAsInt());
                tagData.setPlayerCount(typeData.get("player").getAsInt());
                tagData.setUnobtainable(typeData.get("unobtainable").getAsInt());
                tagDataList.add(tagData);
            }

            for (JsonElement element : rarityArray) {
                JsonObject rarityEntry = element.getAsJsonObject();

                String rarityName = rarityEntry.entrySet().iterator().next().getKey();

                JsonObject rarityData = rarityEntry.getAsJsonObject(rarityName);

                TagRarityData tagData = new TagRarityData();
                tagData.setRarity(TagRarity.valueOf(rarityName.toUpperCase()));
                tagData.setTotal(rarityData.get("total").getAsInt());
                tagData.setPlayerCount(rarityData.get("player").getAsInt());
                tagRarityDataList.add(tagData);
            }

            Profile.getProfile().setTagData(tagDataList);
            Profile.getProfile().setTagRarityData(tagRarityDataList);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void parseMapData(String jsonString) {
        try {
            JsonObject root = new JsonParser().parse(jsonString).getAsJsonObject();

            JsonArray starArray = root.getAsJsonArray("star");
            JsonArray typeArray = root.getAsJsonArray("type");

            List<MapData> mapDataList = new ArrayList<>();
            List<MapTypeData> mapTypeDataList = new ArrayList<>();

            for (JsonElement element : starArray) {
                JsonObject elementEntry = element.getAsJsonObject();

                String starKey = elementEntry.entrySet().iterator().next().getKey();

                JsonObject starData = elementEntry.getAsJsonObject(starKey);

                int starPlayer = starData.get("player").getAsInt();
                int starTotal = starData.get("total").getAsInt();

                MapData mapData = new MapData();
                mapData.setStar(starKey);
                mapData.setPlayer(starPlayer);
                mapData.setTotal(starTotal);
                mapDataList.add(mapData);
            }

            for (JsonElement element : typeArray) {
                JsonObject elementEntry = element.getAsJsonObject();

                String typeKey = elementEntry.entrySet().iterator().next().getKey();

                JsonObject typeData = elementEntry.getAsJsonObject(typeKey);

                int typePlayer = typeData.get("player").getAsInt();
                int typeTotal = typeData.get("total").getAsInt();

                MapTypeData mapData = new MapTypeData();
                mapData.setType(MapType.safeValueOf(typeKey));
                mapData.setPlayer(typePlayer);
                mapData.setTotal(typeTotal);
                mapTypeDataList.add(mapData);
            }
            Profile.getProfile().setMapTypeData(mapTypeDataList);
            Profile.getProfile().setMapData(mapDataList);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
