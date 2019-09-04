package algs4.two;

import java.util.Comparator;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Stopwatch;
import edu.princeton.cs.algs4.StdRandom;

public class SortCompare {

    public static Double[] copy(Double[] a) {
        Double[] b = new Double[a.length];
        for (int i = 0; i < a.length; i++) {
            b[i] = a[i];
        }
        return b;
    }

    public static Double[] randominput(int n) {
        Double[] a = new Double[n];
        for (int i = 0; i < n; i++) {
            a[i] = StdRandom.uniform();
        }
        return a;
    }

    public static Double[] ascInput(int n) {
        Double[] a = new Double[n];
        for (int i = 0; i < n; i++) {
            a[i] = i * 1.0;
        }
        return a;
    }

    public static Double[] descInput(int n) {
        Double[] a = new Double[n];
        for (int i = 0; i < n; i++) {
            a[i] =n- i * 1.0;
        }
        return a;
    }

    public static void main(String[] args) {
        String arg1 = args[0];
        int n = Integer.parseInt(arg1);
        Double[] input = descInput(n);
        Double[] a1 = copy(input);
        Stopwatch timer = new Stopwatch();
        // InsertionX.sort(a1);
        // StdOut.println("InsertionX, " + timer.elapsedTime());

        // a1 = copy(input);
        // timer = new Stopwatch();
        // Selection.sort(a1);
        // StdOut.println("Selection, " + timer.elapsedTime());

        // a1 = copy(input);
        // timer = new Stopwatch();
        // Insertion.sort(a1);
        // StdOut.println("Insertion, " + timer.elapsedTime());
        
        a1 = copy(input);
        timer = new Stopwatch();
        Shell.sort(a1);
        StdOut.println("Shell, " + timer.elapsedTime());
        
        a1 = copy(input);
        timer = new Stopwatch();
        Merge.sort(a1);
        StdOut.println("Merge, " + timer.elapsedTime());
         
        a1 = copy(input);
        timer = new Stopwatch();
        MergeOptimize.sort(a1);
        StdOut.println("MergeOptimize, " + timer.elapsedTime());
         
        a1 = copy(input);
        timer = new Stopwatch();
        MergeBU.sort(a1);
        StdOut.println("MergeBU, " + timer.elapsedTime());
        
        a1 = copy(input);
        timer = new Stopwatch();
        Quick.sort(a1);
        StdOut.println("Quick, " + timer.elapsedTime());

    }
}