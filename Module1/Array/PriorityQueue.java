package Array;

public class PriorityQueue {

    public static void main(String[] args) {
        java.util.PriorityQueue<Integer> priorityQueue = new java.util.PriorityQueue<>();

        // 1. Add elements to the priority queue
        for (int i = 10; i >= 1; i--) {
            priorityQueue.add(i);
        }

        // 2. Remove 3 elements from the priority queue
        for (int i = 0; i < 3; i++) {
            priorityQueue.poll();
        }

        // 3. Print the remaining elements in the priority queue
        System.out.println("Remaining elements in the priority queue: " + priorityQueue);
    }
}
