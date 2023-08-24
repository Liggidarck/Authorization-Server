package com.george.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;

@SpringBootApplication(exclude = {
        JpaRepositoriesAutoConfiguration.class
})
public class ResApplication {
    public static void main(String[] args) {
        SpringApplication.run(ResApplication.class, args);
    }
}
