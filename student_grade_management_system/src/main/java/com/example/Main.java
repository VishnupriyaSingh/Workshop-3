package com.example;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        StudentRegistration registration = new StudentRegistration();
        CourseEnrollment enrollment = new CourseEnrollment();
        GradeCalculator calculator = new GradeCalculator();

        try {
            registration.registerStudent("123", "John Doe", "johndoe@example.com", "1234567890");
            System.out.println("Student registered successfully.");

            enrollment.addCourse("CS101");

            enrollment.enrollStudent("123", "CS101");
            System.out.println("Student enrolled in course successfully.");

            Map<String, Double> grades = new HashMap<>();
            grades.put("CS101", 85.0);
            double finalGrade = calculator.calculateFinalGrade(grades);
            System.out.println("Final Grade: " + finalGrade);

        } catch (InvalidStudentDetailException e) {
            System.err.println("Invalid student details: " + e.getMessage());
        } catch (DuplicateRegistrationException e) {
            System.err.println("Duplicate registration: " + e.getMessage());
        } catch (EnrollmentException e) {
            System.err.println("Enrollment error: " + e.getMessage());
        } catch (GradeCalculationException e) {
            System.err.println("Grade calculation error: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("An unexpected error occurred: " + e.getMessage());
        }
    }
}

