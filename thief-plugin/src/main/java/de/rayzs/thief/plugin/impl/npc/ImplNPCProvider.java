package de.rayzs.thief.plugin.impl.npc;

import java.util.HashMap;
import java.util.Map;

import de.rayzs.thief.api.ThiefAPI;
import de.rayzs.thief.api.npc.*;
import de.rayzs.thief.api.session.Session;

public class ImplNPCProvider implements NPCProvider {

    // Session Id, NPC
    private final Map<Integer, NPC> npcs = new HashMap<>();


    private final ThiefAPI api;

    public ImplNPCProvider(final ThiefAPI api) {
        this.api = api;
    }


    public NPC createNPC(final Session session) {
        
        // Get and remove previous npc associated with the session.
        final NPC prev = getNPC(session);

        if (prev != null && !prev.remove()) {
            System.out.println("Failed to remove previous NPC associated with the session: (#" + session.id() + ")");
        }

        
        // Apply new NPC to the session.
        final NPC npc = new ImplNPC(api);
        npcs.put(session.id(), npc);

        return npc;
    }


    public NPC getNPC(final Session session) {
        return npcs.get(session.id());
    }


    public void resetAll() {
        npcs.values().forEach(NPC::remove);
        npcs.clear();
    }
}