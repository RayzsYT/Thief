package de.rayzs.thief.api.map;

import de.rayzs.thief.api.map.objects.MapObjects;

import java.util.Collection;

public interface Map {

    /**
     * Map name.
     *
     * @return Map name.
     */
    String mapName();

    /**
     * Start location when player enters session.
     *
     * @return Start location.
     */
    SimplifiedLocation startLocation();

    /**
     * {@link de.rayzs.thief.api.map.objects.MapObject}s inside the map.
     *
     * @return Collection of all {@link de.rayzs.thief.api.map.objects.MapObject}s inside the map.
     */
    Collection<MapObjects> objects();
}
