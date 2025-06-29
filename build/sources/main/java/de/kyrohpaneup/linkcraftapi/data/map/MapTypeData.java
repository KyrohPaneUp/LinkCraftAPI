package de.kyrohpaneup.linkcraftapi.data.map;

public class MapTypeData {
    MapType type = MapType.MISC;
    int total = 0;
    int player = 0;

    public void setPlayer(int player) {
        this.player = player;
    }

    public int getPlayer() {
        return player;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getTotal() {
        return total;
    }

    public void setType(MapType type) {
        this.type = type;
    }

    public MapType getType() {
        return type;
    }
}
