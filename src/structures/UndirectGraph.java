package structures;

public class UndirectGraph<V, W extends Comparable<W>> extends Graph<V, W> {

	private HashTable<V, HashTable<V, W>> data = new HashTable<>();

	public boolean exists(V node) {
		return data.hasKey(node);
	}

	public void add(V node) {
		if (!exists(node)) {
			data.put(node, new HashTable<>());
		}
	}

	public List<V> nodes() {
		return data.keys();
	}

	public List<Edge<V, W>> edges() {
		List<Edge<V, W>> result = new LList<>();
		for (V from : data.keys()) {
			for (V to : data.get(from).keys()) {
				W weight = data.get(from).get(to);
				Edge<V, W> e1 = new Edge<>(from, to, weight);
				Edge<V, W> e2 = new Edge<>(to, from, weight);
				if (!result.contains(e1) && !result.contains(e2)) {
					result.append(e1);
				}
			}
		}
		return result;
	}

	public boolean link(Edge<V, W> edge) {
		if (exists(edge.from) && exists(edge.to)) {
			data.get(edge.from).put(edge.to, edge.weight);
			data.get(edge.to).put(edge.from, edge.weight);
			return true;
		} else {
			return false;
		}
	}

	public List<Edge<V, W>> outgoings(V from) {
		List<Edge<V, W>> result = new LList<>();
		if (exists(from)) {
			for (V to : data.get(from).keys()) {
				result.append(new Edge<>(from, to, data.get(from).get(to)));
			}
		}
		return result;
	}

}
