package io.bytestorm.api.permission;

import java.util.List;

public interface CloudPermissionHolder {

    String getId(); //Group name or User UUID

    List<CloudPermission> getPermissions();

    void addPermission(CloudPermission permission);

    void removePermission(CloudPermission permission);

    boolean hasPermission(String node);

}
