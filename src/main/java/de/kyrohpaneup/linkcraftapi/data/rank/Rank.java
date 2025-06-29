package de.kyrohpaneup.linkcraftapi.data.rank;

import java.util.Arrays;

public enum Rank {
    I("§b«§3««§a§lXVI§2»§3»§b»", "§4"),
    II("§c«§fII§c»", "§c"),
    III("§d«§fIII§d»", "§d"),
    IV("§e«§fIV§e»", "§e"),
    V("§6«§fV§6»", "§6"),
    VI("§f«VI»", "§f"),
    VII("§2«§fVII§2»", "§2"),
    VIII("§a«§fVIII§a»", "§a"),
    IX("§5«§fIX§5»", "§5"),
    X("§0«§f§lX§0»", "§9"),
    XI("§4«§f§lXI§4»", "§4"),
    XII("§8«§7«§f§lXII§7»§8»", "§8"),
    XIII("§9«§3«§f§lXIII§3»§9»", "§9"),
    XIV("§3«§b«§f§lXIV§b»§3»", "§3"),
    XV("§7«§1«§f§lXV§1»§7»", "§7"),
    XVI("§b«§3««§a§lXVI§2»§3»§b»", "§b"),
    XVII("§0«§5«§d«§r§lXVII§d»§5»§0»§d", "§d"),
    XVIII("§9§l«§3§l«§a§l«§e§lXVIII§a§l»§3§l»§9§l»§9", "§9"),
    XIX("§e§l«§7§l«§3§l«§6§lXIX§3§l»§7§l»§e§l»§3", "§3"),
    XX("§0§l«§8§l«§4§l«§f§l§mXX§4§l»§8§l»§0§l»§4", "§4");

    private String display;
    private String color;

    Rank(String display, String color) {
        this.display = display;
        this.color = color;
    }

    public String getDisplay() {
        return display.isEmpty() ? "§f" + name() : display;
    }

    public static Rank getRank(String rankString) {
        return Arrays.stream(Rank.values())
                .filter(rank -> rank.name().equalsIgnoreCase(rankString))
                .findFirst()
                .orElse(Rank.I);
    }
}
