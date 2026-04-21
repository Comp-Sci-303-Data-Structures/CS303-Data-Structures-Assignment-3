/*
 * CS-303 Assignment 3
 * Yenghoua Lee
 * April 20, 2026
 * 
 * Question 1: Create Queue data structure
 */

public class Q1_Queue<T> {

    private static class Node<T> {
        T data;
        Node<T> next;
 
        Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node<T> front; // points to the first element
    private Node<T> rear;  // points to the last element
    private int size;      // number of elements currently in the queue
 
    // Constructor
    public Q1_Queue() {
        front = null;
        rear  = null;
        size  = 0;
    }
 
    // offer(T item) – add item to the rear of the queue
    public void offer(T item) {
        Node<T> newNode = new Node<>(item);
 
        if (empty()) {
            // queue was empty: both front and rear point to the new node
            front = newNode;
            rear  = newNode;
        } else {
            rear.next = newNode; // link current rear to new node
            rear      = newNode; // advance rear pointer
        }
        size++;
    }
 
    // poll() – remove and return the front element; null if empty
    public T poll() {
        if (empty()) {
            System.out.println("Queue is empty – poll() returned null.");
            return null;
        }
        T data  = front.data; // save the value to return
        front   = front.next; // advance front pointer
        size--;
 
        if (front == null) {  // queue just became empty
            rear = null;
        }
        return data;
    }
 
    // peek() – return the front element without removing it; null if empty
    public T peek() {
        if (empty()) {
            System.out.println("Queue is empty – peek() returned null.");
            return null;
        }
        return front.data;
    }
 
    // size() – return the number of elements in the queue
    public int size() {
        return size;
    }
 
    // empty() – return true if the queue contains no elements
    public boolean empty() {
        return size == 0;
    }
 
   
    // move_to_rear() – moves the front element to the rear of the queue.
    // Uses only offer(), poll(), and peek() as required.
    public void move_to_rear() {
        if (empty()) {
            System.out.println("Queue is empty – nothing to move.");
            return;
        }
        // peek the front element, poll it off the front, then offer it at the rear
        T frontValue = peek();
        poll();
        offer(frontValue);
    }
 
    // display() – prints every element using only queue operations.
    // Elements are polled off, printed, then re-offered so the queue
    // is restored to its original state and order.
    public void display() {
        if (empty()) {
            System.out.println("Queue is empty.");
            return;
        }
 
        System.out.print("Queue (front → rear): ");
        int currentSize = size(); // snapshot the size
 
        // Cycle through every element: poll → print → re-offer
        for (int i = 0; i < currentSize; i++) {
            T value = poll();
            System.out.print(value);
            if (i < currentSize - 1) System.out.print(" → ");
            offer(value); // put it back at the rear
        }
        System.out.println();
    }
 
    // main – demonstrates Q1 parts (a), (b), and (c)
    public static void main(String[] args) {
 
        // ---- Part (a): Instantiate with integers, push 10 values ----
        System.out.println("=== Q1 Part (a): Push 10 integers ===");
        Q1_Queue<Integer> queue = new Q1_Queue<>();
        for (int i = 10; i <= 100; i += 10) { // 10, 20, 30 … 100
            queue.offer(i);
            System.out.println("  Offered: " + i + "  | size = " + queue.size());
        }
 
        // ---- Part (b): Display all elements using queue functions ----
        System.out.println("\n=== Q1 Part (b): Display all elements ===");
        queue.display();
 
        System.out.println("  peek()  = " + queue.peek());   // should be 10
        System.out.println("  size()  = " + queue.size());   // should be 10
        System.out.println("  empty() = " + queue.empty());  // should be false
 
        // ---- Part (c): move_to_rear ----
        System.out.println("\n=== Q1 Part (c): move_to_rear ===");
        System.out.print("Before move_to_rear – ");
        queue.display();
 
        queue.move_to_rear();
        System.out.print("After  move_to_rear – ");
        queue.display();
 
        // Call it a second time to further verify
        queue.move_to_rear();
        System.out.print("After 2nd move_to_rear – ");
        queue.display();
    }
}
 