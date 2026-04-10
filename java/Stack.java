/**
 * Stack (Last-In, First-Out – LIFO) in Java
 * ==========================================
 * A stack lets you add and remove items only from the top.
 * Implemented here with a singly linked list (no array resizing needed).
 *
 * Real-world uses:
 *   - Undo / redo in editors
 *   - Browser back navigation
 *   - Function call stack
 *   - Balanced parentheses checking
 *
 * Complexities (all O(1)):
 *   push, pop, peek, isEmpty, size
 */

public class Stack {

    // ── Internal Node ────────────────────────────────────────────────────────
    private static class Node {
        int data;
        Node next;
        Node(int data) { this.data = data; }
    }

    private Node top;
    private int size;

    /** Add item to the top – O(1). */
    public void push(int item) {
        Node newNode = new Node(item);
        newNode.next = top;
        top = newNode;
        size++;
    }

    /** Remove and return the top item – O(1). */
    public int pop() {
        if (isEmpty()) throw new java.util.EmptyStackException();
        int value = top.data;
        top = top.next;
        size--;
        return value;
    }

    /** Return the top item without removing it – O(1). */
    public int peek() {
        if (isEmpty()) throw new java.util.EmptyStackException();
        return top.data;
    }

    /** Return true if the stack is empty – O(1). */
    public boolean isEmpty() { return top == null; }

    /** Return the number of items – O(1). */
    public int size() { return size; }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Stack (top→bottom): [");
        Node current = top;
        while (current != null) {
            sb.append(current.data);
            if (current.next != null) sb.append(", ");
            current = current.next;
        }
        return sb.append("]").toString();
    }

    // ── Practical example: balanced parentheses ──────────────────────────────
    public static boolean isBalanced(String expr) {
        Stack stack = new Stack();
        for (char ch : expr.toCharArray()) {
            if (ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch);
            } else if (ch == ')' || ch == ']' || ch == '}') {
                if (stack.isEmpty()) return false;
                char open = (char) stack.pop();
                if ((ch == ')' && open != '(') ||
                    (ch == ']' && open != '[') ||
                    (ch == '}' && open != '{')) return false;
            }
        }
        return stack.isEmpty();
    }

    // ── Demo ─────────────────────────────────────────────────────────────────
    public static void main(String[] args) {
        System.out.println("=== Stack (LIFO) ===\n");

        Stack s = new Stack();
        s.push(1); s.push(2); s.push(3);
        System.out.println(s);
        System.out.println("Peek     : " + s.peek());    // 3
        System.out.println("Pop      : " + s.pop());     // 3
        System.out.println("Pop      : " + s.pop());     // 2
        System.out.println("Size     : " + s.size());    // 1
        System.out.println("IsEmpty  : " + s.isEmpty()); // false
        s.pop();
        System.out.println("IsEmpty  : " + s.isEmpty()); // true

        System.out.println("\n--- Balanced parentheses ---");
        String[] tests = {"([]{})", "([)]", "((())", "{[()]}"};
        for (String t : tests) {
            System.out.printf("  %-10s → %b%n", t, isBalanced(t));
        }
    }
}
