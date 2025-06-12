package io.bytestorm.api.server;

import lombok.NonNull;

import java.util.List;

public interface CloudServerGroup {

    @NonNull
    String getName();

    int getMinimumServers();

    int getMaximumServers();

    List<CloudServerTemplate> getTemplates();

    void addTemplate(@NonNull CloudServerTemplate template);

    void removeTemplate(@NonNull String templateName);

    boolean isStatic();

    boolean isFallback();

}
