package com.grasswort.sb002eurekaclient.configuration;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

/**
 * @author xuliangliang
 * @Classname RibbonClientsConfiguration.java
 * @Description
 * @Date 2020/1/23
 * @blame Java Team
 */
public class RibbonClientsConfiguration {
    @Autowired
    IClientConfig iClientConfig;

    @Bean
    public IRule ribbonRule(IClientConfig config) {
        return new RandomRule();
    }
}
