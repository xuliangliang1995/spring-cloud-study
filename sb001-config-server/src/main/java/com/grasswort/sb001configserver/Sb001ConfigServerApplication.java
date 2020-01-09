package com.grasswort.sb001configserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class Sb001ConfigServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(Sb001ConfigServerApplication.class, args);
    }

}

