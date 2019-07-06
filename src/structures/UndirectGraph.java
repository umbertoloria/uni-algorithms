package structures;

public class UndirectGraph<V, W extends Comparable<W>> extends Graph<V, W> {

	private HashTable<V, HashTable<V, W>> data = new HashTable<>();

	public boolean contains(V node) {
		return data.hasKey(node);
	}

	public void add(V node) {
		if (!contains(node)) {
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

	public void link(Edge<V, W> edge) {
		add(edge.from);
		add(edge.to);
		data.get(edge.from).put(edge.to, edge.weight);
		data.get(edge.to).put(edge.from, edge.weight);
	}

	public List<Edge<V, W>> outgoings(V from) {
		List<Edge<V, W>> result = new LList<>();
		if (contains(from)) {
			for (V to : data.get(from).keys()) {
				result.append(new Edge<>(from, to, data.get(from).get(to)));
			}
		}
		return result;
	}

	public List<UndirectGraph<V, W>> componentiConnesse() {
		List<UndirectGraph<V, W>> componenti = new AList<>();
		HashSet<V> partitions = new HashSet<>();
		for (V node : nodes()) {
			UndirectGraph<V, W> componente = componenteConnessa(node, partitions);
			if (!componente.nodes().empty()) {
				componenti.append(componente);
			}
		}
		return componenti;
	}

	public UndirectGraph<V, W> componenteConnessa(V s) {
		return componenteConnessa(s, new HashSet<>());
	}

	private UndirectGraph<V, W> componenteConnessa(V s, HashSet<V> partitions) {
		UndirectGraph<V, W> componente = new UndirectGraph<>();
		Stack<V> st = new Stack<>(s);
		while (!st.empty()) {
			V u = st.pop();
			if (partitions.thisIsNew(u)) {
				componente.add(u);
				for (Edge<V, W> outgoing : outgoings(u)) {
					st.push(outgoing.to);
				}
			}
		}
		for (V u : componente.nodes()) {
			for (Edge<V, W> e : outgoings(u)) {
				if (componente.contains(e.to)) {
					componente.link(e);
				}
			}
		}
		return componente;
	}

}
