package exercise.three;

import java.util.Comparator;
// import java.util.Comparable;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdDraw;
import java.awt.Font;

public class BinarySearchST<Key extends Comparable<Key>, Value> {
    public Key[] keys;
    private Value[] vals;
    private int N;
    private int current;

    public BinarySearchST(int capacity) {
        keys = (Key[]) new Comparable[capacity];
        vals = (Value[]) new Object[capacity];
    }

    public int size() {
        return N;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public Value get(Key key) {
        if (isEmpty())
            return null;
        int i = rank(key, false);
        if (i < N && keys[i].compareTo(key) == 0) {
            return vals[i];
        } else {
            return null;
        }
    }

    public void put(Key key, Value val) {
        current = 0;
        int i = rank(key, true);
        if (i < N && keys[i].compareTo(key) == 0) {
            vals[i] = val;
            return;
        }
        for (int j = N; j > i; j--) {
            current++;
            keys[j] = keys[j - 1];
            vals[j] = vals[j - 1];
        }
        keys[i] = key;
        vals[i] = val;
        N++;
    }

    public int rank(Key key, boolean isFlag) {
        // return rankRecursion(key, 0, N - 1, isFlag);
        return rankIteration(key, 0, N - 1);
    }

    public int rankRecursion(Key key, int lo, int hi, boolean isFlag) {
        // if (isFlag) {
        // current++;
        // }
        current++;

        // if (hi <= lo)
        if (hi < lo)
            return lo;
        int mid = lo + (hi - lo) / 2;
        int cmp = key.compareTo(keys[mid]);
        if (cmp < 0) {
            return rankRecursion(key, lo, mid - 1, isFlag);
        } else if (cmp > 0) {
            return rankRecursion(key, mid + 1, hi, isFlag);
        } else {
            return mid;
        }
    }

    public int rankIteration(Key key, int lo, int hi) {
        while (lo <= hi) {
            current++;
            int mid = lo + (hi - lo) / 2;
            int cmp = key.compareTo(keys[mid]);
            if (cmp < 0) {
                hi = mid - 1;
            } else if (cmp > 0) {
                lo = mid + 1;
            } else {
                return mid;
            }
        }
        return lo;
    }

    public Iterable<Key> keys() {
        return keys(keys[0], keys[N - 1]);
    }

    public Iterable<Key> keys(Key lo, Key hi) {
        if (lo == null)
            throw new IllegalArgumentException("first argument to keys() is null");
        if (hi == null)
            throw new IllegalArgumentException("second argument to keys() is null");

        Queue<Key> queue = new Queue<Key>();
        if (lo.compareTo(hi) > 0)
            return queue;
        for (int i = rank(lo, false); i < rank(hi, false); i++)
            queue.enqueue(keys[i]);
        if (get(hi) != null)
            queue.enqueue(keys[rank(hi, false)]);
        return queue;
    }

    public static void main(String[] args) {
        int minlen = 8;
        BinarySearchST<String, Integer> st = new BinarySearchST<String, Integer>(150000);
        VisualAccumulator va = new VisualAccumulator(15000, 6000);
        for (int i = 0; !StdIn.isEmpty(); i++) {
            String key = StdIn.readString();
            if (key.length() < minlen)
                continue;
            st.put(key, i);
            va.addDataValue(st.current);
        }

        // StdOut.println("12");
        // for (String s : st.keys())
        //     StdOut.println(s + " " + st.get(s));
    }

}   