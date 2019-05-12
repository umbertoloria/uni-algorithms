package structures;

import sorting.BinarySearch;

import java.util.Iterator;

@SuppressWarnings("unchecked")
public class Set<T extends Comparable<T>> implements Iterable<T> {

	private Object[] data = new Object[8];
	private int size = 0;

	/** Complexity: time O(n) */
	public boolean add(T value) {
		if (contains(value)) {
			return false;
		} else {
			size++;
			ensureCapacity(size);
			int i = size - 1;
			while (i > 0 && value.compareTo((T) data[i - 1]) < 0) {
				data[i] = data[--i];
			}
			data[i] = value;
			return true;
		}
	}

	private void ensureCapacity(int size) {
		if (size > data.length) {
			Object[] tmp = data;
			data = new Object[data.length * 2];
			System.arraycopy(tmp, 0, data, 0, tmp.length);
		}
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

	public Set<T> remove(List<T> list) {
		for (T item : list) {
			remove(item);
		}
		return this;
	}

	public boolean empty() {
		return size == 0;
	}

	/** Complexity: time O(log n) */
	public boolean contains(T value) {
		return BinarySearch.search(data, value, 0, size - 1) >= 0;
	}

	public Set<T> difference(Set<T> other) {
		Set<T> result = new Set<>();
		int i = 0;
		int j = 0;
		int k = 0;
		while (i < size && j < other.size) {
			T a = (T) data[i];
			T b = (T) other.data[j];
			int cmp = a.compareTo(b);
			if (cmp < 0) {
				result.ensureCapacity(k + 1);
				result.data[k++] = data[i];
				i++;
			} else if (cmp == 0) {
				i++;
				j++;
			} else {
				j++;
			}
		}
		while (i < size) {
			result.ensureCapacity(k + 1);
			result.data[k++] = data[i];
			i++;
		}
		result.size = k;
		return result;
	}

	public Iterator<T> iterator() {
		return new ArrayIterator<>(data, size);
	}

	public String toString() {
		return DSUtils.makeString(iterator());
	}

	public List<T> toList() {
		List<T> list = new AList<>();
		for (int i = 0; i < size; i++) {
			list.append((T) data[i]);
		}
		return list;
	}

	public static <V extends Comparable<V>> Set<V> fromList(List<V> list) {
		Set<V> result = new Set<>();
		for (V v : list) {
			result.add(v);
		}
		return result;
	}

}
