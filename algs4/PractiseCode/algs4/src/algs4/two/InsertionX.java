package algs4.two;

import java.util.Comparator;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Stopwatch;

public class InsertionX {
    public static void sort(Comparable[] a) {
        int n = a.length;

        // put smallest element in position to serve as sentinel
        int exchanges = 0;
        for (int i = n-1; i > 0; i--) {
            if (less(a[i], a[i-1])) {
                exch(a, i, i-1);
                exchanges++;
            }
        }
        if (exchanges == 0) return;


        // insertion sort with half-exchanges
        for (int i = 2; i < n; i++) {
            Comparable v = a[i];
            int j = i;
            while (less(v, a[j-1])) {
                a[j] = a[j-1];
                j--;
            }
            a[j] = v;
        }
    }

    private static boolean less(Comparable a, Comparable b) {
        return a.compareTo(b) < 0;
    }

    private static void exch(Comparable[] a, int i, int j) {
        Comparable swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }

    private static void show(Comparable[] a) {
        for (Comparable c : a) {
            // StdOut.print(c + " ");
            StdOut.println(c);
        }
        // StdOut.println();
    }

    private static boolean isSorted(Comparable[] a) {
        for (int i = 1; i < a.length; i++) {
            if (less(a[i], a[i - 1])) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] input = StdIn.readAllInts();
        Integer[] a1 = new Integer[input.length];
        for (int i = 0; i < input.length; i++) {
            a1[i] = input[i];
        }

        Stopwatch timer = new Stopwatch();
        // Insertion.sort(a1);
        // assert Insertion.isSorted(a1);
        // Insertion.show(a1);
        // StdOut.println(timer.elapsedTime());
    }
}
