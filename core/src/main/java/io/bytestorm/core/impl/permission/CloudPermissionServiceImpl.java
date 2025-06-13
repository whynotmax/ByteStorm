package io.bytestorm.core.impl.permission;

import io.bytestorm.api.permission.CloudPermissionService;
import io.bytestorm.api.permission.entities.CloudPermissionGroup;
import io.bytestorm.api.permission.entities.CloudPermissionUser;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

public class CloudPermissionServiceImpl implements CloudPermissionService {
    @Override
    public Optional<CloudPermissionUser> getUser(String userId) {
        return Optional.empty();
    }

    @Override
    public Optional<CloudPermissionGroup> getGroup(String groupName) {
        return Optional.empty();
    }

    @Override
    public void addUser(CloudPermissionUser user) {

    }

    @Override
    public void addGroup(CloudPermissionGroup group) {

    }

    @Override
    public void removeUser(String userId) {

    }

    @Override
    public void removeGroup(String groupName) {

    }

    @Override
    public List<CloudPermissionGroup> getAllGroups() {
        return List.of();
    }

    @Override
    public List<CloudPermissionUser> getAllUsers() {
        return List.of();
    }

    @Override
    public CompletableFuture<Optional<CloudPermissionUser>> getUserAsync(String userId) {
        return null;
    }

    @Override
    public CompletableFuture<Optional<CloudPermissionGroup>> getGroupAsync(String groupName) {
        return null;
    }

    @Override
    public CompletableFuture<Void> addUserAsync(CloudPermissionUser user) {
        return null;
    }

    @Override
    public CompletableFuture<Void> addGroupAsync(CloudPermissionGroup group) {
        return null;
    }

    @Override
    public CompletableFuture<Void> removeUserAsync(String userId) {
        return null;
    }

    @Override
    public CompletableFuture<Void> removeGroupAsync(String groupName) {
        return null;
    }

    @Override
    public CompletableFuture<List<CloudPermissionGroup>> getAllGroupsAsync() {
        return null;
    }

    @Override
    public CompletableFuture<List<CloudPermissionUser>> getAllUsersAsync() {
        return null;
    }
}
