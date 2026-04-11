package de.rayzs.thief.plugin.listener;

import de.rayzs.thief.api.ThiefAPI;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerSessionHandler implements Listener {

    private ThiefAPI api;

    public PlayerSessionHandler(final ThiefAPI api) {
        this.api = api;
    }


    @EventHandler
    public void onPlayerQuit(final PlayerQuitEvent event) {
        final Player player = event.getPlayer();

        api.getSessionProvider().unsetPlayerSession(player);
    }
}
