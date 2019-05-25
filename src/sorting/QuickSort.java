package sorting;

import structures.List;

public class QuickSort {

	/** Complexity: time O(n log n) */
	public static <T extends Comparable<T>> void quicksort(T[] vect, int p, int q) {
		if (p < q) {
			int gap = partition(vect, p, q);
			quicksort(vect, p, gap);
			quicksort(vect, gap + 1, q);
		}
	}

	/** Complexity: time O(n) */
	private static <T extends Comparable<T>> int partition(T[] vect, int p, int q) {
		T pivot = vect[(p + q) / 2];
		int i = p;
		int j = q;
		while (true) {
			while (vect[j].compareTo(pivot) > 0) {
				j--;
			}
			while (vect[i].compareTo(pivot) < 0) {
				i++;
			}
			if (i < j) {
				T tmp = vect[i];
				vect[i] = vect[j];
				vect[j] = tmp;
				j--;
				i++;
			} else {
				break;
			}
		}
		return j;
	}

	public static <T extends Comparable<T>> void quicksort(List<T> list, int p, int q) {
		if (p < q) {
			int gap = partition(list, p, q);
			quicksort(list, p, gap);
			quicksort(list, gap + 1, q);
		}
	}

	private static <T extends Comparable<T>> int partition(List<T> list, int p, int q) {
		T pivot = list.get((p + q) / 2);
		int i = p;
		int j = q;
		while (true) {
			while (list.get(j).compareTo(pivot) > 0) {
				j--;
			}
			while (list.get(i).compareTo(pivot) < 0) {
				i++;
			}
			if (i < j) {
				T tmp = list.get(i);
				list.remove(i);
				list.set(i, list.get(j - 1));
				list.remove(j);
				list.set(j, tmp);
				j--;
				i++;
			} else {
				break;
			}
		}
		return j;
	}

}
