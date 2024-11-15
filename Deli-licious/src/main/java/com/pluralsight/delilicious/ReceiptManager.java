package com.pluralsight.delilicious;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ReceiptManager {
        // Method to create a receipt for the given order
        public void createReceipt(Orders orders) {
                String directoryPath = "./src/main/resources/Receipts";  // Directory where receipts will be saved

                // Generate a unique file name using the current timestamp
                String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd-hhmmss"));
                String fileName = "Order_Receipt_" + timestamp + ".txt";  // Create file name with timestamp
                String filePath = directoryPath + "/" + fileName;  // Full file path

                // Write the order summary to the file
                try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
                        writer.write(orders.displayOrderToString().toString());  // Write order summary to the file
                        System.out.println("Receipt saved at: " + filePath);  // Print the file path of the saved receipt
                } catch (IOException e) {
                        System.err.println("Failed to write receipt:");  // Print error if writing fails
                }
        }
}

