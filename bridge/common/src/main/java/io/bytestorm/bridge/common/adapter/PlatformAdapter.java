package io.bytestorm.bridge.common.adapter;

import java.util.UUID;

public interface PlatformAdapter {
    PlatformInfo getPlatformInfo();
    void sendMessage(UUID userUniqueId, String message);
    void broadcast(String message);
    String getServerName();
}

