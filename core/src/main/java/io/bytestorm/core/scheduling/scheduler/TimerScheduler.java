package io.bytestorm.core.scheduling.scheduler;

import io.bytestorm.core.scheduling.task.CloudTask;
import io.bytestorm.core.scheduling.task.ScheduledCloudTask;
import io.bytestorm.core.scheduling.strategy.ExecutionStrategy;

import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

public class TimerScheduler implements CloudScheduler {

    private final Timer timer = new Timer("CloudScheduler", true);
    // Map taskId -> Pair(ScheduledCloudTask, TimerTask)
    private final Map<Integer, TaskHolder> scheduledTasks = new HashMap<>();

    private static class TaskHolder {
        final ScheduledCloudTask scheduledTask;
        final TimerTask timerTask;

        TaskHolder(ScheduledCloudTask scheduledTask, TimerTask timerTask) {
            this.scheduledTask = scheduledTask;
            this.timerTask = timerTask;
        }
    }

    @Override
    public int schedule(CloudTask task, ExecutionStrategy strategy) {
        int taskId = getNewTaskId();
        ScheduledCloudTask scheduledTask = new ScheduledCloudTask(taskId, task, strategy);
        scheduleInternal(scheduledTask);
        return taskId;
    }

    private int getNewTaskId() {
        int recursionDepth = 0;
        int maxRecursionDepth = 50;
        int taskId;
        do {
            taskId = (int) System.currentTimeMillis(); // Placeholder for unique ID generation
            recursionDepth++;
            if (recursionDepth > maxRecursionDepth) {
                throw new IllegalStateException("Failed to generate a unique task ID after " + maxRecursionDepth + " attempts.");
            }
        } while (scheduledTasks.containsKey(taskId));
        return taskId;
    }

    private void scheduleInternal(ScheduledCloudTask scheduledTask) {
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                scheduledTask.setState(io.bytestorm.core.scheduling.task.TaskState.RUNNING);
                scheduledTask.getTask().execute();
                if (scheduledTask.getStrategy().shouldRepeat()) {
                    scheduledTask.setState(io.bytestorm.core.scheduling.task.TaskState.WAITING);
                    scheduleInternal(scheduledTask);
                } else {
                    scheduledTask.setState(io.bytestorm.core.scheduling.task.TaskState.COMPLETED);
                    scheduledTasks.remove(scheduledTask.getId());
                }
            }
        };

        timer.schedule(timerTask, scheduledTask.getStrategy().getNextExecutionDelay());
        scheduledTasks.put(scheduledTask.getId(), new TaskHolder(scheduledTask, timerTask));
    }

    @Override
    public void cancel(int taskId) {
        TaskHolder holder = scheduledTasks.remove(taskId);
        if (holder != null) {
            holder.timerTask.cancel();
            holder.scheduledTask.setState(io.bytestorm.core.scheduling.task.TaskState.CANCELLED);
        }
    }

    @Override
    public void shutdown() {
        timer.cancel();
    }
}