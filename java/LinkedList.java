/**
 * Singly Linked List in Java
 * ==========================
 * A chain of nodes where each node holds a value and a reference to the
 * next node. Unlike an array, nodes are NOT stored contiguously in memory,
 * so random access is O(n).
 *
 * Complexities:
 *   Prepend (insert at head) : O(1)
 *   Append  (insert at tail) : O(n)
 *   Search                   : O(n)
 *   Delete                   : O(n)
 *   Access by index          : O(n)
 */

public class LinkedList {

    // ── Node ────────────────────────────────────────────────────────────────
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // ── LinkedList class ─────────────────────────────────────────────────────
    Node head;

    /** Insert a new node at the beginning – O(1). */
    public void prepend(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    /** Insert a new node at the end – O(n). */
    public void append(int data) {
        Node newNode = new Node(data);
        if (head == null) { head = newNode; return; }
        Node current = head;
        while (current.next != null) current = current.next;
        current.next = newNode;
    }

    /** Return true if target exists in the list – O(n). */
    public boolean search(int target) {
        Node current = head;
        while (current != null) {
            if (current.data == target) return true;
            current = current.next;
        }
        return false;
    }

    /** Remove the first node whose data equals target – O(n). */
    public void delete(int target) {
        if (head == null) return;
        if (head.data == target) { head = head.next; return; }
        Node current = head;
        while (current.next != null) {
            if (current.next.data == target) {
                current.next = current.next.next; // skip over the target node
                return;
            }
            current = current.next;
        }
    }

    /** Return a string representation of the list. */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node current = head;
        while (current != null) {
            sb.append(current.data).append(" -> ");
            current = current.next;
        }
        sb.append("null");
        return sb.toString();
    }

    // ── Demo ────────────────────────────────────────────────────────────────
    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        System.out.println("=== Singly Linked List ===\n");

        ll.append(10);
        ll.append(20);
        ll.append(30);
        System.out.println("After append 10,20,30 : " + ll);

        ll.prepend(5);
        System.out.println("After prepend 5       : " + ll);

        System.out.println("Search 20             : " + ll.search(20)); // true
        System.out.println("Search 99             : " + ll.search(99)); // false

        ll.delete(20);
        System.out.println("After delete 20       : " + ll);

        ll.delete(5);   // delete head
        System.out.println("After delete head (5) : " + ll);

        ll.delete(30);  // delete tail
        System.out.println("After delete tail (30): " + ll);
    }
}
