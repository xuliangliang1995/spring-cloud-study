package com.grasswort.sb002eurekaclient.rpc;

import com.grasswort.sb002eurekaclient.configuration.FooConfiguration;
import com.grasswort.sb002eurekaclient.entity.Book;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * @author xuliangliang
 * @Classname BookServiceClient.java
 * @Description
 * @Date 2020/1/14
 * @blame Java Team
 */
@FeignClient(contextId = "book", name = "eureka-server",
        //fallback = BookServiceClientHystrixFallback.class
        configuration = FooConfiguration.class,
        fallbackFactory = BookServiceClientHystrixFallbackFactory.class
)
public interface BookServiceClient {

    @RequestMapping(value = "books", method = RequestMethod.GET)
    List<Book> books();

    @RequestMapping(value = "books/{bookId}", method = RequestMethod.GET)
    Book book(@PathVariable("bookId")Long bookId);

}
