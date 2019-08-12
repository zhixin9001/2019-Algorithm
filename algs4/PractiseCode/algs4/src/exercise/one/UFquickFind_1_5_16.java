package exercise.one;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdDraw;

public class UFquickFind_1_5_16 {

    private int[] id;
    private int count; // number of components

    //
    private int connTimes = 0;
    private int cost = 0;
    private int total = 0;

    public int ConnTimes() {
        return connTimes;
    }

    public int Cost() {
        return cost;
    }

    public int Total() {
        return total;
    }

    //

    public UFquickFind_1_5_16(int n) {
        if (n < 0)
            throw new IllegalArgumentException();
        id = new int[n];
        count=n;
        for (int i = 0; i < n; i++) {
            id[i] = i;
        }
    }

    public int find(int p) {
        validate(p);
        return id[p];
    }

    public int count() {
        return count;
    }

    public boolean connected(int p, int q) {
        connTimes++;
        cost = 2;
        total += 2;
        return find(p) == find(q);
    }

    public void union(int p, int q) {
        int vp = find(p);
        int vq = find(q);
        cost += 2;
        total += 2;
        /*
         * error implement, need to refresh all the equal vp items if (vp == vq) {
         * return; } else { id[q] = vp; count--; }
         */

        if (vp == vq) {
            return;
        }
        for (int i = 0; i < id.length; i++) {
            cost++;
            total++;
            if (id[i] == vq) {
                id[i] = vp;
                cost++;
                total++;
            }
            // count--;//don't forget this
        }
        count--;// should be here
    }

    // validate that p is a valid index
    private void validate(int p) {
        if (p < 0 || p >= id.length) {
            throw new IllegalArgumentException("index " + p + " is not between 0 and " + (count - 1));
        }
    }

    public static void main(String[] args) {
        StdOut.println(1);
        int n = StdIn.readInt();
        StdOut.println(n);
        UFquickFind_1_5_16 ufQquickFind = new UFquickFind_1_5_16(n);
        StdDraw.setXscale(0, 1000);
        StdDraw.setYscale(0, 2000);
        StdDraw.setPenRadius(0.005);
        while (!StdIn.isEmpty()) {
            // draw
            if (ufQquickFind.ConnTimes() > 0) {
                StdDraw.setPenColor(StdDraw.GRAY);
                StdDraw.point(ufQquickFind.ConnTimes(), ufQquickFind.Cost());
                //
                StdDraw.setPenColor(StdDraw.RED);
                StdDraw.point(ufQquickFind.ConnTimes(), ufQquickFind.Total() / ufQquickFind.ConnTimes());
            }
            //
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