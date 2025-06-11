package io.bytestorm.common.logging;

import io.bytestorm.common.exception.ByteStormException;
import io.bytestorm.common.util.FileUtil;
import lombok.NonNull;
import org.slf4j.Logger;

import java.io.File;
import java.io.IOException;

public class FileLogger implements CloudLogger {

    private final Logger slf4jLogger;
    private final File logFile;

    public FileLogger(Class<?> clazz, @NonNull File logFile) {
        if (!logFile.exists() || !logFile.isFile()) {
            try {
                FileUtil.createIfNotExists(logFile);
            } catch (IOException e) {
                throw new ByteStormException("Unable to create log file", e);
            }
        }
        if (!logFile.canWrite()) {
            throw new ByteStormException("Log file is not writable: " + logFile.getAbsolutePath());
        }
        this.logFile = logFile;

        System.setProperty(CloudLogger.LOG_FILE_KEY, logFile.getAbsolutePath());
        System.setProperty(CloudLogger.DEFAULT_LOG_LEVEL_KEY, "INFO");
        System.setProperty(CloudLogger.SHOW_DATE_TIME_KEY, "true");

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
