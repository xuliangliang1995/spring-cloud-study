package com.grasswort.sb002eurekaclient.configuration;

import feign.Contract;
import feign.Logger;
import feign.auth.BasicAuthRequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author xuliangliang
 * @Classname FooConfiguration.java
 * @Description
 * @Date 2020/1/14
 * @blame Java Team
 */
@Configuration
public class FooConfiguration {

    @Bean
    Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }

    /// 注释掉 将使用 SpringMvcContract
    /// 不注释，则使用 Feign 契约。支持 @RequestLine 但不支持 @RequestMapping 等 Spring 注解。
    /// 使用 SpringMvc 注解 @RequestMapping 会报错 Method book not annotated with HTTP method type (ex. GET, POST)
    /*@Bean
    public Contract feignContract() {
        return new feign.Contract.Default();
    }*/

    @Bean
    public BasicAuthRequestInterceptor basicAuthRequestInterceptor() {
        return new BasicAuthRequestInterceptor("user", "password");
    }

}
