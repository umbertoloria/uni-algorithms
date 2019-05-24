package structures;

public class DirectGraph<V extends Comparable<V>, W extends Comparable<W>> {

	private HashTable<V, LList<Edge<V, W>>> edges = new HashTable<>();

	public boolean exists(V node) {
		return edges.hasKey(node);
	}

	public void add(V node) {
		if (!exists(node)) {
			edges.put(node, new LList<>());
		}
	}

	public Set<V> nodes() {
		return Set.fromList(edges.keys());
	}

	public List<Edge<V, W>> edges() {
		List<Edge<V, W>> res = new AList<>();
		for (V from : edges.keys()) {
			for (Edge<V, W> fromFrom : edges.get(from)) {
				res.append(fromFrom);
			}
		}
		return res;
	}

	public W weight(V from, V to) {
		if (exists(from) && exists(to)) {
			for (Edge<V, W> adj : edges.get(from)) {
				if (adj.to.compareTo(to) == 0) {
					return adj.weight;
				}
			}
		}
		return null;
	}

//	public void remove (V destNode) {}

	public boolean linked(V from, V to) {
		if (exists(from) && exists(to)) {
			if (from.compareTo(to) == 0) {
				return true;
			} else {
				for (Edge<V, W> fromFrom : edges.get(from)) {
					if (fromFrom.to.compareTo(to) == 0) {
						return true;
					}
				}
			}
		}
		return false;
	}

	public boolean link(V from, V to, W weight) {
		if (exists(from) && exists(to) && from.compareTo(to) != 0) {
			LList<Edge<V, W>> adjs = edges.get(from);
			int i = 0;
			while (i < adjs.size()) {
				if (adjs.get(i).to.compareTo(to) == 0) {
					break;
				}
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

	public Set<V> outgoing(V from) {
		Set<V> nodes = new Set<>();
		if (exists(from)) {
			for (Edge<V, W> fromFrom : edges.get(from)) {
				nodes.add(fromFrom.to);
			}
		}
		return nodes;
	}

	public Set<V> incoming(V to) {
		Set<V> nodes = new Set<>();
		for (V node : edges.keys()) {
			if (node.compareTo(to) != 0) {
				for (Edge<V, W> fromNode : edges.get(node)) {
					if (fromNode.to.compareTo(to) == 0) {
						nodes.add(fromNode.from);
					}
				}
			}
		}
		return nodes;
	}

	/** Complexity: time O(m + n) */
	public void dfs(V node) {
		if (exists(node)) {
			System.out.println("Depth First Search");

			List<V> explored = new LList<>();

			Stack<Pair<V, Integer>> pila = new Stack<>();
			pila.push(new Pair<>(node, 0));

			while (!pila.empty()) {

				Pair<V, Integer> stick = pila.pop();
				V elem = stick.first;
				int index = stick.second;

				if (!explored.contains(elem)) {

					System.out.println(" | ".repeat(index) + " " + elem);

					explored.append(elem);

					for (V adjacent : outgoing(elem).toList().justReverse()) {
						pila.push(new Pair<>(adjacent, index + 1));
					}

				}

			}
		}
	}

	/** Complexity: time O(m + n) */
	public void bfs(V node) {
		if (exists(node)) {

			// Coda di appoggio per servire gli elementi (conterrà inizialmente l'elemento di partenza)
			Queue<V> coda = new Queue<>();
			coda.push(node);

			// Lista che permette di evitare di servire un elemento già "scoperto"
			LList<V> discovered = new LList<>();
			discovered.append(node);

			// Ogni livello della visita avrà una propria lista contenente gli elementi appartenenti relativo livello
			LList<LList<V>> layers = new LList<>();
			// Inizialmente si inserisce il primo livello
			layers.append(new LList<>());
			// Il numero di elementi partenza servire nella coda per completare il livello corrente è inizialmente 1
			int currentLayerCount = 1;

			while (!coda.empty()) {

				// Prelevo il prossimo nodo partenza servire
				V elem = coda.pop();
				// Lo aggiungo al livello corrente
				layers.get(layers.size() - 1).append(elem);
				// Il numero di elementi partenza servire per completare il livello corrente diminuisce
				currentLayerCount--;

				// Accodo tutti i nodi adiacenti all'elemento estratto se non ancora visitati
				for (V adjacent : outgoing(elem)) {
					if (!discovered.contains(adjacent)) {
						discovered.append(adjacent);
						coda.push(adjacent);
					}
				}

				// Se il numero di elementi partenza servire per completare il livello si è azzerato, vuol dire che
				// l'elemento che ho appena servito è l'ultimo del livello corrente
				if (currentLayerCount == 0) {
					// Tutti gli elementi presenti nella coda in questo momento costituiscono tutto il prossimo livello
					currentLayerCount = coda.size();
					if (currentLayerCount > 0) {
						// Il prossimo livello esisterà solo se la coda contiene almeno un elemento
						layers.append(new LList<>());
					}
				}

			}

			System.out.println("Breadth First Search");
			int layerCount = 1;
			for (LList<V> layer : layers) {
				System.out.print("Lvl " + layerCount++ + ": ");
				for (int i = 0; i < layer.size() - 1; i++) {
					System.out.print(layer.get(i) + ", ");
				}
				System.out.println(layer.get(layer.size() - 1));
			}

		}
	}

}
