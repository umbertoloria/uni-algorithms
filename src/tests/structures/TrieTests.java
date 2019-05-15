package tests.structures;

import structures.Set;
import structures.Trie;

public class TrieTests {

	public static void main(String[] args) {
		Trie a = new Trie();
		a.insert("serena");
		a.insert("umberto");
		a.insert("mario");
		a.insert("michelantonio");
		a.insert("antonio");
		a.insert("michele");
		a.insert("orlando");
		a.insert("giovanni");
		Set<String> words = a.search("***e");
		for (String word : words) {
			System.out.println(word);
		}
	}

}



