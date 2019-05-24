package tests.structures;

import structures.MaxHeapSet;
import structures.MinHeapSet;

public class HeapSetTests {

	public static void main(String[] args) {
		System.out.println("*** TEST 1 ***");
		MaxHeapSet<Integer> h1 = new MaxHeapSet<>();
		h1.insert(9);
		h1.insert(15);
		h1.insert(10);
		h1.insert(7);
		h1.insert(12);
		h1.insert(11);
		h1.show();
		System.out.println("Contains 15: " + h1.contains(15));
		System.out.println("Extracted: " + h1.extract());
		h1.show();
		System.out.println("Contains 15: " + h1.contains(15));
		if (!h1.empty()) {
			System.out.println("The heap is not empty.");
		}
		h1.remove(10);
		h1.show();
		System.out.println("Contains 10: " + h1.contains(10));

		System.out.println();
		System.out.println("*** TEST 2 ***");
		System.out.println();

		MinHeapSet<Integer> h2 = new MinHeapSet<>();
		h2.insert(1);
		h2.insert(5);
		h2.insert(6);
		h2.insert(9);
		h2.insert(11);
		h2.insert(8);
		h2.insert(15);
		h2.insert(17);
		h2.insert(21);
		h2.show();
		System.out.println("Remove 5");
		h2.remove(5);
		h2.show();

		System.out.println();
		System.out.println("*** TEST 3 ***");
		System.out.println();

		MinHeapSet<Integer> h3 = new MinHeapSet<>();
		h3.insert(1);
		h3.insert(9);
		h3.insert(22);
		h3.insert(17);
		h3.insert(11);
		h3.insert(33);
		h3.insert(27);
		h3.insert(21);
		h3.insert(19);
		h3.show();
		System.out.println("Remove 33");
		h3.remove(33);
		h3.show();
	}

}
