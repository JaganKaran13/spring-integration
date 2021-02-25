package com.example.springintegrationlearning.endpoint;

import com.example.springintegrationlearning.model.Product;
import com.example.springintegrationlearning.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

@Component
public class ProductEndpoint {
    private static final String STATUSCODE_HEADER = "http_statusCode";

    @Autowired
    private ProductService service;

    public Message<?> get(Message<String> msg) {
        long id = Long.valueOf(msg.getPayload());
        Product product = service.getProductById(id);

        if (product == null) {
            return MessageBuilder.fromMessage(msg)
                    .copyHeadersIfAbsent(msg.getHeaders())
                    .setHeader(STATUSCODE_HEADER, HttpStatus.NOT_FOUND)
                    .build();
        }

        return MessageBuilder.withPayload(product)
                .copyHeadersIfAbsent(msg.getHeaders())
                .setHeader(STATUSCODE_HEADER, HttpStatus.OK)
                .build();
    }
}
