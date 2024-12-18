package com.pluralsight.delilicious;

import java.util.ArrayList;

public class Sandwich extends Item {
    private final boolean isToasted;
    private final SandwichSize sandwichSize;
    private final Breadtype breadtype;
    private final ArrayList<Topping> toppingOnSandwich;

    public Sandwich(boolean isToasted, SandwichSize sandwichSize, Breadtype breadtype, ArrayList<Topping> toppingOnSandwich) {
        this.isToasted = isToasted;
        this.sandwichSize = sandwichSize;
        this.breadtype = breadtype;
        this.toppingOnSandwich = toppingOnSandwich;
    }

    public SandwichSize getSandwichSize() {
        return sandwichSize;
    }

    public void setIsToasted(boolean b) {
    }

    public enum Breadtype {
        WHITE,
        WHEAT,
        RYE,
        WRAP
    }

    public enum SandwichSize {
        FOURINCH,
        EIGHTINCH,
        TWELVEINCH,
    }
    @Override
    public double getprice() {
        double price = 0;

        switch (sandwichSize) {
            case FOURINCH -> price += 5.50;
            case EIGHTINCH -> price += 7;
            case TWELVEINCH -> price += 8.50;
        }

        for (Topping topping : toppingOnSandwich) {
            price += topping.getprice();
        }

        return price;
    }
    @Override
    public String toString() {
        return "Sandwich | " +
                "Toasted: " + isToasted + " | " +
                "Size: " + sandwichSize + " | " +
                "Bread: " + breadtype + " | " +
                "Toppings: " + toppingOnSandwich + " | " +
                "Price: $" + String.format("%.2f", getprice());
    }
}






