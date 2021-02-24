package com.example.springintegrationlearning.service;

import com.example.springintegrationlearning.model.OrderItem;
import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.Router;

@MessageEndpoint
public class DrinkRouter {

    @Router(inputChannel="drinks")
    public String resolveOrderItemChannel(OrderItem orderItem) {
        return (orderItem.isIced()) ? "coldDrink" : "hotDrink";
    }
}
