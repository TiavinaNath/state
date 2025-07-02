package com.hei.school.endpoint.rest.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Random;

@RestController
public class StatefullRandomValueController {
    private static final Path FILE_PATH = Paths.get(System.getProperty("java.io.tmpdir"), "random.txt");

    @GetMapping("/random-value")
    public String getRandomValue() throws IOException {
        if (Files.exists(FILE_PATH)) {
            return Files.readString(FILE_PATH);
        } else {
            String value = String.valueOf(new Random().nextInt(10000));
            Files.writeString(FILE_PATH, value);
            return value;
        }
    }
}
