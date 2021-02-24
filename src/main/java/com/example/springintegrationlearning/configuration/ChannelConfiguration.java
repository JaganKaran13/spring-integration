package com.example.springintegrationlearning.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.BridgeFrom;
import org.springframework.integration.annotation.BridgeTo;
import org.springframework.integration.annotation.Poller;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.channel.QueueChannel;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

@Configuration
public class ChannelConfiguration {

    @Bean
    public MessageChannel orders() {
        return new DirectChannel();
    }
    @Bean
    public MessageChannel drinks() {
        return new DirectChannel();
    }
    @Bean
    public MessageChannel coldDrink() {
        return new QueueChannel(10);
    }
    @Bean
    public MessageChannel hotDrink() {
        return new QueueChannel(10);
    }
    @Bean
    public MessageChannel preparedDrinks() {
        return new DirectChannel();
    }
    @Bean
    @BridgeFrom(value = "coldDrink", poller = @Poller(fixedDelay = "5000", maxMessagesPerPoll = "10"))
    public SubscribableChannel coldDrinksBarista() {
        return new DirectChannel();
    }
    @Bean
    @BridgeFrom(value = "hotDrink", poller = @Poller(fixedDelay = "5000", maxMessagesPerPoll = "10"))
    public SubscribableChannel hotDrinksBarista() {
        return new DirectChannel();
    }

}
