package de.rayzs.thief.api.session;

import de.rayzs.thief.api.map.Map;
import org.bukkit.entity.Player;

import java.util.function.Predicate;

/**
 * Create or get current session of a player.
 */
public interface SessionProvider {
    
    /**
     * Create a session and set players inside it.
     *
     * @param map Map.
     * @param players Players that belong to that session.
     * 
     * @return Created session instance.
     */
    Session createSession(final Map map, final Player... players);


    /**
     * Get current session of player.
     * 
     * @param player Session of player.
     * 
     * @return Returns the {@link Session} object associated with that player. Returns {@code null} otherwise.
     */
    Session getPlayerSession(final Player player);

    /**
     * Unset the session the player is in.
     *
     * @param player Player.
     *
     * @return Returns {@link Boolean#TRUE} if the player was in a session and is now not anymore. Returns {@link Boolean#FALSE} otherwise.
     */
    boolean unsetPlayerSession(final Player player);

    /**
     * Unset the session the player is in if the predicate is fulfilled.
     *
     * @param player Player.
     *
     * @return Returns {@link Boolean#TRUE} if the player was in a session and is now not anymore. Returns {@link Boolean#FALSE} otherwise.
     */
    boolean unsetPlayerSessionIf(final Player player, final Predicate<Session> session);

    /**
     * Removes all players from their associated sessions
     * and clears the map of all sessions.
     */
    void resetAll();
}
