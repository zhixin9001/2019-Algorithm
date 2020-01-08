package algs4.five;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class KMP {
    private String pat;
    private int[][] dfa;

    public KMP(String pat) {
        this.pat = pat;
        int M = pat.length();
        int R = 256;
        dfa = new int[R][M];
        dfa[pat.charAt(0)][0] = 1;
        for (int X = 0, j = 1; j < M; j++) {
            for (int c = 0; c < R; c++)
                dfa[c][j] = dfa[c][X];
            dfa[pat.charAt(j)][j] = j + 1;
            X = dfa[pat.charAt(j)][X];
        }
    }

    public int search(String txt) {
        int i, j, N = txt.length(), M = pat.length();
        for (i = 0, j = 0; i < N && j < M; i++) {
            j = dfa[txt.charAt(i)][j];
        }
        if (j == M)
            return i - M;
        else
            return N;
    }

    // cmd /c --% java algs4.five.KMP AB
    public static void main(String[] args) {
        String txt = "AAAAAAABBBBBBBCCCCCCCABCABCAABBCC";
        String pat = args[0];
        KMP kmp = new KMP(pat);
        int index = kmp.search(txt);
        StdOut.println(index);
        StdOut.println("a".charAt(0)+0);
        StdOut.println(txt.substring(index, index + pat.length()));
    }
}