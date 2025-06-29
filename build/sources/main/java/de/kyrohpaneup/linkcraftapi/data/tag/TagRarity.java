package de.kyrohpaneup.linkcraftapi.data.tag;

import de.kyrohpaneup.linkcraftapi.utils.StringUtils;

public enum TagRarity {
    COMMON("§7", ""),
    UNCOMMON("§9", ""),
    RARE("§b", "§3§l●§bRare§3§l●"),
    EPIC("§5", "§d§l♦§5§lEpic§d§l♦"),
    LEGENDARY("§6", "§b§l★§6§lLegendary§b§l★"),
    CUSTOM("§a", "");

    public final String name;
    public final String color;
    public final String display;

    TagRarity(String color, String display) {
        this.color = color;
        this.name = StringUtils.capitalize(this.name());
        this.display = display.isEmpty() ? color + name : display;
    }
}
