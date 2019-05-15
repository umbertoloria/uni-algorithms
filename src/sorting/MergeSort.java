package sorting;

import java.util.Comparator;

@SuppressWarnings("unchecked")
public class MergeSort {

	public static <T extends Comparable<T>> void mergesort(T[] vect) {
		mergesort(vect, 0, vect.length - 1);
	}

	/** Complexity: time O(n log n) */
	private static <T extends Comparable<T>> void mergesort(T[] vect, int left, int right) {
		if (left < right) {
			int mid = (left + right) / 2;
			mergesort(vect, left, mid);
			mergesort(vect, mid + 1, right);
			merge(vect, left, mid, right);
		}
	}

	/** Complexity: time and space O(n) */
	private static <T extends Comparable<T>> void merge(T[] vect, int left, int mid, int right) {
		int i = left;
		int j = mid + 1;
		int k = 0;
		Object[] tmp = new Object[right - left + 1];
		while (i <= mid && j <= right) {
			if (vect[i].compareTo(vect[j]) < 0) {
				tmp[k] = vect[i++];
			} else {
				tmp[k] = vect[j++];
			}
			k++;
		}
		while (i <= mid) {
			tmp[k++] = vect[i++];
		}
		while (j <= right) {
			tmp[k++] = vect[j++];
		}
		for (k = left; k <= right; k++) {
			vect[k] = (T) tmp[k - left];
		}
	}

	public static <T> void mergesort(T[] vect, Comparator<T> comp) {
		mergesort(vect, 0, vect.length - 1, comp);
	}

	/** Complexity: time O(n log n) */
	private static <T> void mergesort(T[] vect, int left, int right, Comparator<T> comp) {
		if (left < right) {
			int mid = (left + right) / 2;
			mergesort(vect, left, mid, comp);
			mergesort(vect, mid + 1, right, comp);
			merge(vect, left, mid, right, comp);
		}
	}

	/** Complexity: time and space O(n) */
	private static <T> void merge(T[] vect, int left, int mid, int right, Comparator<T> comp) {
		int i = left;
		int j = mid + 1;
		int k = 0;
		Object[] tmp = new Object[right - left + 1];
		while (i <= mid && j <= right) {
			if (comp.compare(vect[i], vect[j]) < 0) {
				tmp[k] = vect[i++];
			} else {
				tmp[k] = vect[j++];
			}
			k++;
		}
		while (i <= mid) {
			tmp[k++] = vect[i++];
		}
		while (j <= right) {
			tmp[k++] = vect[j++];
		}
		for (k = 0; k < tmp.length; k++) {
			vect[left + k] = (T) tmp[k];
		}
	}

}
