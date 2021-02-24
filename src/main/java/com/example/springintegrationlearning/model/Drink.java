package com.example.springintegrationlearning.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Drink {

    private static final long serialVersionUID = 1L;

    private boolean iced;

    private int shots;

    private DrinkType drinkType;

    private int orderNumber;

    public Drink(int orderNumber, DrinkType drinkType, boolean iced, int shots) {
        this.orderNumber = orderNumber;
        this.drinkType = drinkType;
        this.iced = iced;
        this.shots = shots;
    }
}
