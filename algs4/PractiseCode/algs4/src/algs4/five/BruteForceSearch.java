package algs4.five;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class BruteForceSearch {
    public static int search(String pat, String txt) {
        int patL = pat.length();
        int txtL = txt.length();

        for (int i = 0; i <= txtL - patL; i++) {
            int j;
            for (j = 0; j < patL; j++)
                if (txt.charAt(i + j) != pat.charAt(j))
                    break;
            if (j == patL)
                return i;
        }
        return txtL;
    }

    public static int search1(String pat, String txt) {
        int j, patL = pat.length();
        int i, txtL = txt.length();

        for (i = 0, j = 0; i <= txtL && j < patL; i++) {
            if (txt.charAt(i) == pat.charAt(j))
                j++;
            else {
                i -= j;
                j = 0;
            }
        }
        if (j == patL)
            return i - patL;
        else
            return txtL;
    }

    // cmd /c --% java algs4.five.BruteForceSearch words
    public static void main(String[] args) {
        String txt = "eCode-Algorithm-algs4-PractiseCode-algs4-src>java algs4.five.BruteForceSearch wor";
        String pat = args[0];
        StdOut.println("m1");
        int index = search(pat, txt);
        StdOut.println(index);
        StdOut.println(txt.substring(index, index + pat.length()));
        StdOut.println("m2");
        index = search1(pat, txt);
        StdOut.println(index);
        StdOut.println(txt.substring(index, index + pat.length()));
    }
}