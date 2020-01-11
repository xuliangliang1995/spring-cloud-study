package com.grasswort.sb002eurekaserver.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xuliangliang
 * @Classname EchoServiceController.java
 * @Description
 * @Date 2020/1/10
 * @blame Java Team
 */
@RestController
public class EchoServiceController {

    @GetMapping("/echo/{message}")
    public String echoService(@PathVariable("message") String message) {
        return message;
    }
}
