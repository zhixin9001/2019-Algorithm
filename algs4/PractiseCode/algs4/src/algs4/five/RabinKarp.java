package algs4.five;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import java.math.BigInteger;
import java.util.Random;

public class RabinKarp {
    private String pat;
    private long patHash;
    private int M;
    private long Q;
    private int R = 256;
    private long RM;

    public RabinKarp(String pat) {
        this.pat = pat;
        M = pat.length();
        Q = longRandomPrime();
        StdOut.println(Q);
        RM = 1;
        for (int i = 1; i <= M - 1; i++)
            RM = (R * RM) % Q;
        patHash = hash(pat, M);
    }

    private boolean check(String txt, int i) {
        for (int j = 0; j < M; j++)
            if (pat.charAt(j) != txt.charAt(i + j))
                return false;
        return true;
    }

    private long hash(String key, int M) {
        long h = 0;
        for (int j = 0; j < M; j++)
            h = (R * h + key.charAt(j)) % Q;
        return h;
    }

    // a random 31-bit prime
    private static long longRandomPrime() {
        BigInteger prime = BigInteger.probablePrime(31, new Random());
        return prime.longValue();
    }

    public int search(String txt) {
        int N = txt.length();
        long txtHash = hash(txt, M);
        if (patHash == txtHash && check(txt, 0))
            return 0;
        for (int i = M; i < N; i++) {
            txtHash = (txtHash + Q - RM * txt.charAt(i - M) % Q) % Q;
            txtHash = (txtHash * R + txt.charAt(i)) % Q;
            if (patHash == txtHash)
                if (check(txt, i - M + 1))
                    return i - M + 1;
        }
        return N;
    }

    // cmd /c --% java algs4.five.RabinKarp AB
    public static void main(String[] args) {
        String txt = "AAAAAAABBBBBBBCCCCCCCABCABCAABBCC";
        String pat = args[0];
        RabinKarp rabinKarp = new RabinKarp(pat);
        int index = rabinKarp.search(txt);
        StdOut.println(index);
        StdOut.println("a".charAt(0) + 0);
        StdOut.println(txt.substring(index, index + pat.length()));
    }
}