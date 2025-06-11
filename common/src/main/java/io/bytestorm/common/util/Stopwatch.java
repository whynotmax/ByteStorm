package io.bytestorm.common.util;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import lombok.experimental.UtilityClass;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public final class Stopwatch {

    private long startTime;

    private Stopwatch(long startTime) {
        this.startTime = startTime;
    }

    public static Stopwatch create() {
        return new Stopwatch(System.currentTimeMillis());
    }

    public long elapsedMillis() {
        return System.currentTimeMillis() - startTime;
    }

    public void reset() {
        this.startTime = System.currentTimeMillis();
    }

    @Override
    public String toString() {
        return elapsedMillis() + "ms";
    }
}
