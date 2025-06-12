package io.bytestorm.api.player;

import io.bytestorm.api.server.CloudServerGroup;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

public interface CloudServerGroupManager {

    Optional<CloudServerGroup> getGroup(String name);

    List<CloudServerGroup> getGroups();

    void addGroup(CloudServerGroup group);

    void removeGroup(String name);

    CompletableFuture<List<CloudServerGroup>> getGroupsAsync();

    CompletableFuture<Optional<CloudServerGroup>> getGroupAsync(String name);
}
