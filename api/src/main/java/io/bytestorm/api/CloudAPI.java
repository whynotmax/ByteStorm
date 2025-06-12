package io.bytestorm.api;

import io.bytestorm.api.messaging.MessagingService;
import io.bytestorm.api.permission.CloudPermissionService;
import io.bytestorm.api.player.CloudPlayerService;
import io.bytestorm.api.server.CloudServerService;
import io.bytestorm.common.events.CloudEventBus;
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
    CloudEventBus eventBus;

    private CloudAPI(CloudPlayerService playerService, CloudServerService serverService, CloudPermissionService permissionService, MessagingService messagingService, CloudEventBus eventBus) {
        this.playerService = playerService;
        this.serverService = serverService;
        this.permissionService = permissionService;
        this.messagingService = messagingService;
        this.eventBus = eventBus;
    }

    public static void init(CloudPlayerService playerService, CloudServerService serverService, CloudPermissionService permissionService, MessagingService messagingService, CloudEventBus eventBus) {
        if (instance != null) {
            throw new IllegalStateException("CloudAPI is already initialized");
        }
        instance = new CloudAPI(playerService, serverService, permissionService, messagingService, eventBus);
    }

    public static CloudAPI getInstance() {
        if (instance == null) {
            throw new IllegalStateException("CloudAPI is not initialized yet");
        }
        return instance;
    }

}
