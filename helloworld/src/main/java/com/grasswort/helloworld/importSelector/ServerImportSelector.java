package com.grasswort.helloworld.importSelector;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

import java.util.Map;

/**
 * @author xuliangliang
 * @Classname ServerImportSelector.java
 * @Description
 * @Date 2020/1/9
 * @blame Java Team
 */
public class ServerImportSelector implements ImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata annotationMetadata) {
        // 读取 EnableServer 中所有的属性方法，本例中仅有 type() 属性方法
        // 其中 key 为属性方法的名称， value 为属性方法的返回对象
        Map<String, Object> annotationAttributes = annotationMetadata.getAnnotationAttributes(EnableServer.class.getName());
        // 获取名为 type() 的属性方法，并且强制转化成 Server.Type 类型
        Server.Type type = (Server.Type) annotationAttributes.get("type");
        // 导入的类名称数组
        String[] importClassNames = new String[0];
        switch (type) {
            case HTTP: // 当设置 HTTP 服务器类型时， 返回 HTTPServer 组件。
                importClassNames = new String[]{HttpServer.class.getName()};
                break;
            case FTP:// 当设置 FTP 服务器类型时， 返回 HTTPServer 组件。
                importClassNames = new String[]{FtpServer.class.getName()};
                break;
        }
        return importClassNames;
    }
}
