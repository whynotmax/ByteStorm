package io.bytestorm.common.events;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface CloudEventListener {
    CloudEventPriority priority() default 0;
}
