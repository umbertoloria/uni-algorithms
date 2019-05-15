package algorithms.huffman;

import structures.Set;

class CharMap {

	private Set<CharMapItem> items = new Set<>();
	private double frequencySum = 0;

	double averageBitLength() {
		double abl = 0;
		for (CharMapItem item : items) {
			abl += item.freq / frequencySum * item.code.length();
		}
		return abl;
	}

	public void add(CharMap part) {
		for (CharMapItem item : part.items) {
			frequencySum += item.freq;
		}
		items = items.union(part.items);
	}

	public void add(CharMapItem item) {
		frequencySum += item.freq;
		items.add(item);
	}

	public String toString() {
		StringBuilder res = new StringBuilder();
		for (CharMapItem item : items.toList().justReverse()) {
			res.append(item.ch);
			res.append(" - ");
			res.append(item.freq);
			res.append(": ");
			res.append(item.code);
			res.append("\n");
		}
		return res.toString();
	}

}
