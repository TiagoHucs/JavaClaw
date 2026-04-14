package com.javaclaw;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LumaAssistantApplicationTest {
    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(LumaAssistantApplicationTest.class);
        app.setAdditionalProfiles("test");
        app.run(args);
    }
}
