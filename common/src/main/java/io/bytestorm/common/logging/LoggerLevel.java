package io.bytestorm.common.logging;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@Getter
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public enum LoggerLevel {

    TRACE(0),
    DEBUG(100),
    INFO(200),
    WARN(300),
    ERROR(400),
    FATAL(500);

    int weight;

}
