package algorithms;

import structures.AList;
import structures.List;
import structures.MaxHeapSet;
import structures.MinHeapSet;

import java.lang.reflect.Array;

public class KSelector<T extends Comparable<T>> {

	private List<T> elements = new AList<>();

	public void add(T elem) {
		elements.append(elem);
	}

	/** Complexity: time O(k + (n - k) log k) and space O(k) */
	@SuppressWarnings("unchecked")
	public T[] smallest(int k, T[] app) {
		if (elements.size() <= k) {
			return elements.toArray(app);
		} else {
			MaxHeapSet<T> heap = new MaxHeapSet<>();
			for (int i = 0; i < k; i++) {
				heap.insert(elements.get(i));
			}
			for (int i = k; i < elements.size(); i++) {
				T elem = elements.get(i);
				if (heap.peek().compareTo(elem) > 0) {
					heap.extract();
					heap.insert(elem);
				}
			}
			T[] res = (T[]) Array.newInstance(app.getClass().getComponentType(), k);
			while (!heap.empty()) {
				res[--k] = heap.extract();
			}
			return res;
		}
	}

	/** Complexity: time O(k + (n - k) log k) and space O(k) */
	@SuppressWarnings("unchecked")
	public T[] greatest(int k, T[] app) {
		if (elements.size() <= k) {
			return elements.toArray(app);
		} else {
			MinHeapSet<T> heap = new MinHeapSet<>();
			for (int i = 0; i < k; i++) {
				heap.insert(elements.get(i));
			}
			for (int i = k; i < elements.size(); i++) {
				T elem = elements.get(i);
				if (heap.peek().compareTo(elem) < 0) {
					heap.extract();
					heap.insert(elem);
				}
			}
			T[] res = (T[]) Array.newInstance(app.getClass().getComponentType(), k);
			while (!heap.empty()) {
				res[--k] = heap.extract();
			}
			return res;
		}
	}

}
