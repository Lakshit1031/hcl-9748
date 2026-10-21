# Student Course Enrolment System — Explanation

## Where constructor injection occurs

1. **Course** — `Course(String courseId, String courseName, int durationMonths)` receives all its values through the constructor.
2. **Student** — `Student(int studentId, String studentName, Course course)` receives the `Course` dependency through its constructor. Student never creates a Course itself.
3. **StudentService** — `StudentService(Student student)` receives the `Student` dependency through its constructor. StudentService never creates a Student itself.
4. **AppConfig** — each `@Bean` method declares its dependency as a method parameter:
   - `student(Course course)` — Spring finds the `Course` bean in the container and passes it in.
   - `studentService(Student student)` — Spring finds the `Student` bean and passes it in.
   The `@Bean` method then calls the constructor with that dependency. `new` is used only inside `@Bean` methods.

Dependency flow: **Course → Student → StudentService → MainApp**

All fields are `final`, so each object is fully built and cannot change after construction. No field injection, setter injection or `@Autowired` is used.

## What AnnotationConfigApplicationContext does

`AnnotationConfigApplicationContext` is the Spring IoC container for Java-based (annotation) configuration. It replaces XML configuration.

When `new AnnotationConfigApplicationContext(AppConfig.class)` runs, it:

1. Reads the `@Configuration` class `AppConfig`.
2. Finds every `@Bean` method and registers a bean definition for each.
3. Works out the dependency order from the method parameters and creates the beans: Course first, then Student, then StudentService.
4. Keeps each bean as a singleton by default.

`context.getBean(StudentService.class)` returns the ready, fully wired StudentService from the container. `context.close()` shuts the container down and releases its beans.

## Console output

```
Student ID: 101
Student Name: Aditi Sharma
Course ID: C01
Course Name: Java Full Stack
Duration: 4 months
```

## How to run

```
mvn compile exec:java
```
Or run `MainApp` from the IDE.
