package com.example.springintegrationlearning;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.integration.http.dsl.Http;
import org.springframework.integration.mapping.OutboundMessageMapper;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHandler;

@Configuration
public class ChannelConfiguration {

    @Bean
    public MessageChannel requestChannel() {
        return new DirectChannel();
    }

    @Bean
    public IntegrationFlow outbound() {
        return IntegrationFlows.from("requestChannel")
                .handle(Http.outboundGateway("http://localhost:12000/mock/string")
                        .httpMethod(HttpMethod.GET)
                        .expectedResponseType(String.class))
                .get();
    }
}
