package structures;

public class SimpleGraph<T> {

	private HashTable<T, LList<T>> edges = new HashTable<>();

	public void add(T node) {
		if (!exists(node)) {
			edges.put(node, new LList<>());
		}
	}

	public boolean exists(T node) {
		return edges.hasKey(node);
	}

	public List<T> nodes() {
		return edges.keys();
	}

	public boolean linked(T from, T to) {
		if (exists(from) && exists(to) && !from.equals(to)) {
			return edges.get(from).contains(to);
		}
		return false;
	}

	public void link(T from, T to) {
		if (exists(from) && exists(to) && !from.equals(to)) {
			edges.get(from).append(to);
		}
	}

	public List<T> outgoing(T from) {
		List<T> result = new LList<>();
		if (exists(from)) {
			result.expand(edges.get(from));
		}
		return result;
	}

	public List<T> incoming(T to) {
		List<T> result = new LList<>();
		if (exists(to)) {
			for (T node : nodes()) {
				if (!node.equals(to) && linked(node, to)) {
					result.append(node);
				}
			}
		}
		return result;
	}

	public List<List<T>> topologie() {
		List<T> uscentiEsclusivi = new LList<>();
		for (T node : nodes()) {
			if (incoming(node).empty()) {
				uscentiEsclusivi.append(node);
			}
		}
		List<List<T>> totalTopologies = new LList<>();
		for (T t : uscentiEsclusivi) {
			List<List<T>> partialTopologies = topologie(t, new LList<>());
			if (partialTopologies != null) {
				totalTopologies.expand(partialTopologies);
			}
		}
		return totalTopologies;
	}

	private List<List<T>> topologie(T nodo, List<T> visitati) {
		visitati.append(nodo);
		// Rimanenti
		List<T> rimanenti = nodes().exclude(visitati);
		// Nodi senza archi entranti
		List<T> senzaEntranti = new AList<>();
		for (T node : rimanenti) {
			if (incoming(node).exclude(visitati).empty()) {
				senzaEntranti.append(node);
			}
		}
		List<List<T>> totalTopologies = new LList<>();
		if (senzaEntranti.empty()) {
			totalTopologies.append(visitati);
		} else {
			for (T t : senzaEntranti) {
				List<T> tmpPath = new LList<>();
				for (T t1 : visitati) {
					tmpPath.append(t1);
				}
				List<List<T>> partialTopologies = topologie(t, tmpPath);
				if (partialTopologies != null) {
					totalTopologies.expand(partialTopologies);
				}
			}
		}
		return totalTopologies;
	}

	/** Complexity: time O(m + n) */
	public void dfs(T node) {
		if (exists(node)) {
			System.out.println("Depth First Search");

			List<T> explored = new LList<>();

			Stack<Pair<T, Integer>> pila = new Stack<>();
			pila.push(new Pair<>(node, 0));

			while (!pila.empty()) {

				Pair<T, Integer> stick = pila.pop();
				T u = stick.first;
				int index = stick.second;

				if (!explored.contains(u)) {

					System.out.println(" | ".repeat(index) + " " + u);

					explored.append(u);

					for (T v : outgoing(u).justReverse()) {
						pila.push(new Pair<>(v, index + 1));
					}

				}

			}
		}
	}

	/** Complexity: time O(m + n) */
	public void bfs(T node) {
		if (exists(node)) {

			// Coda di appoggio per servire gli elementi (conterrà inizialmente l'elemento di partenza).
			Queue<T> coda = new Queue<>();
			coda.push(node);

			// Lista che permette di evitare di servire un elemento già "scoperto".
			LList<T> discovered = new LList<>();
			discovered.append(node);

			// Ogni livello della visita avrà una propria lista contenente gli elementi ad esso appartenenti.
			LList<LList<T>> layers = new LList<>();
			// Inizialmente si inserisce il primo livello.
			layers.append(new LList<>());
			// Il numero di elementi ancora da processare appartenenti al livello corrente è inizialmente 1.
			int currentLayerCount = 1;

			while (!coda.empty()) {

				// Prelevo il prossimo nodo 'u' servire.
				T u = coda.pop();
				// Lo aggiungo al livello corrente.
				layers.get(layers.size() - 1).append(u);
				// Il numero di elementi da processare per completare il livello corrente diminuisce.
				currentLayerCount--;

				// Accodo tutti i nodi 'v' adiacenti ad 'u' se non ancora visitati.
				for (T v : outgoing(u)) {
					if (!discovered.contains(v)) {
						discovered.append(v);
						coda.push(v);
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
			for (LList<T> layer : layers) {
				System.out.print("Lvl " + layerCount++ + ": ");
				for (int i = 0; i < layer.size() - 1; i++) {
					System.out.print(layer.get(i) + ", ");
				}
				System.out.println(layer.get(layer.size() - 1));
			}

		}
	}

}

//public class SimpleGraph<T extends Comparable<T>> {
//
//	private DirectGraph<T, Integer> graph = new DirectGraph<>();
//
//	public boolean exists(T node) {
//		return graph.exists(node);
//	}
//
//	public void add(T node) {
//		graph.add(node);
//	}
//
//	public Set<T> nodes() {
//		return graph.nodes();
//	}
//
//	public boolean linked(T a, T b) {
//		return graph.linked(a, b);
//	}
//
//	public boolean link(T a, T b) {
//		return graph.link(a, b, 0);
//	}
//
//	public Set<T> outgoing(T a) {
//		return graph.outgoing(a);
//	}
//
//	public Set<T> incoming(T a) {
//		return graph.incoming(a);
//	}
//
//	public List<List<T>> topologie() {
//		Set<T> uscentiEsclusivi = new Set<>();
//		for (T node : graph.nodes()) {
//			if (graph.incoming(node).empty()) {
//				uscentiEsclusivi.add(node);
//			}
//		}
//		List<List<T>> totalTopologies = new LList<>();
//		for (T t : uscentiEsclusivi) {
//			List<List<T>> partialTopologies = topologie(t, new LList<>());
//			if (partialTopologies != null) {
//				totalTopologies.expand(partialTopologies);
//			}
//		}
//		return totalTopologies;
//	}
//
//	private List<List<T>> topologie(T nodo, List<T> visitati) {
//		visitati.append(nodo);
/////////////////////////////////////////////////////////////////////////		 Rimanenti
//		Set<T> rimanenti = graph.nodes().remove(visitati);
//		rimanenti.remove(nodo);
/////////////////////////////////////////////////////////////////////////		 Nodi senza archi entranti
//		Set<T> senzaEntranti = new Set<>();
//		for (T node : rimanenti) {
//			if (graph.incoming(node).remove(visitati).empty()) {
//				senzaEntranti.add(node);
//			}
//		}
//		List<List<T>> totalTopologies = new LList<>();
//		if (senzaEntranti.empty()) {
//			totalTopologies.append(visitati);
/////////////////////////////////////////////////////////////////////////			System.out.println(visitati);
//		} else {
//			for (T t : senzaEntranti) {
//				List<T> tmpPath = new LList<>();
//				for (T t1 : visitati) {
//					tmpPath.append(t1);
//				}
//				List<List<T>> partialTopologies = topologie(t, tmpPath);
//				if (partialTopologies != null) {
//					totalTopologies.expand(partialTopologies);
//				}
//			}
//		}
//		return totalTopologies;
//	}
//
//}
