package io.bytestorm.api.player;

import java.awt.*;

public interface CloudPlayerService {

    CloudPlayerManager getManager();

    void broadcast(Component component);

    default void broadcast(String message) {
        MiniMessage miniMessage = MiniMessage.miniMessage();
        broadcast(miniMessage.deserialize(message));
    }

    void kickAll(Component component);

    default void kickAll(String message) {
        MiniMessage miniMessage = MiniMessage.miniMessage();
        kickAll(miniMessage.deserialize(message));
    }

}
