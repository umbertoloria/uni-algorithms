package tests.structures;

import structures.MinHeap;

public class HeapTests {

	public static void main(String[] args) {
		MinHeap<Integer, String> h1 = new MinHeap<>();
		h1.insert(9, "mario");
		h1.insert(15, "antonio");
		h1.insert(10, "umberto");
		h1.insert(7, "michele");
		h1.insert(12, "michelantonio");
		h1.insert(11, "felice");
		h1.show();
		System.out.println("Peek: " + h1.peek());
		System.out.println("Remove 'michelantonio': " + h1.remove("michelantonio"));
		h1.show();
		System.out.println("Remove 'umberto': " + h1.remove("umberto"));
		h1.show();
		h1.insert(0, "umberto");
		System.out.println("Insert 'umberto'");
		h1.show();
	}

}
