package com.grasswort.helloworld.repository;

import com.grasswort.helloworld.annotation.StringRepository;

import java.util.Arrays;
import java.util.List;

/**
 * @author xuliangliang
 * @Classname NameRepository.java
 * @Description
 * @Date 2020/1/9
 * @blame Java Team
 */
@StringRepository("chineseNameRepository")
public class NameRepository {

    public List<String> findAll() {
        return Arrays.asList("张三", "李四", "王五");
    }
}
