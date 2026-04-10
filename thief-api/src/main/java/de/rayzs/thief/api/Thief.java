package de.rayzs.thief.api;

public class Thief {

    private static ThiefAPI instance;


    /**
     * Set the ThiefAPI instance.
     *
     * @param instance ThiefAPI instance.
     */
    public static void set(final ThiefAPI instance) {

        if (Thief.instance != null) {
            throw new RuntimeException("ThiefAPI is already initialized!");
        }

        Thief.instance = instance;
    }

    /**
     * Get initialized ThiefAPI instance.
     *
     * @return Initialized ThiefAPI instance.
     */
    public static ThiefAPI get() {

        if (instance == null) {
            throw new RuntimeException("ThiefAPI is not initialized!");
        }

        return instance;
    }
}
