package com.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CourseEnrollment {
    private Map<String, Course> courses;

    public CourseEnrollment() {
        this.courses = new HashMap<>();
    }

    public void addCourse(String courseId) {
        if (!courses.containsKey(courseId)) {
            courses.put(courseId, new Course(courseId));
        }
    }

    public void enrollStudent(String studentId, String courseId) throws CourseNotFoundException, EnrollmentException {
        Course course = courses.get(courseId);
        if (course == null) {
            throw new CourseNotFoundException("Course not found");
        }
        course.enrollStudent(studentId);
    }

    private class Course {
        String courseId;
        List<String> enrolledStudents;

        Course(String courseId) {
            this.courseId = courseId;
            this.enrolledStudents = new ArrayList<>();
        }

        void enrollStudent(String studentId) {
            if (enrolledStudents.contains(studentId)) {
                throw new IllegalArgumentException("Student already enrolled in this course");
            }
            enrolledStudents.add(studentId);
        }
    }
}
