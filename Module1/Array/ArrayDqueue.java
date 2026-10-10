package Array;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Iterator;

public class ArrayDqueue {

    public static void main(String[] args) {
        ArrayDeque<Integer> deque = new ArrayDeque<>();

        // 1. INSERTION OPERATIONS
        deque.add(10);              // Add at the end
        deque.addLast(20);          // Add at the end
        deque.addFirst(5);          // Add at the front
        deque.offer(30);            // Add at the end
        deque.offerFirst(1);        // Add at the front
        deque.offerLast(40);        // Add at the end

        System.out.println("After insertion: " + deque);

        // 2. ACCESSING ELEMENTS
        System.out.println("First element: " + deque.getFirst());
        System.out.println("Last element: " + deque.getLast());
        System.out.println("Peek first: " + deque.peekFirst());
        System.out.println("Peek last: " + deque.peekLast());
        System.out.println("Queue peek: " + deque.peek());

        // 3. REMOVAL OPERATIONS
        deque.removeFirst();
        System.out.println("After removeFirst: " + deque);

        deque.removeLast();
        System.out.println("After removeLast: " + deque);

        deque.remove(20);           // Remove a specific element
        System.out.println("After remove(20): " + deque);

        deque.pollFirst();          // Remove first; null if empty
        deque.pollLast();           // Remove last; null if empty
        deque.poll();               // Remove first; null if empty

        System.out.println("After polling: " + deque);

        // 4. SEARCHING
        deque.addAll(Arrays.asList(10, 20, 30, 20));

        System.out.println("Contains 20: " + deque.contains(20));
        System.out.println("Contains 99: " + deque.contains(99));

        // 5. REMOVE FIRST/LAST OCCURRENCE
        deque.removeFirstOccurrence(20);
        System.out.println("After removing first 20: " + deque);

        deque.removeLastOccurrence(20);
        System.out.println("After removing last 20: " + deque);

        // 6. SIZE AND EMPTY CHECK
        System.out.println("Size: " + deque.size());
        System.out.println("Is empty: " + deque.isEmpty());

        // 7. ITERATION FROM FRONT TO BACK
        System.out.println("Forward iteration:");
        for (int element : deque) {
            System.out.print(element + " ");
        }
        System.out.println();

        // 8. ITERATION FROM BACK TO FRONT
        System.out.println("Reverse iteration:");
        Iterator<Integer> reverse = deque.descendingIterator();

        while (reverse.hasNext()) {
            System.out.print(reverse.next() + " ");
        }
        System.out.println();

        // 9. STACK OPERATIONS (LIFO)
        deque.clear();
        deque.push(100);
        deque.push(200);
        deque.push(300);

        System.out.println("Stack: " + deque);
        System.out.println("Stack top: " + deque.peek());
        System.out.println("Stack pop: " + deque.pop());
        System.out.println("Stack after pop: " + deque);

        // 10. QUEUE OPERATIONS (FIFO)
        deque.clear();
        deque.offer(10);
        deque.offer(20);
        deque.offer(30);

        System.out.println("Queue: " + deque);
        System.out.println("Queue front: " + deque.peek());
        System.out.println("Queue remove: " + deque.poll());
        System.out.println("Queue after poll: " + deque);

        // 11. ADD ALL ELEMENTS
        deque.addAll(Arrays.asList(40, 50, 60));
        System.out.println("After addAll: " + deque);

        // 12. ARRAY CONVERSION
        Object[] arr = deque.toArray();
        System.out.println("Array: " + Arrays.toString(arr));

        // 13. CLEAR ALL ELEMENTS
        deque.clear();
        System.out.println("After clear: " + deque);
        System.out.println("Is empty: " + deque.isEmpty());
    }
}
