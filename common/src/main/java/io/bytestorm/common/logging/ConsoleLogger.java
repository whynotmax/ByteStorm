package io.bytestorm.common.logging;

import com.google.common.collect.ImmutableList;
import org.slf4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class ConsoleLogger implements CloudLogger {

    private final Logger slf4jLogger;
    private final List<CloudLogger> childLoggers;

    public ConsoleLogger(Class<?> clazz) {
        this.slf4jLogger = org.slf4j.LoggerFactory.getLogger(clazz);
        this.childLoggers = new ArrayList<>();
    }

    @Override
    public void log(LoggerLevel level, String message, Object... args) {
        if (args == null || args.length == 0) {
            switch (level) {
                case INFO:
                    slf4jLogger.info(message);
                    break;
                case WARN:
                    slf4jLogger.warn(message);
                    break;
                case ERROR:
                    slf4jLogger.error(message);
                    break;
                case DEBUG:
                    slf4jLogger.debug(message);
                    break;
                case TRACE:
                    slf4jLogger.trace(message);
                    break;
                default:
                    throw new IllegalArgumentException("Unknown log level: " + level);
            }
        } else {
            switch (level) {
                case INFO:
                    slf4jLogger.info(message, args);
                    break;
                case WARN:
                    slf4jLogger.warn(message, args);
                    break;
                case ERROR:
                    slf4jLogger.error(message, args);
                    break;
                case DEBUG:
                    slf4jLogger.debug(message, args);
                    break;
                case TRACE:
                    slf4jLogger.trace(message, args);
                    break;
                default:
                    throw new IllegalArgumentException("Unknown log level: " + level);
            }
        }
        for (CloudLogger child : childLoggers) {
            child.log(level, message, args);
        }
    }

    @Override
    public void addChildLogger(CloudLogger childLogger) {
        if (childLogger == null) {
            throw new IllegalArgumentException("Child logger cannot be null");
        }
        childLoggers.add(childLogger);
    }

    @Override
    public void removeChildLogger(CloudLogger childLogger) {
        if (childLogger == null) {
            throw new IllegalArgumentException("Child logger cannot be null");
        }
        childLoggers.remove(childLogger);
    }

    @Override
    public List<CloudLogger> getChildLoggers() {
        return ImmutableList.copyOf(childLoggers);
    }

}
