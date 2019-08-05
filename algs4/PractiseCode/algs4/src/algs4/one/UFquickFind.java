package algs4.one;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class UFquickFind {

    private int[] id;
    private int count; // number of components

    /**
     * Initializes an empty union–find data structure with {@code n} sites {@code 0}
     * through {@code n-1}. Each site is initially in its own component.
     *
     * @param n the number of sites
     * @throws IllegalArgumentException if {@code n < 0}
     */
    public UFquickFind(int n) {
        if (n < 0)
            throw new IllegalArgumentException();
        id = new int[n];
        count=n;
        for (int i = 0; i < n; i++) {
            id[i] = i;
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
        return id[p];
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
     * @param p the integer representing one site
     * @param q the integer representing the other site
     * @return {@code true} if the two sites {@code p} and {@code q} are in the same
     *         component; {@code false} otherwise
     * @throws IllegalArgumentException unless both {@code 0 <= p < n} and
     *                                  {@code 0 <= q < n}
     */
    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    /**
     * Merges the component containing site {@code p} with the the component
     * containing site {@code q}.
     *
     * @param p the integer representing one site
     * @param q the integer representing the other site
     * @throws IllegalArgumentException unless both {@code 0 <= p < n} and
     *                                  {@code 0 <= q < n}
     */
    public void union(int p, int q) {
        int vp = find(p);
        int vq = find(q);
        /*
        error implement, need to refresh all the equal vp items
        if (vp == vq) {
            return;
        } else {
            id[q] = vp;
            count--;
        }
        */

        if(vp==vq){
            return;
        }
        for(int i=0;i<id.length;i++){
            if(id[i]==vq){
                id[i]=vp;
            }
//            count--;//don't forget this
        }
        count--;//should be here
    }

    // validate that p is a valid index
    private void validate(int p) {
        if (p < 0 || p >= id.length) {
            throw new IllegalArgumentException("index " + p + " is not between 0 and " + (count - 1));
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
        StdOut.println(1);
        int n = StdIn.readInt();
        StdOut.println(n);
        UFquickFind ufQquickFind = new UFquickFind(n);
        while (!StdIn.isEmpty()) {
            int p = StdIn.readInt();
            int q = StdIn.readInt();
            if (ufQquickFind.connected(p, q))
                continue;
            ufQquickFind.union(p, q);
            StdOut.println(p + " " + q);
        }
        StdOut.println(ufQquickFind.count() + " components");
    }
}