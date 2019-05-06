package structures;

import java.util.Collections;
import java.util.Iterator;

public class Queue<T> implements Iterable<T> {

	private Node<T> head, tail;
	private int size = 0;

	public T peek() {
		return head != null ? head.value : null;
	}

	public void push(T item) {
		if (tail == null) {
			head = tail = new Node<>(item);
		} else {
			tail = tail.next = new Node<>(item);
		}
		size++;
	}

	public T pop() {
		if (head == null) {
			return null;
		}
		size--;
		T result = head.value;
		head = head.next;
		if (head == null) {
			tail = null;
		}
		return result;
	}

	public boolean empty() {
		return head == null;
	}

	public int size() {
		return size;
	}

	public Iterator<T> iterator() {
		if (head != null) {
			return head.createIterator();
		} else {
			return Collections.emptyIterator();
		}
	}

}
