package de.rayzs.thief.plugin.impl;

import de.rayzs.thief.api.ThiefAPI;
import de.rayzs.thief.api.configuration.ConfigProvider;
import de.rayzs.thief.api.npc.NPCProvider;

import org.bukkit.plugin.Plugin;

public class ImplThiefAPI implements ThiefAPI {

    private final Plugin plugin;

    private final ConfigProvider configProvider;
    private final NPCProvider npcProvider;


    public ImplThiefAPI(final Plugin plugin) {
        this.plugin = plugin;
    }


    @Override
    public Plugin getPlugin() {
        return plugin;
    }

    @Override
    public ConfigProvider getConfigProvider() {
        return configProvider;
    }

    @Override
    public NPCProvider getNpcProvider() {
        return npcProvider;
    }

    
}
