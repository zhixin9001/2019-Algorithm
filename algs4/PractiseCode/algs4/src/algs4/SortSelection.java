package algs4;

import java.util.Comparator;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class SortSelection {
	public static void sort(Comparable[] a) {
		for (int i = 0; i < a.length; i++) {
			int min = i;
			for (int j = i + 1; j < a.length; j++) {
				if (a[i].compareTo(a[j]) > 0) {
					min = j;
				}
			}
			Comparable swap = a[i];
			a[i] = a[min];
			a[min] = swap;
		}
	}
	
	public static void show(Comparable[] a) {
		for(Comparable c:a) {
			StdOut.print(c);
		}
	}

	public static void main(String[] args) {
		String[] a = StdIn.readAllStrings();
		SortSelection.sort(a);
	}
}
