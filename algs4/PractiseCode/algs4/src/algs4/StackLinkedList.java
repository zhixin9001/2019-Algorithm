package algs4;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class StackLinkedList<Item> implements Iterable<Item> {
	private static class Node<Item> {
		public Item item;
		public Node next;
	}

	private Node<Item> first;
	private int N;

	private boolean isEmpty() {
		return first == null;
	}

	public int size() {
		return N;
	}

	public void push(Item item) {
		Node<Item> oldFirst = first;
		first = new Node<Item>();
		first.item = item;
		first.next = oldFirst;
		N++;
	}

	public Item pop() {
		if (isEmpty())
			throw new NoSuchElementException("Stack underflow");
		Item item = first.item;
		first = first.next;
		N--;
		return item;
	}

	@Override
	public Iterator<Item> iterator() {
		return new ListIterator<Item>(first);
	}

	private class ListIterator<Item> implements Iterator<Item> {
		private Node<Item> current;

		public ListIterator(Node<Item> first) {
			current = first;
		}

		@Override
		public boolean hasNext() {
			return current != null;
		}

		@Override
		public Item next() {
			if (!hasNext())
				throw new NoSuchElementException();
			Item item = current.item;
			current = current.next;
			return item;
		}
	}

	public static void main(String[] args) {
		StackLinkedList<String> stack=new StackLinkedList<String>();
		stack.push("a");
		stack.push("a2");
		stack.push("a3");
//		while(!StdIn.isEmpty()) {
//			String item=StdIn.readString();
//			if(!item.equals("-")) {
//				stack.push(item);
//			}else if(!stack.isEmpty()) {
//				StdOut.print(stack.pop()+" ");
//			}
//		}
//		StdOut.println("(" + stack.size() + " left on stack)");

//		StackLinkedList<Integer> stack = new StackLinkedList<Integer>();
//		while (!StdIn.isEmpty()) {
//			int item = StdIn.readInt();
//			if (item != 0) {
//				stack.push(item);
//			} else if (!stack.isEmpty()) {
//				StdOut.print(stack.pop() + " ");
//			}
//		}
		
		for(String s:stack) {
			StdOut.println(s);
		}
		
	}

}
