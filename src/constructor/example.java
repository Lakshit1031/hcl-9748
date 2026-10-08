//package constructor;
//
//class Student {
//    String name;
//
//    // Default constructor
//    Student() {
//        name = "Unknown";
//        System.out.println("Default constructor called");
//    }
//    // Parameterized (args) constructor
//    Student(String name) {
//        this.name = name;
//        System.out.println("Parameterized constructor called");
//    }
//}
//public class example {
//    public static void main(String[] args) {
//
//        // Calling default constructor
//        Student s1 = new Student();
//        System.out.println("Name: " + s1.name);
//
//        // Calling parameterized constructor
//        Student s2 = new Student("Lakshit");
//        System.out.println("Name: " + s2.name);
//    }
//}
//
//
//
//WHATEVER WILL BE THE CLASS ACCESS MODIFIER THAT WILL BE OF DEFAULT CONSTRUCTOR ACCESS MODIFIER.
//
//
//PRIVATE CONSTRUCTOR CAN'T BE CALLED OUTSIDE.
//
//package constructor;
//
//class Student {
//    String name;
//
//    // Private constructor
//    private Student() {
//        name = "Unknown";
//        System.out.println("Private constructor called");
//    }
//}
//
//public class example {
//    public static void main(String[] args) {
//
//        Student s = new Student();  // Error
//    }
//}