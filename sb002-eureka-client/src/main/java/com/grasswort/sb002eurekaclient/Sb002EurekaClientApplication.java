package com.grasswort.sb002eurekaclient;

import com.grasswort.sb002eurekaclient.configuration.EurekaServerRibbonConfiguration;
import com.grasswort.sb002eurekaclient.configuration.RibbonClientsConfiguration;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.netflix.ribbon.RibbonClients;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
@EnableFeignClients
//@RibbonClient(name = "eureka-server", configuration = EurekaServerRibbonConfiguration.class)
@RibbonClients(
        value = {
          @RibbonClient(name = "eureka-server", configuration = EurekaServerRibbonConfiguration.class)
        },
        defaultConfiguration = RibbonClientsConfiguration.class)
public class Sb002EurekaClientApplication {

    /*@Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }*/

    /*@Bean
    public IRule ribbonRule() {
        return new RandomRule();
        //return new RandomRule();
    }*/


    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(Sb002EurekaClientApplication.class, args);

//        DiscoveryClient discoveryClient = ctx.getBean(DiscoveryClient.class);
//        discoveryClient.getServices().forEach(s -> System.out.println(s));
//
//        LoadBalancerClient loadBalancerClient = ctx.getBean(LoadBalancerClient.class);
//        System.out.println(loadBalancerClient.getClass());

    }

}
