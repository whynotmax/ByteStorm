package io.bytestorm.core.scheduling.task;

import io.bytestorm.core.scheduling.strategy.ExecutionStrategy;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import lombok.experimental.NonFinal;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ScheduledCloudTask {
    private final int id;
    private final CloudTask task;
    private final ExecutionStrategy strategy;

    @NonFinal
    private TaskState state;

    public ScheduledCloudTask(int id, CloudTask task, ExecutionStrategy strategy) {
        this.id = id;
        this.task = task;
        this.strategy = strategy;
        this.state = TaskState.WAITING; // Default state
    }

}
