package tests.structures;

import structures.HashTable;

public class HashTableTests {

	public static void main(String[] args) {
		HashTable<String, Integer> ht = new HashTable<>();

		ht.put("umberto", 5102);
		ht.put("mario", 5113);
		ht.put("antonio", 5191);
		System.out.println("filled in");
		status(ht);

		ht.remove("antonio");
		ht.remove("umberto");
		System.out.println("removed two items");
		status(ht);
		if (!ht.hasKey("antonio")) {
			System.out.println("chiave antonio libera\n");
		}

		ht.put("umberto", 5102);
		ht.put("mario", 5113);
		ht.put("antonio", 5191);
		System.out.println("filled them in again");
		status(ht);
		if (ht.hasKey("antonio")) {
			System.out.println("chiave antonio occupata\n");
		}

		ht.put("antonio", 1);
		System.out.println("replaced one of them");
		status(ht);

		ht.remove("gesù");
		System.out.println("fake remotion");
		status(ht);

	}

	private static void status(HashTable<String, Integer> ht) {
		System.out.println("antonio: " + ht.get("antonio"));
		System.out.println("mario  : " + ht.get("mario"));
		System.out.println("umberto: " + ht.get("umberto"));
		System.out.println("count: " + ht.count());
		System.out.println("capacity: " + ht.capacity());
		System.out.println("chiavi: " + ht.keys());
		System.out.println();
	}

}
