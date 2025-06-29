package de.kyrohpaneup.linkcraftapi;

import de.kyrohpaneup.linkcraftapi.connection.ConnectionManager;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(
        modid = LinkCraftAPI.MODID,
        name = LinkCraftAPI.MODNAME,
        version = LinkCraftAPI.VERSION)
public class LinkCraftAPI { // select ExampleMod and hit shift+F6 to rename it

    public static final String MODID = "linkcraftapi";      // the id of your mod, it should never change, it is used by forge and servers to identify your mods
    public static final String MODNAME = "LinkCraftAPI";// the name of your mod
    public static final String VERSION = "1.0";           // the current version of your mod
    @Mod.Instance
    public static LinkCraftAPI instance;

    private ConnectionManager connectionManager;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        connectionManager = new ConnectionManager();
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {

    }

    public ConnectionManager getConnectionManager() {
        return connectionManager;
    }
}
