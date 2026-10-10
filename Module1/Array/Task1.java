package Array;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class Student {
    String name;
    int rollno;
    int age;
    double marks;

    // Constructor
    public Student(String name, int rollno, int age, double marks) {
        this.name = name;
        this.rollno = rollno;
        this.age = age;
        this.marks = marks;
    }

    // Display student details
    public String toString() {
        return "Name: " + name +
                ", Roll No: " + rollno +
                ", Age: " + age +
                ", Marks: " + marks;
    }
}

public class Task1 {
    public static void main(String[] args) {

        ArrayList<Student> students = new ArrayList<>();

        // Add 10 students
        students.add(new Student("Rahul", 101, 20, 85.5));
        students.add(new Student("Aman", 102, 19, 90.0));
        students.add(new Student("Priya", 103, 21, 88.5));
        students.add(new Student("Neha", 104, 18, 92.0));
        students.add(new Student("Rohit", 105, 20, 75.0));
        students.add(new Student("Anjali", 106, 19, 95.0));
        students.add(new Student("Karan", 107, 22, 80.5));
        students.add(new Student("Sneha", 108, 18, 89.0));
        students.add(new Student("Vikas", 109, 21, 78.5));
        students.add(new Student("Pooja", 110, 20, 91.0));

        // Print original list
        System.out.println("Original Student List");
        for (Student s : students) {
            System.out.println(s);
        }

        // Sort by age
        Collections.sort(students, Comparator.comparingInt(s -> s.age));

        System.out.println("\nSorted by Age");
        for (Student s : students) {
            System.out.println(s);

        }

        // Sort by marks
        Collections.sort(students, Comparator.comparingDouble(s -> s.marks));

        System.out.println("\nSorted by Marks");
        for (Student s : students) {
            System.out.println(s);
        }
    }
}








//import java.util.ArrayList;
//import java.util.Collections;
//
//class Student {
//    String name;
//    int rollno;
//    int age;
//    double marks;
//
//    Student(String name, int rollno, int age, double marks) {
//        this.name = name;
//        this.rollno = rollno;
//        this.age = age;
//        this.marks = marks;
//    }
//
//    public String toString() {
//        return "Name: " + name +
//                ", Roll No: " + rollno +
//                ", Age: " + age +
//                ", Marks: " + marks;
//    }
//}
//
//public class Task1 {
//    public static void main(String[] args) {
//
//        ArrayList<Student> students = new ArrayList<>();
//
//        // Add 10 students
//        students.add(new Student("Rahul", 101, 20, 85.5));
//        students.add(new Student("Aman", 102, 19, 90.0));
//        students.add(new Student("Priya", 103, 21, 88.5));
//        students.add(new Student("Neha", 104, 18, 92.0));
//        students.add(new Student("Rohit", 105, 20, 75.0));
//        students.add(new Student("Anjali", 106, 19, 95.0));
//        students.add(new Student("Karan", 107, 22, 80.5));
//        students.add(new Student("Sneha", 108, 18, 89.0));
//        students.add(new Student("Vikas", 109, 21, 78.5));
//        students.add(new Student("Pooja", 110, 20, 91.0));
//
//        // Print original list
//        System.out.println("Original List");
//        for (Student s : students) {
//            System.out.println(s);
//        }
//
//        // Sort by age (ascending)
//        for (int i = 0; i < students.size(); i++) {
//            for (int j = i + 1; j < students.size(); j++) {
//
//                if (students.get(i).age > students.get(j).age) {
//                    Student temp = students.get(i);
//                    students.set(i, students.get(j));
//                    students.set(j, temp);
//                }
//            }
//        }
//
//        System.out.println("\nSorted by Age");
//        for (Student s : students) {
//            System.out.println(s);
//        }
//
//        // Sort by marks (ascending)
//        for (int i = 0; i < students.size(); i++) {
//            for (int j = i + 1; j < students.size(); j++) {
//
//                if (students.get(i).marks > students.get(j).marks) {
//                    Student temp = students.get(i);
//                    students.set(i, students.get(j));
//                    students.set(j, temp);
//                }
//            }
//        }
//
//        System.out.println("\nSorted by Marks");
//        for (Student s : students) {
//            System.out.println(s);
//        }
//    }
//}
