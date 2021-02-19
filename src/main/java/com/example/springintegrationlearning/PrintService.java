package com.example.springintegrationlearning;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

@Component
public class PrintService {

	@ServiceActivator(inputChannel = "inputChannel")
	public void printer(Message<?> name) {
		System.out.println("Welcome "+ name.getPayload());
	}
}
