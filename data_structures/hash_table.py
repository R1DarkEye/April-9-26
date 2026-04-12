"""
Hash Table (Dictionary)
=======================
A hash table maps **keys** to **values** using a hash function that converts
a key into an array index.  This allows near-instant lookups.

Python's built-in dict IS a hash table – but building one from scratch
shows how it works under the hood.

Key concepts:
  • Hash function  – converts a key to an integer index
  • Bucket array   – the underlying array that stores (key, value) pairs
  • Collision      – two keys map to the same index
  • Chaining       – resolve collisions by storing a list at each bucket

Complexities (average case):
  Insert : O(1)
  Lookup : O(1)
  Delete : O(1)

Worst case (all keys collide): O(n)
"""


class HashTable:
    """
    Simple hash table with separate chaining for collision resolution.
    Each bucket holds a list of (key, value) pairs.
    """

    def __init__(self, capacity=16):
        self._capacity = capacity
        self._buckets = [[] for _ in range(capacity)]
        self._size = 0

    # ── Internal helpers ────────────────────────────────────────────────────

    def _hash(self, key):
        """Map a key to a bucket index – O(1)."""
        return hash(key) % self._capacity

    def _find(self, key):
        """Return (bucket, position) for key, or (bucket, -1) if not found."""
        index = self._hash(key)
        bucket = self._buckets[index]
        for pos, (k, _) in enumerate(bucket):
            if k == key:
                return bucket, pos
        return bucket, -1

    # ── Public API ──────────────────────────────────────────────────────────

    def put(self, key, value):
        """Insert or update key → value – O(1) average."""
        bucket, pos = self._find(key)
        if pos == -1:
            bucket.append((key, value))
            self._size += 1
        else:
            bucket[pos] = (key, value)   # update existing key

    def get(self, key):
        """Return the value for key – O(1) average.
        Raises KeyError if the key does not exist.
        """
        bucket, pos = self._find(key)
        if pos == -1:
            raise KeyError(key)
        return bucket[pos][1]

    def delete(self, key):
        """Remove key from the table – O(1) average.
        Raises KeyError if the key does not exist.
        """
        bucket, pos = self._find(key)
        if pos == -1:
            raise KeyError(key)
        bucket.pop(pos)
        self._size -= 1

    def contains(self, key):
        """Return True if key exists in the table – O(1) average."""
        _, pos = self._find(key)
        return pos != -1

    def size(self):
        """Return the number of key-value pairs stored – O(1)."""
        return self._size

    def keys(self):
        """Return a list of all keys – O(n)."""
        return [k for bucket in self._buckets for k, _ in bucket]

    def items(self):
        """Return a list of all (key, value) pairs – O(n)."""
        return [(k, v) for bucket in self._buckets for k, v in bucket]

    def __str__(self):
        pairs = ", ".join(f"{k!r}: {v!r}" for k, v in self.items())
        return "{" + pairs + "}"


def demonstrate_hash_table():
    print("=== Hash Table ===\n")

    # ── Custom implementation ────────────────────────────────────────────────
    ht = HashTable()
    ht.put("name", "Alice")
    ht.put("age", 30)
    ht.put("city", "Berlin")
    print("After inserts  :", ht)

    print("Get 'name'     :", ht.get("name"))     # Alice
    print("Contains 'age' :", ht.contains("age")) # True

    ht.put("age", 31)   # update
    print("After update   :", ht)

    ht.delete("city")
    print("After delete   :", ht)
    print("Size           :", ht.size())

    # ── Python's built-in dict ───────────────────────────────────────────────
    print("\n--- Python dict (built-in hash table) ---")
    d = {}
    d["language"] = "Python"
    d["version"] = 3
    print(d)
    print("language:", d["language"])
    print("Keys    :", list(d.keys()))


if __name__ == "__main__":
    demonstrate_hash_table()
