package io.bytestorm.common.config;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Configuration<T> {

    private final T data;
    private final Class<T> type;

    public T get() {
        return data;
    }
}
