package com.fileparser.service;

import com.fileparser.model.Order;
import com.fileparser.model.OrderAttribute;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StatisticsService {

    public Map<String, Integer> calculateStats(List<Order> orders, OrderAttribute attribute) {
        Map<String, Integer> stats = new HashMap<>();

        for (Order order : orders) {
            switch (attribute) {
                case STATUS -> stats.merge(order.getStatus(), 1, Integer::sum);
                case CUSTOMER -> stats.merge(order.getCustomer().getName(), 1, Integer::sum);
                case TAGS -> {
                    if (order.getTags() != null) {
                        for (String tag : order.getTags()) {
                            stats.merge(tag.trim(), 1, Integer::sum);
                        }
                    }
                }
            }
        }

        return stats;
    }
}
