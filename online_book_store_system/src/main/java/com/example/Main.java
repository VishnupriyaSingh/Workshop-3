package com.example;

public class Main {
    public static void main(String[] args) {
        UserRegistration userReg = new UserRegistration();
        try {
            userReg.registerUser("john_doe", "Password@123", "john@example.com", "1234567890");
            System.out.println("User registration successful.");
        } catch (RegistrationException e) {
            System.out.println("User registration failed: " + e.getMessage());
        }

        BookListing bookList = new BookListing();
        try {
            bookList.addBook("The Great Gatsby", "F. Scott Fitzgerald", "1234567890", 10.99);
            bookList.addBook("1984", "George Orwell", "1234567890123", 8.99);
            System.out.println("Books added successfully.");
        } catch (BookException e) {
            System.out.println("Failed to add book: " + e.getMessage());
        }

        OrderProcessing orderProc = new OrderProcessing();
        try {
            orderProc.processOrder("1234567890", 1); // Assuming this ISBN exists in the stock
            System.out.println("Order processed successfully.");
        } catch (OrderException e) {
            System.out.println("Order processing failed: " + e.getMessage());
        }
    }
}
