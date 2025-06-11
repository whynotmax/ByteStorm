package io.bytestorm.common.util;

import lombok.experimental.UtilityClass;

@UtilityClass
public class ThreadUtil {

    public void runAsync(Runnable task) {
        new Thread(task).start();
    }

    public void sleepSafely(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException ignored) {}
    }
}
