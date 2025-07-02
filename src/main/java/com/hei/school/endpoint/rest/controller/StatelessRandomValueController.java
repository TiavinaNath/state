package com.hei.school.endpoint.rest.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Random;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StatelessRandomValueController {

  @GetMapping("/random-value-stateless")
  public String getRandomValueStateless() throws IOException {
    String value = String.valueOf(new Random().nextInt(10000));
    Path tempFile = Files.createTempFile("random_", ".txt");
    Files.writeString(tempFile, value);
    String readValue = Files.readString(tempFile);
    Files.deleteIfExists(tempFile);
    return readValue;
  }
}
