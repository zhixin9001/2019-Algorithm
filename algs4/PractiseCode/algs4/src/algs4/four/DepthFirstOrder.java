package algs4.four;

import java.util.NoSuchElementException;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.Queue;

public class DepthFirstOrder {
    private boolean[] marked;
    private Queue<Integer> pre;
    private Queue<Integer> post;
    private Stack<Integer> reversePost;

    public DepthFirstOrder(Graph G, int s) {
        marked = new boolean[G.V()];
        edgeTo = new int[G.V()];
        this.s = s;
        dfs(G, s);
    }

    private void dfs(Graph G, int v) {
        marked[v] = true;
        count++;
        for (int w : G.adj(v)) {
            if (!marked[w]) {
                edgeTo[w] = v;
                dfs(G, w);
            }
        }
    }

    public boolean marked(int w) {
        return marked[w];
    }

    //cmd /c --% java algs4.four.DepthFirstSearch ..\..\..\algs4-data\tinyCG.txt 0 
    public static void main(String[] args) {
        In in = new In(args[0]);
        Graph G = new Graph(in);
        int s = Integer.parseInt(args[1]);
        DepthFirstSearch search = new DepthFirstSearch(G, s);

        //
        // for (int v = 0; v < G.V(); v++) {
        // if (search.marked(v))
        // StdOut.print(v + " ");
        // }

        // StdOut.println();
        // if (search.count() != G.V())
        // StdOut.println("NOT connected");
        // else
        // StdOut.println("connected");

        //
        for (int v = 0; v < G.V(); v++) {
            StdOut.print(s+" to "+v+": ");
            if(search.hasPathTo(v)){
                for(int x:search.pathTo(v)){
                    if(x==s) StdOut.print(x);
                    else StdOut.print("-"+x);
                }
            }
            StdOut.println();
        }
    }
}