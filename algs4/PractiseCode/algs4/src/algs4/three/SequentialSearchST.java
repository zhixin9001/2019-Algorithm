package algs4.three;

import com.sun.corba.se.impl.orbutil.graph.Node;

public class SequentialSearchST<Key, Value> {
    private Node first;
    private class Node{
        Key key;
        Value val;
        Node next;

        public Node(Key key,Value val,Node next){
            this.key=key;
            this.val=val;
            this.next=next;
        }
    }

    public Value get(Key key){
        for(Node x=first;x!=null;x=x.next){
            if(key.equals(x.key)){
                return x.val;
            }
        }
        return null;
    }

    public void put(Key key,Value value){
        Node existed=get(key);
        if(existed!=null){
            existed.val=value;
        }else{
            first=new Node(key, val, first);
        }
    }

}