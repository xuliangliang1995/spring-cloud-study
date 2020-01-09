package com.grasswort.helloworld;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

public class HelloworldApplication {
    @SpringBootApplication
    static class App1{}

    @EnableAutoConfiguration
    @ComponentScan
    @Configuration
    static class App2{}

    @EnableAutoConfiguration
    @Configuration
    static class App3{}

    public static void main(String[] args) {
        SpringApplication.run(App3.class, args);
    }

}
