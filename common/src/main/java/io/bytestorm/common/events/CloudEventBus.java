package io.bytestorm.common.events;

import io.bytestorm.common.exception.ByteStormException;
import io.bytestorm.common.logging.ConsoleLogger;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class CloudEventBus {

    private final Map<Class<?>, List<RegisteredCloudListener>> listeners = new ConcurrentHashMap<>();

    public void register(Object listenerObject) {
        for (Method method : listenerObject.getClass().getDeclaredMethods()) {
            if (!method.isAnnotationPresent(CloudEventListener.class)) continue;

            Class<?>[] params = method.getParameterTypes();
            if (params.length != 1 || !CloudEvent.class.isAssignableFrom(params[0])) continue;

            method.setAccessible(true);
            Class<?> eventType = params[0];

            CloudEventListener annotation = method.getAnnotation(CloudEventListener.class);
            RegisteredCloudListener listener = new RegisteredCloudListener(listenerObject, method, annotation.priority());

            listeners.computeIfAbsent(eventType, k -> new ArrayList<>()).add(listener);
            listeners.get(eventType).sort(Comparator.comparingInt(l -> -l.getPriority().getPriority()));
        }
    }

    public void callEvent(CloudEvent event) {
        List<RegisteredCloudListener> registered = listeners.getOrDefault(event.getClass(), List.of());
        for (RegisteredCloudListener listener : registered) {
            try {
                listener.getMethod().invoke(listener.getOwner(), event);
                if (event instanceof Cancellable c && c.isCancelled()) break;
            } catch (Exception e) {
                throw new ByteStormException("Unable to call event listener method:", e);
            }
        }
    }

}
