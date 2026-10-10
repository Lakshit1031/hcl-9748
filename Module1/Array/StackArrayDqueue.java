package Array;

import java.util.ArrayDeque;

public class StackArrayDqueue {
    public static void main(String[] args) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        // Insert elements
        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println("Stack: " + stack);

        // View the top element
        System.out.println("Top element: " + stack.peek());

        // Remove the top element
        System.out.println("Popped element: " + stack.pop());

        System.out.println("After pop: " + stack);

        // CHECK TOP ELEMENT
        System.out.println("Current top: " + stack.peek());

        // SEARCH
        System.out.println("Contains 10: " + stack.contains(10));

        // SIZE
        System.out.println("Stack size: " + stack.size());

        // CHECK EMPTY
        System.out.println("Is empty: " + stack.isEmpty());

        // ITERATE THROUGH STACK
        System.out.println("Stack elements:");
        for (int element : stack) {
            System.out.println(element);
        }

        // REMOVE ALL ELEMENTS
        stack.clear();
        System.out.println("After clear: " + stack);


    }
}
