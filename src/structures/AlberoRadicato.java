package structures;

public class AlberoRadicato<V, W extends Comparable<W>> {

	private HashTable<V, Edge<V, W>> parentLinks = new HashTable<>();
	private HashTable<V, List<Edge<V, W>>> childrenLinks = new HashTable<>();

	public boolean exists(V node) {
		return childrenLinks.hasKey(node);
	}

	public void addRoot(V node) {
		if (!exists(node)) {
			childrenLinks.put(node, new LList<>());
		}
	}

	public void addChild(V parent, V child, W weight) {
		if (!exists(child)) {
			if (!exists(parent)) {
				addRoot(parent);
			}
			Edge<V, W> edge = new Edge<>(parent, child, weight);
			childrenLinks.get(parent).append(edge);
			childrenLinks.put(child, new LList<>());
			parentLinks.put(child, edge);
		}
	}

	public List<Edge<V, W>> edges() {
		List<Edge<V, W>> edges = new AList<>();
		for (V node : childrenLinks.keys()) {
			for (Edge<V, W> edge : childrenLinks.get(node)) {
				edges.append(edge);
			}
		}
		return edges;
	}

	public void show() {
		for (V root : childrenLinks.keys()) {
			if (!parentLinks.hasKey(root)) {
				System.out.println(show(root));
				System.out.println();
			}
		}
	}

	private String show(V node) {
		StringBuilder str = new StringBuilder();
		List<String> x = new AList<>();
		for (Edge<V, W> e : edges()) {
			if (e.from.equals(node)) {
				x.append(show(e.to));
			}
		}
		int fullWidths = 0;
		List<String[]> y = new AList<>();
		List<Integer> widths = new AList<>();
		for (String s : x) {
			String[] tmp = s.split("\n");
			y.append(tmp);
			int localWidth = tmp[0].length();
			widths.append(localWidth);
			fullWidths += localWidth + 3;
		}
		fullWidths -= 3;
		int offset = 0;
		boolean ancora = true;
		while (ancora) {
			ancora = false;
			for (int i = 0; i < y.size(); i++) {
				String[] s = y.get(i);
				if (offset < s.length) {
					str.append(s[offset]);
					if (!ancora && offset + 1 < s.length) {
						ancora = true;
					}
				} else {
					str.append(" ".repeat(widths.get(i)));
				}
				str.append("   ");
			}
			if (str.length() >= 3) {
				str.delete(str.length() - 3, str.length());
			}
			offset++;
			if (ancora) {
				str.append("\n");
			}
		}
		String bigBox = str.toString();
		String result = "";
		String header = node + "";
		if (bigBox.length() == 0) {
			result = header;
		} else {
			int p1 = fullWidths - header.length();
			result += " ".repeat(p1 / 2) + node;
			result += " ".repeat(p1 - p1 / 2) + "\n";
			if (fullWidths >= 3) {
				int p2 = fullWidths - 2;
				result += "/" + "-".repeat(p2) + "\\\n";
			} else {
				int p2 = fullWidths - 1;
				result += " ".repeat(p2 / 2) + "|" + " ".repeat(p2 - p2 / 2) + "\n";
			}
			result += bigBox;
		}
		return result;
	}

}
