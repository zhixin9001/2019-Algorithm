package exercise.three;

import java.util.Comparator;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdDraw;
import java.awt.Font;

public class SequentialSearchST4Hash<Key, Value> {
    private Node first;
    private int n;
    public int current;
    private int sum;

    private class Node {
        Key key;
        Value val;
        Node next;

        public Node(Key key, Value val, Node next) {
            this.key = key;
            this.val = val;
            this.next = next;
        }
    }

    public Value get(Key key) {
        if (key == null)
            throw new IllegalArgumentException("argument to get() is null");
        for (Node x = first; x != null; x = x.next) {
            if (key.equals(x.key)) {
                return x.val;
            }
        }
        return null;
    }

    public void put(Key key, Value value) {
        current = 0;
        if (key == null)
            throw new IllegalArgumentException("first argument to put() is null");

        for (Node x = first; x != null; x = x.next) {
            current++;
            if (key.equals(x.key)) {
                x.val = value;
                return;
            }
        }
        first = new Node(key, value, first);
        n++;
    }

    public int size() {
        return n;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public boolean contains(Key key) {
        if (key == null)
            throw new IllegalArgumentException("argument to contains() is null");
        return get(key) != null;
    }

    public Iterable<Key> keys() {
        Queue<Key> queue = new Queue<Key>();
        for (Node x = first; x != null; x = x.next)
            queue.enqueue(x.key);
        return queue;
    }

    public static void main(String[] args) {
        int distinct = 0, words = 0;
        int minlen = 8;
        SequentialSearchST4Hash<String, Integer> st = new SequentialSearchST4Hash<String, Integer>();
        VisualAccumulator va = new VisualAccumulator(150000, 10000);
        for (int i = 0; !StdIn.isEmpty(); i++) {
            String key = StdIn.readString();
            if (key.length() < minlen)
                continue;
            // words++;
            st.put(key, i);
            va.addDataValue(st.current);
        }
    }

}