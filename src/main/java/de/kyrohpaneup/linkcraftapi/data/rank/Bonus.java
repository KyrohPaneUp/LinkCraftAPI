package de.kyrohpaneup.linkcraftapi.data.rank;

import de.kyrohpaneup.linkcraftapi.data.enums.Rank;

import java.util.Arrays;

public enum Bonus {
    b1("§e#1"),
    b1pro("§e✫1"),
    b2("§e#2"),
    b2pro("§e✫2"),
    b3("§6#3"),
    b3pro("§6✫3"),
    b4("§6#4"),
    b4pro("§6✫4"),
    b5("§c#5"),
    b5pro("§c✫5"),
    b6("§c#6"),
    b6pro("§c✫6"),
    b7("§9#7"),
    b7pro("§9✫7"),
    b8("§9#8"),
    b8pro("§9✫8"),
    b9("§d#9"),
    b9pro("§d✫9"),
    b10("§a§l#10"),
    b10pro("§a§l✫10"),
    b11("§4§l#11"),
    b11pro("§4§l✫11"),
    b12("§3§l#12"),
    b12pro("§3§l✫12");

    String display;

    Bonus(String display) {
        this.display = display;
    }

    public static Bonus getRank(String bonusString) {
        return Arrays.stream(Bonus.values())
                .filter(rank -> rank.name().equalsIgnoreCase(bonusString))
                .findFirst()
                .orElse(Bonus.b1);
    }

    public String getDisplay() {
        return display;
    }
}
