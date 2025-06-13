package io.bytestorm.core.scheduling.strategy;

public class OneTimeExecution implements ExecutionStrategy {
    private final long delay;

    public OneTimeExecution(long delay) {
        this.delay = delay;
    }

    @Override
    public long getNextExecutionDelay() {
        return delay;
    }

    @Override
    public boolean shouldRepeat() {
        return false;
    }
}
