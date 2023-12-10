package com.example;

import java.util.Map;

public class GradeCalculator {
    public double calculateFinalGrade(Map<String, Double> grades) throws GradeCalculationException {
        if (grades.isEmpty()) {
            throw new GradeCalculationException("No grades provided");
        }

        double sum = 0;
        for (double grade : grades.values()) {
            sum += grade;
        }
        return sum / grades.size();
    }
}

