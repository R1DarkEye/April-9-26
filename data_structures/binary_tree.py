"""
Binary Search Tree (BST)
=========================
A Binary Search Tree is a tree where every node satisfies:
  left child  < parent  ≤  right child

This property makes searching very efficient because at each step we can
eliminate half the remaining nodes.

Terminology:
  Root    – the top node of the tree
  Leaf    – a node with no children
  Height  – the longest path from root to a leaf

Complexities (balanced BST):
  Insert : O(log n)
  Search : O(log n)
  Delete : O(log n)

Worst case (completely unbalanced / sorted input): O(n)

Tree traversals (used to read the values in a specific order):
  In-order   (Left → Root → Right) → sorted ascending order
  Pre-order  (Root → Left → Right) → useful for copying/serialising
  Post-order (Left → Right → Root) → useful for deletion
"""


class BSTNode:
    """A single node in the BST."""

    def __init__(self, value):
        self.value = value
        self.left = None    # left sub-tree (smaller values)
        self.right = None   # right sub-tree (larger or equal values)


class BinarySearchTree:
    """Binary Search Tree with insert, search, delete, and traversal."""

    def __init__(self):
        self.root = None

    # ── Insert ──────────────────────────────────────────────────────────────

    def insert(self, value):
        """Insert value into the BST – O(log n) average."""
        self.root = self._insert(self.root, value)

    def _insert(self, node, value):
        if node is None:
            return BSTNode(value)
        if value < node.value:
            node.left = self._insert(node.left, value)
        else:
            node.right = self._insert(node.right, value)
        return node

    # ── Search ──────────────────────────────────────────────────────────────

    def search(self, value):
        """Return True if value exists in the BST – O(log n) average."""
        return self._search(self.root, value)

    def _search(self, node, value):
        if node is None:
            return False
        if value == node.value:
            return True
        if value < node.value:
            return self._search(node.left, value)
        return self._search(node.right, value)

    # ── Delete ──────────────────────────────────────────────────────────────

    def delete(self, value):
        """Remove value from the BST – O(log n) average."""
        self.root = self._delete(self.root, value)

    def _delete(self, node, value):
        if node is None:
            return None
        if value < node.value:
            node.left = self._delete(node.left, value)
        elif value > node.value:
            node.right = self._delete(node.right, value)
        else:
            # Case 1 & 2: node has 0 or 1 child
            if node.left is None:
                return node.right
            if node.right is None:
                return node.left
            # Case 3: node has 2 children
            # Replace with in-order successor (smallest value in right sub-tree)
            successor = self._min_node(node.right)
            node.value = successor.value
            node.right = self._delete(node.right, successor.value)
        return node

    def _min_node(self, node):
        """Return the node with the minimum value in a sub-tree."""
        while node.left:
            node = node.left
        return node

    # ── Traversals ──────────────────────────────────────────────────────────

    def inorder(self):
        """Return values in sorted (ascending) order – O(n)."""
        result = []
        self._inorder(self.root, result)
        return result

    def _inorder(self, node, result):
        if node:
            self._inorder(node.left, result)
            result.append(node.value)
            self._inorder(node.right, result)

    def preorder(self):
        """Return values in root-first order – O(n)."""
        result = []
        self._preorder(self.root, result)
        return result

    def _preorder(self, node, result):
        if node:
            result.append(node.value)
            self._preorder(node.left, result)
            self._preorder(node.right, result)

    def postorder(self):
        """Return values in root-last order – O(n)."""
        result = []
        self._postorder(self.root, result)
        return result

    def _postorder(self, node, result):
        if node:
            self._postorder(node.left, result)
            self._postorder(node.right, result)
            result.append(node.value)

    # ── Height ──────────────────────────────────────────────────────────────

    def height(self):
        """Return the height of the tree – O(n)."""
        return self._height(self.root)

    def _height(self, node):
        if node is None:
            return 0
        return 1 + max(self._height(node.left), self._height(node.right))


def demonstrate_bst():
    print("=== Binary Search Tree ===\n")

    bst = BinarySearchTree()
    values = [50, 30, 70, 20, 40, 60, 80]
    for v in values:
        bst.insert(v)
    print("Inserted         :", values)
    print("In-order (sorted):", bst.inorder())
    print("Pre-order        :", bst.preorder())
    print("Post-order       :", bst.postorder())
    print("Height           :", bst.height())

    print("\nSearch 40        :", bst.search(40))   # True
    print("Search 99        :", bst.search(99))     # False

    bst.delete(30)
    print("\nAfter delete 30  :", bst.inorder())

    bst.delete(50)   # delete root
    print("After delete 50  :", bst.inorder())


if __name__ == "__main__":
    demonstrate_bst()
