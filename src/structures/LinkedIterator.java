package structures;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedIterator<T> implements Iterator<T> {

	private Node<T> app;

	LinkedIterator(Node<T> app) {
		this.app = app;
	}

	public boolean hasNext() {
		return app != null;
	}

	public T next() {
		if (hasNext()) {
			T result = app.value;
			app = app.next;
			return result;
		} else {
			throw new NoSuchElementException();
		}
	}

}