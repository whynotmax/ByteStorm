package io.bytestorm.common.config;

import java.io.File;

public class ConfigPathResolver {

    private final File baseDir;

    public ConfigPathResolver(File baseDir) {
        this.baseDir = baseDir;
    }

    public File resolvePath(String name) {
        return new File(baseDir, name.endsWith(".json") ? name : name + ".json");
    }

    public File resolveModuleConfig(Class<?> clazz) {
        return resolvePath(clazz.getSimpleName().toLowerCase());
    }
}
