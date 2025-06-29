package de.kyrohpaneup.linkcraftapi.connection;

import de.kyrohpaneup.linkcraftapi.data.player.LCPlayer;

public class Profile {

    private static LCPlayer player = new LCPlayer();

    public static LCPlayer getProfile() {
        return player;
    }

    public static void clearProfile() {
        player = new LCPlayer();
    }

    public static void overwriteProfile(LCPlayer profile) {
        player = profile;
    }
}
