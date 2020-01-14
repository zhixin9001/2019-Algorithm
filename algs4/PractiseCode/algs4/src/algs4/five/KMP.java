package algs4.five;

import javax.lang.model.util.ElementScanner6;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class KMP {
    private String pat;
    private int[][] dfa;

    public KMP(String pat) {
        this.pat = pat;
        int M = pat.length();
        int R = 3;
        dfa = new int[R][M];
        dfa[charAt(pat.charAt(0))][0] = 1;
        for (int X = 0, j = 1; j < M; j++) {
            for (int c = 0; c < R; c++)
                dfa[c][j] = dfa[c][X];
            dfa[charAt(pat.charAt(j))][j] = j + 1;
            X = dfa[charAt(pat.charAt(j))][X];
        }
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < M; j++)
                StdOut.print(" " + dfa[i][j]);
            StdOut.println();

        }
    }

    public int charAt(char c) {
        StdOut.println(c);
        if (c == 'A')
            return 0;
        else if (c == 'B')
            return 1;
        else if (c == 'C')
            return 2;
        else
            return 1000;
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

        // int index = kmp.search(txt);
        // StdOut.println(index);
        // StdOut.println("a".charAt(0) + 0);
        // StdOut.println(txt.substring(index, index + pat.length()));
    }
}