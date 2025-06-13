package io.bytestorm.bridge.common.player;

import java.util.UUID;

public interface PlatformPlayerEventListener {

    void handlePlayerJoin(UUID uuid, String name, String serverName);
    void handlePlayerQuit(UUID uuid);
}

