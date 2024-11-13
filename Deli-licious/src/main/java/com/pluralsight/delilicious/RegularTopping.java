package com.pluralsight.delilicious;

public class RegularTopping extends Topping {
    private RegularToppingsOptions regularToppingsOptions;

    public RegularTopping(boolean hasExtra, Sandwich.SandwichSize size, RegularToppingsOptions regularToppingsOptions) {
        super(hasExtra, size);
        this.regularToppingsOptions = regularToppingsOptions;
    }

    public RegularToppingsOptions getRegularToppingsOptions() {
        return regularToppingsOptions;
    }
    public boolean hasExtra(){
        return hasExtra;
    }
    @Override
    public double getprice() {
        return super.getprice();
    }

}
