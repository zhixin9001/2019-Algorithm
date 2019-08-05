package algs4;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Queue<Item> {
    private static class Node<Item> {
        public Item item;
        public Node next;
    }

    private Node<Item> first;
    private Node<Item> last;
    private int N;

    public void enqueue(Item item) {
        Node<Item> oldLast = last;
        last = new Node<Item>();
        last.item = item;
        if (isEmpty()) {
            first = last;
        } else {
            oldLast.next = last;
        }
        N++;
    }

    public Item dequeue() {
        if (isEmpty()) {
            return null;
        }
        Item result = first.item;
        first = first.next;
        if (isEmpty()) {
            last = null;
        }
        N--;
        return result;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public static void main(String[] args) {
        Queue<String> queue = new Queue<String>();
        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            queue.enqueue(item);
        }

        while(!queue.isEmpty()){
            StdOut.println(queue.dequeue());
        }
    }
}