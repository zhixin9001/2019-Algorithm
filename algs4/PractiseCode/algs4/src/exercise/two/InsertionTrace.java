package exercise.two;

import java.util.Comparator;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Stopwatch;
import edu.princeton.cs.algs4.StdDraw;
import java.awt.Font;

public class InsertionTrace {
    public static void sort(String[] a) {
        int n = a.length;
        for (int i = 1; i < a.length; i++) {
            int j;
            for (j = i; j > 0 && less(a[j], a[j - 1]); j--) {
                exch(a, j, j - 1);
            }
            draw(a, i, i, j);
        }
    }

    // exchange a[i] and a[j]
    private static void draw(String[] a, int row, int ith, int min) {
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.text(-2.50, row, ith + "");
        StdDraw.text(-1.25, row, min + "");
        for (int i = 0; i < a.length; i++) {
            if (i == min)
                StdDraw.setPenColor(StdDraw.BOOK_RED);
            else if (i < ith)
                StdDraw.setPenColor(StdDraw.BLACK);
            else
                StdDraw.setPenColor(StdDraw.LIGHT_GRAY);
            StdDraw.text(i, row, a[i] + "");
        }
    }

    // display header
    private static void header(String[] a) {
        int n = a.length;

        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.text(n / 2.0, -3, "a[ ]");
        for (int i = 0; i < n; i++)
            StdDraw.text(i, -2, i + "");
        StdDraw.text(-2.50, -2, "i");
        StdDraw.text(-1.25, -2, "min");
        StdDraw.setPenColor(StdDraw.BOOK_RED);
        StdDraw.line(-3, -1.65, n - 0.5, -1.65);
        StdDraw.setPenColor(StdDraw.BLACK);
        for (int i = 0; i < a.length; i++)
            StdDraw.text(i, -1, a[i]);
    }

    // display footer
    private static void footer(String[] a) {
        int n = a.length;
        StdDraw.setPenColor(StdDraw.BLACK);
        for (int i = 0; i < n; i++)
            StdDraw.text(i, n, a[i]);
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

        // Integer[] a1 = new Integer[10];
        // for (int i = 0; i < 10; i++) {
        // a1[i] = 10 - i;
        // }
        // // set canvas size
        // parse command-line argument as an array of 1-character strings
        String s = args[0];
        int n = s.length();
        String[] a = new String[n];
        for (int i = 0; i < n; i++)
            a[i] = s.substring(i, i + 1);

        // set canvas size
        StdDraw.setCanvasSize(30 * (n + 3), 30 * (n + 3));
        StdDraw.setXscale(-3, n + 1);
        StdDraw.setYscale(n + 1, -4);
        StdDraw.setFont(new Font("SansSerif", Font.PLAIN, 13));

        // draw the header
        header(a);

        // sort the array
        sort(a);

        // draw the footer
        footer(a);
    }
}
