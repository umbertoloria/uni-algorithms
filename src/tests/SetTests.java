package tests;

import structures.Set;

public class SetTests {

	public static void main(String[] args) {
		Set<Integer> a = new Set<>();
		a.add(0);
		a.add(5);
		a.add(4);
		a.add(3);
		a.remove(4);
		a.remove(3);
		a.remove(8);
		if (a.contains(0)) {
			System.out.println("contiene 0");
		}
		a.remove(0);
		a.remove(5);
		if (a.contains(0)) {
			System.out.println("contiene 0");
		}
	}

}
