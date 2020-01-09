package com.grasswort.sb002eurekaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class Sb002EurekaServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(Sb002EurekaServerApplication.class, args);
    }

}
