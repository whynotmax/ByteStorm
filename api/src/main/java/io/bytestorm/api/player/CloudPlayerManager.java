package io.bytestorm.api.player;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

public interface CloudPlayerManager {

    Optional<CloudPlayer> getPlayer(UUID uniqueId);

    Optional<CloudPlayer> getPlayer(String name);

    CloudPlayer getOrCreatePlayer(UUID uniqueId);

    void registerPlayer(CloudPlayer player);

    void unregisterPlayer(UUID uniqueId);

    List<CloudPlayer> getAllPlayers();

    CompletableFuture<Optional<CloudPlayer>> getPlayerAsync(UUID uniqueId);

    CompletableFuture<Optional<CloudPlayer>> getPlayerAsync(String name);

    CompletableFuture<CloudPlayer> getOrCreatePlayerAsync(UUID uniqueId);

    CompletableFuture<List<CloudPlayer>> getAllPlayersAsync();
}
