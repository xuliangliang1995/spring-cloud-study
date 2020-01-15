package com.grasswort.sb002eurekaclient.rpc;

import com.grasswort.sb002eurekaclient.entity.Book;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

/**
 * @author xuliangliang
 * @Classname BookServiceHystrixClient.java
 * @Description
 * @Date 2020/1/14
 * @blame Java Team
 */
@Component
public class BookServiceClientHystrixFallback implements BookServiceClient {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public List<Book> books() {
        logger.warn("books request fail !");
        return Collections.EMPTY_LIST;
    }

    @Override
    public Book book(Long bookId) {
        logger.warn("books/{} request fail !", bookId);
        return null;
    }
}
