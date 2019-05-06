package tests.sorting;

import sorting.MergeSort;

public class MergeSortUsage {

	public static void main(String[] args) {
		String[] a = {
				"Umberto", "Mario", "Antonio", "Serena", "Antonella", "Sara"
		};
		print(a);
		MergeSort.mergesort(a);
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
