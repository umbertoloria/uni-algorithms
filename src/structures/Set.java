package structures;

import java.util.ArrayList;
import java.util.Iterator;

@SuppressWarnings("unchecked")
public class Set<T extends Comparable<T>> implements Iterable<T> {

	private Object[] data = new Object[2];
	private int size = 0;

	/**
	 Complexity: time O(n)
	 */
	public void add(T value) {
		size++;
		if (size == data.length) {
			Object[] tmp = data;
			data = new Object[data.length * 2];
			System.arraycopy(tmp, 0, data, 0, tmp.length);
		}
		int i = size - 1;
		while (i > 0 && value.compareTo((T) data[i - 1]) < 0) {
			data[i] = data[--i];
		}
		data[i] = value;
	}

	/**
	 Complexity: time O(n)
	 */
	public void remove(T value) {
		int i = contains(value, 0, size - 1);
		if (i >= 0) {
			size--;
			for (; i < size; i++) {
				data[i] = data[i + 1];
			}
		}
	}

	public boolean contains(T value) {
		return contains(value, 0, size - 1) != -1;
	}

	/**
	 Complexity: time O(log n)
	 */
	private int contains(T value, int inf, int sup) {
		if (inf <= sup) {
			int mid = (inf + sup) / 2;
			int cmp = value.compareTo((T) data[mid]);
			if (cmp == 0) {
				return mid;
			} else if (cmp > 0) {
				return contains(value, mid + 1, sup);
			} else {
				return contains(value, inf, mid - 1);
			}
		}
		return -1;
	}

	public String toString() {
		if (size == 0) {
			return "[]";
		}
		StringBuilder res = new StringBuilder("[");
		for (int i = 0; i < size - 1; i++) {
			res.append(data[i]);
			res.append(", ");
		}
		res.append(data[size - 1]);
		res.append("]");
		return res.toString();
	}

	public Iterator<T> iterator() {
		ArrayList<T> res = new ArrayList<>();
		for (int i = 0; i < size; i++) {
			res.add((T) data[i]);
		}
		return res.iterator();
	}

}
