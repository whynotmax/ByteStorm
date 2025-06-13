package io.bytestorm.core.scheduling.strategy;

public class FixedRateExecution implements ExecutionStrategy {
    private final long interval;

    public FixedRateExecution(long interval) {
        this.interval = interval;
    }

    @Override
    public long getNextExecutionDelay() {
        return interval;
    }

    @Override
    public boolean shouldRepeat() {
        return true;
    }
}
