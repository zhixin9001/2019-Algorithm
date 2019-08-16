package algs4.two;

import java.util.Comparator;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Stopwatch;

public class Selection {
    public static void sort(Comparable[] a) {
        Comparable min;
        int minIndex = 0;
        for (int i = 0; i < a.length; i++) {
            min = a[i];
            for (int j = i + 1; j < a.length; j++) {
                if (less(a[j], min)) {
                    min = a[j];
                    minIndex = j;
                }
            }
            exch(a, i, minIndex);
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
        Selection.sort(a1);
        assert Selection.isSorted(a1);
        Selection.show(a1);
        // StdOut.println(timer.elapsedTime());
    }
}
