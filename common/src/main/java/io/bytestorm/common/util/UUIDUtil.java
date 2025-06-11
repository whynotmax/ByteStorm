package io.bytestorm.common.util;

import lombok.experimental.UtilityClass;

import java.util.UUID;

@UtilityClass
public class UUIDUtil {

    public UUID fromString(String input) {
        return UUID.fromString(input);
    }

    public String randomUUID() {
        return UUID.randomUUID().toString();
    }

    public UUID fromTrimmed(String input) {
        if (input.length() == 32) {
            return UUID.fromString(input.replaceFirst(
                    "(\\w{8})(\\w{4})(\\w{4})(\\w{4})(\\w{12})",
                    "$1-$2-$3-$4-$5"
            ));
        }
        return UUID.fromString(input);
    }
}
