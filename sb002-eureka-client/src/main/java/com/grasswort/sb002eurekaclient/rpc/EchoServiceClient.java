package com.grasswort.sb002eurekaclient.rpc;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author xuliangliang
 * @Classname EchoServiceClient.java
 * @Description
 * @Date 2020/1/10
 * @blame Java Team
 */
@FeignClient(contextId = "echo", name = "eureka-server")
public interface EchoServiceClient {

    @GetMapping("/echo/{message}")
    String echo(@PathVariable("message") String message);
}
