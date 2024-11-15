package com.pluralsight.delilicious;

public class RegularTopping extends Topping {
    private final Sauce sauce;
    private final RegularToppingsOptions regularToppingsOptions;

    public RegularTopping(boolean hasExtra, Sandwich.SandwichSize size, Sauce sauce, RegularToppingsOptions regularToppingsOptions) {
        super(hasExtra, size);
        this.sauce = sauce;
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
        // Check if the user selects a sauce
        if (sauce != null) {
            return String.format("Topping: %s, Sauce: %s", regularToppingsOptions.name(), sauce.name());
        } else {
            return String.format("Topping: %s, No sauce selected", regularToppingsOptions.name());
        }
    }
}


