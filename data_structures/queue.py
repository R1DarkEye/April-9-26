"""
Queue (First-In, First-Out – FIFO)
===================================
A queue lets you add items at one end (the "rear") and remove them from
the other end (the "front") – just like a line of people waiting.

Real-world uses:
  • Print spoolers
  • CPU / process scheduling
  • Breadth-first search (BFS) in graphs
  • Streaming / buffering data

We use collections.deque for O(1) enqueue AND dequeue.
A plain list would give O(n) dequeue because every element shifts left.

Complexities:
  enqueue (add to rear)      : O(1)
  dequeue (remove from front): O(1)
  peek (see front item)      : O(1)
  is_empty                   : O(1)
"""

from collections import deque


class Queue:
    """Queue implemented with collections.deque."""

    def __init__(self):
        self._data = deque()

    def enqueue(self, item):
        """Add item to the rear of the queue – O(1)."""
        self._data.append(item)

    def dequeue(self):
        """Remove and return the front item – O(1).
        Raises IndexError if the queue is empty.
        """
        if self.is_empty():
            raise IndexError("dequeue from an empty queue")
        return self._data.popleft()

    def peek(self):
        """Return the front item without removing it – O(1)."""
        if self.is_empty():
            raise IndexError("peek at an empty queue")
        return self._data[0]

    def is_empty(self):
        """Return True if the queue has no elements – O(1)."""
        return len(self._data) == 0

    def size(self):
        """Return the number of items in the queue – O(1)."""
        return len(self._data)

    def __str__(self):
        return "Queue (front → rear): " + str(list(self._data))


# ── Practical Example: simple task processor ─────────────────────────────────

def process_tasks(tasks):
    """Simulate processing tasks in the order they arrive."""
    q = Queue()
    for task in tasks:
        q.enqueue(task)
        print(f"  Enqueued : {task}")

    print()
    while not q.is_empty():
        task = q.dequeue()
        print(f"  Processing: {task}")


def demonstrate_queue():
    print("=== Queue (FIFO) ===\n")

    q = Queue()
    q.enqueue("A")
    q.enqueue("B")
    q.enqueue("C")
    print(q)
    print("Peek     :", q.peek())       # A
    print("Dequeue  :", q.dequeue())    # A
    print("Dequeue  :", q.dequeue())    # B
    print("Size     :", q.size())       # 1
    print(q)

    print("\n--- Task processor ---")
    process_tasks(["Print doc", "Send email", "Compile code"])


if __name__ == "__main__":
    demonstrate_queue()
