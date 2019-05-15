package tests.sorting;

import sorting.MergeSort;

import java.util.Comparator;

public class MergeSortUsage {

	public static void main(String[] args) {
		String[] a = {
				"Umberto", "Mario", "Antonio", "Serena", "Antonella", "Sara"
		};
		print(a);
		MergeSort.mergesort(a);
		print(a);

		class A {
			private int a;

			private A(int a) {
				this.a = a;
			}

			public String toString() {
				return a + "";
			}
		}

		A[] aa = {
				new A(5), new A(7), new A(9), new A(8), new A(-10)
		};

		print(aa);
		MergeSort.mergesort(aa, Comparator.comparingInt(o -> o.a));
		print(aa);
	}

	private static void print(Object[] a) {
		System.out.print("|");
		for (Object i : a) {
			System.out.print(i + "|");
		}
		System.out.println();
	}

}
