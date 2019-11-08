package algs4.four;

import java.util.NoSuchElementException;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.ST;
import algs4.three.BST;

public class DegreeOfSeparation {
    //cmd /c --%  java algs4.four.DegreeOfSeparation ..\..\..\algs4-data\routes.txt " " "JFK" 
    public static void main(String[] args) {
        String fileName = args[0];
        String sp = args[1];
        SymbolGraph sg = new SymbolGraph(fileName, sp);
        Graph G = sg.G();
        String source = args[2];
        if (!sg.contains(source)) {
            StdOut.println(source + " not in db");
            return;
        }

        int s = sg.index(source);
        BreadthFirstPaths bfs = new BreadthFirstPaths(G, s);
        while (!StdIn.isEmpty()) {
            String sink=StdIn.readLine();
            if(sg.contains(sink)){
                int t=sg.index(sink);
                if(bfs.hasPathTo(t)){
                    for(int v:bfs.pathTo(t)){
                        StdOut.println("   " +sg.name(v));
                    }
                }else{
                    StdOut.println("Not Connected");
                }
            }else{
                StdOut.println(sink + " not in db");
            }
        }
    }
}