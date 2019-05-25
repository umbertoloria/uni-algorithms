package structures;

public class DirectGraph<V, W extends Comparable<W>> {

	private HashTable<V, LList<Edge<V, W>>> edges = new HashTable<>();

	public boolean exists(V node) {
		return edges.hasKey(node);
	}

	public void add(V node) {
		if (!exists(node)) {
			edges.put(node, new LList<>());
		}
	}

	public List<V> nodes() {
		return edges.keys();
	}

	public List<Edge<V, W>> edges() {
		List<Edge<V, W>> res = new AList<>();
		for (V from : nodes()) {
			for (Edge<V, W> fromFrom : edges.get(from)) {
				res.append(fromFrom);
			}
		}
		return res;
	}

	public boolean link(V from, V to, W weight) {
		if (exists(from) && exists(to) && !from.equals(to)) {
			LList<Edge<V, W>> adjs = edges.get(from);
			int i = 0;
			while (i < adjs.size() && !adjs.get(i).to.equals(to)) {
				i++;
			}
			if (i < adjs.size()) {
				adjs.remove(i);
			}
			adjs.append(new Edge<>(from, to, weight));
			return true;
		} else {
			return false;
		}
	}

	public List<Edge<V, W>> outgoing(V from) {
		List<Edge<V, W>> result = new LList<>();
		if (exists(from)) {
			result.expand(edges.get(from));
		}
		return result;
	}

}
