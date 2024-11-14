package com.pluralsight.delilicious;

import java.util.ArrayList;
import java.util.Scanner;

public class TerminalUI {

    public static void main(String[] args) {
        POSMenu menu = new POSMenu();
        POSMenu.main(args);
    }

    static class POSMenu {
        public static void main(String[] args) {
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
                    case "1" -> orderScreen(input);
                    case "2" -> {
                        System.out.println("Exiting program. Goodbye!");
                        looper = false;
                    }
                    default -> System.out.println("Sorry, Invalid option. Please try again.");
                }
            }
        }

        private static void orderScreen(Scanner scanner) {
            // created while loop with boolean
            boolean ordering = true;
            while (ordering) {
                // Order menu options
                System.out.println("""
                        ==============
                        New Order Menu:
                        ==============
                        1. Add Sandwich
                        2. Add Drinks
                        3. Add Chips
                        4. Checkout
                        5. Cancel Order
                        Select an option (1-5):
                        """);
                String orderChoice = scanner.nextLine();

                // order menu selection
                switch (orderChoice) {
                    case "1" -> chooseBreadOptions(scanner);
                    case "2" -> addDrinks();  // Implement addDrinks method
                    case "3" -> addChips();   // Implement addChips method
                    case "4" -> {
                        sandwichCheckout();  // Implement sandwichCheckout method
                        System.out.println("Checking out. Thank you for your order!");
                        ordering = false;
                    }
                    case "5" -> {
                        System.out.println("Order canceled.");
                        ordering = false;
                    }
                    default -> System.out.println("Invalid option. Please try again.");
                }
            }
        }

        private static void chooseBreadOptions(Scanner scanner) {
            // display bread options
            System.out.println("Select a type of bread for your sandwich:");
            System.out.println("1. Wheat");
            System.out.println("2. White");
            System.out.println("3. Rye");
            System.out.println("4. Wrap");
            int breadChoice = scanner.nextInt();
            scanner.nextLine();  // Consume the newline character

            Sandwich.Breadtype selectedBread = null;

            // switch case to match options to bread choices
            switch (breadChoice) {
                case 1 -> selectedBread = Sandwich.Breadtype.WHEAT;
                case 2 -> selectedBread = Sandwich.Breadtype.WHITE;
                case 3 -> selectedBread = Sandwich.Breadtype.RYE;
                case 4 -> selectedBread = Sandwich.Breadtype.WRAP;
                default -> System.out.println("Invalid choice, Please try again");
            }
            System.out.println(selectedBread);


            // display sandwich size choices
            System.out.println("Select the size of your sandwich:");
            System.out.println("1. Small");
            System.out.println("2. Medium");
            System.out.println("3. Large");
            int sizeChoice = scanner.nextInt();
            scanner.nextLine();  // Consume the newline character

            Sandwich.SandwichSize selectedSize = null;

            // switch case to match options to sandwich sizes
            switch (sizeChoice) {
                case 1 -> selectedSize = Sandwich.SandwichSize.FOURINCH;
                case 2 -> selectedSize = Sandwich.SandwichSize.EIGHTINCH;
                case 3 -> selectedSize = Sandwich.SandwichSize.TWELVEINCH;
                default -> System.out.println("Invalid choice, Please try again.");
            }
            // Create Array list to hold selected toppings
            // Display topping options
            ArrayList<Topping> selectedToppings = new ArrayList<>();
            System.out.println("""
                    Select your toppings please:
                    1. Lettuce
                    2. Mushrooms
                    3. Guacamole
                    4. Pickles
                    5. Cucumbers
                    6. Jalapenos
                    7. Tomatoes
                    8. Onions
                    9. Peppers
                    10. Done
                    """);
            // while loop for topping selection
            boolean toppingLooper = true;
            while (toppingLooper) {
                System.out.print("Choose a topping (1-10): ");
                int toppingChoice = scanner.nextInt();
                scanner.nextLine();
                //Switch case for topping selection
                switch (toppingChoice) {
                    case 1 -> selectedToppings.add(new RegularTopping(false, selectedSize, RegularToppingsOptions.LETTUCE));
                    case 2 -> selectedToppings.add(new RegularTopping(false, selectedSize, RegularToppingsOptions.MUSHROOMS));
                    case 3 -> selectedToppings.add(new RegularTopping(false, selectedSize, RegularToppingsOptions.GUACAMOLE));
                    case 4 -> selectedToppings.add(new RegularTopping(false, selectedSize, RegularToppingsOptions.PICKLES));
                    case 5 -> selectedToppings.add(new RegularTopping(false, selectedSize, RegularToppingsOptions.CUCUMBERS));
                    case 6 -> selectedToppings.add(new RegularTopping(false, selectedSize, RegularToppingsOptions.JALAPENOS));
                    case 7 -> selectedToppings.add(new RegularTopping(false, selectedSize, RegularToppingsOptions.TOMATOES));
                    case 8 -> selectedToppings.add(new RegularTopping(false, selectedSize, RegularToppingsOptions.ONIONS));
                    case 9 -> selectedToppings.add(new RegularTopping(false, selectedSize, RegularToppingsOptions.PEPPERS));
                    case 10 -> toppingLooper = false;
                    default -> System.out.println("Invalid option, please try again.");
                }
            }
            

            // Display selected toppings
            System.out.println("Selected toppings: " + selectedToppings);
        }

        private static void addDrinks() {
            System.out.println("Drinks added to added to order.");
        }

        private static void addChips() {
            System.out.println("Chips added to your order.");
        }

        private static void sandwichCheckout() {
            System.out.println("Checkout completed.");
        }
    }
}
