package com.example.springintegrationlearning.service;

import com.example.springintegrationlearning.model.Drink;
import com.example.springintegrationlearning.model.OrderItem;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicInteger;

@Component
public class Barista {

    private long hotDrinkDelay = 5000;

    private long coldDrinkDelay = 1000;

    private final AtomicInteger hotDrinkCounter = new AtomicInteger();

    private final AtomicInteger coldDrinkCounter = new AtomicInteger();


    public void setHotDrinkDelay(long hotDrinkDelay) {
        this.hotDrinkDelay = hotDrinkDelay;
    }

    public void setColdDrinkDelay(long coldDrinkDelay) {
        this.coldDrinkDelay = coldDrinkDelay;
    }

    @ServiceActivator(inputChannel="hotDrinksBarista")
    public Drink prepareHotDrink(OrderItem orderItem) {
        try {
            Thread.sleep(this.hotDrinkDelay);
            System.out.println(Thread.currentThread().getName()
                    + " prepared hot drink #" + hotDrinkCounter.incrementAndGet() + " for order #"
                    + orderItem.getOrderNumber() + ": " + orderItem);
            return new Drink(orderItem.getOrderNumber(), orderItem.getType(), orderItem.isIced(),
                    orderItem.getShots());
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return null;
        }
    }

    @ServiceActivator(inputChannel="coldDrinksBarista")
    public Drink prepareColdDrink(OrderItem orderItem) {
        try {
            Thread.sleep(this.coldDrinkDelay);
            System.out.println(Thread.currentThread().getName()
                    + " prepared cold drink #" + coldDrinkCounter.incrementAndGet() + " for order #"
                    + orderItem.getOrderNumber() + ": " + orderItem);
            return new Drink(orderItem.getOrderNumber(), orderItem.getType(), orderItem.isIced(),
                    orderItem.getShots());
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return null;
        }
    }

}
