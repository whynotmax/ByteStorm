package io.bytestorm.api.permission.entities;

import io.bytestorm.api.permission.CloudPermission;
import io.bytestorm.api.permission.CloudPermissionHolder;

import java.util.List;
import java.util.UUID;

public interface CloudPermissionUser extends CloudPermissionHolder {

    UUID getUniqueId();

    String getUsername();

    List<CloudPermissionGroup> getGroups();

    void addGroup(CloudPermissionGroup group, int priority);

    void removeGroup(CloudPermissionGroup group);

    boolean isInGroup(CloudPermissionGroup group);

    CloudPermissionGroup getHighestPriorityGroup();

}
