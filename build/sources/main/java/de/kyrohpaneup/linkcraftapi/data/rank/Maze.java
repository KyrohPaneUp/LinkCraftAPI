package de.kyrohpaneup.linkcraftapi.data.rank;

import de.kyrohpaneup.linkcraftapi.data.enums.Rank;

import java.util.Arrays;

public enum Maze {

    I(""),
    II(""),
    III(""),
    IV(""),
    V(""),
    VI(""),
    VII(""),
    VIII(""),
    IX(""),
    X(""),
    XI(""),
    XII(""),
    XIII(""),
    XIV(""),
    XV("§c§nXV"),
    XVI("§f§n&lXVI");

    String display;

    Maze(String display) {
        this.display = display;
    }

    public String getDisplay() {
        return display.isEmpty() ? name().toUpperCase() : display;
    }

    public static Maze getRank(String mazeString) {
        return Arrays.stream(Maze.values())
                .filter(rank -> rank.name().equalsIgnoreCase(mazeString))
                .findFirst()
                .orElse(Maze.I);
    }

}
