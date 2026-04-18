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


    private final Map<UUID, ImplSession> playerSessions = new HashMap<>();
    private int currentSessionId = 0;

    @Override
    public Session createSession(
            final de.rayzs.thief.api.map.Map map,
            final Player... players
    ) {
        final ImplSession session = new ImplSession(api, map, ++currentSessionId);
        final UUID uuid = UUID.randomUUID();

        for (final Player player : players) {

            // Properly unset previous session the player was in.
            unsetPlayerSession(player);


            // Set session to player.
            session.addPlayer(uuid);
            playerSessions.put(uuid, session);
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
    public boolean unsetPlayerSessionIf(Player player, Predicate<Session> predicate) {
        final ImplSession prev = playerSessions.get(player.getUniqueId());

        if (prev != null && predicate.test(prev)) {
            playerLeftSession(player, prev);
            playerSessions.remove(player.getUniqueId());
            return true;
        }

        return false;
    }

    @Override
    public void resetAll() {
        playerSessions.entrySet().removeIf(entry -> {
           final ImplSession session = entry.getValue();
           final UUID uuid = entry.getKey();

           final Player player;
           if ((player = Bukkit.getPlayer(uuid)) != null) {
               playerLeftSession(player, session);
           }

           return true;
        });
    }


    private void playerLeftSession(final Player player, final ImplSession session) {
        session.removePlayer(player.getUniqueId());

        // Code implementation for proper leaving
        // the session. For example a message, etc...
    }
}
