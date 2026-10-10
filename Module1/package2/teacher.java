package package2;

import package1.student;

public class teacher {

    public void teacherFunction() {
        System.out.println("This is Teacher function.");
    }

    public static void main(String[] args) {
        student student = new student();
        student.studentFunction();
        teacher teacher = new teacher();
        teacher.teacherFunction();
    }
}