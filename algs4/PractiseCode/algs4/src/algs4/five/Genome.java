package algs4.five;

import edu.princeton.cs.algs4.BinaryStdIn;
import edu.princeton.cs.algs4.BinaryStdOut;
import edu.princeton.cs.algs4.Alphabet;

public class Genome {
    public static void compress(){
        Alphabet DNA=new Alphabet("ACTG");
        String s=BinaryStdIn.readString();
        int N=s.length();
        BinaryStdOut.write(N);
        for(int i=0;i<N;i++){
            int d=DNA.toIndex(s.charAt(i));
            BinaryStdOut.write(d,DNA.lgR());
        }
        BinaryStdOut.close();
    }

    // cmd /c --% java algs4.five.Genome - < ..\..\..\algs4-data\genomeTiny.txt
    // java algs4.five.Genome - < ..\..\..\algs4-data\genomeTiny.txt | java algs4.five.BinaryDump 64
    public static void main(String[] args) {
        if      (args[0].equals("-")) compress();
        // else if (args[0].equals("+")) expand();
        else throw new IllegalArgumentException("Illegal command line argument");
    }
}