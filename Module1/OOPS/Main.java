//package OOPS;
//class Parent {
//    // Method 1
//    void display() {
//        System.out.println("This is Parent display method");
//    }
//    // Method 2
//    void show() {
//        System.out.println("This is Parent show method");
//    }
//}
//class Child extends Parent {
//    // Child's own method
//    void childMethod() {
//        System.out.println("This is Child method");
//    }
//    // Overriding Parent's display() method
//    @Override
//    void display() {
//        System.out.println("This is Child's overridden display method");
//    }
//}
//public class Main {
//    public static void main(String[] args) {
//        Child c = new Child();
//        // Overridden method
//        c.display();
//        // Parent's method that was not overridden
//        c.show();
//        // Child's own method
//        c.childMethod();
//    }
//}








package OOPS;
class Parent {
    private static int instanceCount;
    Parent() {
        instanceCount++;
    }
    static int getInstanceCount() {
        return instanceCount;
    }
    static void staticMethod() {
        System.out.println("Parent static method");
    }
    // Parent method 1
    void display() {
        System.out.println("Parent display method");
    }
    // Parent method 2
    void show() {
        System.out.println("Parent show method");
    }
}
class Child extends Parent {
    // Hides Parent's static method; static methods are resolved by reference type.
    static void staticMethod() {
        System.out.println("Child static method");
    }
    // Child's own method
    void childMethod() {
        System.out.println("Child method");
    }
    // Overriding Parent's display() method
    @Override
    void display() {
        System.out.println("Child's overridden display method");
    }
}
public class Main {
    public static void main(String[] args) {
        Parent p = new Child();
        System.out.println("Using Parent reference:");
        p.display();   // Child's overridden method
        p.show();      // Parent's method
        Child c = new Child();
        System.out.println("\nUsing Child reference:");
        c.display();       // Child's overridden method
        c.show();          // Inherited Parent method
        c.childMethod();   // Child's own method
        System.out.println("\nMethod hiding example:");
        Parent.staticMethod(); // Parent version
        Child.staticMethod();  // Child version
        Parent referenceToChild = new Child();
        referenceToChild.staticMethod(); // Parent version, despite the Child object
        System.out.println("\nParent/Child instances created: "
                + Parent.getInstanceCount());
    }
}




// method hiding is done at compile time and method overriding is done at runtime.

