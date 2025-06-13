package io.bytestorm.core.scheduling.strategy;

public interface ExecutionStrategy {
    long getNextExecutionDelay(); // in milliseconds
    boolean shouldRepeat();
}
