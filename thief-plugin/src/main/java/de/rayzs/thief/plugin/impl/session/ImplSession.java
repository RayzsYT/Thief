package de.rayzs.thief.plugin.impl.session;

import de.rayzs.thief.api.ThiefAPI;
import de.rayzs.thief.api.map.Map;
import de.rayzs.thief.api.session.Session;
import de.rayzs.thief.api.session.SessionConfig;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.UUID;

public class ImplSession implements Session {


    private final ThiefAPI api;
    private final Map map;
    private final int sessionId;

    private final Collection<UUID> playerIds = new HashSet<>();


    public ImplSession(
            final ThiefAPI api,
            final Map map,
            final int sessionId
    ) {
        this.api = api;
        this.map = map;
        this.sessionId = sessionId;
    }


    @Override
    public void startGame() {

    }

    @Override
    public void endGame() {

    }

    @Override
    public int id() {
        return sessionId;
    }

    @Override
    public Map map() {
        return map;
    }

    @Override
    public SessionConfig config() {
        return null;
    }

    @Override
    public void destruct() {

        for (final Player player : Bukkit.getOnlinePlayers()) {
            api.getSessionProvider().unsetPlayerSessionIf(
                    player,
                    session -> session.id() == sessionId
            );
        }

    }

    @Override
    public Collection<UUID> playersIds() {
        return playerIds;
    }

    public void addPlayer(final UUID playerId) {
        playerIds.add(playerId);
    }

    public void removePlayer(final UUID playerId) {
        playerIds.remove(playerId);
    }
}
