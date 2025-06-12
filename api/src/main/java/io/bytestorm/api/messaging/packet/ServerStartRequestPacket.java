package io.bytestorm.api.messaging.packet;

import lombok.NonNull;

public record ServerStartRequestPacket(String groupName, String templateName, int serverCount, boolean forced) {

    public ServerStartRequestPacket {
        if (groupName == null || groupName.isEmpty()) {
            throw new IllegalArgumentException("Group name cannot be null or empty");
        }
        if (templateName == null) {
            throw new IllegalArgumentException("Template name cannot be null");
        }
        if (serverCount <= 0) {
            throw new IllegalArgumentException("Server count must be greater than zero");
        }
        if (serverCount > 25) {
            throw new IllegalArgumentException("Server count must not exceed 100");
        }
        if (templateName.isEmpty()) {
            throw new IllegalArgumentException("Template name cannot be empty");
        }
    }

    public ServerStartRequestPacket(String groupName, String templateName) {
        this(groupName, templateName, 1, false);
    }

    public ServerStartRequestPacket(String groupName, String templateName, int serverCount) {
        this(groupName, templateName, serverCount, false);
    }

    public ServerStartRequestPacket(String groupName, String templateName, boolean forced) {
        this(groupName, templateName, 1, forced);
    }

    @Override
    public @NonNull String toString() {
        return "ServerStartRequestPacket{" +
                "groupName='" + groupName + '\'' +
                ", templateName='" + templateName + '\'' +
                ", serverCount=" + serverCount +
                ", forced=" + forced +
                '}';
    }
}
