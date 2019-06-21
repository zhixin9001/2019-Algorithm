package algs4;

import java.util.Comparator;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Stopwatch;

public class SortInsertion {
	public static void sort(Comparable[] a) {
		for (int i = 1; i < a.length; i++) {
			for (int j = i; j > 0 && less(a[j], a[j - 1]); j--) {
				exch(a, j, j - 1);
			}
		}
	}

	public static void sort(int[] a) {
		for (int i = 0; i < a.length; i++) {
			for (int j = i; j > 0 && less(a[j], a[j - 1]); j--) {
				exch(a, j, j - 1);
			}
		}
	}

	// e1: a[i] > a[j - 1], 内层循环i是不变的
	// e2: exch(a, i, j);
	// e3: <, 不是>
	// i=1，还是i=0，应该是都行，如果i=0,内层循环j>0就不满足了，a[j-1]不会走到，所以不会超出范围；如果i=1,第一次就可以走到内层循环
	public static void sortP(int[] a) {
		for (int i = 1; i < a.length; i++) {
			for (int j = i; j > 0 && a[/* i */j] /* > */ < a[j - 1]; j--) {
				// exch(a, i, j);
				exch(a, j, j - 1);
			}
		}
	}

	// 改进
	public static void sortP1(int[] a) {
		for (int i = 0; i < a.length; i++) {
			int insertIndex = i;
			for (int j = i; j > 0 && less(a[i], a[j - 1]); j--) {
				StdOut.println(a[i] + "<" + a[j - 1]);
				insertIndex = j - 1;
			}
			StdOut.println(i + "<->" + insertIndex);
			exch(a, i, insertIndex);
			// if (insertIndex != i) {
			// StdOut.println(i + "<->" + insertIndex);
			// exch(a, i, insertIndex);
			// }
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

	public static void main(String[] args) {
		int[] a = StdIn.readAllInts();
		// String[] a = StdIn.readAllStrings();
		Stopwatch timer = new Stopwatch();
		SortInsertion.sortP1(a);
		StdOut.println("---show");
		for (int i : a) {
			StdOut.println(i);
		}
		// StdOut.println(timer.elapsedTime());
	}
}
