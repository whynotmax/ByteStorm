package io.bytestorm.common.util;

import lombok.experimental.UtilityClass;

@UtilityClass
public class StringUtil {

    public boolean isNullOrEmpty(String s) {
        return s == null || s.trim().isEmpty();
    }

    public String colorize(String s) {
        return s.replace("&", "§");
    }

    public String stripColor(String s) {
        return s.replaceAll("(?i)§[0-9A-FK-OR]", "");
    }

    public String stripMiniMessage(String s) {
        return s.replaceAll("(?i)§[0-9A-FK-OR]", "")
                 .replaceAll("<[^>]+>", "")
                 .replaceAll("\\{[^}]+}", "");
    }
}
