package io.bytestorm.common.events;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

import java.lang.reflect.Method;

@Getter
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class RegisteredCloudListener {

    private final Object owner;
    private final Method method;
    private final CloudEventPriority priority;

    public void execute(CloudEvent event) throws Exception {
        method.invoke(owner, event);
    }
}
