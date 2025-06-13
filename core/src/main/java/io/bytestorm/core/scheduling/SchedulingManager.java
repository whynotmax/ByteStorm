package io.bytestorm.core.scheduling;

import io.bytestorm.core.scheduling.scheduler.CloudScheduler;
import io.bytestorm.core.scheduling.scheduler.TimerScheduler;
import io.bytestorm.core.scheduling.task.CloudTask;
import io.bytestorm.core.scheduling.strategy.ExecutionStrategy;

public class SchedulingManager {

    private static final CloudScheduler scheduler = new TimerScheduler();

    private SchedulingManager() {

    }

    public static void scheduleTask(CloudTask task, ExecutionStrategy strategy) {
        scheduler.schedule(task, strategy);
    }

    public static void shutdownScheduler() {
        scheduler.shutdown();
    }
}
