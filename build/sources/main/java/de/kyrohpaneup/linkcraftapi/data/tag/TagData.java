package de.kyrohpaneup.linkcraftapi.data.tag;

public class TagData {
    TagType type;
    int total;
    int playerCount;
    int unobtainable;

    public int getPlayerCount() {
        return playerCount;
    }

    public int getTotal() {
        return total;
    }

    public int getUnobtainable() {
        return unobtainable;
    }

    public TagType getType() {
        return type;
    }

    public void setPlayerCount(int playerCount) {
        this.playerCount = playerCount;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public void setType(TagType type) {
        this.type = type;
    }

    public void setUnobtainable(int unobtainable) {
        this.unobtainable = unobtainable;
    }
}
