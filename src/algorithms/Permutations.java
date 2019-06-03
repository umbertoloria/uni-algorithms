package algorithms;

import structures.AList;
import structures.List;

public class Permutations {

	public static List<String> get(String word) {
		List<String> result = new AList<>();
		for (int i = 0; i < word.length(); i++) {
			result.expand(all("", word, i));
		}
		return result;
	}

	private static List<String> all(String prefix, String word, int ignore) {
		List<String> result = new AList<>();
		if (word.length() > 1) {
			String newprefix = prefix + word.charAt(ignore);
			String rest = word.substring(0, ignore) + word.substring(ignore + 1);
			for (int i = 0; i < rest.length(); i++) {
				result.expand(all(newprefix, rest, i));
			}
		} else {
			result.append(prefix + word);
		}
		return result;
	}

}
