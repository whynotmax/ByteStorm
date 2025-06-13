package io.bytestorm.core.impl.player;

import io.bytestorm.api.permission.entities.CloudPermissionUser;
import io.bytestorm.api.player.CloudPlayer;
import io.bytestorm.api.player.CloudPlayerConnectionState;
import io.bytestorm.api.player.CloudPlayerSession;

import java.awt.*;
import java.util.UUID;

public class CloudPlayerImpl implements CloudPlayer {
    @Override
    public UUID getUniqueId() {
        return null;
    }

    @Override
    public String getName() {
        return "";
    }

    @Override
    public CloudPlayerSession getCurrentSession() {
        return null;
    }

    @Override
    public CloudPlayerConnectionState getConnectionState() {
        return null;
    }

    @Override
    public void setConnectionState(CloudPlayerConnectionState state) {

    }

    @Override
    public CloudPermissionUser getPermissionHolder() {
        return null;
    }

    @Override
    public void sendMessage(Component message) {

    }

    @Override
    public void kick(Component reason) {

    }

    @Override
    public void sendToServer(String serverName) {

    }

    @Override
    public void sendToServer(String serverName, String reason) {

    }

    @Override
    public void sendTitle(Component title, Component subtitle, int fadeIn, int stay, int fadeOut) {

    }

    @Override
    public void sendActionBar(Component message) {

    }
}
