package com.fileparser.parser;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Map;

import com.fileparser.model.Customer;
import com.fileparser.model.Order;
import com.fileparser.model.OrderAttribute;
import com.fileparser.service.StatisticsService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StatisticsServiceTest {

    private StatisticsService statisticsService;

    @BeforeEach
    void setup() {
        statisticsService = new StatisticsService();
    }

    @Test
    void testStatisticsByStatus() {
        Order o1 = new Order();
        o1.setStatus("Pending");

        Order o2 = new Order();
        o2.setStatus("Completed");

        Order o3 = new Order();
        o3.setStatus("Pending");

        List<Order> orders = List.of(o1, o2, o3);

        Map<String, Integer> stats = statisticsService.calculateStats(orders, OrderAttribute.STATUS);

        assertEquals(2, stats.get("Pending"));
        assertEquals(1, stats.get("Completed"));
    }

    @Test
    void testStatisticsByCustomerName() {
        Customer c1 = new Customer("1","Alice");
        Customer c2 = new Customer("2","Bob");
        Customer c3 = new Customer("3","Alice");

        Order o1 = new Order(); o1.setCustomer(c1);
        Order o2 = new Order(); o2.setCustomer(c2);
        Order o3 = new Order(); o3.setCustomer(c3);

        List<Order> orders = List.of(o1, o2, o3);

        Map<String, Integer> stats = statisticsService.calculateStats(orders, OrderAttribute.CUSTOMER);

        assertEquals(2, stats.get("Alice"));
        assertEquals(1, stats.get("Bob"));
    }
}
