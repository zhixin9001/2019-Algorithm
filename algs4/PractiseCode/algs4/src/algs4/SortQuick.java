package algs4;

import java.util.Comparator;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Stopwatch;
import edu.princeton.cs.algs4.StdRandom;

public class SortQuick {

    public static void sort(int[] a) {
        StdRandom.shuffle(a);
        sort(a, 0, a.length - 1);
        assert isSorted(a);
    }

    private static void sort(int[] a, int lo, int hi) {
        if (hi <= lo)
            return;
        int j = partition(a, lo, hi);
        sort(a, lo, j - 1);
        sort(a, j + 1, hi);
        // assert isSorted(a, lo, hi);
    }

    private static boolean less(int v, int w) {
        if (v == w)
            return false; // optimization when reference equals
        return v < w;
    }

    private static int partition(int[] a, int lo, int hi) {
        int i = lo;
        int j = hi + 1;
        int v = a[lo];
        while (true) {

            // find item on lo to swap
            while (less(a[++i], v)) {
                if (i == hi)
                    break;
            }

            // find item on hi to swap
            while (less(v, a[--j])) {
                if (j == lo)
                    break; // redundant since a[lo] acts as sentinel
            }

            // check if pointers cross
            if (i >= j)
                break;

            exch(a, i, j);
        }

        // put partitioning item v at a[j]
        exch(a, lo, j);

        // now, a[lo .. j-1] <= a[j] <= a[j+1 .. hi]
        return j;
    }

    public static boolean isSorted(int[] a) {
        for (int i = 1; i < a.length; i++) {
            if (a[i] < a[i - 1]) {
                return false;
            }
        }
        return true;
    }

    private static void exch(int[] a, int i, int j) {
        int swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }

    public static void main(String[] args) {
        int[] a = StdIn.readAllInts();
        // String[] a = StdIn.readAllStrings();
        StdOut.println(1);
        Stopwatch timer = new Stopwatch();
        SortQuick.sort(a);
        // StdOut.println("---------------------------");
        for (int i : a) {
            StdOut.println(i);
        }
        // StdOut.println(timer.elapsedTime());
    }
}
