package io.bytestorm.core.scheduling.scheduler;

import io.bytestorm.core.scheduling.task.CloudTask;
import io.bytestorm.core.scheduling.strategy.ExecutionStrategy;

public interface CloudScheduler {
    int schedule(CloudTask task, ExecutionStrategy strategy);
    void cancel(int taskId);
    void shutdown();
}
