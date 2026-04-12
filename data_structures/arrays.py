"""
Arrays (Lists in Python)
========================
An array stores elements in contiguous memory locations.
In Python the built-in list acts as a dynamic array.

Complexities (for a list of n elements):
  Access by index : O(1)
  Search          : O(n)
  Append          : O(1) amortised
  Insert at index : O(n)
  Delete at index : O(n)
"""


def demonstrate_arrays():
    # ── Create ──────────────────────────────────────────────────────────────
    numbers = [10, 20, 30, 40, 50]
    print("Initial array:", numbers)

    # ── Access  – O(1) ──────────────────────────────────────────────────────
    print("Element at index 2:", numbers[2])      # 30
    print("Last element      :", numbers[-1])     # 50

    # ── Search  – O(n) ──────────────────────────────────────────────────────
    target = 30
    found_index = -1
    for i, val in enumerate(numbers):
        if val == target:
            found_index = i
            break
    print(f"Search {target}: found at index {found_index}")

    # ── Insert  – O(n) ──────────────────────────────────────────────────────
    numbers.insert(2, 25)          # insert 25 before index 2
    print("After insert(2, 25):", numbers)

    # ── Append  – O(1) amortised ────────────────────────────────────────────
    numbers.append(60)
    print("After append(60)   :", numbers)

    # ── Delete  – O(n) ──────────────────────────────────────────────────────
    numbers.pop(2)                 # remove element at index 2
    print("After pop(2)       :", numbers)

    # ── Slice   – O(k) where k = slice length ───────────────────────────────
    print("Slice [1:4]        :", numbers[1:4])

    # ── 2-D array (matrix) ──────────────────────────────────────────────────
    matrix = [
        [1, 2, 3],
        [4, 5, 6],
        [7, 8, 9],
    ]
    print("\n2-D array (matrix):")
    for row in matrix:
        print(" ", row)
    print("Element at row 1, col 2:", matrix[1][2])   # 6


if __name__ == "__main__":
    demonstrate_arrays()
