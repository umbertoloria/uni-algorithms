package tests;

import structures.HashTable;

public class HashTableTests {

	public static void main(String[] args) {
		HashTable<String, Integer> ht = new HashTable<>();

		ht.put("umberto", 5102);
		ht.put("mario", 5113);
		ht.put("antonio", 5191);

		status(ht);

		ht.remove("antonio");
		ht.remove("umberto");

		status(ht);

		ht.put("umberto", 5102);
		ht.put("mario", 5113);
		ht.put("antonio", 5191);

		status(ht);

	}

	private static void status(HashTable<String, Integer> ht) {
		System.out.println("antonio: " + ht.get("antonio"));
		System.out.println("mario  : " + ht.get("mario"));
		System.out.println("umberto: " + ht.get("umberto"));
		System.out.println("count: " + ht.size());
		System.out.println("capacity: " + ht.capacity());
		System.out.println();
	}

}
