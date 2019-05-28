package tests.structures;

import structures.UnionFind;

public class UnionFindTests {

	public static void main(String[] args) {
		UnionFind<Integer> uf = new UnionFind<>();
		uf.addSet(10);
		uf.addSet(20);
		uf.addSet(21);
		uf.addSet(30);
		uf.addSet(31);
		uf.addSet(32);
		uf.addSet(33);
		status(uf);
		if (uf.union(10, 30)) {
			System.out.println("10 united with 30");
		}
		if (uf.union(20, 21)) {
			System.out.println("20 united with 21");
		}
		if (uf.union(30, 31)) {
			System.out.println("30 united with 31");
		}
		if (uf.union(31, 32)) {
			System.out.println("31 united with 32");
		}
		if (uf.union(33, 31)) {
			System.out.println("33 united with 31");
		}
		System.out.println();
		status(uf);
	}

	private static void status(UnionFind<Integer> uf) {
		System.out.println(uf);
		System.out.println("Segnaposto di 10: " + uf.find(10));
		System.out.println("Segnaposto di 20: " + uf.find(20));
		System.out.println("Segnaposto di 30: " + uf.find(30));
		System.out.println();
	}

}
