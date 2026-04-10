/**
 * Queue (First-In, First-Out – FIFO) in Java
 * ===========================================
 * A queue lets you add items at the rear and remove from the front.
 * Implemented here with a singly linked list for O(1) enqueue AND dequeue.
 *
 * Real-world uses:
 *   - Print spooler / task scheduling
 *   - Breadth-first search (BFS)
 *   - Streaming / buffering data
 *
 * Complexities (all O(1)):
 *   enqueue, dequeue, peek, isEmpty, size
 */

public class Queue {

    // ── Internal Node ────────────────────────────────────────────────────────
    private static class Node {
        int data;
        Node next;
        Node(int data) { this.data = data; }
    }

    private Node front;  // removed from here
    private Node rear;   // added here
    private int size;

    /** Add item to the rear – O(1). */
    public void enqueue(int item) {
        Node newNode = new Node(item);
        if (rear != null) rear.next = newNode;
        rear = newNode;
        if (front == null) front = newNode;
        size++;
    }

    /** Remove and return the front item – O(1). */
    public int dequeue() {
        if (isEmpty()) throw new java.util.NoSuchElementException("Queue is empty");
        int value = front.data;
        front = front.next;
        if (front == null) rear = null;
        size--;
        return value;
    }

    /** Return the front item without removing it – O(1). */
    public int peek() {
        if (isEmpty()) throw new java.util.NoSuchElementException("Queue is empty");
        return front.data;
    }

    /** Return true if the queue is empty – O(1). */
    public boolean isEmpty() { return front == null; }

    /** Return the number of items – O(1). */
    public int size() { return size; }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Queue (front→rear): [");
        Node current = front;
        while (current != null) {
            sb.append(current.data);
            if (current.next != null) sb.append(", ");
            current = current.next;
        }
        return sb.append("]").toString();
    }

    // ── Demo ─────────────────────────────────────────────────────────────────
    public static void main(String[] args) {
        System.out.println("=== Queue (FIFO) ===\n");

        Queue q = new Queue();
        q.enqueue(1); q.enqueue(2); q.enqueue(3);
        System.out.println(q);
        System.out.println("Peek    : " + q.peek());      // 1
        System.out.println("Dequeue : " + q.dequeue());   // 1
        System.out.println("Dequeue : " + q.dequeue());   // 2
        System.out.println("Size    : " + q.size());      // 1
        System.out.println(q);

        System.out.println("\n--- Task processor ---");
        String[] tasks = {"Print doc", "Send email", "Compile code"};
        // Use Java's built-in ArrayDeque for string tasks
        java.util.ArrayDeque<String> taskQueue = new java.util.ArrayDeque<>();
        for (String t : tasks) {
            taskQueue.offer(t);
            System.out.println("  Enqueued : " + t);
        }
        System.out.println();
        while (!taskQueue.isEmpty()) {
            System.out.println("  Processing: " + taskQueue.poll());
        }
    }
}
