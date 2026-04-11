package de.rayzs.thief.api.map.objects;

import de.rayzs.thief.api.map.SimplifiedLocation;

public class MapObject {

    private final MapObjects type;
    private SimplifiedLocation location;

    public MapObject(
            final MapObjects type,
            final SimplifiedLocation location
    ) {
        this.type = type;
    }

    public SimplifiedLocation getLocation() {
        return location;
    }

    public MapObjects getType() {
        return type;
    }
}
