package com.example.springintegrationlearning.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class OrderItem {
    private static final long serialVersionUID = 1L;

    private DrinkType type;

    private int shots = 1;

    private boolean iced = false;

    /** the order this item is tied to */
    private int orderNumber;

    public OrderItem(int orderNumber, DrinkType type, int shots, boolean iced) {
        this.orderNumber = orderNumber;
        this.type = type;
        this.shots = shots;
        this.iced = iced;
    }
}
