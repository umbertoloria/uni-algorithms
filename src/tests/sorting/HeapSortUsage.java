package tests.sorting;

import sorting.HeapSort;

public class HeapSortUsage {

	public static void main(String[] args) {
		Integer[] a = {
				6, 3, 2, 10, -3, 5
		};
		print(a);
		HeapSort.heapsort(a);
		print(a);
	}

	private static void print(Object[] a) {
		System.out.print("|");
		for (Object i : a) {
			System.out.print(i + "|");
		}
		System.out.println();
	}

}
