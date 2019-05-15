package algorithms.huffman;

import structures.MinHeap;

public class Huffman {

	private MinHeap<BNode> heap = new MinHeap<>();

	public void add(char ch, int frequency) {
		heap.insert(new BLeaf(frequency, ch));
	}

	public void studia() {
		while (heap.size() > 1) {
			heap.insert(new BIntern(heap.extract(), heap.extract()));
		}
		CharMap map = heap.extract().elabora("");
		System.out.println("ABL: " + map.averageBitLength());
		System.out.println(map);
	}

}
