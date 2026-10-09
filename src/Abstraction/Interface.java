package Abstraction;

interface A {
    void displayA();
}

interface B {
    void displayB();
}

class C implements A, B {

    public void displayA() {
        System.out.println("This is Interface A");
    }

    public void displayB() {
        System.out.println("This is Interface B");
    }
}

public class Interface {
    public static void main(String[] args) {
        C obj = new C();

        obj.displayA();
        obj.displayB();
    }
}
