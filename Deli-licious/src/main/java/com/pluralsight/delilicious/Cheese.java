package com.pluralsight.delilicious;

public class Cheese extends PremiumTopping {
    private final CheeseChoice cheeseChoice;

    public Cheese(boolean hasExtra, Sandwich.SandwichSize size, CheeseChoice cheeseChoice) {
        super(hasExtra, size);
        this.cheeseChoice = cheeseChoice;
    }

    public enum CheeseChoice{
        //Cheese Choices
        AmericanCheese,
        SWISSCHEESE,
        ProvoloneCheese,
        CheddarCheese,
    }

    @Override
    public double getprice() {
        if (size == Sandwich.SandwichSize.FOURINCH){
            price = .75;
            if (hasExtra) price += .30;
        } else if (size == Sandwich.SandwichSize.EIGHTINCH) {
            price = 1.5;
            if (hasExtra) price += .60;

        } else if (size == Sandwich.SandwichSize.TWELVEINCH) {
            price = 2.25;
            if (hasExtra) price += .90;

        }
        return price;
    }
    @Override
    public String toString() {
        return String.format("Cheese| %s ",cheeseChoice.name());


    }
}


