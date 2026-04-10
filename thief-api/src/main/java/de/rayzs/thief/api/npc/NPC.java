package de.rayzs.thief.api.npc;

import org.bukkit.Location;
import org.bukkit.entity.LivingEntity;

public interface NPC {

    /**
     * Spawn the NPC if not spawned yet.
     *
     * @return Returns {@link Boolean#TRUE} if the NPC didn't exist before and spawned successfully. Returns {@link Boolean#FALSE} otherwise.
     */

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
