"""
Singly Linked List
==================
A linked list is a chain of nodes where each node stores a value and a
pointer to the next node.  Unlike an array the nodes do NOT live in
contiguous memory, so random access is O(n).

Complexities:
  Prepend (insert at head) : O(1)
  Append  (insert at tail) : O(n)  – O(1) with a tail pointer
  Search                   : O(n)
  Delete                   : O(n)
  Access by index          : O(n)
"""


class Node:
    """A single node in the linked list."""

    def __init__(self, data):
        self.data = data
        self.next = None   # pointer to the next node


class LinkedList:
    """Singly linked list with basic operations."""

    def __init__(self):
        self.head = None   # the first node (or None if the list is empty)

    # ── Insert ──────────────────────────────────────────────────────────────

    def prepend(self, data):
        """Insert a new node at the beginning – O(1)."""
        new_node = Node(data)
        new_node.next = self.head
        self.head = new_node

    def append(self, data):
        """Insert a new node at the end – O(n)."""
        new_node = Node(data)
        if self.head is None:
            self.head = new_node
            return
        current = self.head
        while current.next:
            current = current.next
        current.next = new_node

    # ── Search ──────────────────────────────────────────────────────────────

    def search(self, target):
        """Return True if target exists in the list – O(n)."""
        current = self.head
        while current:
            if current.data == target:
                return True
            current = current.next
        return False

    # ── Delete ──────────────────────────────────────────────────────────────

    def delete(self, target):
        """Remove the first node whose data equals target – O(n)."""
        if self.head is None:
            return

        # Special case: the head node itself holds the target
        if self.head.data == target:
            self.head = self.head.next
            return

        current = self.head
        while current.next:
            if current.next.data == target:
                current.next = current.next.next   # skip over the target node
                return
            current = current.next

    # ── Display ─────────────────────────────────────────────────────────────

    def to_list(self):
        """Return all node values as a Python list."""
        result = []
        current = self.head
        while current:
            result.append(current.data)
            current = current.next
        return result

    def __str__(self):
        return " -> ".join(str(val) for val in self.to_list()) + " -> None"


def demonstrate_linked_list():
    ll = LinkedList()

    print("=== Singly Linked List ===\n")

    ll.append(10)
    ll.append(20)
    ll.append(30)
    print("After append 10, 20, 30 :", ll)

    ll.prepend(5)
    print("After prepend 5         :", ll)

    print("Search for 20           :", ll.search(20))   # True
    print("Search for 99           :", ll.search(99))   # False

    ll.delete(20)
    print("After delete 20         :", ll)

    ll.delete(5)    # delete head
    print("After delete head (5)   :", ll)

    ll.delete(30)   # delete tail
    print("After delete tail (30)  :", ll)


if __name__ == "__main__":
    demonstrate_linked_list()
