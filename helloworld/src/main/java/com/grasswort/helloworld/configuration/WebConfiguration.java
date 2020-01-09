package com.grasswort.helloworld.configuration;

import org.springframework.boot.web.context.WebServerInitializedEvent;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;

/**
 * @author xuliangliang
 * @Classname WebConfiguration.java
 * @Description
 * @Date 2020/1/8
 * @blame Java Team
 */
@Configuration
public class WebConfiguration {

    @EventListener(WebServerInitializedEvent.class)
    public void onWebServerReady(WebServerInitializedEvent event) {
        System.out.println("当前 WebServer 实现类为：" + event.getWebServer().getClass().getName());
    }
}
