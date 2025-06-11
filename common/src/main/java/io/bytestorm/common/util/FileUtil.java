package io.bytestorm.common.util;

import lombok.experimental.UtilityClass;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

@UtilityClass
public class FileUtil {

    public void createIfNotExists(File file) throws IOException {
        if (!file.exists()) {
            if (file.isDirectory()) {
                file.mkdirs();
            } else {
                file.getParentFile().mkdirs();
                file.createNewFile();
            }
        }
    }

    public String readFileToString(File file) throws IOException {
        return new String(Files.readAllBytes(file.toPath()));
    }

    public void writeStringToFile(File file, String content) throws IOException {
        Files.write(file.toPath(), content.getBytes());
    }
}
