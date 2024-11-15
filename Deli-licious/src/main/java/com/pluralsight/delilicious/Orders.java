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


    public void addItem(Item item) {
        itemList.add(item);
    }


    public double getTotalPrice() {
        double total = 0;
        for (Item item : itemList) {
            total += item.getprice();
        }
        return total;
    }


    private static int currentOrderNumber = 1;
    private int generateOrderNumber() {
        return currentOrderNumber++;
    }

    @Override
    public String toString() {
        StringBuilder orderSummary = new StringBuilder();
        orderSummary.append("Order Summary:\n")
                .append("Customer Name: ").append(name).append("\n")
                .append("Order Number: ").append(orderNumber).append("\n")
                .append("Order Date: ").append(localDateTime).append("\n")
                .append("Items:\n");

        for (Item item : itemList) {
            orderSummary.append(item.toString()).append("\n");
        }

        orderSummary.append("Total Price: ").append(getTotalPrice()).append("\n");
        return orderSummary.toString();
    }


    public int getOrderNumber() {
        return orderNumber;
    }

    public List<Item> getItemList() {
        return itemList;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public StringBuilder displayOrderToString() {
        StringBuilder orderSummary = new StringBuilder();

        orderSummary.append("========== Order Summary ==========\n");

        if (itemList.isEmpty()) {
            orderSummary.append("Your order is currently empty.\n");
        } else {
            int itemNumber = 1;
            for (Item item : itemList) {
                orderSummary.append("Item ").append(itemNumber++).append(": ").append(item).append("\n");
            }

            orderSummary.append("-----------------------------------\n")
                    .append("Total Items: ").append(itemList.size()).append("\n")
                    .append("Total Price: $").append(String.format("%.2f", getTotalPrice())).append("\n");
        }

        orderSummary.append("===================================");
        return orderSummary;
    }



}