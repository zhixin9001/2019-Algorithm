package algs4.five;

import edu.princeton.cs.algs4.BinaryStdIn;
import edu.princeton.cs.algs4.BinaryStdOut;
import edu.princeton.cs.algs4.Alphabet;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class RunLength {
    public static void compress() {
        
        BinaryStdOut.close();
    }

    public static void expand() {
        boolean b = false;
        while (!BinaryStdIn.isEmpty()) {
            char cnt = BinaryStdIn.readChar();
            for (int i = 0; i < cnt; i++)
                BinaryStdOut.write(b);
            b = !b;
        }
        BinaryStdOut.close();
    }

    // cmd /c --% java algs4.five.Genome - < ..\..\..\algs4-data\genomeTiny.txt
    // java algs4.five.Genome - < ..\..\..\algs4-data\genomeTiny.txt | java
    // algs4.five.BinaryDump 64
    // cmd /c --% java algs4.five.Genome - < ..\..\..\algs4-data\genomeTiny.txt |
    // cmd /c --% java algs4.five.Genome +
    // cmd /c --% java algs4.five.Genome - < ..\..\..\algs4-data\genomeTiny.txt
    // >genomeTiny.2bit
    // cmd /c --% java algs4.five.Genome + < genomeTiny.2bit
    public static void main(String[] args) {
        if (args[0].equals("-"))
            compress();
        else if (args[0].equals("+"))
            expand();
        else
            throw new IllegalArgumentException("Illegal command line argument");
    }
}