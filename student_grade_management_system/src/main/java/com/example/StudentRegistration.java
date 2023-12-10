package com.example;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

public class StudentRegistration {
    private Map<String, Student> students;

    public StudentRegistration() {
        this.students = new HashMap<>();
    }

    public boolean registerStudent(String id, String name, String email, String phone) throws InvalidStudentDetailException, DuplicateRegistrationException{
        if (!isValidStudentDetails(id, name, email, phone)) {
            throw new InvalidStudentDetailException("Invalid student details");
        }

        if (students.containsKey(id)) {
            throw new DuplicateRegistrationException("Duplicate registration");
        }

        students.put(id, new Student(id, name, email, phone));
        return true;
    }

    private boolean isValidStudentDetails(String id, String name, String email, String phone) {
        String idPattern = "\\d+";
        String namePattern = "[A-Za-z ]+";
        String emailPattern = "[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}";
        String phonePattern = "\\d{10}";

        return Pattern.matches(idPattern, id) &&
                Pattern.matches(namePattern, name) &&
                Pattern.matches(emailPattern, email) &&
                Pattern.matches(phonePattern, phone);
    }

    private class Student {
        String id;
        String name;
        String email;
        String phone;

        Student(String id, String name, String email, String phone) {
            this.id = id;
            this.name = name;
            this.email = email;
            this.phone = phone;
        }
    }
}
