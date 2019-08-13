package algs4.one;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Stopwatch;

public class UFweightedQuickUnion {

    private int[] parent;
    private int[] size;
    private int count; // number of components

    /**
     * Initializes an empty union–find data structure with {@code n} sites {@code 0}
     * through {@code n-1}. Each site is initially in its own component.
     *
     * @param n the number of sites
     * @throws IllegalArgumentException if {@code n < 0}
     */
    public UFweightedQuickUnion(int n) {
        if (n < 0)
            throw new IllegalArgumentException();
        parent = new int[n];
        size = new int[n];
        count = n;
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            //size[i] = i;
            size[i]=1;  //1 not i
        }
    }

    /**
     * Returns the component identifier for the component containing site {@code p}.
     *
     * @param p the integer representing one site
     * @return the component identifier for the component containing site {@code p}
     * @throws IllegalArgumentException unless {@code 0 <= p < n}
     */
    public int find(int p) {
        validate(p);
        
        while (p != parent[p]) {
            p = parent[p];
        }
        return p;
    }

    /**
     * Returns the number of components.
     *
     * @return the number of components (between {@code 1} and {@code n})
     */
    public int count() {
        return count;
    }

    /**
     * Returns true if the the two sites are in the same component.
     *
     * @param a the integer representing one site
     * @param b the integer representing the other site
     * @return {@code true} if the two sites {@code p} and {@code q} are in the same
     *         component; {@code false} otherwise
     * @throws IllegalArgumentException unless both {@code 0 <= p < n} and
     *                                  {@code 0 <= q < n}
     */
    public boolean connected(int a, int b) {
        return find(a) == find(b);
    }

    /**
     * Merges the component containing site {@code p} with the the component
     * containing site {@code q}.
     *
     * @param a the integer representing one site
     * @param b the integer representing the other site
     * @throws IllegalArgumentException unless both {@code 0 <= p < n} and
     *                                  {@code 0 <= q < n}
     */
    public void union(int a, int b) {
        int aRoot = find(a);
        int bRoot = find(b);
        if (aRoot == bRoot) {
            return;
        }

        // if(size[p]<size[q/*wrong, qRoot*/]){
        // id[pRoot] = qRoot;
        // size[q]+=size[p];
        // }else{
        // id[qRoot]=pRoot;
        // size[p]+=size[q];
        // }

        if (size[aRoot] < size[bRoot]) {
            parent[aRoot] = bRoot;
            size[bRoot] += size[aRoot];
        } else {
            parent[bRoot] = aRoot;
            size[aRoot] += size[bRoot];
        }
        count--;
    }

    // validate that p is a valid index
    private void validate(int p) {
        if (p < 0 || p >= parent.length) {
            throw new IllegalArgumentException("index " + p + " is not between 0 and " + (parent.length - 1));
        }
    }

    /**
     * Reads in a an integer {@code n} and a sequence of pairs of integers (between
     * {@code 0} and {@code n-1}) from standard input, where each integer in the
     * pair represents some site; if the sites are in different components, merge
     * the two components and print the pair to standard output.
     *
     * @param args the command-line arguments
     */
    public static void main(String[] args) {
        int n = StdIn.readInt();
        StdOut.println(n);
        UFweightedQuickUnion uf = new UFweightedQuickUnion(n);
        Stopwatch timer = new Stopwatch();
        while (!StdIn.isEmpty()) {
            int a = StdIn.readInt();
            int b = StdIn.readInt();
            if (uf.connected(a, b))
                continue;
            uf.union(a, b);
            StdOut.println(a + " " + b);
        }
        StdOut.println(uf.count() + " components");
        StdOut.println(timer.elapsedTime());
    }
}