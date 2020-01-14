package algs4.five;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class BoyerMoore {
    private String pat;
    private int[] right;

    public BoyerMoore(String pat) {
        this.pat = pat;
        int M = pat.length();
        int R = 256;
        right = new int[R];
        for (int c = 0; c < R; c++)
            right[c] = -1;
        for (int j = 0; j < M; j++)
            right[pat.charAt(j)] = j;
    }

    public int search(String txt) {
        int N = txt.length();
        int M = pat.length();
        int skip;
        for (int i = 0; i <= N - M; i += skip) {
            skip = 0;
            for (int j = M - 1; j >= 0; j--) {
                if (pat.charAt(j) != txt.charAt(i + j)) {
                    skip = j - right[txt.charAt(i + j)];
                    if (skip < 1)
                        skip = 1;
                    break;
                }
            }
            if(skip==0) return i;
        }
        return N;
    }

    // cmd /c --% java algs4.five.BoyerMoore AB
    public static void main(String[] args) {
        String txt = "AAAAAAABBBBBBBCCCCCCCABCABCAABBCC";
        String pat = args[0];
        BoyerMoore boyerMoore = new BoyerMoore(pat);
        int index = boyerMoore.search(txt);
        StdOut.println(index);
        StdOut.println("a".charAt(0) + 0);
        StdOut.println(txt.substring(index, index + pat.length()));
    }
}