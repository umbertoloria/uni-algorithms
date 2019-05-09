package structures;

import java.lang.reflect.Array;
import java.util.Iterator;

public abstract class List<T> implements Iterable<T> {

	private int size = 0;

	final void increaseSize() {
		size++;
	}

	final void decreaseSize() {
		size--;
	}

	// Retrieval

	public abstract T get(int index);

	// Insertion

	public final void prepend(T value) {
		set(0, value);
	}

	public final void append(T value) {
		set(size, value);
	}

	public abstract void set(int index, T value);

	public abstract void expand(List<T> external);

	// Removal

	public abstract void remove(int index);

	// Controls

	public final boolean empty() {
		return size == 0;
	}

	public final int size() {
		return size;
	}

	public abstract boolean contains(T value);

	// Utils

	public final AList<T> createReverse() {
		AList<T> result = new AList<>();
		for (T item : this) {
			result.prepend(item);
		}
		return result;
	}

	public abstract void justReverse();

	public abstract Iterator<T> iterator();

	public final String toString() {
		if (empty()) {
			return "[]";
		} else {
			StringBuilder result = new StringBuilder("[");
			for (T item : this) {
				result.append(item);
				result.append(", ");
			}
			result.delete(result.length() - 2, result.length());
			result.append("]");
			return result.toString();
		}
	}

	@SuppressWarnings("unchecked")
	public final T[] toArray(T[] a) {
		if (empty()) {
			return null;
		} else {
			Iterator<T> it = iterator();
			a = (T[]) Array.newInstance(a.getClass().getComponentType(), size());
			int i = 0;
			while (it.hasNext()) {
				a[i++] = it.next();
			}
			return a;
		}
	}

}
