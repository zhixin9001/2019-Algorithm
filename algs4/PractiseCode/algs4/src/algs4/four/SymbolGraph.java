package algs4.four;

import java.util.NoSuchElementException;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.ST;
import algs4.three.BST;

public class SymbolGraph {
    private ST<String, Integer> st;
    private String[] keys;
    private Graph G;

    public SymbolGraph(String stream, String sp) {
        st = new ST<String, Integer>();
        In in = new In(stream);
        while (in.hasNextLine()) {
            String[] a = in.readLine().split(sp);
            for (int i = 0; i < a.length; i++) {
                if (!st.contains(a[i])) {
                    st.put(a[i], st.size());
                }
            }
        }
        keys = new String[st.size()];
        for (String name : st.keys()) {
            keys[st.get(name)] = name;
        }

        G = new Graph(st.size());
        in = new In(stream);
        while (in.hasNextLine()) {
            String[] a = in.readLine().split(sp);
            int v = st.get(a[0]);
            for (int i = 1; i < a.length; i++) {
                G.addEdge(v, st.get(a[i]));
            }
        }
    }

    public boolean contains(String s) {
        return st.contains(s);
    }

    public int index(String s) {
        return st.get(s);
    }

    public String name(int v) {
        return keys[v];
    }

    public Graph G() {
        return G;
    }

    //cmd /c --%  java algs4.four.SymbolGraph ..\..\..\algs4-data\routes.txt " "
    //cmd /c --%  java algs4.four.SymbolGraph ..\..\..\algs4-data\movies.txt "/"
    public static void main(String[] args) {
        String fileName = args[0];
        String sp = args[1];
        SymbolGraph sg = new SymbolGraph(fileName, sp);
        Graph G = sg.G();
        StdOut.println(G);
        // while (StdIn.hasNextLine()) {
        //     String source = StdIn.readLine();
        //     for (int w : G.adj(sg.index(source))) {
        //         StdOut.println("    " + sg.name(w));
        //     }
        // }
    }
}