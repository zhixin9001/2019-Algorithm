package exercise.four;

import java.util.NoSuchElementException;
// import java.util.Stack;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Stack;

public class DepthFirstSearch {
    private boolean[] marked;
    private int count;
    private final int s;

    public DepthFirstSearch(Graph g, int s) {
        this.s = s;
        marked = new boolean[g.V()];
        dfs(g, s);
    }

    public void dfs(Graph g, int v) {
        marked[v] = true;
        count++;
        for (int a : g.adj(v)) {
            if (!marked[a]) {
                dfs(g, a);
            }
        }
    }

    public boolean marked(int w) {
        return marked[w];
    }

    public int count() {
        return count;
    }

    public boolean hasPathTo(int v) {
        return marked(v);
    }

    // cmd /c --% java algs4.four.DepthFirstSearch ..\..\..\algs4-data\tinyCG.txt 0
    public static void main(String[] args) {
        In in = new In(args[0]);
        int s = Integer.parseInt(args[1]);
        Graph g = new Graph(in);
        DepthFirstSearch search = new DepthFirstSearch(g, s);

        for (int i = 0; i < g.V(); i++) {
            if (search.marked(i))
                StdOut.print(i + " ");
        }

        StdOut.println();
        if (search.count() != g.V())
            StdOut.println("NOT connected");
        else
            StdOut.println("connected");
    }
}