package algs4;

import java.util.Iterator;
import java.util.NoSuchElementException;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import javafx.scene.control.TableView.ResizeFeatures;

public class StackResizeArray1<Item> implements Iterable<Item> {
	private Item[] a;
	private int n;

	public StackResizeArray1() {
		a = (Item[]) new Object[1];
	}

	public void push(Item item) {
		if (n == a.length) {
			resize(2 * a.length);
		}
		a[n++] = item;
	}

	private void resize(int max) {
		Item[] temp = (Item[]) new Object[max];
		for (int i = 0; i < n; i++) {
			temp[i] = a[i];
		}
		a = temp;
	}

	public Item pop() {
		if (isEmpty())
			return null;
		Item result = a[--n];
		a[n] = null;// 注意避免对象游离
		if (n == a.length / 4) {
			resize(a.length / 2);
		}
		return result;
	}

	public int size() {
		return n;
	}

	public boolean isEmpty() {
		return n == 0;
	}

	public Iterator<Item> iterator() {
		return new ReverseArrayIterator();
	}

	public class ReverseArrayIterator implements Iterator<Item> {
		private int i = n;

		public boolean hasNext() {
			return i > 0;
		}

		public Item next(){
			return a[--i];
		}

		
	}

	public static void main(String[] args) {
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

		for(String s:stack) {
		StdOut.println(s);
		}
	}

}
