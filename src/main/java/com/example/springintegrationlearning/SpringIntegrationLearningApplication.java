package com.example.springintegrationlearning;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.integration.config.EnableIntegration;

@SpringBootApplication
@EnableIntegration
public class SpringIntegrationLearningApplication implements ApplicationRunner {

	public final GatewayConfiguration requestGateway;

	public SpringIntegrationLearningApplication(GatewayConfiguration requestGateway) {
		this.requestGateway = requestGateway;
	}


	@Override
	public void run(ApplicationArguments args) throws Exception {
		// TODO Auto-generated method stub
		String reply = requestGateway.echo("hello");
		System.out.println(reply);
	}
	
	public static void main(String[] args) {
		SpringApplication.run(SpringIntegrationLearningApplication.class, args);
	}

}
