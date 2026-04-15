package com.javaclaw;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JavaClawApplicationTest {
    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(JavaClawApplicationTest.class);
        app.setAdditionalProfiles("test");
        app.run(args);
    }
}
