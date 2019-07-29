package algs4;

import java.util.Iterator;
import java.util.NoSuchElementException;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class StackResizeArray1<Item> implements Iterable<Item> {
	private Item[] a;
	private int n;

	public void push(Item item) {
		if (n == a.length) {
			resize(2*a.length);
		}
		a[]
	}

	public static void main(String[] args) {
		StdOut.println("StackResizeArray");
		StackResizeArray1<String> stack = new StackResizeArray1<String>();
		while (!StdIn.isEmpty()) {
			String item = StdIn.readString();
			if (!item.equals("-"))
				stack.push(item);
			else if (!stack.isEmpty())
				StdOut.print(stack.pop() + " ");
		}
		StdOut.println("StackResizeArray");
		StdOut.println("(" + stack.size() + " left on stack)");

		// StackResizeArray<Integer> stack = new StackResizeArray<Integer>();
		// while (!StdIn.isEmpty()) {
		// int item = StdIn.readInt();
		// if (item != 0) {
		// stack.push(item);
		// } else if (!stack.isEmpty()) {
		// StdOut.print(stack.pop() + " ");
		// }
		// }

		// stack.push("a");
		// stack.push("a2");
		// stack.push("a3");

		// for(String s:stack) {
		// StdOut.println(s);
		// }
	}

}
