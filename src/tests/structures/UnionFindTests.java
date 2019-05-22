package tests.structures;

import structures.UnionFind;

public class UnionFindTests {

	public static void main(String[] args) {
		UnionFind<Integer> uf = new UnionFind<>();
		uf.addSet(10);
		uf.addSet(20);
		uf.addSet(30);
		status(uf);
		if (uf.union(10, 30)) {
			System.out.println("10 united with 30");
		}
		if (uf.union(10, 20)) {
			System.out.println("10 united with 20");
		}
		if (!uf.union(20, 30)) {
			System.out.println("20 was already united with 30");
		}
		uf.union(10, 20);
		uf.union(20, 30);
		status(uf);
	}

	private static void status(UnionFind<Integer> uf) {
		System.out.println("STATUS");
		System.out.println("10: " + uf.find(10));
		System.out.println("20: " + uf.find(20));
		System.out.println("30: " + uf.find(30));
		uf.show();
		System.out.println();
	}

}
