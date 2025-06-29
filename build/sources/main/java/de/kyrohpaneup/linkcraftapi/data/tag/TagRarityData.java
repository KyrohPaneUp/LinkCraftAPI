package de.kyrohpaneup.linkcraftapi.data.tag;

public class TagRarityData {

    private TagRarity rarity;
    private int total;
    private int playerCount;

    public void setTotal(int total) {
        this.total = total;
    }

    public void setPlayerCount(int playerCount) {
        this.playerCount = playerCount;
    }

    public int getTotal() {
        return total;
    }

    public int getPlayerCount() {
        return playerCount;
    }

    public TagRarity getRarity() {
        return rarity;
    }

    public void setRarity(TagRarity rarity) {
        this.rarity = rarity;
    }
}
