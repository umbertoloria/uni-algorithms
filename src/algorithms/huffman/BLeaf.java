package algorithms.huffman;

final class BLeaf extends BNode {

	private final char ch;

	BLeaf(int frequency, char ch) {
		super(frequency);
		this.ch = ch;
	}

	CharMap elabora(String prepend) {
		CharMap charMap = new CharMap();
		charMap.add(new CharMapItem(ch, frequency, prepend));
		return charMap;
	}

}
