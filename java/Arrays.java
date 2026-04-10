/**
 * Arrays in Java
 * ==============
 * Java arrays are fixed-size, contiguous blocks of memory.
 * java.util.ArrayList acts as a dynamic (resizable) array.
 *
 * Complexities (for an array / ArrayList of n elements):
 *   Access by index : O(1)
 *   Search          : O(n)
 *   Append          : O(1) amortised  (ArrayList)
 *   Insert at index : O(n)
 *   Delete at index : O(n)
 */

import java.util.ArrayList;
import java.util.List;

public class Arrays {

    public static void main(String[] args) {

        // ── Fixed-size array ─────────────────────────────────────────────
        int[] fixed = {10, 20, 30, 40, 50};
        System.out.println("Fixed array : " + java.util.Arrays.toString(fixed));

        // Access – O(1)
        System.out.println("Index 2     : " + fixed[2]);   // 30
        System.out.println("Last element: " + fixed[fixed.length - 1]); // 50

        // Search – O(n)
        int target = 30;
        int foundIndex = -1;
        for (int i = 0; i < fixed.length; i++) {
            if (fixed[i] == target) { foundIndex = i; break; }
        }
        System.out.println("Search " + target + "  : index " + foundIndex);

        // ── Dynamic array (ArrayList) ────────────────────────────────────
        System.out.println("\n--- ArrayList (dynamic array) ---");
        ArrayList<Integer> list = new ArrayList<>(List.of(10, 20, 30, 40, 50));
        System.out.println("Initial     : " + list);

        list.add(60);                  // Append – O(1) amortised
        System.out.println("After add(60)       : " + list);

        list.add(2, 25);               // Insert at index – O(n)
        System.out.println("After add(2,25)     : " + list);

        list.remove(Integer.valueOf(25)); // Delete by value – O(n)
        System.out.println("After remove(25)    : " + list);

        System.out.println("Sublist [1,4)       : " + list.subList(1, 4));

        // ── 2-D array (matrix) ───────────────────────────────────────────
        System.out.println("\n--- 2-D array (matrix) ---");
        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        for (int[] row : matrix) {
            System.out.println("  " + java.util.Arrays.toString(row));
        }
        System.out.println("Row 1, Col 2: " + matrix[1][2]); // 6
    }
}
