package algs4;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import java.util.Iterator;
import java.util.NoSuchElementException;

import com.sun.corba.se.impl.orbutil.graph.Node;

public class StackLinkedList1<Item> implements Iterable<Item> {
	private static class Node<Item> {
		public Item item;
		public Node next;
	}

	private Node<Item> first;
	private int N;

	public void push(Item item) {
		Node<Item> oldFirst = first;
		first = new Node<Item>();
		first.item = item;
		first.next = oldFirst;
		N++;
	}

	public Item pop() {
		if (isEmpty()) {
			return null;
		}
		Item result = first.item;
		first = first.next;
		N--;
		return result;
	}

	public int size() {
		return N;
	}

	public boolean isEmpty() {
		return N == 0;
	}

	@Override
	public Iterator<Item> iterator() {
		return new ListIterator<Item>(first);
	}

	private class ListIterator<Item> implements Iterator<Item> {
		private Node<Item> current;

		public ListIterator(Node first) {
			current = first;
		}

		@Override
		public boolean hasNext() {
			return current.next != null;
		}

		@Override
		public Item next() {
			Item a = current.item;
			current = current.next;
			return a;
		}
	}

	public static void main(String[] args) {
		StackLinkedList1<String> stack = new StackLinkedList1<String>();
		while (!StdIn.isEmpty()) {
			String item = StdIn.readString();
			if (!item.equals("-")) {
				stack.push(item);
			} else if (!stack.isEmpty()) {
				StdOut.print(stack.pop() + " ");
			}
		}
		StdOut.println("(" + stack.size() + " left on stack)");

		for (String s : stack) {
			StdOut.println(s);
		}

	}

}
