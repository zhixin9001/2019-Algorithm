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

    public DepthFirstOrder(Graph G) {
        pre=new Queue<Integer>();
        post=new Queue<Integer>();
        reversePost=new Stack<Integer>();
        marked = new boolean[G.V()];
        for(int v=0;v<G.V();v++){
            if(!marked(v))
                dfs(G, v);
        }
    }

    private void dfs(Graph G, int v) {
        pre.enqueue(v);
        marked[v] = true;
        for (int w : G.adj(v)) {
            if (!marked[w]) {
                dfs(G, w);
            }
        }
        post.enqueue(v);
        reversePost.push(v);
    }

    public boolean marked(int w) {
        return marked[w];
    }

    public Queue<Integer> pre(){
        return pre;
    }

    public Iterable<Integer> post(){
        return post;
    }

    public Iterable<Integer> reversePost(){
        return reversePost;
    }

    //cmd /c --% java algs4.four.DepthFirstOrder ..\..\..\algs4-data\tinyCG.txt 
    public static void main(String[] args) {
        In in = new In(args[0]);
        Graph G = new Graph(in);
        DepthFirstOrder order = new DepthFirstOrder(G);

        StdOut.println("pre:");
        // for(int pre:order.pre()){
        //     StdOut.print(pre + " ");
        // }
        while(order.pre().isEmpty)
        StdOut.println();
        StdOut.println("post:");
        for(int post:order.post()){
            StdOut.print(post + " ");
        }
        StdOut.println();
        StdOut.println("reversePost:");
        for(int reversePost:order.reversePost()){
            StdOut.print(reversePost + " ");
        }
        StdOut.println();
    }
}