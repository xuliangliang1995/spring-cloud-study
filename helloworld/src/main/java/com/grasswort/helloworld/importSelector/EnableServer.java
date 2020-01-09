package com.grasswort.helloworld.importSelector;

import com.grasswort.helloworld.importRegistrar.ServerImportBeanDefinitionRegistrar;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @author xuliangliang
 * @Classname EnableServer.java
 * @Description
 * @Date 2020/1/9
 * @blame Java Team
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
//@Import(ServerImportSelector.class)
@Import(ServerImportBeanDefinitionRegistrar.class)
public @interface EnableServer {
    /**
     * 服务器类型
     * @return
     */
    Server.Type type();
}
