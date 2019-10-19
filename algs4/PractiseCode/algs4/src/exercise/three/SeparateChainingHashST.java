package exercise.three;

import java.security.Key;
import java.util.Comparator;
import java.util.NoSuchElementException;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdDraw;
import exercise.three.SequentialSearchST4Hash;

public class SeparateChainingHashST<Key, Value> {
    private static final int INIT_CAPACITY = 4;

    private int n; // count of k-v pairs
    private int m; // size of hashtable
    private int current;
    private SequentialSearchST4Hash<Key, Value>[] st;

    public SeparateChainingHashST() {
        this(INIT_CAPACITY);
    }

    public SeparateChainingHashST(int M) {
        this.m = M;
        st = (SequentialSearchST4Hash<Key, Value>[]) new SequentialSearchST4Hash[M];
        for (int i = 0; i < M; i++) {
            st[i] = new SequentialSearchST4Hash();
        }
    }

    private int hash(Key key) {
        return (key.hashCode() & 0x7fffffff) % m;
    }

    public Value get(Key key) {
        if (key == null)
            throw new IllegalArgumentException("argument to get() is null");
        return (Value) st[hash(key)].get(key);
    }

    public void put(Key key, Value val) {
        if (key == null)
            throw new IllegalArgumentException("first argument to put() is null");
        current = 0;
        // if (val == null) {
        // delete(key);
        // return;
        // }
        // double table size if average length of list >= 10
        if (n >= 10 * m)
            resize(2 * m);

        int i = hash(key);

        SequentialSearchST4Hash st4Hash = st[i];
        current++;
        if (!st4Hash.contains(key))
            n++;

        st4Hash.put(key, val);
        current += st4Hash.current;

    }

    // public void delete(Key key) {
    // if (key == null)
    // throw new IllegalArgumentException("argument to delete() is null");

    // int i = hash(key);
    // if (st[i].contains(key))
    // n--;
    // st[i].delete(key);

    // if (m < INIT_CAPACITY && size() < 2 * m)
    // resize(m / 2);
    // }

    public void resize(int chains) {
        SeparateChainingHashST<Key, Value> temp = new SeparateChainingHashST<Key, Value>(chains);
        for (int i = 0; i < m; i++) {
            for (Key key : st[i].keys()) {
                temp.put(key, st[i].get(key));
            }
        }
        this.m = temp.m;
        this.n = temp.n;
        this.st = temp.st;
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
            for (Key key : st[i].keys())
                queue.enqueue(key);
        }
        return queue;
    }

    public static void main(String[] args) {
        int minlen = 8;
        SeparateChainingHashST<String, Integer> st = new SeparateChainingHashST<String, Integer>();
        VisualAccumulator va = new VisualAccumulator(15000, 50);
        for (int i = 0; !StdIn.isEmpty(); i++) {
            String key = StdIn.readString();
            if (key.length() < minlen)
                continue;
            st.put(key, i);
            va.addDataValue(st.current);
        }
    }
}
