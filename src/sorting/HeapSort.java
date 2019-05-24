package sorting;

import structures.MinHeapSet;

public class HeapSort {

	/** Complexity: time O(n log n) and space O(n) */
	public static <T extends Comparable<T>> void heapsort(T[] vect) {
		MinHeapSet<T> heap = new MinHeapSet<>();
		for (T t : vect) {
			heap.insert(t);
		}
		int i = 0;
		while (!heap.empty()) {
			vect[i++] = heap.extract();
		}
	}

}
