package com.example;

import java.util.HashMap;
import java.util.Map;

public class OrderProcessing {
    private Map<String, Integer> bookStock = new HashMap<>();

    public void processOrder(String isbn, int quantity) throws OrderException {
        if (!bookStock.containsKey(isbn) || bookStock.get(isbn) < quantity) {
            throw new OrderException("Book out of stock or not available");
        }
        bookStock.put(isbn, bookStock.get(isbn) - quantity);
    }

    public void setStock(String isbn, int quantity) {
        bookStock.put(isbn, quantity);
    }
}
