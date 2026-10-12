package Lambda;
// create a arithmetic interface with a abstract method calculate and write all lambda expressions for calculator

import java.util.*;
@FunctionalInterface
interface Arithmetic {
    int calculate(int a, int b);

}

public class Main {
    public static void main(String[] args) {



        Arithmetic add = (a, b) -> a + b;
        System.out.println("Addition: " + add.calculate(10, 5));


        Arithmetic subtract = (a, b) -> a - b;
        System.out.println("Subtraction: " + subtract.calculate(10, 5));


        Arithmetic multiply = (a, b) -> a * b;
        System.out.println("Multiplication: " + multiply.calculate(10, 5));


        Arithmetic divide = (a, b) -> a / b;
        System.out.println("Division: " + divide.calculate(10, 5));


        Arithmetic modulus = (a, b) -> a % b;
        System.out.println("Modulus: " + modulus.calculate(10, 5));
    }
}

//Pass lambda in collection.sort() method to sort a list of integers in ascending order