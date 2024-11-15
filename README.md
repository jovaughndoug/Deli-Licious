# Deli-licious

## Description
This application is a Point-of-Sale (POS) system designed for a deli. It allows users to manage orders, process transactions, and generate receipts. The system provides an interactive menu for adding, customizing, and confirming orders, while creating detailed receipts for every confirmed transaction.

## Features
- **Add Items to Orders**: Users can add customizable sandwiches, toppings, drinks, and chips to their current order.
- **Modify Orders**: Users can update items in their order, including adding or removing toppings and changing sandwich details.
- **View Order Summary**: Displays the current order in a well-formatted structure with itemized details and pricing.
- **Confirm or Cancel Orders**: Users can confirm their order to finalize it or cancel it entirely.
- **Generate Receipts**: Automatically generates a receipt file with the order summary in the `src/main/resources/Receipts` directory.
- **Read Receipts**: Provides functionality to load and display a previously saved receipt.

## Project Structure

### Directories
- **`src/main/resources/`**: 
  - Contains the directory for storing generated receipt files (`Receipts/`).
- **`src/main/java/com/pluralsight/delilicious/`**: 
  - Houses all Java source files for the POS system.

### Java Classes

- **`Program.java`**: Entry point of the application, containing the main menu logic.
- **`Sandwich.java`**: Represents a sandwich with size, toppings, and additional details.
- **`Topping.java` & `RegularTopping.java`**: Define and manage different types of toppings for sandwiches.
- **`Orders.java`**: Manages a list of items in the current order and calculates totals.
- **`ReceiptManager.java`**: Handles receipt creation and reading functionalities.
- **`TerminalUI.java`**: Provides an interactive menu for users to navigate the POS system, add items, confirm orders, and view order summaries.

### Files
- **`Receipts/`**: Directory for storing all generated receipt files.

## New Lessons

### Enum Classes
using enum classes to create list of values easier.
![image](https://github.com/user-attachments/assets/dcad5003-9068-4a83-8937-c6677060f070)


### Leveraging LocalDateTime
Used `LocalDateTime` to generate unique timestamps for receipt filenames, ensuring no file is overwritten.

### Abstract Classes
Creating abstract classes and learning to connect classes that are similar or share variables.
![image](https://github.com/user-attachments/assets/0b0894b8-8870-43d0-ba4c-4e70e5e9666b)



## Lessons Learned
- **Switch-Case Statements**: Simplifies control flow for multi-option menus, making the code more readable and maintainable.
- **Buffered I/O**: Efficiently handles file operations for saving and reading data.
- **Encapsulation**: Improved Encapsulation
- **Error Handling**: error handling for file operations and menus, ensuring users are informed of issues without crashing the system.

## Future Improvements
- **UI Enhancements**: Add color to prompts or integrate a graphical user interface (GUI) for a more visually pleasing experience.
- **Order Persistence**: Save and reload orders between sessions to improve usability.
- **Testing**: Implement comprehensive unit tests to ensure reliability and robustness of the application.
- **Improved Flexibility**: Support additional menu items, combos, and discounts for a more versatile POS system.

