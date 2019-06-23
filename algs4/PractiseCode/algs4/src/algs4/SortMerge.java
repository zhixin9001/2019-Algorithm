package algs4;

import java.util.Comparator;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Stopwatch;

public class SortMerge {

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

    private static void mergeP(int[] a, int lo, int mid, int hi) {
        int i = lo, j = mid + 1; // j=mid+1
        for (int k = lo; k <= hi; k++) { // k is [lo,hi], pay attention to <=hi
            aux[k] = a[k];
        }

        // the big error, how can i forget the for cycle
        // if (i > mid) {
        // a[i] = aux[j++];
        // } else if (j > hi) {
        // a[j] = aux[i++];
        // } else if (aux[i] < aux[j]) {
        // a[i] = aux[i++];
        // } else {
        // a[j] = aux[j++];
        // }

        for (int k = lo; k <= hi; k++) {
            if (i > mid) {
                a[k] = aux[j++];
            } else if (j > hi) {
                a[k] = aux[i++];
            } else if (aux[j] < aux[i]) { // this is the key of sortting
                a[k] = aux[j++];
            } else { // equals to else if (aux[i] < aux[j])
                a[k] = aux[i++];
            }
        }

    }

    private static final int CUTOFF = 1000; // cutoff to insertion sort

    private static void sort(int[] a, int lo, int hi) {
        if (hi <= lo) {
            return;
        }
        int mid = lo + (hi - lo) / 2;
        sort(a, lo, mid);
        sort(a, mid + 1, hi);
        merge(a, lo, mid, hi);
    }

    private static void sortP(int[] a, int lo, int hi) {
        if (hi <= lo) { // this's is the condition to ending the recursive
            return;
        }
        int mid = lo + (hi - lo) / 2;
        sortP(a, lo, mid);
        sortP(a, mid + 1, hi);
        mergeP(a, lo, mid, hi);
    }

    private static void sortP1(int[] a, int lo, int hi) {
        if (hi <= lo + CUTOFF) { // this's is the condition to ending the recursive
            insertionSort(a, lo, hi);
            return;
        }
        int mid = lo + (hi - lo) / 2;
        sortP(a, lo, mid);
        sortP(a, mid + 1, hi);
        mergeP(a, lo, mid, hi);
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

    private static void sort(int[] a) {
        aux = new int[a.length];
        sort(a, 0, a.length - 1);
    }

    private static void sortP(int[] a) {
        aux = new int[a.length];
        sortP1(a, 0, a.length - 1); // 试试 must be a.length-1
    }

    public static void main(String[] args) {
        int[] a = StdIn.readAllInts();
        // String[] a = StdIn.readAllStrings();
        StdOut.println(1);
        Stopwatch timer = new Stopwatch();
        SortMerge.sortP(a);
        // for (int i : a) {
        //     StdOut.println(i);
        // }
        StdOut.println(timer.elapsedTime());
    }
}
