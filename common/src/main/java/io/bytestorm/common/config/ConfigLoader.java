package io.bytestorm.common.config;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class ConfigLoader {

    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

    public static <T> Configuration<T> load(File file, Class<T> type, T defaultInstance) {
        if (!file.exists()) {
            save(file, defaultInstance); // create default if missing
            return new Configuration<>(defaultInstance, type);
        }

        try (Reader reader = new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8)) {
            T data = GSON.fromJson(reader, type);
            return new Configuration<>(data, type);
        } catch (IOException e) {
            throw new RuntimeException("Fehler beim Laden der Config: " + file.getName(), e);
        }
    }

    public static <T> void save(File file, T data) {
        try (Writer writer = new OutputStreamWriter(new FileOutputStream(file), StandardCharsets.UTF_8)) {
            GSON.toJson(data, writer);
        } catch (IOException e) {
            throw new RuntimeException("Fehler beim Speichern der Config: " + file.getName(), e);
        }
    }
}
