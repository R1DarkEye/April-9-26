"""
Stack (Last-In, First-Out  – LIFO)
===================================
A stack lets you add and remove items only from one end (the "top").
Think of a stack of plates: you always put a new plate on top and take
the top plate off first.

Real-world uses:
  • Undo / redo in text editors
  • Browser back / forward navigation
  • Function call stack in programming languages
  • Balanced parentheses checking

Complexities (all O(1)):
  push  – add to top
  pop   – remove from top
  peek  – look at top without removing
  is_empty – check whether the stack is empty
"""


class Stack:
    """Stack implemented with a Python list (the end of the list is the top)."""

    def __init__(self):
        self._data = []

    def push(self, item):
        """Add item to the top of the stack – O(1) amortised."""
        self._data.append(item)

    def pop(self):
        """Remove and return the top item – O(1).
        Raises IndexError if the stack is empty.
        """
        if self.is_empty():
            raise IndexError("pop from an empty stack")
        return self._data.pop()

    def peek(self):
        """Return the top item without removing it – O(1).
        Raises IndexError if the stack is empty.
        """
        if self.is_empty():
            raise IndexError("peek at an empty stack")
        return self._data[-1]

    def is_empty(self):
        """Return True if the stack has no elements – O(1)."""
        return len(self._data) == 0

    def size(self):
        """Return the number of items in the stack – O(1)."""
        return len(self._data)

    def __str__(self):
        return "Stack (top → bottom): " + str(list(reversed(self._data)))


# ── Practical Example: balanced parentheses checker ──────────────────────────

def is_balanced(expression):
    """Return True if every opening bracket has a matching closing bracket."""
    stack = Stack()
    matching = {')': '(', ']': '[', '}': '{'}

    for char in expression:
        if char in '([{':
            stack.push(char)
        elif char in ')]}':
            if stack.is_empty() or stack.pop() != matching[char]:
                return False

    return stack.is_empty()


def demonstrate_stack():
    print("=== Stack (LIFO) ===\n")

    s = Stack()
    s.push(1)
    s.push(2)
    s.push(3)
    print(s)
    print("Peek       :", s.peek())     # 3
    print("Pop        :", s.pop())      # 3
    print("Pop        :", s.pop())      # 2
    print("Size       :", s.size())     # 1
    print("Is empty?  :", s.is_empty()) # False
    s.pop()
    print("Is empty?  :", s.is_empty()) # True

    print("\n--- Balanced parentheses ---")
    tests = ["([]{})", "([)]", "((())", "{[()]}"]
    for expr in tests:
        print(f"  {expr!r:10s} → {is_balanced(expr)}")


if __name__ == "__main__":
    demonstrate_stack()
