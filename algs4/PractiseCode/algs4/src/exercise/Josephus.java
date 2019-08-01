package exercise;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Queue;


import java.util.Iterator;
import java.util.NoSuchElementException;

import com.sun.glass.ui.Size;

public class Josephus {
    // private static class Node {
    //     public int index;
    //     public Node next;
    // }

    // private Node first;
    // private int N;

    // public Josephus(int n) {
    //     first = new Node();
    //     first.index = 0;
    //     Node temp = first;
    //     for (int i = 1; i < n; i++) {
    //         Node nextNode = new Node();
    //         nextNode.index = i;
    //         nextNode.next = first;
    //         temp.next = nextNode;
    //         temp = nextNode;
    //     }
    //     N = n;

    // }

    // public int remove(Node killNext) {
    //     int result = killNext.next.index;
    //     killNext.next = killNext.next.next;
    //     N--;
    //     return result;
    // }

    // public int size() {
    //     return N;
    // }

    // public static void main(String[] args) {
    //     Josephus josephus = new Josephus(7);
    //     while (josephus.size() > 1) {
    //         StdOut.println("size=" + josephus.size());
    //         Node killNext = josephus.first;  //needn't back to first
    //         for (int i = 0; i < 2; i++) {
    //             killNext = killNext.next;
    //         }
    //         StdOut.println(josephus.remove(killNext));
    //     }

    // }

    public static void main(String[] args) {
        int m = Integer.parseInt(args[0]);
        int n = Integer.parseInt(args[1]);

        // initialize the queue
        Queue<Integer> queue = new Queue<Integer>();
        for (int i = 0; i < n; i++)
            queue.enqueue(i);

        while (!queue.isEmpty()) {
            for (int i = 0; i < m-1; i++)
                queue.enqueue(queue.dequeue());  //dequeue + enqueue, same as a cycle queue
            StdOut.print(queue.dequeue() + " ");
        } 
        StdOut.println();
    }
}

//java exercise.Josephus 2 7