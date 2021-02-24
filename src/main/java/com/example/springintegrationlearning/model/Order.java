package com.example.springintegrationlearning.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
public class Order {
    private static final long serialVersionUID = 1L;

    private List<OrderItem> orderItems = new ArrayList<OrderItem>();

    /** the order number used for tracking */
    private int number;

    public Order(int number) {
        this.number = number;
    }

    public void addItem(DrinkType drinkType, int shots, boolean iced) {
        this.orderItems.add(new OrderItem(this.number, drinkType, shots, iced));
    }

}
