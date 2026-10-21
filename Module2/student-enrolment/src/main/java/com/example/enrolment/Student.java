package com.example.enrolment;

public class Student {

    private final int studentId;
    private final String studentName;
    private final Course course;

    // Constructor injection: Course dependency is supplied by Spring via AppConfig
    public Student(int studentId, String studentName, Course course) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.course = course;
    }

    public int getStudentId() {
        return studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public Course getCourse() {
        return course;
    }

    public void displayStudentDetails() {
        System.out.println("Student ID: " + studentId);
        System.out.println("Student Name: " + studentName);
        course.displayCourseDetails();
    }
}
