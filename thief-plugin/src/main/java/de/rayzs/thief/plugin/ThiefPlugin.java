package de.rayzs.thief.plugin;

import de.rayzs.thief.api.Thief;
import de.rayzs.thief.api.ThiefAPI;
import de.rayzs.thief.plugin.impl.ImplThiefAPI;
import org.bukkit.plugin.java.JavaPlugin;

public class ThiefPlugin extends JavaPlugin {

    @Override
    public void onEnable() {

        // Create and set ThiefAPI instance.
        final ThiefAPI api = new ImplThiefAPI(this);
        Thief.set(api);


        // ...
    }

    @Override
    public void onDisable() {

    }
}
