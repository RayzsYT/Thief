package de.rayzs.thief.plugin;

import de.rayzs.thief.api.Thief;
import de.rayzs.thief.api.ThiefAPI;
import de.rayzs.thief.plugin.impl.ImplThiefAPI;
import de.rayzs.thief.plugin.listener.PlayerSessionHandler;
import org.bukkit.event.HandlerList;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class ThiefPlugin extends JavaPlugin {


    private ThiefAPI api;


    @Override
    public void onEnable() {

        // Create and set ThiefAPI instance.
        api = new ImplThiefAPI(this);
        Thief.set(api);


        // Listeners
        final PluginManager pluginManager = getServer().getPluginManager();

        pluginManager.registerEvents(new PlayerSessionHandler(api), this);
    }

    @Override
    public void onDisable() {
        HandlerList.unregisterAll(this);

        api.getNpcProvider().resetAll();
        api.getSessionProvider().resetAll();
    }
}
