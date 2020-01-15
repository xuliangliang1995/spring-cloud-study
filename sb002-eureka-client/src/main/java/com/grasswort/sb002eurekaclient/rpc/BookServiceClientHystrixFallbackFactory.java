package com.grasswort.sb002eurekaclient.rpc;

import com.grasswort.sb002eurekaclient.entity.Book;
import feign.hystrix.FallbackFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;

/**
 * @author xuliangliang
 * @Classname BookServiceClientHystrixFallbackFactory.java
 * @Description
 * @Date 2020/1/14
 * @blame Java Team
 */
@Component
public class BookServiceClientHystrixFallbackFactory implements FallbackFactory<BookServiceClient> {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public BookServiceClient create(Throwable cause) {
        return new BookServiceClient() {
            @Override
            public List<Book> books() {
                logger.warn("books request fail ! cause reason: {}", cause.getMessage());
                return Collections.EMPTY_LIST;
            }

            @Override
            public Book book(Long bookId) {
                logger.warn("books/{} request fail ! cause reason: {}", bookId, cause.getMessage());
                return null;
            }
        };
    }
}
