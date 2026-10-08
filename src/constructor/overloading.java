package constructor;
class Students {
    String name;
    int age;
    // Default constructor
    Students() {
        name = "Unknown";
        age = 0;
    }
    // Constructor with one argument
    Students(String name) {
        this.name = name;
        age = 0;
    }
    // Constructor with two arguments
    Students(String name, int age) {
        this.name = name;
        this.age = age;
    }
    void display() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println();
    }
}
public class overloading {
    public static void main(String[] args) {
        Students s1 = new Students();
        Students s2 = new Students("Lakshit");
        Students s3 = new Students("Rahul", 21);
        s1.display();
        s2.display();
        s3.display();
    }
}