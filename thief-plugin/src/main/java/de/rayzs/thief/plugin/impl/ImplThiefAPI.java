package de.rayzs.thief.plugin.impl;

import de.rayzs.thief.api.ThiefAPI;
import de.rayzs.thief.api.configuration.ConfigProvider;
import de.rayzs.thief.api.npc.NPCProvider;

import de.rayzs.thief.api.session.SessionProvider;
import de.rayzs.thief.plugin.impl.configuration.ImplConfigProvider;
import de.rayzs.thief.plugin.impl.npc.ImplNPCProvider;
import de.rayzs.thief.plugin.impl.session.ImplSessionProvider;
import org.bukkit.plugin.Plugin;

public class ImplThiefAPI implements ThiefAPI {

    private final Plugin plugin;

    private final ConfigProvider configProvider;
    private final NPCProvider npcProvider;
    private final SessionProvider sessionProvider;


    public ImplThiefAPI(final Plugin plugin) {
        this.plugin = plugin;

        configProvider = new ImplConfigProvider();
        npcProvider = new ImplNPCProvider(this);
        sessionProvider = new ImplSessionProvider();
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

    @Override
    public SessionProvider getSessionProvider() {
        return sessionProvider;
    }
}
