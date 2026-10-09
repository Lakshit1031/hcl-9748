package Abstraction;

public class Stack {

    static class StackImplementation {
        int[] arr;
        int top;
        int capacity;

        // Constructor
        StackImplementation(int size) {
            capacity = size;
            arr = new int[capacity];
            top = -1;
        }

        // 1. Push - add element
        void push(int data) {

            if (isFull()) {
                System.out.println("Stack Overflow");
                return;
            }

            top++;
            arr[top] = data;

            System.out.println(data + " pushed into stack");
        }

        // 2. Pop - remove top element
        int pop() {

            if (isEmpty()) {
                System.out.println("Stack Underflow");
                return -1;
            }

            int value = arr[top];
            top--;

            return value;
        }

        // 3. Peek - see top element without removing it
        int peek() {

            if (isEmpty()) {
                System.out.println("Stack is empty");
                return -1;
            }

            return arr[top];
        }

        // 4. Check if stack is empty
        boolean isEmpty() {
            return top == -1;
        }

        // 5. Check if stack is full
        boolean isFull() {
            return top == capacity - 1;
        }

        // 6. Display stack
        void display() {

            if (isEmpty()) {
                System.out.println("Stack is empty");
                return;
            }

            System.out.println("Stack elements:");

            for (int i = top; i >= 0; i--) {
                System.out.println(arr[i]);
            }
        }

        // 7. Size of stack
        int size() {
            return top + 1;
        }
    }

    public static void main(String[] args) {

        StackImplementation stack = new StackImplementation(5);

        // PUSH
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);

        System.out.println();

        // DISPLAY
        stack.display();

        System.out.println();

        // PEEK
        System.out.println("Top element: " + stack.peek());

        System.out.println();

        // POP
        System.out.println("Popped element: " + stack.pop());

        System.out.println();

        // DISPLAY AFTER POP
        stack.display();

        System.out.println();

        // SIZE
        System.out.println("Stack size: " + stack.size());

        System.out.println();

        // CHECK EMPTY
        System.out.println("Is stack empty? " + stack.isEmpty());

        // PUSH AGAIN
        System.out.println();
        stack.push(50);

        stack.display();
    }
}
