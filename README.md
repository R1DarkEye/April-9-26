# Learning DSA – Data Structures & Algorithms

A beginner-friendly reference for learning the most important **Data Structures** and **Algorithms** in Python and Java.

---

## 📚 Table of Contents

1. [Why Learn DSA?](#why-learn-dsa)
2. [Big O Notation – Complexity Cheat Sheet](#big-o-notation)
3. [Data Structures](#data-structures)
   - [Arrays](#arrays)
   - [Linked List](#linked-list)
   - [Stack](#stack)
   - [Queue](#queue)
   - [Hash Table](#hash-table)
   - [Binary Search Tree](#binary-search-tree)
4. [Algorithms](#algorithms)
   - [Searching](#searching)
   - [Sorting](#sorting)
5. [Learning Roadmap](#learning-roadmap)
6. [Running the Examples](#running-the-examples)

---

## Why Learn DSA?

Data Structures and Algorithms are the building blocks of efficient software.  
Understanding them helps you:

- Write code that runs **faster** and uses **less memory**
- Pass **technical interviews** at top companies
- Build **scalable** applications
- Become a **better problem solver**

---

## Big O Notation

Big O notation describes how the **time** or **space** a program needs grows as the input size `n` increases.

| Notation     | Name         | Example                        |
|-------------|--------------|--------------------------------|
| O(1)        | Constant     | Access array element by index  |
| O(log n)    | Logarithmic  | Binary search                  |
| O(n)        | Linear       | Loop through an array          |
| O(n log n)  | Linearithmic | Merge sort, Quick sort (avg)   |
| O(n²)       | Quadratic    | Bubble sort, nested loops      |
| O(2ⁿ)       | Exponential  | Recursive Fibonacci            |
| O(n!)       | Factorial    | Generating all permutations    |

> **Tip:** Always aim for O(1) or O(log n) when possible.

---

## Data Structures

| Python | Java | Structure | Key Operations |
|--------|------|-----------|----------------|
| [`data_structures/arrays.py`](data_structures/arrays.py) | [`java/Arrays.java`](java/Arrays.java) | Array / List | access O(1), search O(n), insert O(n) |
| [`data_structures/linked_list.py`](data_structures/linked_list.py) | [`java/LinkedList.java`](java/LinkedList.java) | Singly Linked List | prepend O(1), search O(n), delete O(n) |
| [`data_structures/stack.py`](data_structures/stack.py) | [`java/Stack.java`](java/Stack.java) | Stack (LIFO) | push O(1), pop O(1), peek O(1) |
| [`data_structures/queue.py`](data_structures/queue.py) | [`java/Queue.java`](java/Queue.java) | Queue (FIFO) | enqueue O(1), dequeue O(1) |
| [`data_structures/hash_table.py`](data_structures/hash_table.py) | [`java/HashTable.java`](java/HashTable.java) | Hash Table | insert O(1) avg, lookup O(1) avg |
| [`data_structures/binary_tree.py`](data_structures/binary_tree.py) | [`java/BinarySearchTree.java`](java/BinarySearchTree.java) | Binary Search Tree | insert O(log n) avg, search O(log n) avg |

---

## Algorithms

| Python | Java | Topic | Algorithms Covered |
|--------|------|-------|-------------------|
| [`algorithms/searching.py`](algorithms/searching.py) | [`java/Searching.java`](java/Searching.java) | Searching | Linear Search O(n), Binary Search O(log n) |
| [`algorithms/sorting.py`](algorithms/sorting.py) | [`java/Sorting.java`](java/Sorting.java) | Sorting | Bubble O(n²), Selection O(n²), Insertion O(n²), Merge O(n log n), Quick O(n log n) avg |

---

## Learning Roadmap

### 🟢 Beginner
1. Understand Big O notation
2. Arrays and strings
3. Linked lists
4. Stacks and queues
5. Linear and binary search

### 🟡 Intermediate
6. Hash tables
7. Binary trees and BST
8. Basic sorting algorithms (bubble, insertion, merge, quick)
9. Recursion fundamentals

### 🔴 Advanced
10. Heaps and priority queues
11. Graphs (BFS, DFS)
12. Dynamic programming
13. Greedy algorithms
14. Advanced tree structures (AVL, Red-Black)

---

## Running the Examples

### Python

All Python examples require **Python 3** and can be run directly:

```bash
python data_structures/arrays.py
python data_structures/linked_list.py
python data_structures/stack.py
python data_structures/queue.py
python data_structures/hash_table.py
python data_structures/binary_tree.py
python algorithms/searching.py
python algorithms/sorting.py
```

### Java

All Java examples require **JDK 8+**.

**Command line:**
```bash
cd java
javac Arrays.java && java Arrays
javac LinkedList.java && java LinkedList
javac Stack.java && java Stack
javac Queue.java && java Queue
javac HashTable.java && java HashTable
javac BinarySearchTree.java && java BinarySearchTree
javac Searching.java && java Searching
javac Sorting.java && java Sorting
```

**VS Code:**
1. Install the [Extension Pack for Java](https://marketplace.visualstudio.com/items?itemName=vscjava.vscode-java-pack)
2. Open any `.java` file in the `java/` folder
3. Click the **▶ Run** button that appears above the `main` method, or press `F5`

---

*Happy learning! 🚀 Consistent practice is the key to mastering DSA.*

---

## 📚 Table of Contents

1. [Why Learn DSA?](#why-learn-dsa)
2. [Big O Notation – Complexity Cheat Sheet](#big-o-notation)
3. [Data Structures](#data-structures)
   - [Arrays](#arrays)
   - [Linked List](#linked-list)
   - [Stack](#stack)
   - [Queue](#queue)
   - [Hash Table](#hash-table)
   - [Binary Search Tree](#binary-search-tree)
4. [Algorithms](#algorithms)
   - [Searching](#searching)
   - [Sorting](#sorting)
5. [Learning Roadmap](#learning-roadmap)

---

## Why Learn DSA?

Data Structures and Algorithms are the building blocks of efficient software.  
Understanding them helps you:

- Write code that runs **faster** and uses **less memory**
- Pass **technical interviews** at top companies
- Build **scalable** applications
- Become a **better problem solver**

---

## Big O Notation

Big O notation describes how the **time** or **space** a program needs grows as the input size `n` increases.

| Notation     | Name         | Example                        |
|-------------|--------------|--------------------------------|
| O(1)        | Constant     | Access array element by index  |
| O(log n)    | Logarithmic  | Binary search                  |
| O(n)        | Linear       | Loop through an array          |
| O(n log n)  | Linearithmic | Merge sort, Quick sort (avg)   |
| O(n²)       | Quadratic    | Bubble sort, nested loops      |
| O(2ⁿ)       | Exponential  | Recursive Fibonacci            |
| O(n!)       | Factorial    | Generating all permutations    |

> **Tip:** Always aim for O(1) or O(log n) when possible.

---

## Data Structures

| File | Structure | Key Operations |
|------|-----------|----------------|
| [`data_structures/arrays.py`](data_structures/arrays.py) | Array / List | access O(1), search O(n), insert O(n) |
| [`data_structures/linked_list.py`](data_structures/linked_list.py) | Singly Linked List | prepend O(1), search O(n), delete O(n) |
| [`data_structures/stack.py`](data_structures/stack.py) | Stack (LIFO) | push O(1), pop O(1), peek O(1) |
| [`data_structures/queue.py`](data_structures/queue.py) | Queue (FIFO) | enqueue O(1), dequeue O(1) |
| [`data_structures/hash_table.py`](data_structures/hash_table.py) | Hash Table | insert O(1) avg, lookup O(1) avg |
| [`data_structures/binary_tree.py`](data_structures/binary_tree.py) | Binary Search Tree | insert O(log n) avg, search O(log n) avg |

---

## Algorithms

| File | Topic | Algorithms Covered |
|------|-------|-------------------|
| [`algorithms/searching.py`](algorithms/searching.py) | Searching | Linear Search O(n), Binary Search O(log n) |
| [`algorithms/sorting.py`](algorithms/sorting.py) | Sorting | Bubble O(n²), Selection O(n²), Insertion O(n²), Merge O(n log n), Quick O(n log n) avg |

---

## Learning Roadmap

### 🟢 Beginner
1. Understand Big O notation
2. Arrays and strings
3. Linked lists
4. Stacks and queues
5. Linear and binary search

### 🟡 Intermediate
6. Hash tables
7. Binary trees and BST
8. Basic sorting algorithms (bubble, insertion, merge, quick)
9. Recursion fundamentals

### 🔴 Advanced
10. Heaps and priority queues
11. Graphs (BFS, DFS)
12. Dynamic programming
13. Greedy algorithms
14. Advanced tree structures (AVL, Red-Black)

---

## Running the Examples

All examples are written in **Python 3** and can be run directly:

```bash
python data_structures/arrays.py
python data_structures/linked_list.py
python data_structures/stack.py
python data_structures/queue.py
python data_structures/hash_table.py
python data_structures/binary_tree.py
python algorithms/searching.py
python algorithms/sorting.py
```

---

*Happy learning! 🚀 Consistent practice is the key to mastering DSA.*