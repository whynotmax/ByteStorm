package io.bytestorm.api.server;

import io.bytestorm.api.player.CloudServerGroupManager;

public interface CloudServerService {

    CloudServerManager getServerManager();

    CloudServerGroupManager getGroupManager();

    void reloadTemplates();

    void reloadGroups();

}
