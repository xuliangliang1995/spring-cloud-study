package com.grasswort.sb001configclient.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xuliangliang
 * @Classname HelloController.java
 * @Description
 * @Date 2020/1/9
 * @blame Java Team
 */
@RestController
@RefreshScope
public class HelloController {

    @Value("${message:defaultMessage}")
    private String message;

    @GetMapping
    public String hello() {
        return message;
    }
}
