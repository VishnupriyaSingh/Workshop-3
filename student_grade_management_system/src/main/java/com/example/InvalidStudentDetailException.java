package com.example;

public class InvalidStudentDetailException extends Exception {
    public InvalidStudentDetailException(String message) {
        super(message);
    }
}