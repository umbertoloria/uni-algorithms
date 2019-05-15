package tests.structures;

import structures.MaxHeap;

public class HeapTests {

	public static void main(String[] args) {
		MaxHeap<Integer> h = new MaxHeap<>();
		h.insert(9);
		h.insert(15);
		h.insert(10);
		h.insert(7);
		h.insert(12);
		h.insert(11);
		h.show();
		System.out.println("Min: " + h.extract());
		h.show();
		if (h.empty()) {
			System.out.println("The heap is empty.");
		}
	}

}
