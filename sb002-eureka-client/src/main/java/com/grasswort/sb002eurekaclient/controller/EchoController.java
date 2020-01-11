package com.grasswort.sb002eurekaclient.controller;

import com.grasswort.sb002eurekaclient.rpc.EchoServiceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xuliangliang
 * @Classname EchoController.java
 * @Description
 * @Date 2020/1/10
 * @blame Java Team
 */
@RestController
public class EchoController {

    private final EchoServiceClient echoServiceClient;

    private final Environment environment;

    public EchoController(EchoServiceClient echoServiceClient, Environment environment) {
        this.echoServiceClient = echoServiceClient;
        this.environment = environment;
    }

    @GetMapping("/echo/{message}")
    public String echo(@PathVariable("message") String message) {
        return echoServiceClient.echo(String.format("[%s]%s", port(), message));
    }

    private String port() {
        return environment.getProperty("local.server.port");
    }
}
