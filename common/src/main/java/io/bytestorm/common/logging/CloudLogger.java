package io.bytestorm.common.logging;

public interface CloudLogger {

    public static final String LOG_FILE_KEY = "bytestorm.log.file";
    public static final String DEFAULT_LOG_LEVEL_KEY = "bytestorm.log.level";
    public static final String SHOW_DATE_TIME_KEY = "bytestorm.log.showDateTime";

    void log(LoggerLevel level, String message, Object... args);

    default void info(String message, Object... args) {
        log(LoggerLevel.INFO, message, args);
    }

    default void warn(String message, Object... args) {
        log(LoggerLevel.WARN, message, args);
    }

    default void error(String message, Object... args) {
        log(LoggerLevel.ERROR, message, args);
    }

    default void debug(String message, Object... args) {
        log(LoggerLevel.DEBUG, message, args);
    }

    default void trace(String message, Object... args) {
        log(LoggerLevel.TRACE, message, args);
    }

    default void info(String message) {
        info(message, (Object[]) null);
    }

    default void warn(String message) {
        warn(message, (Object[]) null);
    }

    default void error(String message) {
        error(message, (Object[]) null);
    }

    default void debug(String message) {
        debug(message, (Object[]) null);
    }

    default void trace(String message) {
        trace(message, (Object[]) null);
    }

}
