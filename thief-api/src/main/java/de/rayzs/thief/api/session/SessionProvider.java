package de.rayzs.thief.api.session;

import org.bukkit.entity.Player;

/**
 * Create or get current session of a player.
 */
public interface SessionProvider {
    
    /**
     * Create a session and set players inside it.
     * 
     * @param player Players that belong to that session.
     * 
     * @return Created session instance.
     */
    Session createSession(final Player... players);


    /**
     * Get current session of player.
     * 
     * @param player Session of player.
     * 
     * @return Returns the {@link Session} object associated with that player. Returns {@code null} otherwise.
     */
    Session getPlayerSession(final Player player);

}
