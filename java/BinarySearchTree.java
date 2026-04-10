/**
 * Binary Search Tree (BST) in Java
 * ==================================
 * A BST is a tree where every node satisfies:
 *   left child  < parent  ≤  right child
 *
 * This property makes searching very efficient.
 *
 * Complexities (balanced BST):
 *   Insert : O(log n)
 *   Search : O(log n)
 *   Delete : O(log n)
 * Worst case (sorted input – degenerates to a linked list): O(n)
 *
 * Traversals:
 *   In-order   (Left → Root → Right) → sorted ascending order
 *   Pre-order  (Root → Left → Right) → copy/serialise a tree
 *   Post-order (Left → Right → Root) → deletion of tree
 */

import java.util.ArrayList;
import java.util.List;

public class BinarySearchTree {

    // ── Node ─────────────────────────────────────────────────────────────────
    private static class Node {
        int value;
        Node left, right;
        Node(int value) { this.value = value; }
    }

    private Node root;

    // ── Insert ───────────────────────────────────────────────────────────────
    public void insert(int value) { root = insert(root, value); }

    private Node insert(Node node, int value) {
        if (node == null) return new Node(value);
        if (value < node.value)       node.left  = insert(node.left,  value);
        else                          node.right = insert(node.right, value);
        return node;
    }

    // ── Search ───────────────────────────────────────────────────────────────
    public boolean search(int value) { return search(root, value); }

    private boolean search(Node node, int value) {
        if (node == null) return false;
        if (value == node.value) return true;
        return value < node.value ? search(node.left, value)
                                  : search(node.right, value);
    }

    // ── Delete ───────────────────────────────────────────────────────────────
    public void delete(int value) { root = delete(root, value); }

    private Node delete(Node node, int value) {
        if (node == null) return null;
        if (value < node.value)       node.left  = delete(node.left,  value);
        else if (value > node.value)  node.right = delete(node.right, value);
        else {
            // Case 1 & 2: 0 or 1 child
            if (node.left == null)  return node.right;
            if (node.right == null) return node.left;
            // Case 3: 2 children – replace with in-order successor
            Node successor = minNode(node.right);
            node.value = successor.value;
            node.right = delete(node.right, successor.value);
        }
        return node;
    }

    private Node minNode(Node node) {
        while (node.left != null) node = node.left;
        return node;
    }

    // ── Traversals ───────────────────────────────────────────────────────────
    public List<Integer> inorder() {
        List<Integer> result = new ArrayList<>();
        inorder(root, result);
        return result;
    }
    private void inorder(Node node, List<Integer> result) {
        if (node == null) return;
        inorder(node.left, result);
        result.add(node.value);
        inorder(node.right, result);
    }

    public List<Integer> preorder() {
        List<Integer> result = new ArrayList<>();
        preorder(root, result);
        return result;
    }
    private void preorder(Node node, List<Integer> result) {
        if (node == null) return;
        result.add(node.value);
        preorder(node.left, result);
        preorder(node.right, result);
    }

    public List<Integer> postorder() {
        List<Integer> result = new ArrayList<>();
        postorder(root, result);
        return result;
    }
    private void postorder(Node node, List<Integer> result) {
        if (node == null) return;
        postorder(node.left, result);
        postorder(node.right, result);
        result.add(node.value);
    }

    // ── Height ───────────────────────────────────────────────────────────────
    public int height() { return height(root); }
    private int height(Node node) {
        if (node == null) return 0;
        return 1 + Math.max(height(node.left), height(node.right));
    }

    // ── Demo ─────────────────────────────────────────────────────────────────
    public static void main(String[] args) {
        System.out.println("=== Binary Search Tree ===\n");

        BinarySearchTree bst = new BinarySearchTree();
        int[] values = {50, 30, 70, 20, 40, 60, 80};
        System.out.print("Inserted         : ");
        for (int v : values) { bst.insert(v); System.out.print(v + " "); }
        System.out.println();

        System.out.println("In-order (sorted): " + bst.inorder());
        System.out.println("Pre-order        : " + bst.preorder());
        System.out.println("Post-order       : " + bst.postorder());
        System.out.println("Height           : " + bst.height());

        System.out.println("\nSearch 40        : " + bst.search(40)); // true
        System.out.println("Search 99        : " + bst.search(99));  // false

        bst.delete(30);
        System.out.println("\nAfter delete 30  : " + bst.inorder());

        bst.delete(50);   // delete root
        System.out.println("After delete 50  : " + bst.inorder());
    }
}
