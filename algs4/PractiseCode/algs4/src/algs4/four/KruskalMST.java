package algs4.four;

import java.util.NoSuchElementException;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.UF;
import edu.princeton.cs.algs4.Queue;

public class KruskalMST {
    private Queue<Edge> mst;
    private double _weight = 0;

    public KruskalMST(EdgeWeightedGraph G) {
        mst = new Queue<Edge>();
        MinPQ<Edge> pq = new MinPQ<Edge>();
        UF uf = new UF(G.V());

        for (Edge e : G.edges()) {
            pq.insert(e);
        }

        while (!pq.isEmpty() && mst.size() < G.V() - 1) {
            Edge e = pq.delMin();
            int v = e.either(), w = e.other(v);
            if (uf.connected(v, w))
                continue;
            uf.union(v, w);
            mst.enqueue(e);
            _weight += e.weight();
        }
    }

    public Iterable<Edge> edges() {
        return mst;
    }

    public double weight() {
        return _weight;
    }

    // cmd /c --% java algs4.four.KruskalMST ..\..\..\algs4-data\tinyEWG.txt
    public static void main(String[] args) {
        In in = new In(args[0]);
        EdgeWeightedGraph ewg = new EdgeWeightedGraph(in);
        KruskalMST kruskalMST = new KruskalMST(ewg);
        // StdOut.println(ewg);
        for (Edge e : kruskalMST.edges()) {
            StdOut.println(e);
        }
        StdOut.println(kruskalMST.weight());
    }
}