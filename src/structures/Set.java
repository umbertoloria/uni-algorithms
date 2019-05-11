package structures;

import sorting.BinarySearch;

import java.util.Iterator;

@SuppressWarnings("unchecked")
public class Set<T extends Comparable<T>> implements Iterable<T> {

	private Object[] data = new Object[16];
	private int size = 0;

	/** Complexity: time O(n) */
	public boolean add(T value) {
		if (contains(value)) {
			return false;
		} else {
			size++;
			ensureCapacity();
			int i = size - 1;
			while (i > 0 && value.compareTo((T) data[i - 1]) < 0) {
				data[i] = data[--i];
			}
			data[i] = value;
			return true;
		}
	}

	private void ensureCapacity() {
		if (size >= data.length) {
			Object[] tmp = data;
			data = new Object[data.length * 2];
			System.arraycopy(tmp, 0, data, 0, tmp.length);
		}
	}

	/** Complexity: time O(n) */
	public boolean remove(T value) {
		int index = BinarySearch.search(data, value, 0, size - 1);
		if (index >= 0) {
			size--;
			for (; index < size; index++) {
				data[index] = data[index + 1];
			}
			return true;
		} else {
			return false;
		}
	}

	/** Complexity: time O(log n) */
	public boolean contains(T value) {
		return BinarySearch.search(data, value, 0, size - 1) >= 0;
	}

	/** Complexity: time O(log n) */
	public T get(T like) {
		int index = BinarySearch.search(data, like, 0, size - 1);
		if (index >= 0) {
			return (T) data[index];
		} else {
			return null;
		}
	}

	public Iterator<T> iterator() {
		return new ArrayIterator<>(data, size);
	}

	public String toString() {
		return DSUtils.makeString(iterator());
	}

}
