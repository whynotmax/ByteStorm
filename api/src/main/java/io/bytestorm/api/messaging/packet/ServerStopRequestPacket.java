package io.bytestorm.api.messaging.packet;

import lombok.NonNull;

public record ServerStopRequestPacket(String groupName, boolean forced) implements Packet {

    public ServerStopRequestPacket {
        if (groupName == null || groupName.isEmpty()) {
            throw new IllegalArgumentException("Group name cannot be null or empty");
        }
    }

    public ServerStopRequestPacket(String groupName) {
        this(groupName, false);
    }

    @Override
    public @NonNull String toString() {
        return "ServerStopRequestPacket{" +
                "groupName='" + groupName + '\'' +
                ", forced=" + forced +
                '}';
    }
}
