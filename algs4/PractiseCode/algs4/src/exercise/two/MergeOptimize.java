package exercise.two;

import java.util.Comparator;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Stopwatch;

public class MergeOptimize {

    private static int CUTOFF = 4;

    private static void merge(Comparable[] src, Comparable[] dst, int lo, int mid, int hi) { //
        int i = lo, j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            src[k] = dst[k];
        }

        for (int k = lo; k <= hi; k++) {
            if (i > mid) {
                dst[k] = src[j++];
            } else if (j > hi) {
                dst[k] = src[i++];
            } else if (less(src[i], src[j])) {
                dst[k] = src[i++];
            } else {
                dst[k] = src[j++];
            }
        }
    }

    private static void sort(Comparable[] src, Comparable[] dst, int lo, int hi) {
        if (hi <= lo + CUTOFF) {
            insertionSort(dst, lo, hi);
            return;
        }
        int mid = lo + (hi - lo) / 2;
        sort(src, dst, lo, mid);
        sort(src, dst, mid + 1, hi);

        // if (!less(src[mid + 1], src[mid])) {
        // for (int i = lo; i <= hi; i++) {
        // dst[i] = src[i];
        // }
        // return;
        // }

        merge(src, dst, lo, mid, hi);
    }

    public static void sort(Comparable[] a) {
        Comparable[] aux = a.clone();
        sort(aux, a, 0, a.length - 1);
    }

    public static void insertionSort(Comparable[] a, int lo, int hi) {
        for (int i = lo; i <= hi; i++) {
            for (int j = i; j > 0 && less(a[j], a[j - 1]); j--) {
                exch(a, j, j - 1);
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
        int[] input = StdIn.readAllInts();

        Integer[] a1 = new Integer[input.length];
        for (int i = 0; i < input.length; i++) {
            a1[i] = input[i];
        }

        Stopwatch timer = new Stopwatch();
        sort(a1);
        assert isSorted(a1);
        show(a1);
        // StdOut.println(timer.elapsedTime());
    }
}
