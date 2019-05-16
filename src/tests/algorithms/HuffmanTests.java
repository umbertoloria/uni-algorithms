package tests.algorithms;

import algorithms.huffman.Huffman;

public class HuffmanTests {

	public static void main(String[] args) {
		Huffman h1 = new Huffman();
		h1.add('f', 5);
		h1.add('e', 9);
		h1.add('c', 12);
		h1.add('b', 13);
		h1.add('d', 16);
		h1.add('a', 45);
		h1.studia();
		Huffman h2 = new Huffman();
		h2.add('g', 4);
		h2.add('c', 7);
		h2.add('d', 10);
		h2.add('a', 25);
		h2.add('e', 26);
		h2.add('b', 28);
		h2.studia();
	}

}
