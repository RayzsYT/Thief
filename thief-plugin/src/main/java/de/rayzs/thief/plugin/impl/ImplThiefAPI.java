package de.rayzs.thief.plugin.impl;

import de.rayzs.thief.api.ThiefAPI;
import org.bukkit.plugin.Plugin;

public class ImplThiefAPI implements ThiefAPI {

    private final Plugin plugin;


    public ImplThiefAPI(final Plugin plugin) {
        this.plugin = plugin;
    }


    @Override
    public Plugin getPlugin() {
        return plugin;
    }
}
