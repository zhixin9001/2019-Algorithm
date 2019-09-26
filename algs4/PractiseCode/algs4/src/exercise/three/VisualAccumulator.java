package exercise.three;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;

public class VisualAccumulator {
    private double total;
    private int n;

    public VisualAccumulator(int trials, double max) {
        StdDraw.setCanvasSize(1000, 500);
        StdDraw.setXscale(0, trials);
        StdDraw.setYscale(0, max);
        StdDraw.setPenRadius(0.005);
    }

    public void addDataValue(double value) {
        n++;
        total += value;
        StdDraw.setPenColor(StdDraw.DARK_GRAY);
        StdDraw.point(n, value);
        StdDraw.setPenColor(StdDraw.RED);
        double mean=mean();
        StdDraw.point(n, mean);
        if(total%100==0){
            StdOut.println(n+"----"+mean);
        }

    }

    public double mean() {
        return total / n;
    }

    public String toString() {
        return "n = " + n + ", mean = " + mean();
    }
}