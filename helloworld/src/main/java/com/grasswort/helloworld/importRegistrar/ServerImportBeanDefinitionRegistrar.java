package com.grasswort.helloworld.importRegistrar;

import com.grasswort.helloworld.importSelector.ServerImportSelector;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionReaderUtils;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

import java.util.stream.Stream;

/**
 * @author xuliangliang
 * @Classname ServerImportBeanDefinitionRegistrar.java
 * @Description
 * @Date 2020/1/9
 * @blame Java Team
 */
public class ServerImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {
    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        // 复用 {@link ServerImportSelector} 实现，避免重复劳动
        ImportSelector importSelector = new ServerImportSelector();
        // 筛选 class 名称集合
        String[] selectedClassNames = importSelector.selectImports(importingClassMetadata);
        // 创建 Bean 定义
        Stream.of(selectedClassNames)
                // 转化为 BeanDefinitionBuilder 对象
                .map(BeanDefinitionBuilder::genericBeanDefinition)
                // 转化为 BeanDefinition 对象
                .map(BeanDefinitionBuilder::getBeanDefinition)
                .forEach(beanDefinition -> {
                    // 注册 BeanDefinition 到 BeanDefinitionRegistry
                    BeanDefinitionReaderUtils.registerWithGeneratedName(beanDefinition, registry);
                });
    }
}
