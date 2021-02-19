package com.example.springintegrationlearning;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.config.EnableIntegration;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;

@SpringBootApplication
@EnableIntegration
public class SpringIntegrationLearningApplication implements ApplicationRunner {
	
	@Autowired
	@Qualifier("inputChannel")
	public MessageChannel inputChannel;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		// TODO Auto-generated method stub
		inputChannel.send(MessageBuilder.withPayload("Jagan").build());
		
	}
	
	public static void main(String[] args) {
		SpringApplication.run(SpringIntegrationLearningApplication.class, args);
	}

}
