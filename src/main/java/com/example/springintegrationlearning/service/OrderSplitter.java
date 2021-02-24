package com.example.springintegrationlearning.service;

import com.example.springintegrationlearning.model.Order;
import com.example.springintegrationlearning.model.OrderItem;
import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.Splitter;

import java.util.List;

@MessageEndpoint
public class OrderSplitter {

    @Splitter(inputChannel="orders", outputChannel="drinks")
    public List<OrderItem> split(Order order) {
        return order.getOrderItems();
    }

}
