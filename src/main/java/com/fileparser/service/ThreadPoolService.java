package com.fileparser.service;

import com.fileparser.parser.OrderJsonParser;
import com.fileparser.model.Order;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class ThreadPoolService {

    private final ExecutorService executor;

    public ThreadPoolService(int threads) {
        this.executor = Executors.newFixedThreadPool(threads);
    }

    public List<Order> parseFiles(List<File> files, OrderJsonParser parser) {
        List<Future<List<Order>>> futures = new ArrayList<>();

        for (File f : files) {
            futures.add(executor.submit(() -> parser.parse(f)));
        }

        List<Order> result = new ArrayList<>();

        for (Future<List<Order>> future : futures) {
            try {
                result.addAll(future.get());
            } catch (Exception e) {
                System.err.println("Error reading file: " + e.getMessage());
            }
        }

        executor.shutdown();
        return result;
    }
}
