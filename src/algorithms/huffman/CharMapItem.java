package algorithms.huffman;

final class CharMapItem implements Comparable<CharMapItem> {

	final char ch;
	final int freq;
	final String code;

	CharMapItem(char ch, int freq, String code) {
		this.ch = ch;
		this.freq = freq;
		this.code = code;
	}

	public int compareTo(CharMapItem o) {
		return freq - o.freq;
	}

}
