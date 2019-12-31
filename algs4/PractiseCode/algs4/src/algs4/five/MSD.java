package algs4.five;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Insertion;

public class MSD {
    private static int R = 256;
    private static final int M = 0;
    private static String[] aux;

    private static int charAt(String s, int d) {
        if (d < s.length())
            return s.charAt(d);
        else
            return -1;
    }

    public static void sort(String[] a) {
        int N = a.length;
        aux = new String[N];
        StdOut.println(String.format("sort(a, %s, %s, %s)", 0, N - 1, 0));
        sort(a, 0, N - 1, 0);

    }

    public static int index;

    public static void sort(String[] a, int lo, int hi, int d) {
        index++;
        if (hi <= lo + M) {
            insertion(a, lo, hi, d);
            return;
        }

        int[] count = new int[R + 2];
        for (int i = lo; i <= hi; i++)
            count[charAt(a[i], d) + 2]++;

        for (int r = 0; r < R + 1; r++)
            count[r + 1] += count[r];

        for (int i = lo; i <= hi; i++)
            aux[count[charAt(a[i], d) + 1]++] = a[i];

        for (int i = lo; i <= hi; i++)
            a[i] = aux[i - lo];

        StdOut.print("count= ");
        for (int i : count) {
            StdOut.print(String.format("%d ", i));
        }
        StdOut.println();
        StdOut.print("a= ");
        for (String s : a) {
            StdOut.print(String.format("%s ", s));
        }
        StdOut.println();
        StdOut.print("aux= ");
        for (String s : aux) {
            StdOut.print(String.format("%s ", s));
        }
        StdOut.println();
        for (int r = 0; r < R; r++) {
            StdOut.println(String.format("%d sort(a, %s, %s, %s)", index, lo + count[r], lo + count[r + 1] - 1, d + 1));
            sort(a, lo + count[r], lo + count[r + 1] - 1, d + 1);
        }
    }

    // insertion sort a[lo..hi], starting at dth character
    private static void insertion(String[] a, int lo, int hi, int d) {
        for (int i = lo; i <= hi; i++)
            for (int j = i; j > lo && less(a[j], a[j - 1], d); j--)
                exch(a, j, j - 1);
    }

    // exchange a[i] and a[j]
    private static void exch(String[] a, int i, int j) {
        String temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    // is v less than w, starting at character d
    private static boolean less(String v, String w, int d) {
        // assert v.substring(0, d).equals(w.substring(0, d));
        for (int i = d; i < Math.min(v.length(), w.length()); i++) {
            if (v.charAt(i) < w.charAt(i))
                return true;
            if (v.charAt(i) > w.charAt(i))
                return false;
        }
        return v.length() < w.length();
    }

    // cmd /c --% java algs4.five.MSD < ..\..\..\algs4-data\words3.txt
    // cmd /c --% java algs4.five.MSD < .\algs4\five\testWords.txt
    public static void main(String[] args) {
        String[] a = StdIn.readAllStrings();
        int n = a.length;
        int w = a[0].length();

        // sort the strings
        sort(a);
        // print results
        for (int i = 0; i < n; i++)
            StdOut.println(a[i]);
    }
}