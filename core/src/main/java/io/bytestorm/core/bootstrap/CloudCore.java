package io.bytestorm.core.bootstrap;

import io.bytestorm.api.CloudAPI;
import io.bytestorm.api.messaging.MessagingService;
import io.bytestorm.common.events.CloudEventBus;
import io.bytestorm.common.logging.CloudLogger;
import io.bytestorm.common.logging.LoggerFactory;
import io.bytestorm.common.util.FileUtil;
import io.bytestorm.core.impl.messaging.MessagingServiceImpl;
import io.bytestorm.core.impl.permission.CloudPermissionServiceImpl;
import io.bytestorm.core.impl.player.CloudPlayerServiceImpl;
import io.bytestorm.core.impl.server.CloudServerServiceImpl;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public final class CloudCore {

    public static CloudLogger CONSOLE;
    public static CloudLogger FILE_LOGGER;

    CloudPlayerServiceImpl cloudPlayerService;
    CloudServerServiceImpl cloudServerService;
    CloudPermissionServiceImpl cloudPermissionService;
    MessagingServiceImpl messagingService;
    CloudEventBus eventBus;

    private CloudCore() {
        CONSOLE.info("Loading Services... 🔧");

        this.cloudPlayerService = new CloudPlayerServiceImpl();
        this.cloudServerService = new CloudServerServiceImpl();
        this.cloudPermissionService = new CloudPermissionServiceImpl();
        this.messagingService = new MessagingServiceImpl("", "");
        this.eventBus = new CloudEventBus();

        CONSOLE.info("Initializing CloudAPI... 🌐");

        CloudAPI.init(this.cloudPlayerService, this.cloudServerService, this.cloudPermissionService, this.messagingService, this.eventBus);

        CONSOLE.info("CloudAPI initialized successfully! ✅");
        CONSOLE.info("Services loaded successfully! ✅");

    }

    public static void main(String[] args) throws IOException {
        initializeLogging();

        CONSOLE.info("Starting ByteStorm Core... 🚀 (This may take a moment)");

        new CloudCore();
    }

    private static void initializeLogging() {
        CONSOLE = LoggerFactory.consoleLogger(CloudCore.class);
        File latestLogFile = new File("logs/latest.log");
        if (!latestLogFile.getParentFile().exists()) {
            latestLogFile.getParentFile().mkdirs();
        }
        if (latestLogFile.exists()) {
            File parentDir = latestLogFile.getParentFile();
            File[] logFiles = parentDir.listFiles((dir, name) -> name.endsWith(".log"));
            int filesInDirectory = logFiles != null ? logFiles.length : 0;
            File backupFile = new File("logs/log_" + (filesInDirectory + 1) + ".log");
            if (backupFile.exists()) {
                backupFile.delete();
            }
            boolean renamed = latestLogFile.renameTo(backupFile);
            if (!renamed) {
                try {
                    throw new IOException("Failed to rename log file to backup.");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        try {
            Files.delete(latestLogFile.toPath());
            FileUtil.createIfNotExists(latestLogFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        FILE_LOGGER = LoggerFactory.fileLogger(CloudCore.class, latestLogFile);
        CONSOLE.addChildLogger(FILE_LOGGER);
    }
}
