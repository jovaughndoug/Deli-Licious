package com.pluralsight.delilicious;

import java.util.Scanner;

public class TerminalUI {


    // Launches the start screen
    public void main() {
        startScreen();

    }

    // Method for Start screen
    public void startScreen() {
        // Create Scanner for while loop
        Scanner input = new Scanner(System.in);
        boolean looper = true;
        // Instantiate Ordering Screens to use one of its methods
        OrderingScreens orderingScreens = new OrderingScreens();

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
                case "1" -> orderingScreens.orderScreen();
                case "2" -> {
                    System.out.println("Exiting program. Goodbye!");
                    looper = false;
                }
                default -> System.out.println("Sorry, Invalid option. Please try again.");
            }
        }
    }


}



