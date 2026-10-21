package com.example.enrolment;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    // Course -> Student -> StudentService -> MainApp

    @Bean
    public Course course() {
        return new Course("C01", "Java Full Stack", 4);
    }

    // Spring resolves the Course parameter from the container
    @Bean
    public Student student(Course course) {
        return new Student(101, "Aditi Sharma", course);
    }

    // Spring resolves the Student parameter from the container
    @Bean
    public StudentService studentService(Student student) {
        return new StudentService(student);
    }
}
