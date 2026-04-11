package de.rayzs.thief.api.map;

import de.rayzs.thief.api.configuration.Config;
import org.bukkit.Bukkit;
import org.bukkit.Location;

public class SimplifiedLocation {


    /**
     * Read and construct the {@link SimplifiedLocation}
     * object from the config.
     *
     * @param config Config.
     * @param path Path.
     *
     * @return Read {@link SimplifiedLocation} object.
     */
    public static SimplifiedLocation readLocationFromConfig(
            final Config config,
            final String path
    ) {
        final String worldName = (String) config.get(path + ".world");

        final double x = (double) config.get(path + ".x");
        final double y = (double) config.get(path + ".y");
        final double z = (double) config.get(path + ".z");

        final float yaw = (float) (double) config.get(path + ".yaw");
        final float pitch = (float) (double) config.get(path + ".pitch");

        return new SimplifiedLocation(
                worldName,
                x, y, z,
                yaw, pitch
        );
    }

    /**
     * Write {@link SimplifiedLocation} into the config.
     *
     * @param config Config.
     * @param path Path.
     */
    public static void writeLocationToConfig(
            final SimplifiedLocation simplifiedLocation,
            final Config config,
            final String path
    ) {
        config.set(path + ".world", simplifiedLocation.worldName)
                .set(path + ".x", simplifiedLocation.x)
                .set(path + ".y", simplifiedLocation.y)
                .set(path + ".z", simplifiedLocation.z)
                .set(path + ".yaw", simplifiedLocation.yaw)
                .set(path + ".pitch", simplifiedLocation.pitch)
                .save();
    }


    private final String worldName;
    private final double x, y, z;
    private final float yaw, pitch;


    private Location location;


    public SimplifiedLocation(Location location) {
        this(
                location.getWorld().getName(),
                location.getX(), location.getY(), location.getZ(),
                location.getYaw(), location.getPitch()
        );
    }

    public SimplifiedLocation(
            String worldName,
            double x, double y, double z,
            float yaw, float pitch
    ) {
        this.worldName = worldName;

        this.x = x;
        this.y = y;
        this.z = z;

        this.yaw = yaw;
        this.pitch = pitch;
    }


    /**
     * {@link SimplifiedLocation} as {@link Location}.
     * Constructed only ones once called.
     *
     * @return Constructed {@link Location} based off {@link SimplifiedLocation}.
     */
    public Location toLocation() {

        if (location == null) {
            location = new Location(
                    Bukkit.getWorld(worldName),
                    x, y, z,
                    yaw, pitch
            );
        }

        return location;
    }
}
