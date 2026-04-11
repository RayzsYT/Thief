package de.rayzs.thief.plugin.impl.session;

import de.rayzs.thief.api.ThiefAPI;
import de.rayzs.thief.api.session.Session;
import de.rayzs.thief.api.session.SessionProvider;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.function.Predicate;

public class ImplSessionProvider implements SessionProvider {


    private final ThiefAPI api;

    public ImplSessionProvider(final ThiefAPI api) {
        this.api = api;
    }


    private final Map<UUID, Session> playerSessions = new HashMap<>();
    private int currentSessionId = 0;

    @Override
    public Session createSession(
            final de.rayzs.thief.api.map.Map map,
            final Player... players
    ) {
        final Session session = new ImplSession(api, map, ++currentSessionId);

        for (final Player player : players) {

            // Properly unset previous session the player was in.
            unsetPlayerSession(player);


            // Set session to player.
            playerSessions.put(player.getUniqueId(), session);
        }

        return session;
    }

    @Override
    public Session getPlayerSession(final Player player) {
        return playerSessions.get(player.getUniqueId());
    }

    @Override
    public boolean unsetPlayerSession(final Player player) {
        final Session prev = playerSessions.get(player.getUniqueId());

        if (prev == null) {
            return false;
        }

        playerSessions.remove(player.getUniqueId());
        return false;
    }

    @Override
    public boolean unsetPlayerSessionIf(Player player, Predicate<Session> session) {
        final Session prev = playerSessions.get(player.getUniqueId());

        if (prev != null && session.test(prev)) {
            playerLeftSession(player, prev);
            playerSessions.remove(player.getUniqueId());

            return true;
        }

        return false;
    }

    @Override
    public void resetAll() {
        playerSessions.entrySet().removeIf(entry -> {
           final Session session = entry.getValue();
           final UUID uuid = entry.getKey();

           final Player player;
           if ((player = Bukkit.getPlayer(uuid)) != null) {
               playerLeftSession(player, session);
           }

           return true;
        });
    }


    private void playerLeftSession(final Player player, final Session session) {
        // Code implementation for proper leaving
        // the session. For example a message, etc...
    }
}
