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
		System.out.println("to list: " + a.toList());
		System.out.println("is empty: " + a.empty());

		Set<Integer> c = new Set<>();
		c.add(1);
		c.add(2);
		c.add(3);
		c.add(4);
		c.add(8);
		c.add(10);
		c.add(13);
		c.add(15);
		c.add(18);

		Set<Integer> d = new Set<>();
		d.add(2);
		d.add(4);
		d.add(5);
		d.add(7);
		d.add(13);
		d.add(15);
		d.add(120);

		System.out.println("c  : " + c);
		System.out.println("d  : " + d);
		System.out.println("c-d: " + c.difference(d));
		System.out.println("c+d: " + c.union(d));
	}

}
