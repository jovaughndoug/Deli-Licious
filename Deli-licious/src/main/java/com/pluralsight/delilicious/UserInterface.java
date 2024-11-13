package com.pluralsight.delilicious;

import javax.swing.*;
import javax.swing.JOptionPane;
import java.awt.*;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;

public class UserInterface {
}

class POSMenu {
    public static void main(String[] args) {
        boolean looper = true;

        while (looper) {
            // Display menu options
            String[] options = {"New Order", "Exit Program"};
            int choice = JOptionPane.showOptionDialog(
                    null,
                    "Select an option:",
                    "Welcome To Deli-Licious",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.INFORMATION_MESSAGE,
                    null,
                    options,
                    options[0]
            );

            // Handle menu selection
            switch (choice) {
                case 0 -> // New Order
                        createNewOrder();
                case 1 -> { // Exit Program
                    looper = false;
                    JOptionPane.showMessageDialog(null, "Exiting program. Goodbye!");
                }
                default -> looper = false; // Exit if user closes the dialog
            }
        }
    }

    private static void createNewOrder() {
        //Adding a new order
        boolean ordering = true;
        while (ordering) {
            // Order menu options
            String[] orderOptions = {"Add Sandwich", "Add Drinks", "Add Chips", "Checkout", "Cancel Order"};
            int orderChoice = JOptionPane.showOptionDialog(
                    null,
                    "Select an item to add to your order or checkout:",
                    "New Order Menu",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.INFORMATION_MESSAGE,
                    null,
                    orderOptions,
                    orderOptions[0]
            );

            // Handle order menu selection
            switch (orderChoice) {
                case 0 -> addSandwich();
               // case 1 -> placeholder();
                case 3 -> {  // Checkout
                    JOptionPane.showMessageDialog(null, "Checking out. Thank you for your order!");
                    ordering = false;  // Exit the order menu loop
                }
                case 4 -> {  // Cancel Order
                    JOptionPane.showMessageDialog(null, "Order canceled.");
                    ordering = false;  // Exit the order menu loop
                }
                default -> ordering = false;  // Exit if user closes the dialog
            }


        }
    }

    private static void addSandwich() {
        // Display bread options
        Sandwich.Breadtype[] breadOptions = Sandwich.Breadtype.values();
        Sandwich.Breadtype breadChoice = (Sandwich.Breadtype) JOptionPane.showInputDialog(
                null,
                "Select a type of bread for your sandwich:",
                "Bread Selection",
                JOptionPane.QUESTION_MESSAGE, // Asks the user a question
                null,
                breadOptions,
                breadOptions[0]
        );

        // Display the selected bread type
        if (breadChoice != null) {
            JOptionPane.showMessageDialog(null, "You selected: " + breadChoice);
        } else {
            JOptionPane.showMessageDialog(null, "No bread selected.");
            return;
        }


        //Display Sandwich Sizes
        Sandwich.SandwichSize[] sandwichSizeOptions = Sandwich.SandwichSize.values();
        Sandwich.SandwichSize sandwichSizeChoice = (Sandwich.SandwichSize) JOptionPane.showInputDialog(null,
                "Select The Size you would like:",
                "Size Selection",
                JOptionPane.QUESTION_MESSAGE,
                null, sandwichSizeOptions,
                sandwichSizeOptions[0]);


        //Display Sandwich size Choice
        if (sandwichSizeChoice != null) {
            JOptionPane.showMessageDialog(null, "You selected: " + sandwichSizeChoice);
        } else {
            JOptionPane.showMessageDialog(null, "No Sandwich Size Selected.");
        }
        ArrayList<Topping> toppinglist = new ArrayList<>();
        boolean toppingslooper = true;
        //Display toppings and allow user to choose
        //Create a Jpanel Gridlayout with one column
        JPanel toppingsPanel = new JPanel(new GridLayout(0, 1));
        //Create an Array list to store the checkboxes
        ArrayList<JCheckBox> checkBoxes = new ArrayList<>();

        //Add a label to the panel to indicate the section for regular toppings
        toppingsPanel.add(new JLabel("Select Regular Toppings:"));
        // Loop through Regular toppings and create checkboxes for each
        for (RegularToppingsOptions topping : RegularToppingsOptions.values()) {
            JCheckBox checkBox = new JCheckBox(topping.toString());
            //Add Checkboxes to list of checkboxes
            checkBoxes.add(checkBox);
            //Add checkbox list to panel
            toppingsPanel.add(checkBox);
        }
        //Add a label to the panel to indicate the section for premium toppings
        toppingsPanel.add(new JLabel("Select Premium Toppings:"));
        //Loop over MeatChoice values and create checkboxes for each
        for (Meats.MeatChoice topping : Meats.MeatChoice.values()) {
            JCheckBox checkBox = new JCheckBox(topping.toString());
            checkBoxes.add(checkBox);
            //Add checkbox list to panel
            toppingsPanel.add(checkBox);
        }

        // Loop over CheeseChoice value and create checkboxes for each
        for (Cheese.CheeseChoice topping : Cheese.CheeseChoice.values()) {
            JCheckBox checkBox = new JCheckBox(topping.toString());
            checkBoxes.add(checkBox);
            //Add checkbox to panel
            toppingsPanel.add(checkBox);
        }
        // Display panel with checkboxes in JOptionPane
        int result = JOptionPane.showConfirmDialog(
                null,
                toppingsPanel,
                "Select Toppings",
                JOptionPane.OK_CANCEL_OPTION, //Add Ok and Cancel buttons to dialog
                JOptionPane.PLAIN_MESSAGE    //Removes default image
        );
        // Collect selected toppings
        ArrayList<Topping> selectedToppings = new ArrayList<>();
        for (JCheckBox checkBox : checkBoxes) {
            if (checkBox.isSelected()) {
                String toppingName = checkBox.getText().toUpperCase();
                System.out.println(toppingName);
                Cheese.CheeseChoice enumVal = matchCheeseChoice(toppingName);
                if(enumVal != null){
                    Cheese c = new Cheese(false, sandwichSizeChoice, enumVal);
                    selectedToppings.add(c);
                }



            }
//            double totalPrice = selectedToppings.stream().mapToDouble(Topping ::getprice).sum();
//            System.out.println(totalPrice);
        }

    }
    private static Cheese.CheeseChoice matchCheeseChoice(String s){
        Cheese.CheeseChoice result = null;
        try {
            // if it matches, return the enum
            result = Cheese.CheeseChoice.valueOf(s);
            // if it doesn't, return null
        }
        catch (IllegalArgumentException e){
            // forgive, but return null
        }
        return result;
    }
}










