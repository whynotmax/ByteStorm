package io.bytestorm.core.bootstrap;

import io.bytestorm.api.CloudAPI;
import io.bytestorm.api.messaging.MessagingService;
import io.bytestorm.common.events.CloudEventBus;
import io.bytestorm.common.logging.CloudLogger;
import io.bytestorm.common.logging.LoggerFactory;
import io.bytestorm.common.util.FileUtil;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public final class CloudCore {

    public static CloudLogger CONSOLE;
    public static CloudLogger FILE_LOGGER;

    public static void main(String[] args) throws IOException {
        initializeLogging();

        CONSOLE.info("Starting ByteStorm Core... 🚀 (This may take a moment)");

        try {
            // Services laden
            ServiceRegistry.init();

            // Initialisiere CloudAPI
            CloudAPI.init(ServiceRegistry.get(PlayerService.class), ServiceRegistry.get(ServerService.class), ServiceRegistry.get(PermissionService.class), ServiceRegistry.get(MessagingService.class), ServiceRegistry.get(CloudEventBus.class));

            // Starte Lifecycle
            CloudLifecycleManager lifecycle = new CloudLifecycleManager();
            lifecycle.start();

            System.out.println("✅ ByteStorm Core ready for duty!");
        } catch (Exception e) {
            System.err.println("❌ Failed to boot ByteStorm:");
            e.printStackTrace();
            System.exit(1);
        }
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
