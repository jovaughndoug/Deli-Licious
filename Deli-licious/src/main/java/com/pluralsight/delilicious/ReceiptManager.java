package com.pluralsight.delilicious;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ReceiptManager {
        public void createReceipt(Orders orders) {
                String directoryPath = "./src/main/resources/Receipts";

                // create file name
                String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd-hhmmss"));
                String fileName = "Order_Receipt_" + timestamp + ".txt";
                String filePath = directoryPath + "/" + fileName;

                // Write order to the file
                try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
                        writer.write(orders.displayOrderToString().toString());
                        System.out.println("Receipt saved at: " + filePath);
                } catch (IOException e) {
                        System.err.println("Failed to write receipt:");
                }
        }
}

