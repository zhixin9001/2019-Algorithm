package algs4.four;

import java.util.NoSuchElementException;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Queue;

public class KosarajuSCC {
    private boolean[] marked;
    private int[] id;
    private int count;

    public KosarajuSCC(Digraph g) {
        marked = new boolean[g.V()];
        id = new int[g.V()];
        DepthFirstOrder order = new DepthFirstOrder(g.reverse());
        for (int s : order.reversePost()) {
            if (!marked[s]) {
                dfs(g, s);
                count++;
            }
        }
    }

    private void dfs(Digraph g, int v) {
        marked[v] = true;
        id[v] = count;
        for (int w : g.adj(v)) {
            if (!marked[w])
                dfs(g, w);
        }
    }

    public boolean stronglyConnected(int v, int w) {
        return id[v] == id[w];
    }

    public int id(int v) {
        return id[v];
    }

    public int count() {
        return count;
    }

    // cmd /c --% java algs4.four.KosarajuSCC ..\..\..\algs4-data\tinyDG.txt
    public static void main(String[] args) {
        In in = new In(args[0]);
        Digraph g = new Digraph(in);

        KosarajuSCC scc = new KosarajuSCC(g);

        int m = scc.count();
        StdOut.println(m + " strongly connected components");
        Queue<Integer>[] components = (Queue<Integer>[]) new Queue[m];
        for (int i = 0; i < m; i++) {
            components[i] = new Queue<Integer>();
        }

        for (int i = 0; i < g.V(); i++) {
            components[scc.id(i)].enqueue(i);
        }

        for (int i = 0; i < m; i++) {
            StdOut.println();
            for (int w : components[i]) {
                StdOut.print(w + " ");
            }
        }
        StdOut.println();
    }
}