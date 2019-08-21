package algs4.two;

import java.util.Comparator;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Stopwatch;

public class Shell {
    public static void sort(Comparable[] a) {
        // StdOut.println("Shellq, ");
        int N = a.length;
        int h = 1;
        while (h <= N / 3) {
            h = 3 * h + 1;
        }

        while (h >= 1) {
            for (int i = h; i < N; i++) {
                for (int j = i; j > h && less(a[j], a[j - h]); j -= h) {
                    exch(a, j, j - h);
                }
            }
            h /= 3;
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
        assert Shell.isSorted(a1);
        Shell.show(a1);
        // StdOut.println(timer.elapsedTime());
    }
}