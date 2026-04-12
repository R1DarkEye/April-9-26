/**
 * Sorting Algorithms in Java
 * ===========================
 *
 * Algorithm      | Best      | Average   | Worst     | Space   | Stable?
 * ---------------+-----------+-----------+-----------+---------+--------
 * Bubble Sort    | O(n)      | O(n²)     | O(n²)     | O(1)    | Yes
 * Selection Sort | O(n²)     | O(n²)     | O(n²)     | O(1)    | No
 * Insertion Sort | O(n)      | O(n²)     | O(n²)     | O(1)    | Yes
 * Merge Sort     | O(n log n)| O(n log n)| O(n log n)| O(n)    | Yes
 * Quick Sort     | O(n log n)| O(n log n)| O(n²)     | O(log n)| No
 *
 * Java's built-in Arrays.sort() uses a dual-pivot Quicksort for primitives
 * and TimSort (merge + insertion hybrid) for objects – both O(n log n).
 */

import java.util.Arrays;

public class Sorting {

    // ── Bubble Sort ───────────────────────────────────────────────────────────
    /**
     * Repeatedly swap adjacent elements that are out of order.
     * Time: O(n²) avg/worst, O(n) best (early exit)  |  Space: O(1)
     */
    public static int[] bubbleSort(int[] input) {
        int[] arr = input.clone();
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            boolean swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j]; arr[j] = arr[j + 1]; arr[j + 1] = tmp;
                    swapped = true;
                }
            }
            if (!swapped) break; // early exit
        }
        return arr;
    }

    // ── Selection Sort ────────────────────────────────────────────────────────
    /**
     * Find the minimum element and move it to the front of the unsorted portion.
     * Time: O(n²) always  |  Space: O(1)
     */
    public static int[] selectionSort(int[] input) {
        int[] arr = input.clone();
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            int minIdx = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIdx]) minIdx = j;
            }
            int tmp = arr[i]; arr[i] = arr[minIdx]; arr[minIdx] = tmp;
        }
        return arr;
    }

    // ── Insertion Sort ────────────────────────────────────────────────────────
    /**
     * Build sorted list one element at a time by inserting each new element
     * into its correct position in the already-sorted prefix.
     * Time: O(n²) avg/worst, O(n) best  |  Space: O(1)
     */
    public static int[] insertionSort(int[] input) {
        int[] arr = input.clone();
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) { arr[j + 1] = arr[j]; j--; }
            arr[j + 1] = key;
        }
        return arr;
    }

    // ── Merge Sort ────────────────────────────────────────────────────────────
    /**
     * Divide array in half, sort each half, merge them back together.
     * Time: O(n log n) always  |  Space: O(n)
     */
    public static int[] mergeSort(int[] input) {
        if (input.length <= 1) return input.clone();
        int mid = input.length / 2;
        int[] left  = mergeSort(Arrays.copyOfRange(input, 0,   mid));
        int[] right = mergeSort(Arrays.copyOfRange(input, mid, input.length));
        return merge(left, right);
    }

    private static int[] merge(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];
        int i = 0, j = 0, k = 0;
        while (i < left.length && j < right.length) {
            result[k++] = (left[i] <= right[j]) ? left[i++] : right[j++];
        }
        while (i < left.length)  result[k++] = left[i++];
        while (j < right.length) result[k++] = right[j++];
        return result;
    }

    // ── Quick Sort ────────────────────────────────────────────────────────────
    /**
     * Pick a pivot, partition into elements < pivot and > pivot, sort each part.
     * Time: O(n log n) avg, O(n²) worst  |  Space: O(log n) call-stack
     */
    public static int[] quickSort(int[] input) {
        int[] arr = input.clone();
        quickSortHelper(arr, 0, arr.length - 1);
        return arr;
    }

    private static void quickSortHelper(int[] arr, int low, int high) {
        if (low >= high) return;
        int pivotIdx = partition(arr, low, high);
        quickSortHelper(arr, low,         pivotIdx - 1);
        quickSortHelper(arr, pivotIdx + 1, high);
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high]; // choose last element as pivot
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                int tmp = arr[i]; arr[i] = arr[j]; arr[j] = tmp;
            }
        }
        int tmp = arr[i + 1]; arr[i + 1] = arr[high]; arr[high] = tmp;
        return i + 1;
    }

    // ── Demo ──────────────────────────────────────────────────────────────────
    public static void main(String[] args) {
        int[] original = {64, 25, 12, 22, 11, 90, 45, 38};
        System.out.println("=== Sorting Algorithms ===\n");
        System.out.println("Original      : " + Arrays.toString(original));
        System.out.println();

        System.out.println("Bubble Sort   : " + Arrays.toString(bubbleSort(original)));
        System.out.println("Selection Sort: " + Arrays.toString(selectionSort(original)));
        System.out.println("Insertion Sort: " + Arrays.toString(insertionSort(original)));
        System.out.println("Merge Sort    : " + Arrays.toString(mergeSort(original)));
        System.out.println("Quick Sort    : " + Arrays.toString(quickSort(original)));

        int[] builtin = original.clone();
        Arrays.sort(builtin);
        System.out.println("Arrays.sort() : " + Arrays.toString(builtin));

        // Step-by-step bubble sort
        System.out.println("\n--- Bubble Sort step-by-step on [5, 3, 1, 4] ---");
        int[] arr = {5, 3, 1, 4};
        int n = arr.length, step = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j]; arr[j] = arr[j + 1]; arr[j + 1] = tmp;
                    System.out.println("  Swap step " + (++step) + ": " + Arrays.toString(arr));
                }
            }
        }
    }
}
