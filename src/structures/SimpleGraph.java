package structures;

public class SimpleGraph<V> extends Graph<V, Integer> {

	private HashTable<V, LList<V>> edges = new HashTable<>();

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

	public List<Edge<V, Integer>> edges() {
		List<Edge<V, Integer>> result = new LList<>();
		for (V from : edges.keys()) {
			for (V to : edges.get(from)) {
				result.append(new Edge<>(from, to));
			}
		}
		return result;
	}

	public boolean link(Edge<V, Integer> edge) {
		if (exists(edge.from) && exists(edge.to)) {
			edges.get(edge.from).append(edge.to);
			return true;
		} else {
			return false;
		}
	}

	public List<Edge<V, Integer>> outgoings(V from) {
		List<Edge<V, Integer>> result = new LList<>();
		if (exists(from)) {
			for (V to : edges.get(from)) {
				result.append(new Edge<>(from, to));
			}
		}
		return result;
	}

	public List<Edge<V, Integer>> incomings(V to) {
		List<Edge<V, Integer>> result = new LList<>();
		if (exists(to)) {
			for (V from : edges.keys()) {
				if (!from.equals(to) && edges.get(from).contains(to)) {
					result.append(new Edge<>(from, to));
				}
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

	/** Complexity: time O(m + n) */
	public void dfs(V node) {
		if (exists(node)) {
			System.out.println("Depth First Search");

			HashTable<V, Boolean> explored = new HashTable<>();

			Stack<Pair<V, Integer>> pila = new Stack<>();
			pila.push(new Pair<>(node, 0));

			while (!pila.empty()) {

				Pair<V, Integer> stick = pila.pop();
				V u = stick.first;
				int index = stick.second;

				if (!explored.hasKey(u)) {

					System.out.println(" | ".repeat(index) + " " + u);

					explored.put(u, true);

					for (Edge<V, Integer> edge : outgoings(u).justReverse()) {
						pila.push(new Pair<>(edge.to, index + 1));
					}

				}

			}
		}
	}

	/** Complexity: time O(m + n) */
	public void bfs(V node) {
		if (exists(node)) {

			// Coda di appoggio per servire gli elementi (conterrà inizialmente l'elemento di partenza).
			Queue<V> coda = new Queue<>();
			coda.push(node);

			// Lista che permette di evitare di servire un elemento già "scoperto".
			LList<V> discovered = new LList<>();
			discovered.append(node);

			// Ogni livello della visita avrà una propria lista contenente gli elementi ad esso appartenenti.
			LList<LList<V>> layers = new LList<>();
			// Inizialmente si inserisce il primo livello.
			layers.append(new LList<>());
			// Il numero di elementi ancora da processare appartenenti al livello corrente è inizialmente 1.
			int currentLayerCount = 1;

			while (!coda.empty()) {

				// Prelevo il prossimo nodo 'u' servire.
				V u = coda.pop();
				// Lo aggiungo al livello corrente.
				layers.get(layers.size() - 1).append(u);
				// Il numero di elementi da processare per completare il livello corrente diminuisce.
				currentLayerCount--;

				// Accodo tutti i nodi 'v' adiacenti ad 'u' se non ancora visitati.
				for (Edge<V, Integer> edge : outgoings(u)) {
					if (!discovered.contains(edge.to)) {
						discovered.append(edge.to);
						coda.push(edge.to);
					}
				}

				// Se il numero di elementi ancora da processare per completare il livello corrente si è azzerato,
				// vuol dire che l'elemento che ho appena servito è l'ultimo del livello corrente.
				if (currentLayerCount == 0) {
					// In questo momento, tutti gli elementi presenti nella coda costituiscono il prossimo livello.
					currentLayerCount = coda.size();
					if (currentLayerCount > 0) {
						// Il prossimo livello esisterà solo se la coda contiene almeno un elemento.
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
