package com.pluralsight.delilicious;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class TerminalUI {


    // Launches the start screen
    public static void main(String[] args) {
        startScreen();

    }

    // MMethod for Start screen
    public static void startScreen() {
        // Create Scanner for while loop
        Scanner input = new Scanner(System.in);
        boolean looper = true;

        while (looper) {
            // Display menu
            System.out.println("""
                    =========================
                    =========================
                    Welcome to Deli-Licious!
                    =========================
                    =========================
                    1. New Order
                    2. Exit Program
                    Please select an option (1-2)
                    """);

            String choice = input.nextLine();

            // get input for menu selection
            switch (choice) {
                case "1" -> orderScreen();
                case "2" -> {
                    System.out.println("Exiting program. Goodbye!");
                    looper = false;
                }
                default -> System.out.println("Sorry, Invalid option. Please try again.");
            }
        }
    }

    // Create Method for order Screen
    public static void orderScreen() {
        Scanner scan = new Scanner(System.in);
        // Creates new Order
        Orders order = new Orders();

        while (true) {
            // Display menu
            System.out.println("""
                    1) Add Sandwich
                    2) Add Drink
                    3) Add Chips
                    4) Checkout
                    0) Cancel Order
                    """);

            // Try catch to catch user errors
            try {
                //
                int userInput = scan.nextInt();
                scan.nextLine();

                switch (userInput) {
                    case 1 -> order.addItem(addSandwich());
                    case 2 -> order.addItem(addDrink());
                    case 3 -> order.addItem(addChips()); // Methods adds items to order
                    case 4 -> {
                        System.out.println(order.displayOrderToString());
                        //  System.out.println("What is the name for your order?");
                        return;
                    }
                    case 0 -> {
                        System.out.println("Order canceled.");
                        return;
                    }
                    default -> System.out.println("Invalid option. Please try again.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scan.nextLine();
            }
        }
    }

    public static Sandwich addSandwich() {
        Scanner scan = new Scanner(System.in);

        Sandwich.Breadtype breadType = null;
        while (breadType == null) {
            System.out.println("Select a type of bread for your sandwich:");
            System.out.println("1) WHEAT\n2) WHITE\n3) RYE\n4) WRAP");

            try {
                int breadChoice = scan.nextInt();
                scan.nextLine();

                breadType = switch (breadChoice) {
                    case 1 -> Sandwich.Breadtype.WHEAT;
                    case 2 -> Sandwich.Breadtype.WHITE;
                    case 3 -> Sandwich.Breadtype.RYE;
                    case 4 -> Sandwich.Breadtype.WRAP;
                    default -> {
                        System.out.println("Invalid option. Please try again.");
                        yield null;
                    }
                };
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scan.nextLine();
            }
        }

        Sandwich.SandwichSize sandwichSize = null;
        while (sandwichSize == null) {
            System.out.println("Select the size of your sandwich:");
            System.out.println("1) FOUR INCH\n2) EIGHT INCH\n3) TWELVE-INCH");

            try {
                int sizeChoice = scan.nextInt();
                scan.nextLine();

                sandwichSize = switch (sizeChoice) {
                    case 1 -> Sandwich.SandwichSize.FOURINCH;
                    case 2 -> Sandwich.SandwichSize.EIGHTINCH;
                    case 3 -> Sandwich.SandwichSize.TWELVEINCH;
                    default -> {
                        System.out.println("Invalid option. Please try again.");
                        yield null;
                    }
                };
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scan.nextLine();
            }
        }

        System.out.println("Would you like it toasted? (1) Yes, (2) No");
        boolean toasted = false;
        while (true) {
            try {
                int toastChoice = scan.nextInt();
                scan.nextLine();

                if (toastChoice == 1 || toastChoice == 2) {
                    toasted = toastChoice == 1;
                    break;
                } else {
                    System.out.println("Invalid option. Please enter 1 for Yes or 2 for No.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scan.nextLine();
            }
        }

        ArrayList<Topping> toppings = addToppings(sandwichSize);
        return new Sandwich(toasted, sandwichSize, breadType, toppings);
    }

    public static Drinks addDrink() {
        Scanner scan = new Scanner(System.in);

        Drinks.DrinkSize size = null;
        while (size == null) {
            System.out.println("Select drink size:");
            System.out.println("1) SMALL\n2) MEDIUM\n3) LARGE");

            try {
                int sizeChoice = scan.nextInt();
                scan.nextLine();

                size = switch (sizeChoice) {
                    case 1 -> Drinks.DrinkSize.SMALL;
                    case 2 -> Drinks.DrinkSize.MEDIUM;
                    case 3 -> Drinks.DrinkSize.LARGE;
                    default -> {
                        System.out.println("Invalid option. Please try again.");
                        yield null;
                    }
                };
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scan.nextLine();
            }
        }

        System.out.println("Enter the name of the drink:");
        String name = scan.nextLine();
        return new Drinks(size, name);
    }

    public static Chips addChips() {
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter the type of chips:");
        String name = scan.nextLine();
        return new Chips(name);
    }

    public static ArrayList<Topping> addToppings(Sandwich.SandwichSize sandwichSize) {
        Scanner scan = new Scanner(System.in);
        ArrayList<Topping> toppings = new ArrayList<>();

        while (true) {
            System.out.println("Select a topping for your sandwich:");
            System.out.println("""
                    1) Lettuce
                    2) Mushrooms
                    3) Guacamole
                    4) Pickles
                    5) Cucumbers
                    6) Jalapenos
                    7) Tomatoes
                    8) Onions
                    9) Peppers
                    10) Done with regular toppings
                    """);

            try {
                int toppingChoice = scan.nextInt();
                scan.nextLine();

                switch (toppingChoice) {
                    case 1 -> toppings.add(new RegularTopping(false, sandwichSize, RegularToppingsOptions.LETTUCE));
                    case 2 -> toppings.add(new RegularTopping(false, sandwichSize, RegularToppingsOptions.MUSHROOMS));
                    case 3 -> toppings.add(new RegularTopping(false, sandwichSize, RegularToppingsOptions.GUACAMOLE));
                    case 4 -> toppings.add(new RegularTopping(false, sandwichSize, RegularToppingsOptions.PICKLES));
                    case 5 -> toppings.add(new RegularTopping(false, sandwichSize, RegularToppingsOptions.CUCUMBERS));
                    case 6 -> toppings.add(new RegularTopping(false, sandwichSize, RegularToppingsOptions.JALAPENOS));
                    case 7 -> toppings.add(new RegularTopping(false, sandwichSize, RegularToppingsOptions.TOMATOES));
                    case 8 -> toppings.add(new RegularTopping(false, sandwichSize, RegularToppingsOptions.ONIONS));
                    case 9 -> toppings.add(new RegularTopping(false, sandwichSize, RegularToppingsOptions.PEPPERS));
                    case 10 -> {
                        addPremiumMeat(toppings, sandwichSize);
                        addPremiumCheese(toppings, sandwichSize);
                        return toppings;
                    }
                    default -> System.out.println("Invalid topping choice. Please try again.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scan.nextLine();
            }
        }
    }

    public static void addPremiumMeat(ArrayList<Topping> toppings, Sandwich.SandwichSize sandwichSize) {
        Scanner scan = new Scanner(System.in);

        while (true) {
            System.out.println("""
                    Select a premium meat or type 7 to finish:
                    1) Steak
                    2) Ham
                    3) Salami
                    4) Roast Beef
                    5) Chicken
                    6) Bacon
                    7) Done with meats
                    """);

            try {
                int meatChoice = scan.nextInt();
                scan.nextLine();

                if (meatChoice == 7) break;

                System.out.println("Would you like extra meat? (yes/no)");
                boolean hasExtra = scan.nextLine().equalsIgnoreCase("yes");

                switch (meatChoice) {
                    case 1 -> toppings.add(new Meats(hasExtra, sandwichSize, Meats.MeatChoice.STEAK));
                    case 2 -> toppings.add(new Meats(hasExtra, sandwichSize, Meats.MeatChoice.HAM));
                    case 3 -> toppings.add(new Meats(hasExtra, sandwichSize, Meats.MeatChoice.SALAMI));
                    case 4 -> toppings.add(new Meats(hasExtra, sandwichSize, Meats.MeatChoice.ROASTBEEF));
                    case 5 -> toppings.add(new Meats(hasExtra, sandwichSize, Meats.MeatChoice.CHICKEN));
                    case 6 -> toppings.add(new Meats(hasExtra, sandwichSize, Meats.MeatChoice.BACON));
                    default -> System.out.println("Invalid meat choice. Please try again.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scan.nextLine();
            }
        }
    }

    public static void addPremiumCheese(ArrayList<Topping> toppings, Sandwich.SandwichSize sandwichSize) {
        Scanner scan = new Scanner(System.in);

        while (true) {
            System.out.println("""
                    Select a premium cheese or type 5 to finish:
                    1) American Cheese
                    2) Swiss Cheese
                    3) Provolone Cheese
                    4) Cheddar Cheese
                    5) Done with cheeses
                    """);

            try {
                int cheeseChoice = scan.nextInt();
                scan.nextLine();

                if (cheeseChoice == 5) break;

                System.out.println("Would you like extra cheese? (yes/no)");
                boolean hasExtra = scan.nextLine().equalsIgnoreCase("yes");

                switch (cheeseChoice) {
                    case 1 -> toppings.add(new Cheese(hasExtra, sandwichSize, Cheese.CheeseChoice.AmericanCheese));
                    case 2 -> toppings.add(new Cheese(hasExtra, sandwichSize, Cheese.CheeseChoice.SWISSCHEESE));
                    case 3 -> toppings.add(new Cheese(hasExtra, sandwichSize, Cheese.CheeseChoice.ProvoloneCheese));
                    case 4 -> toppings.add(new Cheese(hasExtra, sandwichSize, Cheese.CheeseChoice.CheddarCheees));
                    default -> System.out.println("Invalid cheese choice. Please try again.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scan.nextLine();
            }
        }
    }
}

