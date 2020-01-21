package algs4.five;

import edu.princeton.cs.algs4.BinaryStdIn;
import edu.princeton.cs.algs4.BinaryStdOut;
import edu.princeton.cs.algs4.Alphabet;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.TST;

public class LWZ {
    private static final int R = 256;
    private static final int L = 4096;
    private static final int W = 12;

    public static void compress() {
        String input = BinaryStdIn.readString();
        TST<Integer> st = new TST<Integer>();

        for (int i = 0; i < R; i++)
            st.put("" + (char) i, i);
        int code = R + 1;

        while (input.length() > 0) {
            String s = st.longestPrefixOf(input);
            BinaryStdOut.write(st.get(s), W);

            int t = s.length();
            if (t < input.length() && code < L)
                st.put(input.substring(0, t + 1), code++);
            input = input.substring(t);
        }

        BinaryStdOut.write(R, W);
        BinaryStdOut.close();
    }

    public static void expand() {
        String[] st = new String[L];
        int i;
        for (i = 0; i < R; i++)
            st[i] = "" + (char) i;
        st[i++] = " ";

        int codeword = BinaryStdIn.readInt(W);
        String val = st[codeword];
        while (true) {
            BinaryStdOut.write(val);
            codeword = BinaryStdIn.readInt(W);
            if (codeword == R)
                break;
            String s = st[codeword];
            if (i == codeword)
                s = val + val.charAt(0);
            if (i < L)
                st[i++] = val + s.charAt(0);
            val = s;
        }
        BinaryStdOut.close();
    }

    /* cmd /c --% java algs4.five.LWZ - < ..\..\..\algs4-data\medTale.txt | java algs4.five.PictureDump 512 47
     cmd /c --% java algs4.five.LWZ - < ..\..\..\algs4-data\medTale.txt | java algs4.five.HexDump 48
     cmd /c --% java algs4.five.LWZ - "ABRACADABRABRABRA" | java algs4.five.HexDump 48
    */
    public static void main(String[] args) {
        if (args[0].equals("-"))
            compress();
        else if (args[0].equals("+"))
            expand();
        else
            throw new IllegalArgumentException("Illegal command line argument");
    }
}