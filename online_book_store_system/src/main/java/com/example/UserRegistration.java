package com.example;

import java.util.regex.Pattern;
import java.util.HashMap;
import java.util.Map;

public class UserRegistration {
    private Map<String, String> registeredUsers = new HashMap<>();

    public void registerUser(String username, String password, String email, String phone) throws RegistrationException {
        if (!isValidUsername(username) || !isValidPassword(password) || !isValidEmail(email) || !isValidPhone(phone)) {
            throw new RegistrationException("Invalid input");
        }
        if (registeredUsers.containsKey(username)) {
            throw new RegistrationException("Username already exists");
        }
        registeredUsers.put(username, "User details");
    }

    private boolean isValidUsername(String username) {
        return Pattern.matches("[a-zA-Z0-9_]{5,20}", username);
    }

    private boolean isValidPassword(String password) {
        return Pattern.matches("(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=]).{8,}", password);
    }

    private boolean isValidEmail(String email) {
        return Pattern.matches("^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$", email);
    }

    private boolean isValidPhone(String phone) {
        return Pattern.matches("\\d{10}", phone);
    }
}
