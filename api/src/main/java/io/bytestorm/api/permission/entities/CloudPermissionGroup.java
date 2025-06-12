package io.bytestorm.api.permission.entities;

import io.bytestorm.api.permission.CloudPermissionHolder;

import java.util.List;

public interface CloudPermissionGroup extends CloudPermissionHolder {

    String getName();

    List<?> getInheritedGroups();

    void inheritGroup(CloudPermissionGroup group);

    void uninheritGroup(CloudPermissionGroup group);

}
