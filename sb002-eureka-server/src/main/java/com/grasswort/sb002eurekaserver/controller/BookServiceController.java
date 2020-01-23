package com.grasswort.sb002eurekaserver.controller;

import com.grasswort.sb002eurekaserver.entity.Book;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author xuliangliang
 * @Classname BookServiceController.java
 * @Description
 * @Date 2020/1/14
 * @blame Java Team
 */
@RestController
@RequestMapping("books")
public class BookServiceController {

    private static final List<Book> BOOK_LIST = new LinkedList<>(Arrays.asList(
            new Book(1L, "本草纲目", "李时珍"),
            new Book(2L, "SpringBoot 编程思想", "小马哥")
    ));

    private final Environment environment;

    public BookServiceController(Environment environment) {
        this.environment = environment;
    }

    @GetMapping
    public List<Book> books() {
        return BOOK_LIST;
    }

    @GetMapping("/{bookId}")
    public Book book(@PathVariable("bookId") Long bookId) {
        System.out.println("【PORT】:" + environment.getProperty("local.server.port"));
        return BOOK_LIST.stream()
                .filter(book -> book.getId().equals(bookId))
                .findFirst()
                .orElse(null);
    }
}
