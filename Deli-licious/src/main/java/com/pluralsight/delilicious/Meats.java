package com.pluralsight.delilicious;

public class Meats extends PremiumTopping {
    Meats meatType;

    public Meats(boolean hasExtra, Sandwich.SandwichSize size, Meats meatType) {
        super(hasExtra, size);
        this.meatType = meatType;
    }
    public Meats getMeatType(){
        return meatType;
    }

    @Override
    public double getprice() {
        if (size == Sandwich.SandwichSize.FOURINCH){
            price = 1;
            if (hasExtra) price += .50;
        } else if (size == Sandwich.SandwichSize.EIGHTINCH) {
            price = 2;
            if (hasExtra) price += 1.00;

        } else if (size == Sandwich.SandwichSize.TWELVEINCH) {
            price = 3;
            if (hasExtra) price += 1.50;

        }
        return price;
    }
    public enum MeatChoice{
    //Meat Choices
    STEAK,
    Ham,
    Salami,
    RoastBeef,
    Chicken,
    Bacon;
    //String simpleName;
    //MeatChoice(String simpleName){
        //this.simpleName = simpleName;
   }
   // String getSimpleName(){
       // return simpleName;
   }


//}
