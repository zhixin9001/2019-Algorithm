
package algs4.four;

import java.util.NoSuchElementException;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.In;

public class UnionFind {
    private boolean[] marked;
    private int[] id;
    private int count;

    public UnionFind(Graph G) {
        marked = new boolean[G.V()];
        id = new int[G.V()];
        for (int s = 0; s < G.V(); s++) {
            if (!marked[s]) {
                dfs(G, s);
                count++;
            }
        }
    }

    private void dfs(Graph G, int v) {
        marked[v] = true;
        id[v] = count;
        for (int w : G.adj(v)) {
            if (!marked[w]) {
                dfs(G, w);
            }
        }
    }

    public boolean connected(int v, int w) {
        return id[v] == id[w];
    }

    public int id(int v) {
        return id[v];
    }

    public int count() {
        return count;
    }

    // java algs4.four.Graph ..\..\..\algs4-data\tinyG.txt
    public static void main(String[] args) {
        In in = new In(args[0]);
        Graph G = new Graph(in);
        UnionFind uf = new UnionFind(G);
        int m = uf.count();
        StdOut.println(m + " components");

        Bag<Integer>[] components = (Bag<Integer>[]) new Bag[m];
        for (int i = 0; i < m; i++) {
            components[i] = new Bag<Integer>();
        }

        for (int v = 0; v < G.V(); v++) {
            components[uf.id(v)].add(v);
        }

        for (int i = 0; i < m; i++) {
            for (int c : components[i]) {
                StdOut.print(c + " ");
            }
            StdOut.println();
        }
    }
}