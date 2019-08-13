package exercise.one;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.Stopwatch;

public class UFquickUnion_1_5_16 {

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

    public UFquickUnion_1_5_16(int n) {
        if (n < 0)
            throw new IllegalArgumentException();
        id = new int[n];
        count = n;
        for (int i = 0; i < n; i++) {
            id[i] = i;
        }
    }

    public int find(int p) {
        validate(p);
        cost=1;
        total++;
        while (p != id[p]) {
            cost += 2;
            total += 2;
            p = id[p];
        }
        return p;
    }

    public int count() {
        return count;
    }

    public boolean connected(int p, int q) {
        connTimes++;
        return find(p) == find(q);
    }

    public void union(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);
        if (pRoot == qRoot) {
            return;
        }
        id[pRoot] = qRoot;
        count--;
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
        UFquickUnion_1_5_16 uf = new UFquickUnion_1_5_16(n);
        StdDraw.setXscale(0, 1000000);
        StdDraw.setYscale(0, 1000000);
        StdDraw.setPenRadius(0.005);
        Stopwatch timer = new Stopwatch();
        while (!StdIn.isEmpty()) {
            // draw
            if (uf.ConnTimes() > 0) {
                StdDraw.setPenColor(StdDraw.GRAY);
                StdDraw.point(uf.ConnTimes(), uf.Cost());
                //
                StdDraw.setPenColor(StdDraw.RED);
                StdDraw.point(uf.ConnTimes(), uf.Total() / uf.ConnTimes());
            }
            //
            int p = StdIn.readInt();
            int q = StdIn.readInt();
            if (uf.connected(p, q))
                continue;
            uf.union(p, q);
            // StdOut.println(p + " " + q);
        }
        StdOut.println(uf.count() + " components");
        StdOut.println(timer.elapsedTime());
    }
}