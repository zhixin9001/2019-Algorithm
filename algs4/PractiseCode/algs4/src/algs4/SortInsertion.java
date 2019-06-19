package algs4;

import java.util.Comparator;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Stopwatch;

public class SortInsertion {
	public static void sort(Comparable[] a) {
		for (int i = 1; i < a.length; i++) {
            for(int j=i;j>0&&less(a[j],a[j-1]);j--){
                exch(a, j, j-1);
            }
		}
	}

	public static void sort(int[] a) {
		for (int i = 0; i < a.length; i++) {
            for(int j=i;j>0&&less(a[j],a[j-1]);j--){
                exch(a, j, j-1);
            }			
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
		SortInsertion.sort(a);
		StdOut.println(timer.elapsedTime());
	}
}
