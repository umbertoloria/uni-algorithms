package tests;

import sorting.QuickSort;

public class QuickSortUsage {

	public static void main(String[] args) {
		Integer[] a = {
				6, 3, 2, 10, -3, 5, 1, 4, 5, 3, 2, 6, 4, 1, 3, 7
		};
		print(a);
		QuickSort.quicksort(a, 0, a.length - 1);
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
