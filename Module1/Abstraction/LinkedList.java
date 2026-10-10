package Abstraction;
//
//public class LinkedList {
//    // 1. SINGLY LINKED LIST
//    static class SinglyLinkedList {
//        // Node
//        static class Node {
//            int data;
//            Node next;
//
//            Node(int data) {
//                this.data = data;
//                this.next = null;
//            }
//        }
//
//        Node head;
//
//        // INSERT AT BEGINNING
//
//        void insertFirst(int data) {
//
//            Node newNode = new Node(data);
//
//            newNode.next = head;
//            head = newNode;
//        }
//
//        // INSERT AT END
//        void insertLast(int data) {
//
//            Node newNode = new Node(data);
//
//            if (head == null) {
//                head = newNode;
//                return;
//            }
//
//            Node temp = head;
//
//            while (temp.next != null) {
//                temp = temp.next;
//            }
//
//            temp.next = newNode;
//        }
//
//        // INSERT AT POSITION
//        // Position starts from 1
//        void insertAtPosition(int data, int position) {
//
//            if (position <= 0) {
//                System.out.println("Invalid position");
//                return;
//            }
//
//            if (position == 1) {
//                insertFirst(data);
//                return;
//            }
//
//            Node newNode = new Node(data);
//            Node temp = head;
//
//            for (int i = 1; i < position - 1 && temp != null; i++) {
//                temp = temp.next;
//            }
//
//            if (temp == null) {
//                System.out.println("Invalid position");
//                return;
//            }
//
//            newNode.next = temp.next;
//            temp.next = newNode;
//        }
//
//        // DISPLAY
//        void display() {
//
//            Node temp = head;
//
//            while (temp != null) {
//                System.out.print(temp.data + " -> ");
//                temp = temp.next;
//            }
//
//            System.out.println("null");
//        }
//
//        // SEARCH
//        boolean search(int value) {
//
//            Node temp = head;
//
//            while (temp != null) {
//
//                if (temp.data == value) {
//                    return true;
//                }
//
//                temp = temp.next;
//            }
//
//            return false;
//        }
//
//        // LENGTH
//        int length() {
//
//            int count = 0;
//            Node temp = head;
//
//            while (temp != null) {
//                count++;
//                temp = temp.next;
//            }
//
//            return count;
//        }
//
//        // DELETE FIRST
//        void deleteFirst() {
//
//            if (head == null) {
//                System.out.println("List is empty");
//                return;
//            }
//
//            head = head.next;
//        }
//
//        // DELETE LAST
//        void deleteLast() {
//
//            if (head == null) {
//                System.out.println("List is empty");
//                return;
//            }
//
//            if (head.next == null) {
//                head = null;
//                return;
//            }
//
//            Node temp = head;
//
//            while (temp.next.next != null) {
//                temp = temp.next;
//            }
//
//            temp.next = null;
//        }
//
//        // DELETE BY VALUE
//        void deleteValue(int value) {
//
//            if (head == null) {
//                return;
//            }
//
//            // If first node contains value
//            if (head.data == value) {
//                head = head.next;
//                return;
//            }
//
//            Node temp = head;
//
//            while (temp.next != null) {
//
//                if (temp.next.data == value) {
//                    temp.next = temp.next.next;
//                    return;
//                }
//
//                temp = temp.next;
//            }
//
//            System.out.println("Value not found");
//        }
//
//        // DELETE AT POSITION
//        void deleteAtPosition(int position) {
//
//            if (head == null) {
//                return;
//            }
//
//            if (position <= 0) {
//                System.out.println("Invalid position");
//                return;
//            }
//
//            if (position == 1) {
//                head = head.next;
//                return;
//            }
//
//            Node temp = head;
//
//            for (int i = 1; i < position - 1 && temp != null; i++) {
//                temp = temp.next;
//            }
//
//            if (temp == null || temp.next == null) {
//                System.out.println("Invalid position");
//                return;
//            }
//
//            temp.next = temp.next.next;
//        }
//
//        // REVERSE
//        void reverse() {
//
//            Node previous = null;
//            Node current = head;
//
//            while (current != null) {
//
//                Node nextNode = current.next;
//
//                current.next = previous;
//
//                previous = current;
//                current = nextNode;
//            }
//
//            head = previous;
//        }
//
//        // FIND MIDDLE
//        int findMiddle() {
//
//            if (head == null) {
//                return -1;
//            }
//
//            Node slow = head;
//            Node fast = head;
//
//            while (fast != null && fast.next != null) {
//
//                slow = slow.next;
//                fast = fast.next.next;
//            }
//
//            return slow.data;
//        }
//
//        // NTH NODE FROM END
//        int nthFromEnd(int n) {
//
//            if (n <= 0) {
//                return -1;
//            }
//
//            Node first = head;
//            Node second = head;
//
//            for (int i = 0; i < n; i++) {
//
//                if (first == null) {
//                    return -1;
//                }
//
//                first = first.next;
//            }
//
//            while (first != null) {
//
//                first = first.next;
//                second = second.next;
//            }
//
//            return second.data;
//        }
//
//        // COUNT OCCURRENCES
//        int countValue(int value) {
//
//            int count = 0;
//            Node temp = head;
//
//            while (temp != null) {
//
//                if (temp.data == value) {
//                    count++;
//                }
//
//                temp = temp.next;
//            }
//
//            return count;
//        }
//
//        // MAXIMUM
//        int findMax() {
//
//            if (head == null) {
//                return -1;
//            }
//
//            int max = head.data;
//
//            Node temp = head.next;
//
//            while (temp != null) {
//
//                if (temp.data > max) {
//                    max = temp.data;
//                }
//
//                temp = temp.next;
//            }
//
//            return max;
//        }
//
//        // MINIMUM
//        int findMin() {
//
//            if (head == null) {
//                return -1;
//            }
//
//            int min = head.data;
//
//            Node temp = head.next;
//
//            while (temp != null) {
//
//                if (temp.data < min) {
//                    min = temp.data;
//                }
//
//                temp = temp.next;
//            }
//
//            return min;
//        }
//
//
//        // CHECK PALINDROME
//        boolean isPalindrome() {
//
//            if (head == null || head.next == null) {
//                return true;
//            }
//
//            // Find middle
//            Node slow = head;
//            Node fast = head;
//
//            while (fast != null && fast.next != null) {
//                slow = slow.next;
//                fast = fast.next.next;
//            }
//
//            // Reverse second half
//            Node secondHalf = reverseFromNode(slow);
//
//            Node firstHalf = head;
//            Node second = secondHalf;
//
//            while (second != null) {
//
//                if (firstHalf.data != second.data) {
//                    return false;
//                }
//
//                firstHalf = firstHalf.next;
//                second = second.next;
//            }
//
//            return true;
//        }
//
//        // Helper method for palindrome
//        Node reverseFromNode(Node node) {
//
//            Node previous = null;
//            Node current = node;
//
//            while (current != null) {
//
//                Node next = current.next;
//
//                current.next = previous;
//
//                previous = current;
//                current = next;
//            }
//
//            return previous;
//        }
//
//
//        // DETECT CYCLE
//        boolean hasCycle() {
//
//            Node slow = head;
//            Node fast = head;
//
//            while (fast != null && fast.next != null) {
//
//                slow = slow.next;
//                fast = fast.next.next;
//
//                if (slow == fast) {
//                    return true;
//                }
//            }
//
//            return false;
//        }
//    }
//
//
//
//    // 2. DOUBLY LINKED LIST
//
//    static class DoublyLinkedList {
//
//        class Node {
//            int data;
//            Node prev;
//            Node next;
//
//            Node(int data) {
//                this.data = data;
//            }
//        }
//
//        Node head;
//
//
//        // INSERT AT BEGINNING
//        void insertFirst(int data) {
//
//            Node newNode = new Node(data);
//
//            if (head == null) {
//                head = newNode;
//                return;
//            }
//
//            newNode.next = head;
//            head.prev = newNode;
//            head = newNode;
//        }
//
//
//        // INSERT AT END
//        void insertLast(int data) {
//
//            Node newNode = new Node(data);
//
//            if (head == null) {
//                head = newNode;
//                return;
//            }
//
//            Node temp = head;
//
//            while (temp.next != null) {
//                temp = temp.next;
//            }
//
//            temp.next = newNode;
//            newNode.prev = temp;
//        }
//
//
//        // DELETE FIRST
//        void deleteFirst() {
//
//            if (head == null) {
//                return;
//            }
//
//            head = head.next;
//
//            if (head != null) {
//                head.prev = null;
//            }
//        }
//
//
//        // DELETE LAST
//        void deleteLast() {
//
//            if (head == null) {
//                return;
//            }
//
//            if (head.next == null) {
//                head = null;
//                return;
//            }
//
//            Node temp = head;
//
//            while (temp.next != null) {
//                temp = temp.next;
//            }
//
//            temp.prev.next = null;
//        }
//
//
//        // DISPLAY FORWARD
//        void displayForward() {
//
//            Node temp = head;
//
//            while (temp != null) {
//
//                System.out.print(temp.data + " <-> ");
//
//                temp = temp.next;
//            }
//
//            System.out.println("null");
//        }
//
//        // DISPLAY BACKWARD
//        void displayBackward() {
//
//            if (head == null) {
//                return;
//            }
//
//            Node temp = head;
//
//            while (temp.next != null) {
//                temp = temp.next;
//            }
//
//            while (temp != null) {
//
//                System.out.print(temp.data + " <-> ");
//
//                temp = temp.prev;
//            }
//
//            System.out.println("null");
//        }
//    }
//
//
//
//    // 3. CIRCULAR LINKED LIST
//
//    static class CircularLinkedList {
//
//        class Node {
//            int data;
//            Node next;
//
//            Node(int data) {
//                this.data = data;
//            }
//        }
//
//        Node head;
//
//        // INSERT AT BEGINNING
//        void insertFirst(int data) {
//
//            Node newNode = new Node(data);
//
//            if (head == null) {
//
//                head = newNode;
//                newNode.next = head;
//
//                return;
//            }
//
//            Node temp = head;
//
//            while (temp.next != head) {
//                temp = temp.next;
//            }
//
//            newNode.next = head;
//            temp.next = newNode;
//            head = newNode;
//        }
//
//        // INSERT AT END
//        void insertLast(int data) {
//
//            Node newNode = new Node(data);
//
//            if (head == null) {
//
//                head = newNode;
//                newNode.next = head;
//
//                return;
//            }
//
//            Node temp = head;
//
//            while (temp.next != head) {
//                temp = temp.next;
//            }
//
//            temp.next = newNode;
//            newNode.next = head;
//        }
//
//        // DELETE FIRST
//        void deleteFirst() {
//
//            if (head == null) {
//                return;
//            }
//
//            // Only one node
//            if (head.next == head) {
//                head = null;
//                return;
//            }
//
//            Node temp = head;
//
//            while (temp.next != head) {
//                temp = temp.next;
//            }
//
//            temp.next = head.next;
//            head = head.next;
//        }
//
//        // DELETE LAST
//        void deleteLast() {
//
//            if (head == null) {
//                return;
//            }
//
//            if (head.next == head) {
//                head = null;
//                return;
//            }
//
//            Node temp = head;
//
//            while (temp.next.next != head) {
//                temp = temp.next;
//            }
//
//            temp.next = head;
//        }
//
//        // DISPLAY
//        void display() {
//
//            if (head == null) {
//                System.out.println("List is empty");
//                return;
//            }
//
//            Node temp = head;
//
//            do {
//
//                System.out.print(temp.data + " -> ");
//
//                temp = temp.next;
//
//            } while (temp != head);
//
//            System.out.println("(back to head)");
//        }
//    }
//
//
//    // MAIN METHOD
//
//    public static void main(String[] args) {
//
//        // SINGLY LINKED LIST TEST
//
//        System.out.println("===== SINGLY LINKED LIST =====");
//
//        SinglyLinkedList list = new SinglyLinkedList();
//
//        list.insertLast(10);
//        list.insertLast(20);
//        list.insertLast(30);
//        list.insertLast(40);
//
//        System.out.println("Original:");
//        list.display();
//
//        list.insertFirst(5);
//
//        System.out.println("After insertFirst(5):");
//        list.display();
//
//        list.insertAtPosition(25, 4);
//
//        System.out.println("After insertAtPosition(25, 4):");
//        list.display();
//
//        System.out.println("Length: " + list.length());
//
//        System.out.println("Search 30: " + list.search(30));
//
//        System.out.println("Middle: " + list.findMiddle());
//
//        System.out.println("2nd node from end: "
//                + list.nthFromEnd(2));
//
//        System.out.println("Maximum: " + list.findMax());
//
//        System.out.println("Minimum: " + list.findMin());
//
//        System.out.println("Count of 20: "
//                + list.countValue(20));
//
//        list.deleteFirst();
//
//        System.out.println("After deleteFirst():");
//        list.display();
//
//        list.deleteLast();
//
//        System.out.println("After deleteLast():");
//        list.display();
//
//        list.deleteValue(20);
//
//        System.out.println("After deleteValue(20):");
//        list.display();
//
//        list.insertLast(20);
//        list.insertLast(10);
//
//        System.out.println("Before reverse:");
//        list.display();
//
//        list.reverse();
//
//        System.out.println("After reverse:");
//        list.display();
//
//        System.out.println("Is Palindrome: "
//                + list.isPalindrome());
//
//        System.out.println("Has Cycle: "
//                + list.hasCycle());
//
//
//        // DOUBLY LINKED LIST TEST
//
//        System.out.println();
//        System.out.println("===== DOUBLY LINKED LIST =====");
//
//        DoublyLinkedList doubly = new DoublyLinkedList();
//
//        doubly.insertLast(10);
//        doubly.insertLast(20);
//        doubly.insertLast(30);
//
//        doubly.insertFirst(5);
//
//        System.out.println("Forward:");
//        doubly.displayForward();
//
//        System.out.println("Backward:");
//        doubly.displayBackward();
//
//        doubly.deleteFirst();
//
//        System.out.println("After deleteFirst():");
//        doubly.displayForward();
//
//        doubly.deleteLast();
//
//        System.out.println("After deleteLast():");
//        doubly.displayForward();
//
//
//
//        // CIRCULAR LINKED LIST TEST
//
//        System.out.println();
//        System.out.println("===== CIRCULAR LINKED LIST =====");
//
//        CircularLinkedList circular =
//                new CircularLinkedList();
//
//        circular.insertLast(10);
//        circular.insertLast(20);
//        circular.insertLast(30);
//
//        circular.insertFirst(5);
//
//        System.out.println("Circular list:");
//        circular.display();
//
//        circular.deleteFirst();
//
//        System.out.println("After deleteFirst():");
//        circular.display();
//
//        circular.deleteLast();
//
//        System.out.println("After deleteLast():");
//        circular.display();
//    }
//}
//
//
//
//
//
//
class LinkedList {

    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    Node head = null;

    // Insert at end
    void insert(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            return;
        }

        Node temp = head;

        while (temp.next != null) {
            temp = temp.next;
        }

        temp.next = newNode;
    }

    // Insert newData after existingData
    void insertAfter(int existingData, int newData) {

        Node temp = head;

        // Find the node containing existingData
        while (temp != null && temp.data != existingData) {
            temp = temp.next;
        }

        // Element not found
        if (temp == null) {
            System.out.println(existingData + " not found");
            return;
        }

        // Create new node
        Node newNode = new Node(newData);

        // Connect new node
        newNode.next = temp.next;

        // Connect existing node to new node
        temp.next = newNode;
    }

    // Display list
    void display() {
        Node temp = head;

        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }

        System.out.println("null");
    }

    public static void main(String[] args) {

        LinkedList list = new LinkedList();

        list.insert(10);
        list.insert(20);
        list.insert(30);
        list.insert(40);

        System.out.println("Before insertion:");
        list.display();

        // Insert 25 after 20
        list.insertAfter(20, 25);

        System.out.println("After insertion:");
        list.display();
    }
}