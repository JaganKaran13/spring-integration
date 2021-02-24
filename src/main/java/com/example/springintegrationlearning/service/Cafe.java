package com.example.springintegrationlearning.service;

import com.example.springintegrationlearning.model.Order;
import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.MessagingGateway;
import org.springframework.stereotype.Component;

@MessagingGateway
@Component
public interface Cafe {

    @Gateway(requestChannel="orders")
    void placeOrder(Order order);
}
