package com.pluralsight.delilicious;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class OrderingScreens {
    // Create Method for order Screen
    public void orderScreen() {
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
    public boolean confirmOrderScreen(Orders order) {
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
                default -> System.out.println("Invalid option. Please try again."); // Error handling for wrong number
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a number.");
            scan.nextLine(); // Error handling
        }
        return false;
    }

    // Method to Add a sandwich
    public Sandwich addSandwich() {
        // Create scanner for while loop
        Scanner scan = new Scanner(System.in);
        // Instantiate Toppings Screen to use one of its methods
        ToppingsScreens toppingsScreens = new ToppingsScreens();
        // create bread type variable to load Sandwich Object
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
            System.out.println("1) FOUR INCH\n2) EIGHT INCH\n3) TWELVE INCH");

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
        ArrayList<Topping> toppings = toppingsScreens.addToppings(sandwichSize);

        // Create and return a new Sandwich object, passing the selected options
        // sandwichSize (enum), breadType (enum), and toppings (ArrayList of Topping objects) and toasted
        return new Sandwich(toasted, sandwichSize, breadType, toppings);

    }

    // Method to add a drink to the order
    public Drinks addDrink() {
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
    public Chips addChips() {
        // Create a Scanner object to read user input
        Scanner scan = new Scanner(System.in);

        // Prompt the user to enter the type of chips they would like
        System.out.println("Enter Chips you would like:");
        String name = scan.nextLine(); // Read the name of the chips

        // Create and return a new Chips object with the given name
        return new Chips(name);
    }
}
