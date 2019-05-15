package algorithms.huffman;

final class BIntern extends BNode {

	private final BNode left, right;

	BIntern(BNode left, BNode right) {
		super(left.frequency + right.frequency);
		this.left = left;
		this.right = right;
	}

	CharMap elabora(String prepend) {
		CharMap charMap = new CharMap();
		charMap.add(left.elabora(prepend + "0"));
		charMap.add(right.elabora(prepend + "1"));
		return charMap;
	}

}
