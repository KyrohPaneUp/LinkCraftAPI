package de.kyrohpaneup.linkcraftapi.data.tag;

import de.kyrohpaneup.linkcraftapi.utils.StringUtils;

public enum TagType {
    HIDDEN("§d"),
    VICTOR("§6"),
    EVENT("§c"),
    SPECIAL("§3");

    public final String color;
    public final String name;

    TagType(String color) {
        this.color = color;
        this.name = StringUtils.capitalize(this.name().toLowerCase());
    }
}
