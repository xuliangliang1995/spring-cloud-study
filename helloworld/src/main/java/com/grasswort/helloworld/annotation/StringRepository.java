package com.grasswort.helloworld.annotation;

import org.springframework.stereotype.Component;

import java.lang.annotation.*;

/**
 * @author xuliangliang
 * @Classname StringRepository.java
 * @Description
 * @Date 2020/1/9
 * @blame Java Team
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Component
public @interface StringRepository {
    /**
     * 属性方法名称必须与{@link Component#value()} 保持一致
     * @return Bean 的名称
     */
    String value() default "";
}
