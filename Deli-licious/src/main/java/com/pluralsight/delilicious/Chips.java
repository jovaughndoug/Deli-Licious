package com.pluralsight.delilicious;

public class Chips extends Item {
    private String name;

    public Chips(String name) {
        this.name = name;
    }

    @Override
    public double getprice() {
        return 1.50;  // Price for Chips
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Chips|" + name + "|" + String.format("%.2f", getprice());  // Format price to 2 decimal places
    }
}