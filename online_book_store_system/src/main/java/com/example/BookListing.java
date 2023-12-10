package com.example;

import java.util.List;
import java.util.ArrayList;

public class BookListing {
    private List<Book> books = new ArrayList<>();

    public void addBook(String title, String author, String isbn, double price) throws BookException {
        if (!isValidISBN(isbn)) {
            throw new BookException("Invalid ISBN");
        }
        books.add(new Book(title, author, isbn, price));
    }

    private boolean isValidISBN(String isbn) {
        return isbn != null && isbn.matches("[0-9]{10}|[0-9]{13}");
    }
}

class Book {
    private String title;
    private String author;
    private String isbn;
    private double price;

    public Book(String title, String author, String isbn, double price) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.price = price;
    }
}
