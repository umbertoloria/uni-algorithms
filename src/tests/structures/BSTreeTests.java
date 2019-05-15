package tests.structures;

import structures.BSTree;

public class BSTreeTests {

	public static void main(String[] args) {
		BSTree<Integer> t = new BSTree<>(10);
		t.put(3);
		t.put(2);
		t.put(8);
		t.put(12);
		t.show();
		System.out.println("Contains 10: " + t.contains(10));
		System.out.println("Count      : " + t.size());
		t.remove(8);
		t.show();
		t.remove(10);
		t.show();
		System.out.println("Contains 10: " + t.contains(10));
		System.out.println("Count      : " + t.size());
	}

}
