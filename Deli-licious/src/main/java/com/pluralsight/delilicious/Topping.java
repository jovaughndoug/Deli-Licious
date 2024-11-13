package com.pluralsight.delilicious;

public class Topping extends Item {
    protected boolean hasExtra;
    protected Sandwich.SandwichSize size;

    public Topping(boolean hasExtra, Sandwich.SandwichSize size) {
        this.hasExtra = hasExtra;
        this.size = size;
    }

    @Override
    public double getprice() {

        return 1;
    }
}
