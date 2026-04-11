package de.rayzs.thief.api.session;

import de.rayzs.thief.api.map.Map;

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
     * Destruct the session.
     * It kicks all players from the sessions and closes
     * all operations associated with that session.
     */
    void destruct();
}
