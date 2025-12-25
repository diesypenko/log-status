package com.fileparser.parser;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;
import java.util.List;
import java.util.concurrent.ExecutionException;

import org.junit.jupiter.api.Test;

import com.fileparser.model.Order;
import com.fileparser.service.ThreadPoolService;

class ThreadPoolServiceTest {

    @Test
    void testParallelParsing() throws ExecutionException, InterruptedException {
        ThreadPoolService pool = new ThreadPoolService(4);
        JsonStreamReader reader = new JsonStreamReader();

        List<File> files = List.of(
                new File("src/test/resources/test_data/orders1.json"),
                new File("src/test/resources/test_data/orders2.json")
        );

        List<Order> orders = pool.parseFiles(files, reader);

        assertNotNull(orders);
        assertTrue(orders.size() > 0);
    }
}
