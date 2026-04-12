/**
 * Hash Table in Java
 * ==================
 * Maps keys to values using a hash function.
 * Collisions are resolved with separate chaining (a linked list per bucket).
 *
 * Java's built-in HashMap IS a hash table – but building one from scratch
 * shows exactly how it works under the hood.
 *
 * Complexities (average case):
 *   Insert : O(1)
 *   Lookup : O(1)
 *   Delete : O(1)
 * Worst case (all keys collide): O(n)
 */

import java.util.LinkedList;
import java.util.HashMap;

public class HashTable {

    // ── Entry (key-value pair) ────────────────────────────────────────────────
    private static class Entry {
        String key;
        String value;
        Entry(String key, String value) { this.key = key; this.value = value; }
    }

    private final int capacity;
    private final LinkedList<Entry>[] buckets;
    private int size;

    @SuppressWarnings("unchecked")
    public HashTable(int capacity) {
        this.capacity = capacity;
        this.buckets = new LinkedList[capacity];
        for (int i = 0; i < capacity; i++) buckets[i] = new LinkedList<>();
    }

    public HashTable() { this(16); }

    // ── Hash function ────────────────────────────────────────────────────────
    private int hash(String key) {
        // Math.abs guards against negative hashCode values
        return Math.abs(key.hashCode()) % capacity;
    }

    // ── Public API ───────────────────────────────────────────────────────────

    /** Insert or update key → value – O(1) average. */
    public void put(String key, String value) {
        LinkedList<Entry> bucket = buckets[hash(key)];
        for (Entry entry : bucket) {
            if (entry.key.equals(key)) { entry.value = value; return; }
        }
        bucket.add(new Entry(key, value));
        size++;
    }

    /** Return the value for key – O(1) average. Throws if not found. */
    public String get(String key) {
        for (Entry entry : buckets[hash(key)]) {
            if (entry.key.equals(key)) return entry.value;
        }
        throw new java.util.NoSuchElementException("Key not found: " + key);
    }

    /** Remove key from the table – O(1) average. */
    public void delete(String key) {
        LinkedList<Entry> bucket = buckets[hash(key)];
        bucket.removeIf(entry -> entry.key.equals(key));
        size--;
    }

    /** Return true if key exists – O(1) average. */
    public boolean contains(String key) {
        for (Entry entry : buckets[hash(key)]) {
            if (entry.key.equals(key)) return true;
        }
        return false;
    }

    /** Return the number of entries – O(1). */
    public int size() { return size; }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        for (LinkedList<Entry> bucket : buckets) {
            for (Entry entry : bucket) {
                sb.append(entry.key).append(": ").append(entry.value).append(", ");
            }
        }
        if (sb.length() > 1) sb.setLength(sb.length() - 2); // remove trailing ", "
        return sb.append("}").toString();
    }

    // ── Demo ─────────────────────────────────────────────────────────────────
    public static void main(String[] args) {
        System.out.println("=== Hash Table ===\n");

        // Custom implementation
        HashTable ht = new HashTable();
        ht.put("name", "Alice");
        ht.put("age", "30");
        ht.put("city", "Berlin");
        System.out.println("After inserts  : " + ht);
        System.out.println("Get 'name'     : " + ht.get("name"));
        System.out.println("Contains 'age' : " + ht.contains("age")); // true

        ht.put("age", "31");  // update
        System.out.println("After update   : " + ht);

        ht.delete("city");
        System.out.println("After delete   : " + ht);
        System.out.println("Size           : " + ht.size());

        // Java's built-in HashMap
        System.out.println("\n--- Java HashMap (built-in hash table) ---");
        HashMap<String, Object> map = new HashMap<>();
        map.put("language", "Java");
        map.put("version", 17);
        System.out.println(map);
        System.out.println("language : " + map.get("language"));
        System.out.println("Keys     : " + map.keySet());
    }
}
