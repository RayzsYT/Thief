package de.rayzs.thief.api.npc;

import de.rayzs.thief.api.session.Session;

/**
 * Get or create an NPC for object for a session.
 */
public interface NPCProvider {
    
    /**
     * Create an NPC associated to a session.
     * Removes the previous associated NPC if there's one.
     * 
     * @param session Session.
     * 
     * @return Created NPC.
     */
    NPC createNPC(final Session session);

    /**
     * Get NPC associated with the provided {@link Session} object.
     * 
     * @param session Session.
     * 
     * @return Returns the {@link NPC} object associated with that {@link Session} object. Returns {@code null} otherwise.
     */
    NPC getNPC(final Session session);

    /**
     * Removes all nps.
     */
    void resetAll();

}
