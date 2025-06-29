package de.kyrohpaneup.linkcraftapi.data.map;

import de.kyrohpaneup.linkcraftapi.utils.ColorUtils;

public enum MapType {
    TOTAL("Total", "§4", true),
    RANKUP("Main Rankups","§b", true),
    SIDE("Side Courses", "§f", true),
    BONUS_PRO("Pro-Mode Maps", "§6", true),
    BONUS("Bonus Rankups", "§e", false),
    WOLF("Wolf Rankups", "§7", false),
    CHALLENGE("Challenges", "§a", false),
    MAZE("Maze Rankups", "§c", true),
    MISC("Miscellaneous Maps", "§d", false),
    LEGACY("Legacy Courses", "§9", false);


    public final String color;
    public final String name;
    public final boolean priority;

    MapType(String name, String color, boolean priority) {
        this.name = name;
        this.color = color;
        this.priority = priority;
    }

    public boolean isPriority() {
        return priority;
    }

    public String getName() {
        return name;
    }

    public int getColor() {
        return ColorUtils.getColorFromCode(color);
    }

    public static MapType safeValueOf(String name) {
        for (MapType type : MapType.values()) {
            if (type.name().equalsIgnoreCase(name)) {
                return type;
            }
        }
        return MISC;
    }

}
