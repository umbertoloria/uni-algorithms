package structures;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;

class Node<T> {

	T value;
	Node<T> next;

	Node(T value) {
		this.value = value;
	}

	Node(T value, Node<T> next) {
		this.value = value;
		this.next = next;
	}

	Node<T> jump(int times) {
		Node<T> result = this;
		for (int i = 0; i < times; i++) {
			result = result.next;
		}
		return result;
	}

	public String toString() {
		return value.toString();
	}

	Iterator<T> createIterator() {
		ArrayList<T> result = new ArrayList<>();
		Node<T> app = this;
		while (app != null) {
			result.add(app.value);
			app = app.next;
		}
		return result.iterator();
	}

	@SuppressWarnings("unchecked")
	T[] toArray(T[] a) {
		Node<T> x = this;
		int count = 0;
		while (x != null) {
			x = x.next;
			count++;
		}
		a = (T[]) Array.newInstance(a.getClass().getComponentType(), count);
		int i = 0;
		for (x = this; x != null; x = x.next) {
			a[i++] = x.value;
		}
		return a;
	}

}
