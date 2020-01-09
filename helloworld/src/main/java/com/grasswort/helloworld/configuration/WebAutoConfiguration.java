package com.grasswort.helloworld.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author xuliangliang
 * @Classname WebAutoConfiguration.java
 * @Description
 * @Date 2020/1/8
 * @blame Java Team
 */
@Configuration
@Import(WebConfiguration.class)
public class WebAutoConfiguration {
}
