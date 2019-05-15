package tests.algorithms;

import algorithms.huffman.Huffman;

public class HuffmanTests {

	public static void main(String[] args) {
		Huffman h = new Huffman();
		h.add('f', 5);
		h.add('e', 9);
		h.add('c', 12);
		h.add('b', 13);
		h.add('d', 16);
		h.add('a', 45);
		h.studia();
	}

}
