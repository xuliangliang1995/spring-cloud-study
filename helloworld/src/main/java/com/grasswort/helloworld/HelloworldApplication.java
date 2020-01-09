package com.grasswort.helloworld;

import com.grasswort.helloworld.importSelector.EnableServer;
import com.grasswort.helloworld.importSelector.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
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
    @EnableServer(type = Server.Type.HTTP)
    static class App3{}

    public static void main(String[] args) {
        /*ConfigurableApplicationContext ctx = SpringApplication.run(App1.class, args);
        NameRepository nameRepository = ctx.getBean(NameRepository.class);
        nameRepository.findAll().stream().forEach(name -> System.out.println(name));*/

        ConfigurableApplicationContext ctx = SpringApplication.run(App3.class, args);
        Server server = ctx.getBean(Server.class);
        server.start();
        server.stop();
    }

}
