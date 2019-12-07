package algs4.four;

import java.util.NoSuchElementException;
import java.lang.RuntimeException;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.In;

public class Edge implements Comparable<Edge> {
    private final int v; 
    private final int w; 
    private final double weight; 

    public Edge(int v, int w, double weight) {
        this.v = v;
        this.w = w;
        this.weight = weight;
    }

    public double weight() {
        return this.weight;
    }

    public int either() {
        return this.v;
    }

    public int other(int vertex) {
        if (v == vertex)
            return w;
        if (w == vertex)
            return v;
        else
            throw new RuntimeException("Inconsistent edge");
    }

    public int compareTo(Edge that) {
        if (this.weight() < that.weight())
            return -1;
        else if (this.weight() > that.weight())
            return 1;
        else
            return 0;
    }

    public String toString() {
        return String.format("%d-%d %.2f", v, w, weight);
    }
}