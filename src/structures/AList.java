package structures;

import java.util.Iterator;

@SuppressWarnings("unchecked")
public class AList<T> extends List<T> {

	private Object[] data = new Object[16];

	public T get(int index) {
		if (empty() || index < 0 || index >= size()) {
			throw new IndexOutOfBoundsException("List reading index out of bounds");
		} else {
			return (T) data[index];
		}
	}

	public void set(int index, T value) {
		if (index < 0 || index > size()) {
			throw new IndexOutOfBoundsException("List assignment index out of bounds");
		} else {
			int i = size();
			while (i > index) {
				data[i] = data[i - 1];
				i--;
			}
			data[index] = value;
			increaseSize();
			ensureCapacity();
		}
	}

	private void ensureCapacity() {
		if (size() >= data.length) {
			Object[] tmp = data;
			data = new Object[data.length * 2];
			System.arraycopy(tmp, 0, data, 0, tmp.length);
		}
	}

	public void expand(List<T> external) {
		if (external.size() > 0) {
			Iterator<T> it = external.iterator();
			int i = size();
			while (it.hasNext()) {
				data[i++] = it.next();
				increaseSize();
			}
		}
	}

	public void remove(int index) {
		if (index < 0 || index > size()) {
			throw new IndexOutOfBoundsException("List assignment index out of bounds");
		} else {
			while (index < size() - 1) {
				data[index] = data[index + 1];
				index++;
			}
			decreaseSize();
		}
	}

	/** Complexity: time O(n) */
	public boolean contains(T value) {
		for (Object item : data) {
			if (item.equals(value)) {
				return true;
			}
		}
		return false;
	}

	public AList<T> justReverse() {
		for (int i = 0; i < size() / 2; i++) {
			T tmp = (T) data[i];
			data[i] = data[size() - 1 - i];
			data[size() - 1 - i] = tmp;
		}
		return this;
	}

	public Iterator<T> iterator() {
		return new ArrayIterator<>(data, size());
	}

}
