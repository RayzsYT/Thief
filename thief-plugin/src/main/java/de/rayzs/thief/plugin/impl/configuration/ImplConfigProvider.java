package de.rayzs.thief.plugin.impl.configuration;

import de.rayzs.thief.api.configuration.*;
import java.util.*;

public class ImplConfigProvider implements ConfigProvider {

    private final Map<String, Config> configs = new HashMap<>();

    @Override
    public Config getOrCreate(final String fileName) {
        return getOrCreate(null, fileName);
    }

    @Override
    public Config getOrCreate(final String filePath, final String fileName) {
        final String id = ((filePath != null) ? (filePath + "/") : "") + fileName;

        Config config = configs.get(id);
        if (config != null) {
            return config;
        }

        config = new ImplConfig(filePath, fileName);

        configs.put(id, config);
        return config;
    }
}
