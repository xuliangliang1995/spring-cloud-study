package com.grasswort.sb002eurekaclient.controller;

import com.grasswort.sb002eurekaclient.entity.Book;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author xuliangliang
 * @Classname BookControllerV2.java
 * @Description
 * @Date 2020/1/21
 * @blame Java Team
 */
//@RestController
//@RequestMapping("/v2/books")
public class BookControllerV2 {

    private final RestTemplate restTemplate;

    public BookControllerV2(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("/{bookId}")
    public Book books(@PathVariable("bookId")Long bookId) {
        Book book = restTemplate.getForObject("http://eureka-server/books/".concat(String.valueOf(bookId)), Book.class);
        return book;
    }
}
