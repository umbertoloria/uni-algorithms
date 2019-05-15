package algorithms.huffman;

abstract class BNode implements Comparable<BNode> {

	final int frequency;

	BNode(int frequency) {
		this.frequency = frequency;
	}

	public int compareTo(BNode o) {
		return frequency - o.frequency;
	}

	abstract CharMap elabora(String prepend);

}
