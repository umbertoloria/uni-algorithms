package structures;

import java.util.Iterator;
import java.util.NoSuchElementException;

@SuppressWarnings("unchecked")
public class ArrayIterator<T> implements Iterator<T> {

	private Object[] data;
	private int size;
	private int i = 0;

	ArrayIterator(Object[] data, int size) {
		this.data = data;
		this.size = size;
	}

	public boolean hasNext() {
		return i < size;
	}

	public T next() {
		if (hasNext()) {
			return (T) data[i++];
		} else {
			throw new NoSuchElementException();
		}
	}

}