package io.bytestorm.api.permission;

import java.util.List;

public final class DefaultPermissions {

    public static List<CloudPermission> defaultUserPermissions() {
        return List.of(
                new CloudPermission("cloud.connect", true),
                new CloudPermission("cloud.server.join", true)
        );
    }

    public static List<CloudPermission> defaultAdminPermissions() {
        return List.of(
                new CloudPermission("cloud.*", true)
        );
    }
}

