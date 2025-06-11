package io.bytestorm.common.logging;

import org.slf4j.Logger;

public class ConsoleLogger implements CloudLogger {

    private final Logger slf4jLogger;

    public ConsoleLogger(Class<?> clazz) {
        this.slf4jLogger = org.slf4j.LoggerFactory.getLogger(clazz);
    }

    @Override
    public void log(LoggerLevel level, String message, Object... args) {
        if (args == null || args.length == 0) {
            switch (level) {
                case INFO: slf4jLogger.info(message); break;
                case WARN: slf4jLogger.warn(message); break;
                case ERROR: slf4jLogger.error(message); break;
                case DEBUG: slf4jLogger.debug(message); break;
                case TRACE: slf4jLogger.trace(message); break;
                default: throw new IllegalArgumentException("Unknown log level: " + level);
            }
        } else {
            switch (level) {
                case INFO: slf4jLogger.info(message, args); break;
                case WARN: slf4jLogger.warn(message, args); break;
                case ERROR: slf4jLogger.error(message, args); break;
                case DEBUG: slf4jLogger.debug(message, args); break;
                case TRACE: slf4jLogger.trace(message, args); break;
                default: throw new IllegalArgumentException("Unknown log level: " + level);
            }
        }
    }

}
