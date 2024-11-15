package com.pluralsight.delilicious;

public class Meats extends PremiumTopping {
    MeatChoice meatType;

    public Meats(boolean hasExtra, Sandwich.SandwichSize size, MeatChoice meatType) {
        super(hasExtra, size);
        this.meatType = meatType;
    }
    public MeatChoice getMeatType(){
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
    HAM,
    SALAMI,
    ROASTBEEF,
    CHICKEN,
    BACON
        //String simpleName;
    //MeatChoice(String simpleName){
        //this.simpleName = simpleName;
   }
   // String getSimpleName(){
       // return simpleName;

    @Override
    public String toString() {
        return String.format("Meat| %s",meatType.name());


    }
}


//}
