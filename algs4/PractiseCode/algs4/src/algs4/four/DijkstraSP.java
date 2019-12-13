package algs4.four;

import java.util.NoSuchElementException;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.IndexMinPQ;
import edu.princeton.cs.algs4.Queue;

public class DijkstraSP {
    private DirectedEdge[] edgeTo;
    private double[] distTo;
    private IndexMinPQ<Double> pq;

    public DijkstraSP(EdgeWeightedDigraph G, int s) {
        edgeTo = new DirectedEdge[G.V()];
        distTo = new double[G.V()];
        pq=new IndexMinPQ<Double>(G.V());
        
        for(int v=0;v<G.V();v++){
            distTo[v]=Double.POSITIVE_INFINITY;
        }

        distTo[s]=0.0;
        pq.insert(s,0.0);
        while(!pq.isEmpty()){
            relax(G,pq.delMin());
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

    // cmd /c --% java algs4.four.DijkstraSP ..\..\..\algs4-data\tinyEWG.txt
    public static void main(String[] args) {
        In in = new In(args[0]);
        EdgeWeightedGraph ewg = new EdgeWeightedGraph(in);
        DijkstraSP lazyPrim = new DijkstraSP(ewg);
        // StdOut.println(ewg);
        double weight = 0;
        for (Edge e : lazyPrim.edges()) {
            weight += e.weight();
            StdOut.println(e);
        }
        StdOut.println(weight);
    }
}