package algs4.four;

import java.util.NoSuchElementException;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.IndexMinPQ;
import edu.princeton.cs.algs4.Queue;

public class PrimMST {
    private boolean[] marked;
    private Edge[] edgeTo;
    private double[] distTo;
    private Queue<Edge> mst;
    private IndexMinPQ<Double> pq;

    public PrimMST(EdgeWeightedGraph G) {
        pq = new MinPQ<Edge>();
        marked = new boolean[G.V()];
        mst = new IndexMinPQ<Double>();
        edgeTo = new Edge[G.V()];
        distTo = new double[G.V()];
        for (int v = 0; v < G.V(); v++) {
            distTo[v] = Double.POSITIVE_INFINITY;
        }
        distTo[0] = 0.0;
        pq.insert(0,0.0);
        while(!pq.isEmpty()){
            visit(G, pq.delMin);
        }
    }

    public void visit(EdgeWeightedGraph G, int v) {
        marked[v] = true;
        for (Edge e : G.adj(v)) {
            if (!marked[e.other(v)]) {
                pq.insert(e);
            }
        }
    }

    public Iterable<Edge> edges() {
        return mst;
    }

    // cmd /c --% java algs4.four.LazyPrimMST ..\..\..\algs4-data\tinyEWG.txt
    public static void main(String[] args) {
        In in = new In(args[0]);
        EdgeWeightedGraph ewg = new EdgeWeightedGraph(in);
        LazyPrimMST lazyPrim = new LazyPrimMST(ewg);
        // StdOut.println(ewg);
        for (Edge e : lazyPrim.edges()) {
            StdOut.println(e);
        }
    }
}