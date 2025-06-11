package io.bytestorm.common.config;

import java.io.File;

public class TemplateConfig {

    private final ConfigPathResolver resolver;

    public TemplateConfig(ConfigPathResolver resolver) {
        this.resolver = resolver;
    }

    public <T> Configuration<T> loadOrCreate(String fileName, Class<T> type, T defaultInstance) {
        File file = resolver.resolvePath(fileName);
        return ConfigLoader.load(file, type, defaultInstance);
    }

    public <T> Configuration<T> loadModule(Class<T> clazz, T defaultInstance) {
        File file = resolver.resolveModuleConfig(clazz);
        return ConfigLoader.load(file, clazz, defaultInstance);
    }
}
