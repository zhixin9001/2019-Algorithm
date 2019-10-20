package algs4.three;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Queue;
import java.util.Comparator;
import java.util.NoSuchElementException;

public class LinerProbingHashST<Key, Value> {
    private int n; // count of k-v pairs
    private int m = 16; // size of hashtable
    private Key[] keys;
    private Value[] vals;

    public LinerProbingHashST() {
        this(16);
    }

    public LinerProbingHashST(int capaticy) {
        keys = (Key[]) new Object[capaticy];
        vals = (Value[]) new Object[capaticy];
    }

    private int hash(Key key) {
        return (key.hashCode() & 0x7fffffff) % m;
    }

    public Value get(Key key) {
        if (key == null)
            throw new IllegalArgumentException("argument to get() is null");
        for (int i = hash(key); keys[i] != null; i = (i + 1) % m) {
            if (keys[i].equals(key)) {
                return vals[i];
            }
        }
        return null;
    }

    public void put(Key key, Value val) {
        if (key == null)
            throw new IllegalArgumentException("first argument to put() is null");

        // double table size if average length of list >= 10
        if (n >= m / 2)
            resize(2 * m);

        int i;
        for (i = hash(key); keys[i] != null; i = (i + 1) % m) {
            if (keys[i].equals(key)) {
                vals[i] = val;
                return;
            }
        }
        keys[i] = key;
        vals[i] = val;
        n++;
    }

    public void resize(int capacity) {
        LinerProbingHashST<Key, Value> st = new LinerProbingHashST<Key, Value>(capacity);
        for (int i = 0; i < m; i++) {
            if (keys[i] != null) {
                st.put(keys[i], vals[i]);
            }
            keys = st.keys;
            vals = st.vals;
            m = st.m;
        }
    }

    public int size() {
        return n;
    }

    public boolean contains(Key key) {
        if (key == null)
            throw new IllegalArgumentException("argument to contains() is null");
        return get(key) != null;
    }

    public Iterable<Key> keys() {
        Queue<Key> queue = new Queue<Key>();
        for (int i = 0; i < m; i++) {
            if (keys[i] != null) {
                queue.enqueue(keys[i]);
            }
        }
        return queue;
    }

    public static void main(String[] args) {
        LinerProbingHashST<String, Integer> st = new LinerProbingHashST<String, Integer>();
        for (int i = 0; !StdIn.isEmpty(); i++) {
            String key = StdIn.readString();
            st.put(key, i);
        }

        StdOut.println();

        for (String s : st.keys())
            StdOut.println(s + "-" + st.get(s));
    }
}
