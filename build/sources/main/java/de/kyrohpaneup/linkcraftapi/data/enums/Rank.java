package de.kyrohpaneup.linkcraftapi.data.enums;

import java.util.Arrays;

public enum Rank {

    I,
    II,
    III,
    IV,
    V,
    VI,
    VII,
    VIII,
    IX,
    X,
    XI,
    XII,
    XIII,
    XIV,
    XV,
    XVI;

    public static Rank getRank(String rankString) {
        return Arrays.stream(Rank.values())
                .filter(rank -> rank.name().equalsIgnoreCase(rankString))
                .findFirst()
                .orElse(Rank.I);
    }
}
