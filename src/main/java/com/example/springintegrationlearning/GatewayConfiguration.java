package com.example.springintegrationlearning;

import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.MessagingGateway;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@MessagingGateway
@Component
public interface GatewayConfiguration {

    @Gateway(requestChannel = "requestChannel")
    String echo(String request);
}
