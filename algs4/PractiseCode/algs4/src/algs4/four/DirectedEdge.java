package algs4.four;

import java.util.NoSuchElementException;
import java.lang.RuntimeException;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.In;

public class DirectedEdge {
    private final int v; 
    private final int w; 
    private final double weight; 

    public DirectedEdge(int v, int w, double weight) {
        this.v = v;
        this.w = w;
        this.weight = weight;
    }

    public double weight() {
        return this.weight;
    }

    public int from() {
        return this.v;
    }

    public int to() {
        return this.w;
    }

    public String toString() {
        return String.format("%d->%d %.2f", v, w, weight);
    }
}