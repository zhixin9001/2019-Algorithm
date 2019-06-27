package algs4;

import java.util.Comparator;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Stopwatch;

public class SortMergeBU {

    private static int[] aux;

    private static void merge(int[] a, int lo, int mid, int hi) { //
        int i = lo, j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            aux[k] = a[k];
        }

        for (int k = lo; k <= hi; k++) {
            if (i > mid) {
                a[k] = aux[j++];
            } else if (j > hi) {
                a[k] = aux[i++];
            } else if (aux[i] < aux[j]) {
                a[k] = aux[i++];
            } else {
                a[k] = aux[j++];
            }
        }
    }

/*
------1
 lo=0 mid=0 hi=1
8 30 -30 -20 -10 40 0 10 15 .............
 lo=2 mid=2 hi=3
8 30 -30 -20 -10 40 0 10 15 .............
 lo=4 mid=4 hi=5
8 30 -30 -20 -10 40 0 10 15 .............
 lo=6 mid=6 hi=7
8 30 -30 -20 -10 40 0 10 15 .............
------2
 lo=0 mid=1 hi=3
-30 -20 8 30 -10 40 0 10 15 .............
 lo=4 mid=5 hi=7
-30 -20 8 30 -10 0 10 40 15 .............
------4
 lo=0 mid=3 hi=7
-30 -20 -10 0 8 10 30 40 15 .............
------8
 lo=0 mid=7 hi=8
-30 -20 -10 0 8 10 15 30 40
*/

    public static void sort(int[] a) {
        int n = a.length;
        aux = new int[a.length];
        for (int len = 1; len < n; len *= 2) {
            // StdOut.print("------");
            // StdOut.println(len);
            for (int lo = 0; lo < n - len; lo += len + len) {
                int mid = lo + len - 1;
                int hi = Math.min(lo + len + len - 1, n - 1);
                // StdOut.print(" lo=");
                // StdOut.print(lo);
                // StdOut.print(" mid=");
                // StdOut.print(mid);
                // StdOut.print(" hi=");
                // StdOut.println(hi);
                merge(a, lo, mid, hi);
                // for (int i : a) {
                //     StdOut.print(i);
                //     StdOut.print(" ");
                // }
                // StdOut.println(".............");
            }
        }
        assert isSorted(a);
    }

    public static boolean isSorted(int[] a) {
        for (int i = 1; i < a.length; i++) {
            if (a[i] < a[i - 1]) {
                return false;
            }
        }
        return true;
    }

    public static void insertionSort(int[] a, int lo, int hi) {
        for (int i = lo; i <= hi; i++) {
            for (int j = i; j > 0 && (a[j] < a[j - 1]); j--) {
                exch(a, j, j - 1);
            }
        }
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
        SortMergeBU.sort(a);
        StdOut.println("---------------------------");
        // for (int i : a) {
        //     StdOut.println(i);
        // }
        StdOut.println(timer.elapsedTime());
    }
}
