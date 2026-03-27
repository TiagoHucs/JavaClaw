package com.lumaassistant.filereader;

import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

public class FileReader {

    public static String readFile(String filePathName) {
        ClassPathResource resource = new ClassPathResource(filePathName);

        try {
            return new String(
                    Files.readAllBytes(resource.getFile().toPath()),
                    StandardCharsets.UTF_8
            );
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
