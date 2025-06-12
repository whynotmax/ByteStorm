package io.bytestorm.api.player;

import io.bytestorm.api.permission.entities.CloudPermissionUser;

import java.awt.*;
import java.util.UUID;

public interface CloudPlayer {

    UUID getUniqueId();

    String getName();

    CloudPlayerSession getCurrentSession();

    CloudPlayerConnectionState getConnectionState();

    void setConnectionState(CloudPlayerConnectionState state);

    CloudPermissionUser getPermissionHolder();

    void sendMessage(Component message);

    default void sendMiniMessage(String message) {
        MiniMessage miniMessage = MiniMessage.miniMessage();
        sendMessage(miniMessage.deserialize(message));
    }

    void kick(Component reason);

    default void kick(String reason) {
        MiniMessage miniMessage = MiniMessage.miniMessage();
        kick(miniMessage.deserialize(reason));
    }

    void sendToServer(String serverName);

    void sendToServer(String serverName, String reason);

    void sendTitle(Component title, Component subtitle, int fadeIn, int stay, int fadeOut);

    default void sendTitle(String title, String subtitle, int fadeIn, int stay, int fadeOut) {
        MiniMessage miniMessage = MiniMessage.miniMessage();
        sendTitle(miniMessage.deserialize(title), miniMessage.deserialize(subtitle), fadeIn, stay, fadeOut);
    }

    default void sendTitle(Component title, Component subtitle) {
        sendTitle(title, subtitle, 10, 70, 20);
    }

    default void sendTitle(String title, String subtitle) {
        MiniMessage miniMessage = MiniMessage.miniMessage();
        sendTitle(miniMessage.deserialize(title), miniMessage.deserialize(subtitle), 10, 70, 20);
    }

    void sendActionBar(Component message);

    default void sendActionBar(String message) {
        MiniMessage miniMessage = MiniMessage.miniMessage();
        sendActionBar(miniMessage.deserialize(message));
    }
}
