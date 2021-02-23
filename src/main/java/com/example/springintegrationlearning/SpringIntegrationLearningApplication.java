package com.example.springintegrationlearning;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.integration.config.EnableIntegration;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;

@SpringBootApplication
@EnableIntegration
public class SpringIntegrationLearningApplication implements ApplicationRunner {
	
	public final MessageChannel inputChannel;

	public SpringIntegrationLearningApplication(@Qualifier("inputChannel") MessageChannel inputChannel) {
		this.inputChannel = inputChannel;
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		// TODO Auto-generated method stub
		inputChannel.send(MessageBuilder.withPayload("Jagan").build());
		
	}
	
	public static void main(String[] args) {
		SpringApplication.run(SpringIntegrationLearningApplication.class, args);
	}

}
