package com.pluralsight.delilicious;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Orders {
    private List<Item> itemList;
    private String name;
    private int orderNumber = 1;
    private LocalDateTime localDateTime = LocalDateTime.now();

    public Orders() {
        this.itemList = new ArrayList<>();
        this.name = name;
        this.orderNumber = generateOrderNumber();
        this.localDateTime = LocalDateTime.now();
    }

    // Adds an item to the order
    public void addItem(Item item) {
        itemList.add(item);  // Add item to the list
    }

    // Calculates and returns the total price of all items in the order
    public double getTotalPrice() {
        double total = 0;
        for (Item item : itemList) {
            total += item.getprice();  // Add each item's price to total
        }
        return total;  // Return total price
    }

    private static int currentOrderNumber = 1;  // counter for order number

    // Generates a unique order number by incrementing the counter
    private int generateOrderNumber() {

        return currentOrderNumber++;  // return order number counting
    }

     //Converts the order to a detailed string summary
    @Override
    public String toString() {
        StringBuilder orderSummary = new StringBuilder();  // StringBuilder to build the order summary
        orderSummary.append("Order Summary:\n")
                .append("Customer Name: ").append(name).append("\n")  // Customer's name
                .append("Order Number: ").append(orderNumber).append("\n")  // Order number
                .append("Order Date: ").append(localDateTime).append("\n")  // Order date/time
                .append("Items:\n");

        for (Item item : itemList) {
            orderSummary.append(item.toString()).append("\n");  // Add each item's string representation
        }

        orderSummary.append("Total Price: ").append(getTotalPrice()).append("\n");  // Total price of the order
        return orderSummary.toString();  // Return the final summary string
    }

    // Getter for the order number
    public int getOrderNumber() {
        return orderNumber;
    }

    // Getter for the list of items in the order
    public List<Item> getItemList() {
        return itemList;
    }

    // Getter for the order's date/time
    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    // Displays a formatted order summary or indicates if it's empty
    public StringBuilder displayOrderToString() {
        StringBuilder orderSummary = new StringBuilder();  // Initialize the summary string

        orderSummary.append("========== Order Summary ==========\n");

        if (itemList.isEmpty()) {
            orderSummary.append("Your order is currently empty.\n");  // Notify if no items in the order
        } else {
            int itemNumber = 1;
            for (Item item : itemList) {
                orderSummary.append("Item ").append(itemNumber++).append(": ").append(item).append("\n");  // List each item
            }

            orderSummary.append("-----------------------------------\n")
                    .append("Total Items: ").append(itemList.size()).append("\n")  // Display the number of items
                    .append("Total Price: $").append(String.format("%.2f", getTotalPrice())).append("\n");  // Display total price
        }

        orderSummary.append("===================================");
        return orderSummary;  // Return the formatted string
    }
}


