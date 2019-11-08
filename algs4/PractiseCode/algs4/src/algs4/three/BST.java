package algs4.three;

import java.util.Comparator;
import java.util.NoSuchElementException;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import javafx.scene.Node;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdDraw;
import java.awt.Font;

public class BST<Key extends Comparable<Key>, Value> {
    private Node root;

    private class Node {
        private Key key;
        private Value val;
        private Node left, right;
        public int size;

        public Node(Key key, Value val, int size) {
            this.key = key;
            this.val = val;
            this.size = size;
        }
    }

    public int size() {
        return size(root);
    }

    public int size(Node x) {
        if (x == null)
            return 0;
        else
            return x.size;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public Value get(Key key) {
        return get(root, key);
    }

    public boolean contains(Key key) {
        if (key == null) throw new IllegalArgumentException("argument to contains() is null");
        return get(key) != null;
    }

    private Value get(Node x, Key key) {
        if (key == null)
            throw new IllegalArgumentException("calls get() with a null key");
        if (x == null)
            return null;
        int cmp = key.compareTo(x.key);
        if (cmp > 0) {
            return get(x.right, key);
        } else if (cmp < 0) {
            return get(x.left, key);
        } else {
            return x.val;
        }
    }

    public Node getNode(Key key) {
        return getNode(root, key);
    }

    private Node getNode(Node x, Key key) {
        if (key == null)
            throw new IllegalArgumentException("calls get() with a null key");
        if (x == null)
            return null;
        int cmp = key.compareTo(x.key);
        if (cmp > 0) {
            return getNode(x.right, key);
        } else if (cmp < 0) {
            return getNode(x.left, key);
        } else {
            return x;
        }
    }

    public void put(Key key, Value val) {
        root = put(root, key, val);
    }

    private Node put(Node x, Key key, Value val) {
        if (key == null)
            throw new IllegalArgumentException("calls put() with a null key");
        if (x == null)
            return new Node(key, val, 1);
        int cmp = key.compareTo(x.key);
        if (cmp < 0)
            x.left = put(x.left, key, val);
        else if (cmp > 0)
            x.right = put(x.right, key, val);
        else {
            x.val = val;
        }
        x.size = size(x.left) + size(x.right) + 1;
        return x;
    }

    public Key min() {
        if (isEmpty())
            throw new NoSuchElementException("calls min() with empty symbol table");
        return min(root).key;
    }

    private Node min(Node x) {
        if (x.left == null)
            return x;
        else
            return min(x.left);
    }

    public Key max() {
        if (isEmpty())
            throw new NoSuchElementException("calls max() with empty symbol table");
        return max(root).key;
    }

    private Node max(Node x) {
        if (x.right == null)
            return x;
        else
            return max(x.right);
    }

    // public Key floor(Key key) {
    // if (key == null) throw new IllegalArgumentException("argument to floor() is
    // null");
    // if (isEmpty()) throw new NoSuchElementException("calls floor() with empty
    // symbol table");
    // Node x = floor(root, key);
    // if (x == null) return null;
    // else return x.key;
    // }

    // private Node floor(Node x, Key key) {
    // if (x == null) return null;
    // int cmp = key.compareTo(x.key);
    // if (cmp == 0) return x;
    // if (cmp < 0) return floor(x.left, key);
    // Node t = floor(x.right, key);
    // if (t != null) return t;
    // else return x;
    // }
    public Key floor(Key key) {
        if (key == null)
            throw new IllegalArgumentException("argument to floor() is null");
        if (isEmpty())
            throw new NoSuchElementException("calls max() with empty symbol table");
        Node n = floor(root, key);
        if (n == null) {
            return null;
        } else {
            return n.key;
        }
    }

    private Node floor(Node x, Key key) {
        if (x == null) {
            return null;
        }

        int cmp = key.compareTo(x.key);
        if (cmp == 0)
            return x;
        if (cmp < 0)
            return floor(x.left, key);

        Node n = floor(x.right, key);
        if (n == null) {
            return x;
        } else {
            return n;
        }
    }

    public Key ceiling(Key key) {
        if (isEmpty())
            throw new NoSuchElementException("calls max() with empty symbol table");
        Node n = ceiling(root, key);
        if (n == null) {
            return null;
        } else {
            return n.key;
        }
    }

    private Node ceiling(Node x, Key key) {
        if (x == null) {
            return null;
        }

        int cmp = key.compareTo(x.key);
        if (cmp == 0)
            return x;
        if (cmp > 0)
            return ceiling(x.right, key);

        Node n = ceiling(x.left, key);
        if (n == null) {
            return x;
        } else {
            return n;
        }
    }

    public Key select(int k) {
        if (k < 0 || k >= size()) {
            throw new IllegalArgumentException("argument to select() is invalid: " + k);
        }
        return select(root, k).key;
    }

    private Node select(Node x, int k) {
        if (x == null) {
            return null;
        }

        int t = size(x.left);
        if (t > k) {
            return select(x.left, k);
        } else if (t < k) {
            return select(x.right, k - t - 1);
        } else {
            return x;
        }
    }

    public int rank(Key key) {
        if (key == null)
            throw new IllegalArgumentException("argument to rank() is null");
        return rank(key, root);
    }

    // private int rank(Key key, Node x) {
    // if (x == null) {
    // return 0;
    // }
    // int cmp = key.compareTo(x.key);
    // if (cmp > 0) {
    // return size(x.left) + size(x.right) + 1;
    // } else if (cmp < 0) {
    // return size(x.left);
    // } else {
    // return x.size;
    // }
    // }

    private int rank(Key key, Node x) {
        if (x == null) {
            return 0;
        }
        int cmp = key.compareTo(x.key);
        if (cmp > 0) {
            return size(x.left) + rank(key, x.right) + 1;
        } else if (cmp < 0) {
            return rank(key, x.left);
        } else {
            return size(x.left);
        }
    }

    public void deleteMin() {
        if (isEmpty())
            throw new NoSuchElementException("Symbol table underflow");
        root = deleteMin(root);
    }

    private Node deleteMin(Node x) {
        if (x.left == null)
            return x.right;
        x.left = deleteMin(x.left);
        x.size = size(x.left) + size(x.right) + 1;
        return x;
    }

    public void deleteMax() {
        if (isEmpty())
            throw new NoSuchElementException("Symbol table underflow");
        root = deleteMax(root);
    }

    private Node deleteMax(Node x) {
        if (x.right == null)
            return x.left;
        x.right = deleteMax(x.right);
        x.size = size(x.left) + size(x.right) + 1;
        return x;
    }

    public void delete(Key key) {
        if (key == null)
            throw new IllegalArgumentException("calls delete() with a null key");
        root = delete(root, key);
    }

    private Node delete(Node x, Key key) {
        if (x == null)
            return null;

        int cmp = key.compareTo(x.key);
        if (cmp < 0)
            x.left = delete(x.left, key);
        else if (cmp > 0)
            x.right = delete(x.right, key);
        else {
            if (x.right == null)
                return x.left;
            if (x.left == null)
                return x.right;
            Node t = x;
            x = min(t.right);
            x.right = deleteMin(t.right);
            x.left = t.left;
        }
        x.size = size(x.left) + size(x.right) + 1;
        return x;
    }

    public Iterable<Key> keys() {
        if (isEmpty())
            return new Queue<Key>();
        return keys(min(), max());
    }

    public Iterable<Key> keys(Key lo, Key hi) {
        if (lo == null)
            throw new IllegalArgumentException("first argument to keys() is null");
        if (hi == null)
            throw new IllegalArgumentException("second argument to keys() is null");

        Queue<Key> queue = new Queue<Key>();
        keys(root, queue, lo, hi);
        return queue;
    }

    public void keys(Node x, Queue<Key> queue, Key lo, Key hi) {
        if (x == null)
            return;
        int cmplo = lo.compareTo(x.key);
        int cmphi = hi.compareTo(x.key);
        if (cmplo < 0)
            keys(x.left, queue, lo, hi);
        if (cmplo <= 0 && cmphi >= 0)
            queue.enqueue(x.key);
        if (cmphi > 0)
            keys(x.right, queue, lo, hi);
    }

    public static void main(String[] args) {
        BST<String, Integer> st = new BST<String, Integer>();
        for (int i = 0; !StdIn.isEmpty(); i++) {
            String key = StdIn.readString();
            st.put(key, i);
        }

        StdOut.println();

        for (String s : st.keys())
            StdOut.println(s + " " + st.size(st.getNode(s)));
        String key = args[0];
        // st.deleteMax();
        StdOut.println("DELETE " + key);
        // st.delete(key);

        StdOut.println("=====");

        for (String s : st.keys())
            StdOut.println(s + " " + st.size(st.getNode(s)));
    }
}