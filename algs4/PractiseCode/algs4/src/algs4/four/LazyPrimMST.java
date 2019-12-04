package algs4.four;

import java.util.NoSuchElementException;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.Queue;

public class LazyPrimMST {
    private boolean[] marked;
    private Queue<Edge> mst;
    private MinPQ<Edge> pq;

    public LazyPrimMST(EdgeWeightedGraph G) {
        pq = new MinPQ<Edge>();
        marked = new boolean[G.V()];
        mst = new Queue<Edge>();
        visit(G, 0);
        while (!pq.isEmpty()) {
            Edge e = pq.delMin();
            int v = e.either(), w = e.other(v);
            if (marked[v] && marked[w])
                continue;

            mst.enqueue(e);
            if (!marked[v])
                visit(G, v);
            if (!marked[w])
                visit(G, w);
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
        double weight=0;
        for (Edge e : lazyPrim.edges()) {
            weight += e.weight();
            StdOut.println(e);
        }
        StdOut.println(weight);
    }
}