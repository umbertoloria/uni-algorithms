package structures;

public class SimpleGraph<V> extends Graph<V, Integer> {

	private HashTable<V, LList<V>> edges = new HashTable<>();

	public boolean contains(V node) {
		return edges.hasKey(node);
	}

	public void add(V node) {
		if (!contains(node)) {
			edges.put(node, new LList<>());
		}
	}

	public List<V> nodes() {
		return edges.keys();
	}

	public List<Edge<V, Integer>> edges() {
		List<Edge<V, Integer>> result = new LList<>();
		for (V from : edges.keys()) {
			for (V to : edges.get(from)) {
				result.append(new Edge<>(from, to));
			}
		}
		return result;
	}

	public void link(Edge<V, Integer> edge) {
		add(edge.from);
		add(edge.to);
		edges.get(edge.from).append(edge.to);
	}

	public List<Edge<V, Integer>> outgoings(V from) {
		List<Edge<V, Integer>> result = new LList<>();
		if (contains(from)) {
			for (V to : edges.get(from)) {
				result.append(new Edge<>(from, to));
			}
		}
		return result;
	}

	public List<List<V>> topologie() {
		List<V> uscentiEsclusivi = new LList<>();
		for (V node : nodes()) {
			if (incomings(node).empty()) {
				uscentiEsclusivi.append(node);
			}
		}
		List<List<V>> totalTopologies = new LList<>();
		for (V t : uscentiEsclusivi) {
			totalTopologies.expand(topologie(t, new LList<>()));
		}
		return totalTopologies;
	}

	private List<List<V>> topologie(V nodo, List<V> visitati) {
		visitati.append(nodo);
		// Rimanenti
		List<V> rimanenti = nodes().exclude(visitati);
		// Nodi senza archi entranti
		List<V> senzaEntranti = new AList<>();
		for (V node : rimanenti) {
			List<Edge<V, Integer>> incomings = incomings(node);
			// Rimuovo gli archi entranti in 'node' che provengono dai nodi già visitati.
			for (int i = 0; i < incomings.size(); i++) {
				if (visitati.contains(incomings.get(i).from)) {
					incomings.remove(i);
					i--;
				}
			}
			// Se non rimane nessun arco entrante in 'node', allora questo può far partire una nuova topologia.
			if (incomings.empty()) {
				senzaEntranti.append(node);
			}
		}
		List<List<V>> totalTopologies = new LList<>();
		if (senzaEntranti.empty()) {
			totalTopologies.append(visitati);
		} else {
			for (V t : senzaEntranti) {
				List<V> tmpPath = new LList<>();
				tmpPath.expand(visitati);
				totalTopologies.expand(topologie(t, tmpPath));
			}
		}
		return totalTopologies;
	}

}
