package io.bytestorm.bridge.common.player;

import io.bytestorm.api.player.CloudPlayer;
import io.bytestorm.api.player.CloudPlayerManager;

import java.util.UUID;

public class BridgePlayerAdapter {

    private final CloudPlayerManager playerManager;

    public BridgePlayerAdapter(CloudPlayerManager playerManager) {
        this.playerManager = playerManager;
    }

    public void onPlayerJoin(UUID uuid) {
        CloudPlayer player = playerManager.getOrCreatePlayer(uuid);
        playerManager.registerPlayer(player);
    }

    public void onPlayerQuit(UUID uuid) {
        playerManager.unregisterPlayer(uuid);
    }
}

