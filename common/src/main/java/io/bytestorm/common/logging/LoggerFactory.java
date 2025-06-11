package io.bytestorm.common.logging;

import java.io.File;

public class LoggerFactory {

    public static CloudLogger consoleLogger(Class<?> clazz) {
        return new ConsoleLogger(clazz);
    }

    public static CloudLogger fileLogger(Class<?> clazz, File file) {
        return new FileLogger(clazz, file);
    }
}

