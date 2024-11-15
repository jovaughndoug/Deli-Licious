package com.pluralsight.delilicious;

public class RegularTopping extends Topping {
    private final RegularToppingsOptions regularToppingsOptions;

    public RegularTopping(boolean hasExtra, Sandwich.SandwichSize size, RegularToppingsOptions regularToppingsOptions) {
        super(hasExtra, size);
        this.regularToppingsOptions = regularToppingsOptions;
    }

    public RegularToppingsOptions getRegularToppingsOptions() {
        return regularToppingsOptions;
    }

    public boolean hasExtra() {

        return hasExtra;
    }

    @Override
    public double getprice() {

        return super.getprice();
    }

    @Override
    public String toString() {
        // Use String.format() to format the output as "Topping Name: Lettuce"
        return String.format(" %s", regularToppingsOptions.name());


    }
}


