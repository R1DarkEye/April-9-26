"""
Searching Algorithms
=====================

Linear Search  – O(n)
----------------------
Check every element one by one until the target is found or the list ends.
Works on **unsorted** data.

Binary Search  – O(log n)
--------------------------
Repeatedly halve the search space by comparing the target with the middle
element.  The list MUST be **sorted** first.

Comparison:
  Algorithm      | Best | Average | Worst | Requires sorted?
  ---------------+------+---------+-------+-----------------
  Linear Search  | O(1) |  O(n)   | O(n)  | No
  Binary Search  | O(1) | O(log n)| O(log n)| Yes
"""


# ── Linear Search ────────────────────────────────────────────────────────────

def linear_search(arr, target):
    """
    Search for target in arr by checking each element.

    Returns the index of the first match, or -1 if not found.
    Time  : O(n)
    Space : O(1)
    """
    for index, value in enumerate(arr):
        if value == target:
            return index
    return -1


# ── Binary Search (iterative) ────────────────────────────────────────────────

def binary_search(arr, target):
    """
    Search for target in a SORTED arr by halving the search space each step.

    Returns the index of the match, or -1 if not found.
    Time  : O(log n)
    Space : O(1)
    """
    left, right = 0, len(arr) - 1

    while left <= right:
        mid = (left + right) // 2      # avoid potential overflow vs (l+r)/2

        if arr[mid] == target:
            return mid
        elif arr[mid] < target:
            left = mid + 1             # target is in the RIGHT half
        else:
            right = mid - 1            # target is in the LEFT half

    return -1


# ── Binary Search (recursive) ────────────────────────────────────────────────

def binary_search_recursive(arr, target, left=None, right=None):
    """
    Recursive version of binary search.
    Time  : O(log n)
    Space : O(log n)  ← due to call-stack depth
    """
    if left is None:
        left = 0
    if right is None:
        right = len(arr) - 1

    if left > right:
        return -1

    mid = (left + right) // 2
    if arr[mid] == target:
        return mid
    elif arr[mid] < target:
        return binary_search_recursive(arr, target, mid + 1, right)
    else:
        return binary_search_recursive(arr, target, left, mid - 1)


# ── Demo ─────────────────────────────────────────────────────────────────────

def demonstrate_searching():
    unsorted = [64, 25, 12, 22, 11, 90, 45]
    sorted_arr = sorted(unsorted)   # [11, 12, 22, 25, 45, 64, 90]

    print("=== Searching Algorithms ===\n")
    print("Unsorted array:", unsorted)
    print("Sorted array  :", sorted_arr)

    # Linear Search
    print("\n--- Linear Search (works on unsorted) ---")
    for target in [22, 90, 100]:
        idx = linear_search(unsorted, target)
        if idx != -1:
            print(f"  Search {target:>3}: found at index {idx}")
        else:
            print(f"  Search {target:>3}: NOT found")

    # Binary Search (iterative)
    print("\n--- Binary Search iterative (requires sorted) ---")
    for target in [22, 90, 100]:
        idx = binary_search(sorted_arr, target)
        if idx != -1:
            print(f"  Search {target:>3}: found at index {idx} in sorted array")
        else:
            print(f"  Search {target:>3}: NOT found")

    # Binary Search (recursive)
    print("\n--- Binary Search recursive (requires sorted) ---")
    for target in [11, 64, 55]:
        idx = binary_search_recursive(sorted_arr, target)
        if idx != -1:
            print(f"  Search {target:>3}: found at index {idx} in sorted array")
        else:
            print(f"  Search {target:>3}: NOT found")

    # Step-by-step walkthrough
    print("\n--- Step-by-step binary search for 45 ---")
    arr = sorted_arr
    target = 45
    left, right = 0, len(arr) - 1
    step = 1
    while left <= right:
        mid = (left + right) // 2
        print(f"  Step {step}: left={left}, right={right}, mid={mid}, arr[mid]={arr[mid]}")
        if arr[mid] == target:
            print(f"  Found {target} at index {mid}!")
            break
        elif arr[mid] < target:
            left = mid + 1
        else:
            right = mid - 1
        step += 1


if __name__ == "__main__":
    demonstrate_searching()
