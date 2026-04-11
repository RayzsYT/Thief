package de.rayzs.thief.plugin.impl.session;

import de.rayzs.thief.api.ThiefAPI;
import de.rayzs.thief.api.map.Map;
import de.rayzs.thief.api.session.Session;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class ImplSession implements Session {


    private final ThiefAPI api;
    private final Map map;
    private final int sessionId;


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
    public int id() {
        return sessionId;
    }

    @Override
    public Map map() {
        return map;
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
}
