package com.example.springintegrationlearning;

import com.example.springintegrationlearning.model.DrinkType;
import com.example.springintegrationlearning.model.Order;
import com.example.springintegrationlearning.service.Cafe;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringIntegrationLearningApplication implements ApplicationRunner {

	private final Cafe cafe;

	public SpringIntegrationLearningApplication(Cafe cafe) {
		this.cafe = cafe;
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringIntegrationLearningApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		Order order = new Order(1);
		order.addItem(DrinkType.LATTE, 2, false);
		order.addItem(DrinkType.MOCHA, 3, true);
		cafe.placeOrder(order);
	}
}
