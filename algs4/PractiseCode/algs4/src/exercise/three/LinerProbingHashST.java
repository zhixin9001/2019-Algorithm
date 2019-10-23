package exercise.three;

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
    public int current;

    public LinerProbingHashST() {
        this(16);
    }

    public LinerProbingHashST(int capacity) {
        keys = (Key[]) new Object[capacity];
        vals = (Value[]) new Object[capacity];
        m=capacity;
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
        current = 0;
        // double table size if average length of list >= 10
        if (n >= m / 2)
            resize(2 * m);

        int i;
        for (i = hash(key); keys[i] != null; i = (i + 1) % m) {
            current++;
            if (keys[i].equals(key)) {
                current++;
                vals[i] = val;
                return;
            }
        }
        current++;
        keys[i] = key;
        vals[i] = val;
        n++;
    }

    public void resize(int capacity) {
        LinerProbingHashST<Key, Value> st = new LinerProbingHashST<Key, Value>(capacity);
        for (int i = 0; i < m; i++) {
            current++;
            if (keys[i] != null) {
                current++;
                st.put(keys[i], vals[i]);
            }
            keys = st.keys;
            vals = st.vals;
            m = st.m;
            n=st.n;
        }      
        StdOut.println("----resize-----"+capacity+"-------"+current);
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
        int minlen = 8;
        LinerProbingHashST<String, Integer> st = new LinerProbingHashST<String, Integer>();
        VisualAccumulator va = new VisualAccumulator(15000, 20);
        for (int i = 0; !StdIn.isEmpty(); i++) {
            String key = StdIn.readString();
            if (key.length() < minlen)
                continue;
            st.put(key, i);
            va.addDataValue(st.current);
        }
    }
}
