package Wildcard;
import java.util.*;

public class Wildcard {

    // 1. Unbounded wildcard
    static void printList(List<?> list) {
        System.out.println("Unbounded Wildcard:");
        for (Object item : list) {
            System.out.println(item);
        }
    }

    // 2. Upper bounded wildcard
    static void printNumbers(List<? extends Number> list) {
        System.out.println("Upper Bounded Wildcard:");
        for (Number num : list) {
            System.out.println(num);
        }
    }

    // 3. Lower bounded wildcard
    static void addNumbers(List<? super Integer> list) {
        System.out.println("Lower Bounded Wildcard:");

        list.add(10);
        list.add(20);
        list.add(30);

        System.out.println(list);
    }

    public static void main(String[] args) {

        // Unbounded wildcard
        List<String> names = Arrays.asList("Aman", "Rahul", "Priya");
        printList(names);

        // Upper bounded wildcard
        List<Integer> numbers = Arrays.asList(10, 20, 30);
        printNumbers(numbers);

        List<Double> decimals = Arrays.asList(1.5, 2.5, 3.5);
        printNumbers(decimals);

        // Lower bounded wildcard
        List<Integer> values = new ArrayList<>();
        addNumbers(values);
    }
}
