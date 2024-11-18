package com.pluralsight.delilicious;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ToppingsScreens {
    //Method to add toppings to sandwich
    public ArrayList<Topping> addToppings(Sandwich.SandwichSize sandwichSize) {
        // Create a Scanner object to read user input
        Scanner scan = new Scanner(System.in);

        // Initialize an empty list to store toppings
        ArrayList<Topping> toppings = new ArrayList<>();

        // Prompt for sauce selection at the beginning using select sauce method
        Sauce selectedSauce = selectSauce();
        // uses a ternary operator to see if sauce is null
        System.out.println("You selected the sauce: " + (selectedSauce != null ? selectedSauce : "No Sauce"));

        // Loop to keep asking the user to select toppings until done
        while (true) {
            // Display the list of regular topping options
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
                // Read the user's topping choice
                int toppingChoice = scan.nextInt();
                scan.nextLine(); // Consume the newline character

                // If the user is done with regular toppings, proceed to premium toppings
                if (toppingChoice == 10) {
                    addPremiumMeat(toppings, sandwichSize); // Add premium meats
                    addPremiumCheese(toppings, sandwichSize); // Add premium cheeses
                    return toppings; // Return the list of toppings
                }

                // Ask if the user wants extra of the selected topping
                System.out.println("Would you like extra? (yes/no)");
                boolean hasExtra = scan.nextLine().equalsIgnoreCase("yes");

                // Add the topping to the list based on the user's choice
                switch (toppingChoice) {
                    case 1 ->
                            toppings.add(new RegularTopping(hasExtra, sandwichSize, selectedSauce, RegularToppingsOptions.LETTUCE));
                    case 2 ->
                            toppings.add(new RegularTopping(hasExtra, sandwichSize, selectedSauce, RegularToppingsOptions.MUSHROOMS));
                    case 3 ->
                            toppings.add(new RegularTopping(hasExtra, sandwichSize, selectedSauce, RegularToppingsOptions.GUACAMOLE));
                    case 4 ->
                            toppings.add(new RegularTopping(hasExtra, sandwichSize, selectedSauce, RegularToppingsOptions.PICKLES));
                    case 5 ->
                            toppings.add(new RegularTopping(hasExtra, sandwichSize, selectedSauce, RegularToppingsOptions.CUCUMBERS));
                    case 6 ->
                            toppings.add(new RegularTopping(hasExtra, sandwichSize, selectedSauce, RegularToppingsOptions.JALAPENOS));
                    case 7 ->
                            toppings.add(new RegularTopping(hasExtra, sandwichSize, selectedSauce, RegularToppingsOptions.TOMATOES));
                    case 8 ->
                            toppings.add(new RegularTopping(hasExtra, sandwichSize, selectedSauce, RegularToppingsOptions.ONIONS));
                    case 9 ->
                            toppings.add(new RegularTopping(hasExtra, sandwichSize, selectedSauce, RegularToppingsOptions.PEPPERS));
                    default -> System.out.println("Invalid topping choice. Please try again."); // Handle invalid input
                }
            } catch (InputMismatchException e) {
                // Handle invalid input and prompt the user to try again
                System.out.println("Invalid input. Please enter a number.");
                scan.nextLine();
            }
        }
    }

    // Method to select a sauce for the sandwich
    public Sauce selectSauce() {
        // Initialize the scanner and loop flag
        Scanner scan = new Scanner(System.in);
        // variable for whille loop
        boolean sauceLooper = true;
        Sauce selectedSauce = null;  // Variable to store the selected sauce

        // Loop for sauce selection
        while (sauceLooper) {
            System.out.println("Select a sauce for this sandwich:");
            // Display sauce options
            System.out.println("""
                    1) Mayo
                    2) Mustard
                    3) Ranch
                    4) Vinaigrette
                    5) Au Jus
                    6) Ketchup
                    7) No Sauce
                    """);

            try {
                // Get the user's choice
                int sauceChoice = scan.nextInt();
                scan.nextLine();

                // Handle the user's choice using a switch statement
                switch (sauceChoice) {
                    case 1 -> {
                        selectedSauce = Sauce.MAYO;
                        sauceLooper = false;
                    }
                    case 2 -> {
                        selectedSauce = Sauce.MUSTARD;
                        sauceLooper = false;
                    }
                    case 3 -> {
                        selectedSauce = Sauce.RANCH;
                        sauceLooper = false;
                    }
                    case 4 -> {
                        selectedSauce = Sauce.VINAIGRETTE;
                        sauceLooper = false;
                    }
                    case 5 -> {
                        selectedSauce = Sauce.AU_JUS;
                        sauceLooper = false;
                    }
                    case 6 -> {
                        selectedSauce = Sauce.KETCHUP;
                        sauceLooper = false;
                    }
                    case 7 -> sauceLooper = false;  // Exit the loop with no sauce selected

                    default ->
                            System.out.println("Invalid choice. Please select a valid sauce.");  // Handle invalid input
                }
            } catch (InputMismatchException e) {
                // Handle invalid input
                System.out.println("Invalid input. Please enter a number.");
                scan.nextLine();
            }
        }

        // Return the selected sauce
        return selectedSauce;
    }

    // Method to add premium meat to the sandwich
    public void addPremiumMeat(ArrayList<Topping> toppings, Sandwich.SandwichSize sandwichSize) {
        // Initialize scanner for input
        Scanner scan = new Scanner(System.in);

        // Loop for selecting premium meats
        while (true) {
            // Display meat options
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
                // Get user's meat choice
                int meatChoice = scan.nextInt();
                scan.nextLine();

                if (meatChoice == 7) break;  // Exit the loop if user chooses to finish

                // Ask if the user wants extra meat
                System.out.println("Would you like extra meat? (yes/no)");
                boolean hasExtra = scan.nextLine().equalsIgnoreCase("yes");

                // Add the selected meat to the toppings list
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
                // Handle invalid input
                System.out.println("Invalid input. Please enter a number.");
                scan.nextLine();
            }
        }
    }

    // Method to add premium cheese to the sandwich
    public void addPremiumCheese(ArrayList<Topping> toppings, Sandwich.SandwichSize sandwichSize) {
        // Initialize the scanner for input
        Scanner scan = new Scanner(System.in);

        // Loop for selecting premium cheeses
        while (true) {
            // Display cheese options
            System.out.println("""
                    Select a premium cheese or type 5 to finish:
                    1) American Cheese
                    2) Swiss Cheese
                    3) Provolone Cheese
                    4) Cheddar Cheese
                    5) Done with cheeses
                    """);

            try {
                // Get user's cheese choice
                int cheeseChoice = scan.nextInt();
                scan.nextLine();

                if (cheeseChoice == 5) break;  // Exit the loop if user chooses to finish

                // Ask if the user wants extra cheese
                System.out.println("Would you like extra cheese? (yes/no)");
                boolean hasExtra = scan.nextLine().equalsIgnoreCase("yes");

                // Add the selected cheese to the toppings list
                switch (cheeseChoice) {
                    case 1 -> toppings.add(new Cheese(hasExtra, sandwichSize, Cheese.CheeseChoice.AmericanCheese));
                    case 2 -> toppings.add(new Cheese(hasExtra, sandwichSize, Cheese.CheeseChoice.SWISSCHEESE));
                    case 3 -> toppings.add(new Cheese(hasExtra, sandwichSize, Cheese.CheeseChoice.ProvoloneCheese));
                    case 4 -> toppings.add(new Cheese(hasExtra, sandwichSize, Cheese.CheeseChoice.CheddarCheese));
                    default ->
                            System.out.println("Invalid cheese choice. Please try again.");  // Handle invalid cheese choice
                }
            } catch (InputMismatchException e) {
                // Handle invalid input
                System.out.println("Invalid input. Please enter a number.");
                scan.nextLine();
            }
        }
    }
}

