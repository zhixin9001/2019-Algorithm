package algs4.three;

import java.util.Comparator;
import java.util.NoSuchElementException;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdDraw;
import algs4.three.SequentialSearchST;

public class SeparateChainingHashST<Key, Value> {
    private int N;   //count of k-v pairs
    private int M;   //size of hashtable
    private SequentialSearchST<Key,Value>[] st;

    public SeparateChainingHashST(){
        this(997);
    }

    public SeparateChainingHashST(int M){
        this.M=M;
        st= (SequentialSearchST<Key,Value>[])new SequentialSearchST[M];
        for(int i=0;i<M;i++){
            st[i]=new SequentialSearchST();
        }
    }

    private int hash(Key key){
        return (key.hashCode()&0x7fffffff)%M;
    }

    public Value get(Key key){
        return (Value)st[hash(key)].get(key);
    }

    public void put(Key key,Value val){
        st[hash(key)].put(key,val);
    }
}
