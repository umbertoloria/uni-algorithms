package structures;

public abstract class Graph<V, W extends Comparable<W>> {

	public abstract boolean exists(V node);

	public abstract void add(V node);

	public abstract List<V> nodes();

	public abstract List<Edge<V, W>> edges();

	public abstract boolean link(Edge<V, W> edge);

	public abstract List<Edge<V, W>> outgoings(V from);

	public List<List<V>> componentiConnesse() {
		HashTable<V, Integer> partitions = new HashTable<>();
		int i = 0;
		for (V node : nodes()) {
			componenteConnessa(node, partitions, i++);
		}
		List<List<V>> result = new AList<>();
		for (V node : partitions.keys()) {
			int part = partitions.get(node);
			if (part < result.size()) {
				result.get(part).append(node);
			} else {
				for (int j = result.size(); j <= part; j++) {
					result.append(new AList<>());
				}
				result.get(result.size() - 1).append(node);
			}
		}
		return result;
	}

	private void componenteConnessa(V node, HashTable<V, Integer> partitions, int id) {
		if (!partitions.hasKey(node)) {
			partitions.put(node, id);
			for (Edge<V, W> edge : outgoings(node)) {
				componenteConnessa(edge.to, partitions, id);
			}
		}
	}

}
