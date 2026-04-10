package de.rayzs.thief.api.npc;

import org.bukkit.Location;

/**
 * Basic NPC with low level functionalities like moving and changing states.
 */
public interface NPC {

    /**
     * Spawn the NPC at a certain location if not spawned yet.
     *
     * @param location Location where to spawn the NPC at.
     * @return Returns {@link Boolean#TRUE} if the NPC didn't exist before and spawned successfully. Returns {@link Boolean#FALSE} otherwise.
     */
    boolean spawn(final Location location);

    /**
     * Remove the NPC.
     *
     * @return Returns {@link Boolean#TRUE} if the NPC exists and was removed successfully. Returns {@link Boolean#FALSE} otherwise.
     */
    boolean remove();

    /**
     * Move NPC towards a certain location.
     *
     * @param location Location.
     */
    void move(final Location location);

    /**
     * Current {@link AwareState} of the NPC:.
     *
     * @return Returns current {@link AwareState}.
     */
    AwareState getState();

    /**
     * Change the NPCs' current {@link AwareState}.
     *
     * @param state New {@link AwareState}.
     */
    void changeState(final AwareState state);
}
