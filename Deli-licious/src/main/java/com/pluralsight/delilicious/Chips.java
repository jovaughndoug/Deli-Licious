package com.pluralsight.delilicious;

public class Chips extends Item {
    private String name;

    public Chips(String name){}

    @Override
    public double getprice() {
        return 1.50;
    }

    public String getName() {

        return name;
    }
}
