package de.rayzs.thief.api.map.objects;

import de.rayzs.thief.api.map.SimplifiedLocation;

public enum MapObjects {


    WARDROBE, MONEY;


    /**
     * Create {@link MapObject}.
     *
     * @param location Location of {@link MapObject}.
     *
     * @return Created {@link MapObject}.
     */
    public MapObject createObject(final SimplifiedLocation location) {
        return new MapObject(this, location);
    }
}
