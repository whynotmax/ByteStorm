package io.bytestorm.api.server;

import io.bytestorm.api.messaging.packet.ServerStartRequestPacket;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

public interface CloudServerManager {

    Optional<CloudServer> getServer(UUID uniqueId);

    Optional<CloudServer> getServer(String name);

    List<CloudServer> getServers();

    List<CloudServer> getServersByGroup(String groupName);

    CloudServer startServer(ServerStartRequestPacket request);

    void stopServer(String name);

    CompletableFuture<Optional<CloudServer>> getServerAsync(UUID uniqueId);

    CompletableFuture<Optional<CloudServer>> getServerAsync(String name);

    CompletableFuture<List<CloudServer>> getServersAsync();

    CompletableFuture<List<CloudServer>> getServersByGroupAsync(String groupName);
}
