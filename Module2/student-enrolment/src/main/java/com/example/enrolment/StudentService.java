package com.example.enrolment;

public class StudentService {

    private final Student student;

    // Constructor injection: Student dependency is supplied by Spring via AppConfig
    public StudentService(Student student) {
        this.student = student;
    }

    public void displayStudentProfile() {
        student.displayStudentDetails();
    }
}
