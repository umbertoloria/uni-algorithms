package structures;

import java.util.Iterator;

public class LList<T> extends List<T> {

	private Node<T> head;

	public T get(int index) {
		if (empty() || index < 0 || index >= size()) {
			throw new IndexOutOfBoundsException("List reading index out of bounds");
		} else {
			return head.jump(index).value;
		}
	}

	public void set(int index, T value) {
		if (index < 0 || index > size()) {
			throw new IndexOutOfBoundsException("List assignment index out of bounds");
		} else {
			if (index == 0) {
				head = new Node<>(value, head);
			} else {
				Node<T> prev = head.jump(index - 1);
				prev.next = new Node<>(value, prev.next);
			}
			increaseSize();
		}
	}

	public void expand(List<T> external) {
		if (external.size() > 0) {
			Iterator<T> it = external.iterator();
			Node<T> tail;
			if (empty()) {
				head = new Node<>(it.next());
				increaseSize();
			}
			tail = head.jump(size() - 1);
			while (it.hasNext()) {
				tail.next = new Node<>(it.next());
				tail = tail.next;
				increaseSize();
			}
		}
	}

	public void remove(int index) {
		if (index < 0 || index > size()) {
			throw new IndexOutOfBoundsException("List assignment index out of bounds");
		} else {
			if (index == 0) {
				head = head.next;
			} else {
				Node<T> app = head.jump(index - 1);
				app.next = app.next.next;
			}
			decreaseSize();
		}
	}

	/** Complexity: time O(n) */
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

	public void justReverse() {
		if (size() >= 2) {
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

	public Iterator<T> iterator() {
		return new LinkedIterator<>(head);
	}

}
