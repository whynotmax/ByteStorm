package io.bytestorm.api.server;

import io.reactivex.rxjava3.annotations.Nullable;
import lombok.NonNull;

import java.util.List;

public interface CloudServerTemplate {

    @NonNull
    String getName();

    @Nullable
    String getGroup();

    @NonNull
    String getBaseDirectory();

    @NonNull
    List<String> getJvmArguments();

    int getMinimumMemory(); // in MB

    int getMaximumMemory(); // in MB

}
