package de.rayzs.thief.api.session;

import de.rayzs.thief.api.map.Map;
import org.bukkit.entity.Player;

import java.util.Collection;
import java.util.UUID;

/**
 * The session class acts as a session per game.
 */
public interface Session {
    
    /**
     * The id of the session. Is an unique integer.
     * 
     * @return Session Id.
     */
    int id();

    /**
     * {@link Map} of session.
     *
     * @return {@link Map} of session.
     */
    Map map();

    /**
     * Session configuration.
     *
     * @return {@link SessionConfig}.
     */
    SessionConfig config();

    /**
     * Start game.
     */
    void startGame();

    /**
     * End game.
     */
    void endGame();

    /**
     * Destruct the session.
     * It kicks all players from the sessions and closes
     * all operations associated with that session.
     */
    void destruct();

    /**
     * Player ids that are in that session.
     *
     * @return Collection of player ids in that session.
     */
    Collection<UUID> playersIds();
}
