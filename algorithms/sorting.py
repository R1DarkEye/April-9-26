"""
Sorting Algorithms
==================

Algorithm      | Best     | Average  | Worst    | Space  | Stable?
---------------+----------+----------+----------+--------+--------
Bubble Sort    | O(n)     | O(n²)    | O(n²)    | O(1)   | Yes
Selection Sort | O(n²)    | O(n²)    | O(n²)    | O(1)   | No
Insertion Sort | O(n)     | O(n²)    | O(n²)    | O(1)   | Yes
Merge Sort     | O(n logn)| O(n logn)| O(n logn)| O(n)   | Yes
Quick Sort     | O(n logn)| O(n logn)| O(n²)    | O(logn)| No

Stable = equal elements keep their original relative order.

Rule of thumb:
  - Small arrays (n < ~20)  → Insertion Sort
  - Large arrays             → Merge Sort or Quick Sort
  - Python built-in          → Timsort (hybrid Merge + Insertion, O(n log n))
"""


# ── Bubble Sort ──────────────────────────────────────────────────────────────

def bubble_sort(arr):
    """
    Repeatedly swap adjacent elements that are out of order.
    After each pass the largest unsorted element "bubbles" to its final position.

    Time : O(n²) average/worst, O(n) best (already sorted with early-exit)
    Space: O(1)
    """
    arr = arr[:]   # work on a copy so we don't mutate the input
    n = len(arr)
    for i in range(n):
        swapped = False
        for j in range(0, n - i - 1):
            if arr[j] > arr[j + 1]:
                arr[j], arr[j + 1] = arr[j + 1], arr[j]
                swapped = True
        if not swapped:   # early exit: list is already sorted
            break
    return arr


# ── Selection Sort ───────────────────────────────────────────────────────────

def selection_sort(arr):
    """
    Find the minimum element in the unsorted portion and place it at the front.

    Time : O(n²) always
    Space: O(1)
    """
    arr = arr[:]
    n = len(arr)
    for i in range(n):
        min_index = i
        for j in range(i + 1, n):
            if arr[j] < arr[min_index]:
                min_index = j
        arr[i], arr[min_index] = arr[min_index], arr[i]
    return arr


# ── Insertion Sort ───────────────────────────────────────────────────────────

def insertion_sort(arr):
    """
    Build the sorted list one element at a time by inserting each new element
    into its correct position in the already-sorted prefix.

    Time : O(n²) average/worst, O(n) best (already sorted)
    Space: O(1)
    """
    arr = arr[:]
    for i in range(1, len(arr)):
        key = arr[i]
        j = i - 1
        while j >= 0 and arr[j] > key:
            arr[j + 1] = arr[j]
            j -= 1
        arr[j + 1] = key
    return arr


# ── Merge Sort ───────────────────────────────────────────────────────────────

def merge_sort(arr):
    """
    Divide the list in half, recursively sort each half, then merge them.
    This is a classic divide-and-conquer algorithm.

    Time : O(n log n) always
    Space: O(n)  – needs auxiliary space for merging
    """
    if len(arr) <= 1:
        return arr[:]

    mid = len(arr) // 2
    left = merge_sort(arr[:mid])
    right = merge_sort(arr[mid:])
    return _merge(left, right)


def _merge(left, right):
    """Merge two sorted lists into one sorted list – O(n)."""
    result = []
    i = j = 0
    while i < len(left) and j < len(right):
        if left[i] <= right[j]:
            result.append(left[i])
            i += 1
        else:
            result.append(right[j])
            j += 1
    result.extend(left[i:])
    result.extend(right[j:])
    return result


# ── Quick Sort ───────────────────────────────────────────────────────────────

def quick_sort(arr):
    """
    Pick a pivot, partition the list into elements ≤ pivot and > pivot,
    then recursively sort each partition.

    Time : O(n log n) average, O(n²) worst (sorted input + bad pivot choice)
    Space: O(log n) average (call-stack depth)
    """
    if len(arr) <= 1:
        return arr[:]
    pivot = arr[len(arr) // 2]              # choose middle element as pivot
    left = [x for x in arr if x < pivot]
    middle = [x for x in arr if x == pivot]
    right = [x for x in arr if x > pivot]
    return quick_sort(left) + middle + quick_sort(right)


# ── Demo ─────────────────────────────────────────────────────────────────────

def demonstrate_sorting():
    original = [64, 25, 12, 22, 11, 90, 45, 38]
    print("=== Sorting Algorithms ===\n")
    print("Original      :", original)
    print()

    algorithms = [
        ("Bubble Sort   ", bubble_sort),
        ("Selection Sort", selection_sort),
        ("Insertion Sort", insertion_sort),
        ("Merge Sort    ", merge_sort),
        ("Quick Sort    ", quick_sort),
    ]

    for name, func in algorithms:
        result = func(original)
        print(f"{name}: {result}")

    # Python built-in
    print(f"Python sorted (): {sorted(original)}")

    # Step-by-step walkthrough for bubble sort
    print("\n--- Bubble Sort step-by-step on [5, 3, 1, 4] ---")
    arr = [5, 3, 1, 4]
    n = len(arr)
    step = 0
    for i in range(n):
        for j in range(0, n - i - 1):
            if arr[j] > arr[j + 1]:
                arr[j], arr[j + 1] = arr[j + 1], arr[j]
                step += 1
                print(f"  Swap step {step}: {arr}")


if __name__ == "__main__":
    demonstrate_sorting()
