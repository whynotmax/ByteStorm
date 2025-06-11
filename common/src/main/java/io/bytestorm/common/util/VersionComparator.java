package io.bytestorm.common.util;

import lombok.experimental.UtilityClass;

import java.util.Arrays;

@UtilityClass
public class VersionComparator {

    public int compare(String v1, String v2) {
        int[] parts1 = Arrays.stream(v1.split("\\.")).mapToInt(Integer::parseInt).toArray();
        int[] parts2 = Arrays.stream(v2.split("\\.")).mapToInt(Integer::parseInt).toArray();

        int maxLength = Math.max(parts1.length, parts2.length);
        for (int i = 0; i < maxLength; i++) {
            int a = i < parts1.length ? parts1[i] : 0;
            int b = i < parts2.length ? parts2[i] : 0;
            if (a != b) return a - b;
        }
        return 0;
    }

    public boolean isNewer(String base, String compareTo) {
        return compare(base, compareTo) < 0;
    }

    public boolean isOlder(String base, String compareTo) {
        return compare(base, compareTo) > 0;
    }

    public boolean isEqual(String base, String compareTo) {
        return compare(base, compareTo) == 0;
    }
}
