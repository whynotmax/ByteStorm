package io.bytestorm.api.permission;

import io.bytestorm.api.permission.entities.CloudPermissionGroup;
import io.bytestorm.api.permission.entities.CloudPermissionUser;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

public interface CloudPermissionService {

    Optional<CloudPermissionUser> getUser(String userId);

    Optional<CloudPermissionGroup> getGroup(String groupName);

    void addUser(CloudPermissionUser user);

    void addGroup(CloudPermissionGroup group);

    void removeUser(String userId);

    void removeGroup(String groupName);

    List<CloudPermissionGroup> getAllGroups();

    List<CloudPermissionUser> getAllUsers();

    CompletableFuture<Optional<CloudPermissionUser>> getUserAsync(String userId);

    CompletableFuture<Optional<CloudPermissionGroup>> getGroupAsync(String groupName);

    CompletableFuture<Void> addUserAsync(CloudPermissionUser user);

    CompletableFuture<Void> addGroupAsync(CloudPermissionGroup group);

    CompletableFuture<Void> removeUserAsync(String userId);

    CompletableFuture<Void> removeGroupAsync(String groupName);

    CompletableFuture<List<CloudPermissionGroup>> getAllGroupsAsync();

    CompletableFuture<List<CloudPermissionUser>> getAllUsersAsync();
}