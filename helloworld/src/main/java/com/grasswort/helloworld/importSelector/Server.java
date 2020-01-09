package com.grasswort.helloworld.importSelector;

/**
 * @author xuliangliang
 * @Classname Server.java
 * @Description
 * @Date 2020/1/9
 * @blame Java Team
 */
public interface Server {
    /**
     * 启动服务器
     */
    void start();

    /**
     * 停止服务器
     */
    void stop();

    /**
     * 服务器类型
     */
    enum Type {
        HTTP, FTP
    }
}
