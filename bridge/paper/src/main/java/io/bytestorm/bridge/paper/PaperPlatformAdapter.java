package io.bytestorm.bridge.paper;

import io.bytestorm.api.CloudAPI;
import io.bytestorm.api.player.CloudPlayer;
import io.bytestorm.bridge.common.adapter.PlatformAdapter;
import io.bytestorm.bridge.common.adapter.PlatformInfo;
import org.bukkit.Bukkit;

import java.io.File;
import java.util.Collection;
import java.util.Optional;
import java.util.Properties;
import java.util.UUID;
import java.util.stream.Collectors;

public class PaperPlatformAdapter implements PlatformAdapter {

    @Override
    public PlatformInfo getPlatformInfo() {
        String name = "Paper";
        String apiVersion = Bukkit.getBukkitVersion();
        return new PlatformInfo(name, apiVersion, false);
    }

    @Override
    public void sendMessage(UUID userUniqueId, String message) {
        Optional<CloudPlayer> playerOptional = CloudAPI.getInstance().getPlayerService().getManager().getPlayer(userUniqueId);
        if (playerOptional.isPresent()) {
            CloudPlayer player = playerOptional.get();
            player.sendMiniMessage(message);
        } else {
            throw new IllegalArgumentException("Player with UUID " + userUniqueId + " not found.");
        }
    }

    @Override
    public void broadcast(String message) {
        Collection<CloudPlayer> players = CloudAPI.getInstance().getPlayerService().getManager().getAllPlayers();
        for (CloudPlayer player : players) {
            player.sendMiniMessage(message);
        }
    }

    @Override
    public String getServerName() {
        File serverPropertiesFile = new File("server.properties");
        if (serverPropertiesFile.exists()) {
            try {
                Properties serverProperties = new Properties();
                serverProperties.load(new java.io.FileInputStream(serverPropertiesFile));
                String serverName = serverProperties.getProperty("server-name");
                if (serverName != null && !serverName.isEmpty()) {
                    return serverName;
                } else {
                    throw new IllegalStateException("server-name property is not set or is empty in server.properties");
                }
            } catch (Exception e) {
                throw new RuntimeException("Failed to read server name from server.properties", e);
            }
        } else {
            throw new IllegalStateException("server.properties file not found.");
        }
    }
}

