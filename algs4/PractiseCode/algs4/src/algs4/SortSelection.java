package algs4;

import java.util.Comparator;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Stopwatch;

public class SortSelection {
	public static void sort(Comparable[] a) {
		for (int i = 0; i < a.length; i++) {
			int min = i;
			for (int j = i + 1; j < a.length; j++) {
				if (less(a[j], a[min])) {
					min = j;
				}
			}
			exch(a, i, min);
		}
	}

	public static void sort(int[] a) {
		for (int i = 0; i < a.length; i++) {
			int min = i;
			for (int j = i + 1; j < a.length; j++) {
				if ((a[j] < a[min])) {
					min = j;
				}
			}
			exch(a, i, min);
		}
	}

	public static void sortP(int[] a) {
		for (int i = 0; i < a.length; i++) {
			int min = i;
			for (int j = i + 1; j < a.length; j++) {
				if (a[j] < a[/* i */min]) {
					min = j;
				}
			}
			exch(a, i, /* j */min);
		}
	}

	private static boolean less(Comparable a, Comparable b) {
		return a.compareTo(b) < 0;
	}

	private static void exch(Object[] a, int i, int j) {
		Object swap = a[i];
		a[i] = a[j];
		a[j] = swap;
	}

	private static void exch(int[] a, int i, int j) {
		int swap = a[i];
		a[i] = a[j];
		a[j] = swap;
	}

	public static void show(Comparable[] a) {
		for (Comparable c : a) {
			StdOut.println(c);
		}
	}

	public static void main(String[] args) {
		int[] a = StdIn.readAllInts();
		// String[] a = StdIn.readAllStrings();
		Stopwatch timer = new Stopwatch();
		SortSelection.sort(a);
		StdOut.println(timer.elapsedTime());
	}
}
