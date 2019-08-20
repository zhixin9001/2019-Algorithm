package exercise.two;

import java.util.Comparator;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Stopwatch;
import edu.princeton.cs.algs4.StdDraw;

public class Selection {
    public static void sort(Comparable[] a) {
        // int min = 0;
        // for (int i = 0; i < a.length; i++) {
        // min = i;
        // for (int j = i + 1; j < a.length; j++) {
        // if (less(a[j], a[min])) {
        // min = j;
        // }
        // }
        // exch(a, i, min);
        // }
        // Comparable min;
        // StdOut.println("Selection");
        int minIndex = 0;
        for (int i = 0; i < a.length; i++) {
            // min = a[i];
            minIndex = i;
            for (int j = i + 1; j < a.length; j++) {
                if (less(a[j], a[minIndex])) {
                    // min = a[j];
                    minIndex = j;
                }
            }
            exch(a, i, minIndex);
            int y = 0;
            // StdDraw.
            for (int x = 0; x < a.length; x++) {
                y = Integer.parseInt(a[x].toString());
                StdDraw.point(x, y);
            }
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
        // int[] input = StdIn.readAllInts();

        Integer[] a1 = new Integer[10];
        for (int i = 0; i < 10; i++) {
            a1[i] = 10 - i;
        }
        StdDraw.setXscale(0, 15);
        StdDraw.setYscale(0, 15);
        StdDraw.setPenRadius(0.005);
        StdDraw.setPenColor(StdDraw.GRAY);

        Stopwatch timer = new Stopwatch();
        Selection.sort(a1);
        assert Selection.isSorted(a1);
        // Selection.show(a1);
        // StdOut.println(timer.elapsedTime());
    }
}
