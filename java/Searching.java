/**
 * Searching Algorithms in Java
 * =============================
 *
 * Linear Search  – O(n)
 * ----------------------
 * Check every element one by one until the target is found or the array ends.
 * Works on UNSORTED data.
 *
 * Binary Search  – O(log n)
 * --------------------------
 * Repeatedly halve the search space by comparing the target with the middle
 * element. The array MUST be SORTED first.
 *
 * Comparison:
 *   Algorithm      | Best | Average  | Worst    | Sorted required?
 *   ---------------+------+----------+----------+-----------------
 *   Linear Search  | O(1) | O(n)     | O(n)     | No
 *   Binary Search  | O(1) | O(log n) | O(log n) | Yes
 */

import java.util.Arrays;

public class Searching {

    // ── Linear Search ─────────────────────────────────────────────────────────
    /**
     * Search for target in arr by checking each element.
     * Returns the index of the first match, or -1 if not found.
     * Time: O(n)  |  Space: O(1)
     */
    public static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) return i;
        }
        return -1;
    }

    // ── Binary Search (iterative) ─────────────────────────────────────────────
    /**
     * Search for target in a SORTED arr by halving the search space each step.
     * Returns the index of the match, or -1 if not found.
     * Time: O(log n)  |  Space: O(1)
     */
    public static int binarySearch(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2; // avoids integer overflow
            if (arr[mid] == target)      return mid;
            else if (arr[mid] < target)  left  = mid + 1; // target in right half
            else                         right = mid - 1; // target in left half
        }
        return -1;
    }

    // ── Binary Search (recursive) ─────────────────────────────────────────────
    /**
     * Recursive binary search.
     * Time: O(log n)  |  Space: O(log n) due to call-stack depth
     */
    public static int binarySearchRecursive(int[] arr, int target, int left, int right) {
        if (left > right) return -1;
        int mid = left + (right - left) / 2;
        if (arr[mid] == target)     return mid;
        if (arr[mid] < target)      return binarySearchRecursive(arr, target, mid + 1, right);
        return binarySearchRecursive(arr, target, left, mid - 1);
    }

    // ── Demo ──────────────────────────────────────────────────────────────────
    public static void main(String[] args) {
        int[] unsorted = {64, 25, 12, 22, 11, 90, 45};
        int[] sorted   = unsorted.clone();
        Arrays.sort(sorted);   // [11, 12, 22, 25, 45, 64, 90]

        System.out.println("=== Searching Algorithms ===\n");
        System.out.println("Unsorted: " + Arrays.toString(unsorted));
        System.out.println("Sorted  : " + Arrays.toString(sorted));

        // Linear search
        System.out.println("\n--- Linear Search (works on unsorted) ---");
        int[] targets = {22, 90, 100};
        for (int t : targets) {
            int idx = linearSearch(unsorted, t);
            System.out.printf("  Search %3d : %s%n",
                t, idx != -1 ? "found at index " + idx : "NOT found");
        }

        // Binary search (iterative)
        System.out.println("\n--- Binary Search iterative (requires sorted) ---");
        for (int t : targets) {
            int idx = binarySearch(sorted, t);
            System.out.printf("  Search %3d : %s%n",
                t, idx != -1 ? "found at index " + idx + " in sorted array" : "NOT found");
        }

        // Binary search (recursive)
        System.out.println("\n--- Binary Search recursive (requires sorted) ---");
        int[] targets2 = {11, 64, 55};
        for (int t : targets2) {
            int idx = binarySearchRecursive(sorted, t, 0, sorted.length - 1);
            System.out.printf("  Search %3d : %s%n",
                t, idx != -1 ? "found at index " + idx + " in sorted array" : "NOT found");
        }

        // Step-by-step walkthrough
        System.out.println("\n--- Step-by-step binary search for 45 ---");
        int target = 45;
        int left = 0, right = sorted.length - 1, step = 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            System.out.printf("  Step %d: left=%d, right=%d, mid=%d, sorted[mid]=%d%n",
                step++, left, right, mid, sorted[mid]);
            if (sorted[mid] == target) { System.out.println("  Found " + target + " at index " + mid + "!"); break; }
            else if (sorted[mid] < target) left  = mid + 1;
            else                           right = mid - 1;
        }
    }
}
