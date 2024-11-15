package com.pluralsight.delilicious;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class TerminalUI {


    // Launches the start screen
    public static void main() {
        startScreen();

    }

    // Method for Start screen
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
        // Create scanner for while loop
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
                // Grabbing user input and skipping nex line
                int userInput = scan.nextInt();
                scan.nextLine();

                switch (userInput) {
                    case 1 -> order.addItem(addSandwich());
                    case 2 -> order.addItem(addDrink());
                    case 3 -> order.addItem(addChips()); // Methods adds items to order
                    case 4 -> {
                        boolean exitToStart = confirmOrderScreen(order);
                        if (exitToStart) {
                            System.out.println("Returning to the start screen...");
                            return; // Return to the start screen if user chooses to cancel order
                        }
                    }
                    case 0 -> {
                        System.out.println("Order canceled.");
                        return; // cancels the order
                    }
                    default -> System.out.println("Invalid option. Please try again."); // error handling
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scan.nextLine(); //error handling catches invalid inputs
            }
        }
    }


    // Method for confirm order screen
    public static boolean confirmOrderScreen(Orders order) {
        // create scanner
        Scanner scan = new Scanner(System.in);

        // Display the current order
        System.out.println(order.displayOrderToString());

        // Display menu
        System.out.println("""
                =========================
                Would you like to:
                1) Confirm Order
                2) Cancel Order
                3) Go Back to Order Screen
                Please select an option (1-3):
                """);


        // Try Catch to statement to catch invalid input
        try {
            int userChoice = scan.nextInt();
            scan.nextLine();

            // Switch case for menu choice
            switch (userChoice) {
                case 1 -> {
                    // User confirms the order
                    System.out.println("Order confirmed. Thank you!");

                    // Create a receipt and save it to the directory
                    ReceiptManager receiptManager = new ReceiptManager();
                    receiptManager.createReceipt(order);

                    System.out.println("Your receipt has been saved.");
                    return true;  // Exit the current menu
                }
                case 2 -> {
                    // User cancels the order
                    System.out.println("Order canceled.");
                    return true; // Exit the current menu
                }
                case 3 -> {
                    // User goes back to the order screen
                    System.out.println("Returning to the order screen...");
                    return false; // Stay in the current menu
                }
                default -> {
                    System.out.println("Invalid option. Please try again.");
                } // Error handling for wrong number
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a number.");
            scan.nextLine(); // Error handling
        }
        return false;
    }


    // Method to Add a sandwich
    public static Sandwich addSandwich() {
        // Create scanner for while loop
        Scanner scan = new Scanner(System.in);
        // creat breadtype variable to load Sandwich Object
        Sandwich.Breadtype breadType = null;
        while (breadType == null) {
            // Get the user input for bread type
            System.out.println("Select a type of bread for your sandwich:");
            System.out.println("1) WHEAT\n2) WHITE\n3) RYE\n4) WRAP");


            // Try catch for menu choice
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
                        yield null; // error handling for wrong number
                    }
                };
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scan.nextLine(); // error handling for wrong input
            }
        }

        // Sandwich size has the same thing applied to it to get that as well
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

        // Prompt for toasted or not
        // Prompt the user if they want their sandwich toasted.
        System.out.println("Would you like it toasted? (1) Yes, (2) No");

        // Initialize a boolean variable to track if the sandwich is toasted.
        boolean toasted = false;

        // Start a loop to keep asking the user until they provide a valid input.
        while (true) {
            try {
                // Read the user's input
                int toastChoice = scan.nextInt();
                scan.nextLine();
                if (toastChoice == 1 || toastChoice == 2) {
                    // Set the 'toasted' variable to true if the user chose "Yes" (1), else set it to false.
                    toasted = toastChoice == 1;
                    break;  // Exit the loop as the input is valid.
                } else {
                    System.out.println("Invalid option. Please enter 1 for Yes or 2 for No."); // error handling
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scan.nextLine(); // error handling
            }
        }

          // Call the addToppings method to allow the user to select toppings for the sandwich.
         // The 'sandwichSize' is passed as a parameter to determine the size of the sandwich.
        ArrayList<Topping> toppings = addToppings(sandwichSize);

         // Create and return a new Sandwich object, passing the selected options
         // sandwichSize (enum), breadType (enum), and toppings (ArrayList of Topping objects) and toasted
        return new Sandwich(toasted, sandwichSize, breadType, toppings);

    }

    // Method to add a drink to the order
    public static Drinks addDrink() {
        // Create a Scanner object to read user input
        Scanner scan = new Scanner(System.in);

        // Initialize the size of the drink as null
        Drinks.DrinkSize size = null;

        // Loop until a valid size is chosen
        while (size == null) {
            // Prompt the user to select a drink size
            System.out.println("Select drink size:");
            System.out.println("1) SMALL\n2) MEDIUM\n3) LARGE");

            try {
                // Read the user's drink size choice
                int sizeChoice = scan.nextInt();
                scan.nextLine();

                // Use a switch statement to set the drink size based on user input
                size = switch (sizeChoice) {
                    case 1 -> Drinks.DrinkSize.SMALL;
                    case 2 -> Drinks.DrinkSize.MEDIUM;
                    case 3 -> Drinks.DrinkSize.LARGE;
                    default -> {
                        System.out.println("Invalid option. Please try again.");
                        yield null;  // Return null to continue the loop
                    }
                };
            } catch (InputMismatchException e) {
                // Catch invalid input types (non-integer) and prompt the user to try again
                System.out.println("Invalid input. Please enter a number.");
                scan.nextLine();
            }
        }

        // Prompt the user to enter the name of the drink
        System.out.println("Enter the name of the drink:");
        String name = scan.nextLine(); // Read the name of the drink

        // Create and return a new Drinks object with the chosen size and name
        return new Drinks(size, name);
    }

    // Method to add chips to the order
    public static Chips addChips() {
        // Create a Scanner object to read user input
        Scanner scan = new Scanner(System.in);

        // Prompt the user to enter the type of chips they would like
        System.out.println("Enter Chips you would like:");
        String name = scan.nextLine(); // Read the name of the chips

        // Create and return a new Chips object with the given name
        return new Chips(name);
    }

    // Method to add toppings to the sandwich
    public static ArrayList<Topping> addToppings(Sandwich.SandwichSize sandwichSize) {
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
                    default ->
                            System.out.println("Invalid topping choice. Please try again."); // Handle invalid input
                }
            } catch (InputMismatchException e) {
                // Handle invalid input and prompt the user to try again
                System.out.println("Invalid input. Please enter a number.");
                scan.nextLine();
            }
        }
    }


    // Method to select a sauce for the sandwich
    public static Sauce selectSauce() {
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
                    case 7 -> {
                        sauceLooper = false;  // Exit the loop with no sauce selected
                    }
                    default -> System.out.println("Invalid choice. Please select a valid sauce.");  // Handle invalid input
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
    public static void addPremiumMeat(ArrayList<Topping> toppings, Sandwich.SandwichSize sandwichSize) {
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
    public static void addPremiumCheese(ArrayList<Topping> toppings, Sandwich.SandwichSize sandwichSize) {
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
                    default -> System.out.println("Invalid cheese choice. Please try again.");  // Handle invalid cheese choice
                }
            } catch (InputMismatchException e) {
                // Handle invalid input
                System.out.println("Invalid input. Please enter a number.");
                scan.nextLine();
            }
        }
    }


}



