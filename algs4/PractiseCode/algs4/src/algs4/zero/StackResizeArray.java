package algs4;

import java.util.Iterator;
import java.util.NoSuchElementException;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class StackResizeArray<Item> implements Iterable<Item> {
	private Item[] a; // array of items
	private int n; // number of elements on stack

	public StackResizeArray() {
		a = (Item[]) new Object[2];
		n = 0;
	}

	public boolean isEmpty() {
		return n == 0;
	}

	public int size() {
		return n;
	}

	private void resize(int capacity) {
		assert capacity >= n;

		// textbook implementation
		Item[] temp = (Item[]) new Object[capacity];
		for (int i = 0; i < n; i++) {
			temp[i] = a[i];
		}
		a = temp;

		// alternative implementation
		// a = java.util.Arrays.copyOf(a, capacity);
	}

	public void push(Item item) {
		if (n == a.length)
			resize(2 * a.length); // double size of array if necessary
		a[n++] = item; // add item
	}

	public Item pop() {
		if (isEmpty())
			throw new NoSuchElementException("Stack underflow");
		Item item = a[n - 1];
		a[n - 1] = null; // to avoid loitering
		n--;
		// shrink size of array if necessary
		if (n > 0 && n == a.length / 4)
			resize(a.length / 2);
		return item;
	}

	@Override
	public Iterator<Item> iterator() {
		return new ListIterator<Item>();
	}

	private class ListIterator<Item> implements Iterator<Item> {
		private int i;

		public ListIterator() {
			i = n - 1;
		}

		@Override
		public boolean hasNext() {
			return i>=0;
		}

		@Override
		public Item next() {
			if(!hasNext()) throw new NoSuchElementException();
			return (Item) a[i--];
		}

	}

	public static void main(String[] args) {
		StdOut.println("StackResizeArray");
    	StackResizeArray<String> stack = new StackResizeArray<String>();
        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            if (!item.equals("-")) stack.push(item);
            else if (!stack.isEmpty()) StdOut.print(stack.pop() + " ");
        }
        StdOut.println("StackResizeArray");
        StdOut.println("(" + stack.size() + " left on stack)");

//		StackResizeArray<Integer> stack = new StackResizeArray<Integer>();
//		while (!StdIn.isEmpty()) {
//			int item = StdIn.readInt();
//			if (item != 0) {
//				stack.push(item);
//			} else if (!stack.isEmpty()) {
//				StdOut.print(stack.pop() + " ");
//			}
//		}
		
//		stack.push("a");
//		stack.push("a2");
//		stack.push("a3");
		
//		for(String s:stack) {
//			StdOut.println(s);
//		}
	}

}
