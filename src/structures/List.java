package structures;

import java.util.ArrayList;
import java.util.Iterator;

public class List<T> implements Iterable<T> {

//	public int indexOf(T node) {}

	private Node<T> head;
	private int size = 0;

	public T get(int index) {
		if (size == 0 || index < 0 || index >= size) {
			throw new IndexOutOfBoundsException("List reading index out of bounds");
		}

		return head.jump(index).value;
	}

	public void set(int index, T value) {
		if (index < 0 || index > size) {
			throw new IndexOutOfBoundsException("List assignment index out of bounds");
		}

		if (index == 0) {
			head = new Node<>(value, head);
		} else {
			Node<T> prev = head.jump(index - 1);
			prev.next = new Node<>(value, prev.next);
		}
		size++;
	}

	public void prepend(T value) {
		head = new Node<>(value, head);
		size++;
	}

	public void append(T value) {
		if (size == 0) {
			head = new Node<>(value);
		} else {
			head.jump(size - 1).next = new Node<>(value);
		}
		size++;
	}

	public void remove(int index) {
		if (index < 0 || index > size) {
			throw new IndexOutOfBoundsException("List assignment index out of bounds");
		}

		if (index == 0) {
			head = head.next;
		} else {
			Node<T> app = head.jump(index - 1);
			app.next = app.next.next;
		}
		size--;
	}

	public int size() {
		return size;
	}

	public boolean contains(T value) {
		Node<T> app = head;
		while (app != null) {
			if (app.value == value) {
				return true;
			}
			app = app.next;
		}
		return false;
	}

	public List<T> createReversed() {
		List<T> result = new List<>();
		for (T item : this) {
			result.prepend(item);
		}
		return result;
	}

	public void reverse() {
		if (size >= 2) {
			Node<T> to_empty = head.next;
			Node<T> reversed = head;
			reversed.next = null;
			Node<T> tmp;
			while (to_empty != null) {
				tmp = to_empty;
				to_empty = to_empty.next;
				tmp.next = reversed;
				reversed = tmp;
			}
			head = reversed;
		}
	}

	public String toString() {
		if (size == 0) {
			return "[]";
		}
		StringBuilder result = new StringBuilder("[");
		Node<T> app = head;
		for (int i = 0; i < size - 1; i++) {
			result.append(app.value);
			result.append(", ");
			app = app.next;
		}
		result.append(app.value);
		result.append("]");
		return result.toString();
	}

	public Iterator<T> iterator() {
		ArrayList<T> result = new ArrayList<>();
		Node<T> app = head;
		while (app != null) {
			result.add(app.value);
			app = app.next;
		}
		return result.iterator();
	}

}
