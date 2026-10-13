package Generic;

import java.util.*;
// Generic class with one type parameter
class Box<T> {
    private T value;
    public void setValue(T value) {
        this.value = value;
    }
    public T getValue() {
        return value;
    }
    public void display() {
        System.out.println("Value: " + value);
    }
}
// Generic class with multiple type parameters
class Pair<K, V> {
    private K key;
    private V value;
    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }
    public K getKey() {
        return key;
    }
    public V getValue() {
        return value;
    }
    public void display() {
        System.out.println(key + " = " + value);
    }
}
// Generic interface
interface Container<T> {
    void add(T item);
    T get();
}
// Implementation of generic interface
class MyContainer<T> implements Container<T> {
    private T item;
    public void add(T item) {
        this.item = item;
    }
    public T get() {
        return item;
    }
}
public class Main {

    // Generic method
    public static <T> void printArray(T[] arr) {
        for (T item : arr) {
            System.out.print(item + " ");
        }
        System.out.println();
    }
    // Bounded type parameter
    public static <T extends Number> double square(T num) {
        return num.doubleValue() * num.doubleValue();
    }
    // Upper-bounded wildcard
    public static double sum(List<? extends Number> list) {
        double total = 0;
        for (Number num : list) {
            total += num.doubleValue();
        }
        return total;
    }
    // Lower-bounded wildcard
    public static void addIntegers(List<? super Integer> list) {
        list.add(10);
        list.add(20);
    }
    // Unbounded wildcard
    public static void displayList(List<?> list) {
        for (Object item : list) {
            System.out.print(item + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {

        //Generic class with Integer
        Box<Integer> b1 = new Box<>();
        b1.setValue(100);
        b1.display();
        //Generic class with String
        Box<String> b2 = new Box<>();
        b2.setValue("Java Generics");
        b2.display();
        //Multiple type parameters
        Pair<Integer, String> p =
                new Pair<>(101, "Lakshit");
        p.display();
        //Generic method
        Integer[] nums = {10, 20, 30};
        String[] names = {"Java", "Python", "C++"};
        printArray(nums);
        printArray(names);
        //Bounded type parameter
        System.out.println(square(5));
        System.out.println(square(2.5));
        //Generic interface
        Container<String> c = new MyContainer<>();
        c.add("Hello");
        System.out.println(c.get());
        //Upper-bounded wildcard
        List<Integer> list1 =
                Arrays.asList(10, 20, 30);
        System.out.println(sum(list1));
        //Lower-bounded wildcard
        List<Number> list2 = new ArrayList<>();
        addIntegers(list2);
        System.out.println(list2);
        //Unbounded wildcard
        List<String> list3 =
                Arrays.asList("A", "B", "C");
        displayList(list3);
        //Generic collection
        List<String> subjects = new ArrayList<>();
        subjects.add("Java");
        subjects.add("DSA");
        subjects.add("DBMS");
        subjects.add("OS");
        subjects.add("COA");
        subjects.add("CN");
        System.out.println(subjects);
        //Type-safe retrieval
        String subject = subjects.get(0);
        System.out.println(subject);
    }
}

