package sorting;

public class BinarySearch {


	/** Complexity: time O(log n) */
	@SuppressWarnings("unchecked")
	public static <T extends Comparable<T>> int search(Object[] data, T value, int inf, int sup) {
		if (inf <= sup) {
			int mid = (inf + sup) / 2;
			int cmp = value.compareTo((T) data[mid]);
			if (cmp == 0) {
				return mid;
			} else if (cmp > 0) {
				return search(data, value, mid + 1, sup);
			} else {
				return search(data, value, inf, mid - 1);
			}
		}
		return -1;
	}

}
