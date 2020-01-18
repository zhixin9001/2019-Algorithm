package algs4.five;

import edu.princeton.cs.algs4.BinaryStdIn;
import edu.princeton.cs.algs4.BinaryStdOut;
import edu.princeton.cs.algs4.Alphabet;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Genome {
    public static void compress(){
        Alphabet DNA=new Alphabet("ACTG");
        String s=BinaryStdIn.readString();
        int N=s.length();
        BinaryStdOut.write(N);
        
        for(int i=0;i<N;i++){
            int d=DNA.toIndex(s.charAt(i));
            // StdOut.println(" ebits"+d);
            BinaryStdOut.write(d,DNA.lgR());
        }
        BinaryStdOut.close();
    }

    public static void expand(){
        Alphabet DNA=new Alphabet("ACTG");
        int w=DNA.lgR();
        int N=BinaryStdIn.readInt();
        for(int i=0;i<N;i++){
            char c=BinaryStdIn.readChar(w);
            StdOut.println("c="+c);
            char e=DNA.toChar(c);
            StdOut.println("e="+e);
            BinaryStdOut.write(DNA.toChar(c));
        }
        BinaryStdOut.close();
    }

    // cmd /c --% java algs4.five.Genome - < ..\..\..\algs4-data\genomeTiny.txt
    // java algs4.five.Genome - < ..\..\..\algs4-data\genomeTiny.txt | java algs4.five.BinaryDump 64
    // cmd /c --% java algs4.five.Genome - < ..\..\..\algs4-data\genomeTiny.txt | cmd /c --% java algs4.five.Genome + 
    // cmd /c --% java algs4.five.Genome - < ..\..\..\algs4-data\genomeTiny.txt >genomeTiny.2bit
    // cmd /c --% java algs4.five.Genome +  < genomeTiny.2bit
    public static void main(String[] args) {
        if      (args[0].equals("-")) compress();
        else if (args[0].equals("+")) expand();
        else throw new IllegalArgumentException("Illegal command line argument");
    }
}