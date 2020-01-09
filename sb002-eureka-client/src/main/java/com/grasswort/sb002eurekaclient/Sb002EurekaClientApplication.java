package com.grasswort.sb002eurekaclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class Sb002EurekaClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(Sb002EurekaClientApplication.class, args);
    }

}
