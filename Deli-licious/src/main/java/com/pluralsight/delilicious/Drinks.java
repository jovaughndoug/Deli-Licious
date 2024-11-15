package com.pluralsight.delilicious;

public class Drinks extends Item {
    private DrinkSize drinkSize;
    private double price;
    private String name;

    public Drinks(DrinkSize drinkSize, String name) {
        this.drinkSize = drinkSize;
        this.name = name;
        setPriceBasedOnSize(drinkSize);
    }

    public enum DrinkSize {
        SMALL,
        MEDIUM,
        LARGE
    }


    private void setPriceBasedOnSize(DrinkSize size) {
        switch (size) {
            case SMALL -> this.price = 2.0;
            case MEDIUM -> this.price = 2.5;
            case LARGE -> this.price = 3.0;
            default -> this.price = 0;
        }
    }

    @Override
    public double getprice() {
        return price;
    }

    @Override
    public String toString() {
        return String.format("Drink|%s|%.2f|%s", drinkSize, price, name);
    }
}
