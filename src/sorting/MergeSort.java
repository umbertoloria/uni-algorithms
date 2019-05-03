package sorting;

public class MergeSort {

	public static <T extends Comparable<T>> void mergesort(T[] vect) {
		mergesort(vect, 0, vect.length - 1);
	}

	/**
	 Complexity: time O(n log n)
	 */
	private static <T extends Comparable<T>> void mergesort(T[] vect, int left, int right) {
		if (left < right) {
			int mid = (left + right) / 2;
			mergesort(vect, left, mid);
			mergesort(vect, mid + 1, right);
			merge(vect, left, mid, right);
		}
	}

	/**
	 Complexity: time O(n), space O(n)
	 */
	@SuppressWarnings("unchecked")
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

}