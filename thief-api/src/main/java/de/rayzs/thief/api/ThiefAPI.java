package de.rayzs.thief.api;

import org.bukkit.plugin.Plugin;

import de.rayzs.thief.api.configuration.ConfigProvider;
import de.rayzs.thief.api.npc.NPCProvider;

public interface ThiefAPI {

    /**
     * Get {@link Plugin} object.
     *
     * @return {@link Plugin} object.
     */
    Plugin getPlugin();

    /**
     * Get the config provider to create or fetch existing
     * {@link Config} objects.
     * 
     * @return Config provider.
     */
    ConfigProvider getConfigProvider();

    /**
     * Get NPC provider.
     * 
     * @return NPC provider.
     */
    NPCProvider getNpcProvider();
}
