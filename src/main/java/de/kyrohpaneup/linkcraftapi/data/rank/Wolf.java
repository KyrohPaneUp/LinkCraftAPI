package de.kyrohpaneup.linkcraftapi.data.rank;

import de.kyrohpaneup.linkcraftapi.data.enums.Rank;

import java.util.Arrays;

public enum Wolf {

    wolf_i("§a①"),
    wolf_ii("§7②"),
    wolf_iii("§b③"),
    wolf_iv("§e④"),
    wolf_v("§d⑤"),
    wolf_vi("§5⑥"),
    wolf_vii("§c⑦"),
    wolf_viii("§2⑧"),
    wolf_ix("§9⑨"),
    wolf_x("§6&l⑩"),
    wolf_xi("§4&l⑪"),
    wolf_xii("§f&l⑫"),
    wolf_xiii("§3&l⑬");

    String display;

    Wolf(String display) {
        this.display = display;
    }

    public static Wolf getRank(String wolfString) {
        return Arrays.stream(Wolf.values())
                .filter(rank -> rank.name().equalsIgnoreCase(wolfString))
                .findFirst()
                .orElse(Wolf.wolf_i);
    }

    public String getDisplay() {
        return display;
    }
}
