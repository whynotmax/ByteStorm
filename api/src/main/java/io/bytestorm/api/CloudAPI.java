package io.bytestorm.api;

import io.bytestorm.api.messaging.MessagingService;
import io.bytestorm.api.permission.CloudPermissionService;
import io.bytestorm.api.player.CloudPlayerService;
import io.bytestorm.api.server.CloudServerService;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@Getter
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public final class CloudAPI {

    private static CloudAPI instance;

    CloudPlayerService playerService;
    CloudServerService serverService;
    CloudPermissionService permissionService;
    MessagingService messagingService;

    private CloudAPI(CloudPlayerService playerService, CloudServerService serverService, CloudPermissionService permissionService, MessagingService messagingService) {
        this.playerService = playerService;
        this.serverService = serverService;
        this.permissionService = permissionService;
        this.messagingService = messagingService;
    }

    public static void init(CloudPlayerService playerService, CloudServerService serverService, CloudPermissionService permissionService, MessagingService messagingService) {
        if (instance != null) {
            throw new IllegalStateException("CloudAPI is already initialized");
        }
        instance = new CloudAPI(playerService, serverService, permissionService, messagingService);
    }

    public static CloudAPI getInstance() {
        if (instance == null) {
            throw new IllegalStateException("CloudAPI is not initialized yet");
        }
        return instance;
    }

}
