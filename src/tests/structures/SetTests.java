package tests.structures;

import structures.Set;

public class SetTests {

	public static void main(String[] args) {
		Set<Integer> a = new Set<>();
		System.out.println(a);
		a.add(0);
		System.out.println(a);
		a.add(5);
		System.out.println(a);
		a.add(4);
		System.out.println(a);
		a.add(3);
		System.out.println(a);
		System.out.println("Iterator:");
		for (Integer item : a) {
			System.out.println("elem: " + item);
		}
		a.remove(4);
		System.out.println(a);
		a.remove(3);
		System.out.println(a);
		a.remove(8);
		System.out.println(a);
		if (a.contains(0)) {
			System.out.println("contiene 0");
		}
		a.remove(0);
		System.out.println(a);
		if (a.remove(5)) {
			System.out.println("riuscito a rimuovere 5");
		}
		System.out.println(a);
		if (!a.contains(0)) {
			System.out.println("non contiene 0");
		}
	}

}
