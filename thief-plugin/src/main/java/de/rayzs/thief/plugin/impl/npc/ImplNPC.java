package de.rayzs.thief.plugin.impl.npc;

import org.bukkit.Location;
import org.bukkit.entity.Mannequin;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

import de.rayzs.thief.api.ThiefAPI;
import de.rayzs.thief.api.npc.AwareState;
import de.rayzs.thief.api.npc.NPC;

public class ImplNPC implements NPC {


    private Mannequin entity;
    private AwareState state;

    private Location currentTargetLocation;


    public ImplNPC(final ThiefAPI api) {



        new BukkitRunnable() {

            final double walkingSpeed = 0.1d;
            final double huntingSpeed = 0.15d;

            @Override
            public void run() {

                if (state == AwareState.NOTHING) {
                    // Does nothing...
                    return;
                }



                if (state == AwareState.LOOKING) {
                    // Looks around...
                    return;
                }


                // Moves (if possible)
                if (currentTargetLocation == null) {
                    return;
                }


                final Location current = entity.getLocation();

                if (current.distance(currentTargetLocation) <= 2) {
                    currentTargetLocation = null;
                    return;
                }

                final Vector dir = currentTargetLocation
                    .clone()
                    .subtract(current)
                    .getDirection()
                    .normalize()
                    .multiply(
                        state == AwareState.HUNTING 
                        ? huntingSpeed : walkingSpeed
                    );

                dir.setY(0);

                entity.setVelocity(dir);
            }
            
        }.runTaskTimer(api.getPlugin(), 10, 10);

    }



    public boolean spawn(final Location location) {

        if (entity != null && !entity.isDead()) {
            System.out.println("NPC is already alive!");
            return false;
        }


        entity = (Mannequin) location.getWorld().spawn(location, Mannequin.class, mannequin -> {
            mannequin.setCustomNameVisible(false);
        });

        return true;
    }

    public boolean remove() {

        if (entity == null) {
            System.out.println("NPC isn't spawned yet.");
            return false;
        }

        entity.remove();
        
        entity = null;
        return true;
    }

    public void move(final Location location) {
        
    }

    public AwareState getState() {
        return state;
    }

    public void changeState(final AwareState state) {
        this.state = state;
    }
    
}
