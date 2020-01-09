package com.grasswort.helloworld.annotation;

import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.StandardAnnotationMetadata;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.SimpleMetadataReaderFactory;
import org.springframework.util.ClassUtils;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;
import org.springframework.util.ReflectionUtils;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.annotation.Target;
import java.lang.reflect.AnnotatedElement;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author xuliangliang
 * @Classname StringRepositoryAnnotationReflectionTest.java
 * @Description
 * @Date 2020/1/9
 * @blame Java Team
 */
@StringRepository(value = "stringRepositoryAnnotationReflectionTest")
public class StringRepositoryAnnotationReflectionTest {


    public static void main(String[] args) throws IOException {
        resolveStringRepositoryValueV2();
        asm();
    }

    public static void resolveStringRepositoryValue() {
//        在 Java 反射编程模型中，注解之间无法继承，也不能实现接口。
//        不过 Java 语言默认将所有注解实现 Annotation 接口，被标注的对象用 API AnnotatedElement 表达。
//        通过 AnnotatedElement#getAnnotation(Class) 方法返回指定类的注解对下你给，获取注解属性则需要显式地调用对应的属性方法。
        AnnotatedElement annotatedElement = StringRepositoryAnnotationReflectionTest.class;
        StringRepository stringRepository = annotatedElement.getAnnotation(StringRepository.class);
        String value = stringRepository.value();
        System.out.println("获取 StringRepository value 值为：" + value);

        ReflectionUtils.doWithMethods(StringRepository.class,
                method -> System.out.printf("@StringRepository.%s() = %s\n",
                        method.getName(),
                        ReflectionUtils.invokeMethod(method, stringRepository)),
                method -> method.getParameterCount() == 0 && ! method.getDeclaringClass().equals(Annotation.class)
                );

        Set<Annotation> metaAnnotations = getAllMetaAnnotations(stringRepository);
        metaAnnotations.stream().forEach(StringRepositoryAnnotationReflectionTest::printAnnotationAttribute);
    }

    public static void resolveStringRepositoryValueV2() {
        AnnotationMetadata annotationMetadata = new StandardAnnotationMetadata(StringRepositoryAnnotationReflectionTest.class);

        Set<String> metaAnnotationTypes = annotationMetadata.getAnnotationTypes()
                .stream()
                .map(annotationMetadata::getMetaAnnotationTypes)
                .collect(LinkedHashSet::new, Set::addAll, Set::addAll);

        metaAnnotationTypes.forEach(metaAnnotation -> {
            Map<String, Object> annotationAttributes = annotationMetadata.getAnnotationAttributes(metaAnnotation);
            if (! CollectionUtils.isEmpty(annotationAttributes)) {
                annotationAttributes.forEach((name, value) -> {
                    System.out.printf("@%s.%s() = %s\n",
                            ClassUtils.getShortName(metaAnnotation),
                            name,
                            value
                            );
                });
            }
        });
    }

    public static void asm() throws IOException {
        SimpleMetadataReaderFactory factory = new SimpleMetadataReaderFactory();
        MetadataReader metadataReader = factory.getMetadataReader(StringRepositoryAnnotationReflectionTest.class.getName());
        AnnotationMetadata annotationMetadata = metadataReader.getAnnotationMetadata();
        annotationMetadata.getAnnotationTypes().stream().forEach(name -> System.out.println(name));
    }



    private static Set<Annotation> getAllMetaAnnotations(Annotation annotation) {
        Annotation[] metaAnnotations = annotation.annotationType().getAnnotations();
        if (ObjectUtils.isEmpty(metaAnnotations)) {
            return Collections.emptySet();
        }
        // 获取所有非 Java 标准元注解集合
        Set<Annotation> metaAnnotationSet = Stream.of(metaAnnotations)
                .filter(metaAnnotation ->
                        !Target.class.getPackage().equals(metaAnnotation.annotationType().getPackage())
                )
                .collect(Collectors.toSet());

        Set<Annotation> metaMetaAnnotationSet = metaAnnotationSet.stream()
                .map(StringRepositoryAnnotationReflectionTest::getAllMetaAnnotations)
                .collect(HashSet::new, Set::addAll, Set::addAll);

        metaAnnotationSet.addAll(metaMetaAnnotationSet);

        return metaAnnotationSet;
    }

    private static void printAnnotationAttribute(Annotation annotation) {
        Class<?> annotationType = annotation.annotationType();
        ReflectionUtils.doWithMethods(annotationType,
                method -> System.out.printf("@%s.%s() = %s\n",
                        annotationType.getSimpleName(),
                        method.getName(),
                        ReflectionUtils.invokeMethod(method, annotation)),
                method -> method.getParameterCount() == 0 && ! method.getDeclaringClass().equals(Annotation.class)
        );
    }
}
