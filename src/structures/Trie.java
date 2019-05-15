package structures;

public class Trie {

	private class TrieNode {

		private HashTable<Character, TrieNode> letters = new HashTable<>();
		private boolean end = false;

		void setEnd() {
			end = true;
		}

		Set<String> getAll(String prepend) {
			Set<String> words = new Set<>();
			if (end) {
				words.add(prepend);
			}
			for (Character key : letters.keys()) {
				words = words.union(letters.get(key).getAll(prepend + key));
			}
			return words;
		}

		Set<String> search(String starting) {
			Set<String> result = new Set<>();
			if (starting.length() > 0) {
				Queue<Pair<Character, TrieNode>> chars = new Queue<>();
				char ch = starting.charAt(0);
				if (ch == '*') {
					for (Character key : letters.keys()) {
						chars.push(new Pair<>(key, letters.get(key)));
					}
				} else {
					TrieNode tmp = letters.get(ch);
					if (tmp != null) {
						chars.push(new Pair<>(ch, tmp));
					}
				}
				while (!chars.empty()) {
					Pair<Character, TrieNode> pair = chars.pop();
					for (String word : pair.second.search(starting.substring(1))) {
						result.add(pair.first + word);
					}
				}
			} else {
				result = result.union(getAll(""));
			}
			return result;
		}

	}

	private TrieNode root = new TrieNode();

	public void insert(String word) {
		TrieNode tmp = root;
		for (int i = 0; i < word.length(); i++) {
			char ch = word.charAt(i);
			if (tmp.letters.hasKey(ch)) {
				tmp = tmp.letters.get(ch);
			} else {
				TrieNode newnode = new TrieNode();
				tmp.letters.put(ch, newnode);
				tmp = newnode;
			}
		}
		tmp.setEnd();
	}

	public Set<String> search(String starting) {
		return root.search(starting);
	}

}
