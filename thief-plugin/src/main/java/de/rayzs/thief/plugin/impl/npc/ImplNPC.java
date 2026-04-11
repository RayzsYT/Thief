package de.rayzs.thief.plugin.impl.npc;

import org.bukkit.Location;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Mannequin;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

import de.rayzs.thief.api.ThiefAPI;
import de.rayzs.thief.api.npc.AwareState;
import de.rayzs.thief.api.npc.NPC;

import java.util.Random;

public class ImplNPC implements NPC {


    private Mannequin entity;
    private AwareState state;

    private Location currentTargetLocation;
    private LivingEntity huntingTargetEntity;


    public ImplNPC(final ThiefAPI api) {



        new BukkitRunnable() {

            final Random random = new Random();

            final double walkingSpeed = 0.1d;
            final double huntingSpeed = 0.15d;

            long lastLookAround = System.currentTimeMillis();

            @Override
            public void run() {

                if (state == AwareState.NOTHING) {
                    // Does nothing...
                    return;
                }


                final Location current = entity.getLocation();

                if (state == AwareState.LOOKING) {

                    if (System.currentTimeMillis() - lastLookAround < 1600) {
                        return;
                    }

                    lastLookAround = System.currentTimeMillis();


                    final Vector randomLookVec = current.clone().add(
                            random.nextInt(3),
                            0,
                            random.nextInt(3)
                    ).toVector();


                    final Vector dir = randomLookVec
                            .subtract(current.getDirection())
                            .normalize();


                    current.setDirection(dir);
                    return;
                }


                final Location targetLocation = state == AwareState.HUNTING
                        ? huntingTargetEntity.getLocation()
                        : currentTargetLocation;

                if (targetLocation == null) {
                    return;
                }


                if (current.distance(targetLocation) <= 2) {
                    currentTargetLocation = null;
                    return;
                }

                final Vector dir = targetLocation
                    .clone()
                    .subtract(current)
                    .getDirection()
                    .normalize();

                dir.setY(current.getDirection().getY());

                final Vector vel = dir.clone().multiply(
                        state == AwareState.HUNTING
                                ? huntingSpeed
                                : walkingSpeed
                );

                vel.setY(0);

                entity.setVelocity(vel);
                entity.getLocation().setDirection(dir);
            }
            
        }.runTaskTimer(api.getPlugin(), 10, 10);

    }



    public boolean spawn(final Location location) {

        if (entity != null && !entity.isDead()) {
            System.out.println("NPC is already alive!");
            return false;
        }


        entity = location.getWorld().spawn(location, Mannequin.class, mannequin -> {
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
        currentTargetLocation = location;
    }

    @Override
    public void setHuntingTarget(final LivingEntity target) {
        huntingTargetEntity = target;
    }

    public AwareState getState() {
        return state;
    }

    public void changeState(final AwareState state) {
        this.state = state;
    }
    
}
