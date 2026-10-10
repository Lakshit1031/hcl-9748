package constructor;

class Person {
    String name;

    Person(String name) {
        this.name = name;
    }

    void showDetails() {
        System.out.println("Parent method 1: Name = " + name);
    }

    void showRole() {
        System.out.println("Parent method 2: Role = Person");
    }
}

public class superuse extends Person {
    int rollNumber;

    superuse(String name, int rollNumber) {
        super(name);
        this.rollNumber = rollNumber;
    }

    @Override
    void showRole() {
        System.out.println("Overridden in child: Role = Student");
    }

    void showRollNumber() {
        System.out.println("Child method: Roll number = " + rollNumber);
    }

    public static void main(String[] args) {
        superuse student = new superuse("Lakshit", 101);
        student.showRole();       // Overridden parent method
        student.showRollNumber(); // Child method
        student.showDetails();    // Parent method
    }
}
