package com.grasswort.helloworld.importSelector;

import org.springframework.stereotype.Component;

/**
 * @author xuliangliang
 * @Classname HttpServer.java
 * @Description
 * @Date 2020/1/9
 * @blame Java Team
 */
@Component
public class HttpServer implements Server {
    /**
     * 启动服务器
     */
    @Override
    public void start() {
        System.out.println("HTTP 服务器启动中。。。");
    }

    /**
     * 停止服务器
     */
    @Override
    public void stop() {
        System.out.println("HTTP 服务器关闭中。。。");
    }
}
