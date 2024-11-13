package com.pluralsight.delilicious;

import java.util.ArrayList;

public class Sandwich extends Item {
    private double price;
    private boolean isToasted;
    private SandwichSize sandwichSize;
    private Breadtype breadtype;
    private ArrayList<Topping> toppingOnSandwich = new ArrayList<>();

    public Sandwich(boolean isToasted, SandwichSize sandwichSize, Breadtype breadtype) {
        this.isToasted = isToasted;
        this.sandwichSize = sandwichSize;
        this.breadtype = breadtype;
    }

    public SandwichSize getSandwichSize() {
        return sandwichSize;
    }
    public void addTopping(Topping topping){
        toppingOnSandwich.add(topping);

    }

    public enum Breadtype {
        White,
        Wheat,
        Rye,
        Wrap;
    }

    public enum SandwichSize {
        FOURINCH,
        EIGHTINCH,
        TWELVEINCH,
    }

    @Override
    public double getprice() {
        price = 0;
        for(Topping topping: toppingOnSandwich) {
            price += 5.50;
        }
            if (sandwichSize == SandwichSize.FOURINCH){
                price += 5.50;
            } else if (sandwichSize==SandwichSize.EIGHTINCH) {
                price+= 7;

            } else if (sandwichSize==SandwichSize.TWELVEINCH) {
                price += 8.50;

            }
            return price;

    }
}





