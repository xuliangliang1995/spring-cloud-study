package com.grasswort.sb002eurekaclient.controller;

import com.grasswort.sb002eurekaclient.entity.Book;
import com.grasswort.sb002eurekaclient.rpc.BookServiceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author xuliangliang
 * @Classname BookController.java
 * @Description
 * @Date 2020/1/14
 * @blame Java Team
 */
@RestController
@RequestMapping("books")
public class BookController {

    @Autowired
    BookServiceClient bookServiceClient;

    @GetMapping
    public List<Book> books() {
        return bookServiceClient.books();
    }

    @GetMapping("/{bookId}")
    public Book book(@PathVariable("bookId") Long bookId) {
        return bookServiceClient.book(bookId);
    }
}
