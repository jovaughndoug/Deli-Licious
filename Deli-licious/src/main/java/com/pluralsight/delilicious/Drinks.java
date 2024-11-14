package com.pluralsight.delilicious;

public class Drinks extends Item {
    private DrinkSize drinkSize;
    private double price;
    private String name;

    public Drinks(DrinkSize drinkSize, double price, String name) {
        this.drinkSize = drinkSize;
        this.name = name;
    }
    public enum DrinkSize{
        SMALL,
        MEDIUM,
        LARGE
    }

    @Override
    public double getprice() {
        price = 0;
        if(drinkSize == DrinkSize.SMALL){
            price += 2;
        } else if (drinkSize == DrinkSize.MEDIUM) {
            price += 2.5;

        } else if (drinkSize == DrinkSize.LARGE) {
            price += 3;

        }
        return price;
    }
}
