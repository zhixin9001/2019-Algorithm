package exercise.one;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.Stopwatch;

public class UFweightedQuickUnion_1_5_16 {

    private int[] parent;
    private int[] size;
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

    public UFweightedQuickUnion_1_5_16(int n) {
        if (n < 0)
            throw new IllegalArgumentException();
        parent = new int[n];
        size = new int[n];
        count = n;
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            // size[i] = i;
            size[i] = 1; // 1 not i
        }
    }

    public int find(int p) {
        validate(p);
        cost = 1;
        total++;
        while (p != parent[p]) {
            p = parent[p];
            cost += 2;
            total += 2;
        }
        return p;
    }

    public int count() {
        return count;
    }

    public boolean connected(int a, int b) {
        connTimes++;
        return find(a) == find(b);
    }

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

    public static void main(String[] args) {
        int n = StdIn.readInt();
        StdOut.println(n);
        UFweightedQuickUnion_1_5_16 uf = new UFweightedQuickUnion_1_5_16(n);
        StdDraw.setXscale(0, 1000);
        StdDraw.setYscale(0, 1000);
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
            StdOut.println(uf.ConnTimes() + " " + uf.Cost());
            //
            int a = StdIn.readInt();
            int b = StdIn.readInt();
            if (uf.connected(a, b))
                continue;
            uf.union(a, b);
            // StdOut.println(a + " " + b);
        }
        StdOut.println(uf.count() + " components");
        StdOut.println(timer.elapsedTime());
    }
}