package algs4.four;

import java.util.NoSuchElementException;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Stack;

public class DirectedDFS {
    private boolean[] marked;

    public DirectedDFS(Digraph g, int s) {
        marked = new boolean[g.V()];
        dfs(g, s);
    }

    public DirectedDFS(Digraph g, Iterable<Integer> sources) {
        marked = new boolean[g.V()];
        for (int s : sources) {
            if (!marked[s])
                dfs(g, s);
        }
    }

    private void dfs(Digraph g, int v) {
        marked[v] = true;
        for (int w : g.adj(v))
            if (!marked[w])
                dfs(g, w);
    }

    public static void main(String[] args) {
        Digraph g = new Digraph(args[0]);
        Bag<Integer> sources = new Bag<Integer>();
        for (int i = 1; i < args.length; i++) {
            sources.add(Integer.parseInt(args[i]));
        }

        DirectedDFS directedDFS = new DirectedDFS(g, sources);
        for (int v = 0; v < g.V(); v++) {
            if (directedDFS.marked[v]) {
                StdOut.print(v + " ");
            }
        }
    }
}