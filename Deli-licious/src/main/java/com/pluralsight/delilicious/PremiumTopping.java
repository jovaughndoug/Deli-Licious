package com.pluralsight.delilicious;

public class PremiumTopping extends Topping {
    double price;

    public PremiumTopping(boolean hasExtra, Sandwich.SandwichSize size) {
        super(hasExtra, size);
    }
}
