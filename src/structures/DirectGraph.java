package structures;

public class DirectGraph<V extends Comparable<V>, E> {

	private class Edge implements Comparable<Edge> {

		private V destNode;
		private E value;

		Edge(V destNode, E value) {
			this.destNode = destNode;
			this.value = value;
		}

		public int compareTo(Edge o) {
			return destNode.compareTo(o.destNode);
		}

		public void setValue(E value) {
			this.value = value;
		}

	}

	private HashTable<V, Set<Edge>> edges = new HashTable<>();

	public boolean exists(V node) {
		return edges.hasKey(node);
	}

	public void add(V node) {
		if (!exists(node)) {
			edges.put(node, new Set<>());
		}
	}

	public Set<V> nodes() {
		return Set.fromList(edges.keys());
	}

	public E value(V a, V b) {
		if (linked(a, b)) {
			return edges.get(a).get(new Edge(b, null)).value;
		} else {
			return null;
		}
	}

//	public void remove (V destNode) {}

	public boolean linked(V a, V b) {
		if (exists(a) && exists(b)) {
			return a.equals(b) || edges.get(a).contains(new Edge(b, null));
		} else {
			return false;
		}
	}

	public boolean link(V a, V b, E value) {
		if (exists(a) && exists(b)) {
			Edge e = edges.get(a).get(new Edge(b, null));
			if (e == null) {
				edges.get(a).add(new Edge(b, value));
			} else if (!e.value.equals(value)) {
				e.setValue(value);
			}
			return true;
		} else {
			return false;
		}
	}

	public Set<V> outgoing(V a) {
		Set<V> nodes = new Set<>();
		Set<Edge> outgoings = edges.get(a);
		if (outgoings != null) {
			for (Edge edge : outgoings) {
				nodes.add(edge.destNode);
			}
		}
		return nodes;
	}

	public Set<V> incoming(V a) {
		Set<V> nodes = new Set<>();
		for (V node : edges.keys()) {
			if (node.compareTo(a) != 0) {
				if (edges.get(node).contains(new Edge(a, null))) {
					nodes.add(node);
				}
			}
		}
		return nodes;
	}

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

	/** Complexity: time O(2m + n) */
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
