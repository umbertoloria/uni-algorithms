package structures;

import java.util.Iterator;

public class DirectGraph<T extends Comparable<T>, V> {

	private final class Edge implements Comparable<Edge> {

		final T node;
		final V value;

		Edge(T node, V value) {
			this.node = node;
			this.value = value;
		}

		public int compareTo(Edge o) {
			return node.compareTo(o.node);
		}

	}

	private Set<T> nodes = new Set<>();
	private HashTable<T, Set<Edge>> edges = new HashTable<>();

	public boolean exists(T node) {
		return nodes.contains(node);
	}

	public void add(T node) {
		if (!exists(node)) {
			nodes.add(node);
			edges.put(node, new Set<>());
		}
	}

//	public void remove (T node) {
//		if (exists(node)) {
//			nodes.remove(nodes.indexOf(node));
//			edges.put(node, new LList<>());
//		}
//	}

	public boolean linked(T a, T b) {
		if (!exists(a) || !exists(b)) {
			return false;
		} else {
			return a == b || edges.get(a).contains(new Edge(b, null));
		}
	}

	public void link(T a, T b, V value) {
		if (exists(a) && exists(b) && !linked(a, b)) {
			edges.get(a).add(new Edge(b, value));
		}
	}

	public LList<T> adjacents(T a) {
		if (!exists(a)) {
			return null;
		}
		Iterator<Edge> it = edges.get(a).iterator();
		LList<T> nodes = new LList<>();
		while (it.hasNext()) {
			nodes.append(it.next().node);
		}
		return nodes;

	}

	public void dfs(T node) {
		if (exists(node)) {
			System.out.println("Depth First Search");

			List<T> explored = new LList<>();

			Stack<Pair<T, Integer>> pila = new Stack<>();
			pila.push(new Pair<>(node, 0));

			while (!pila.empty()) {

				Pair<T, Integer> stick = pila.pop();
				T elem = stick.first;
				int index = stick.second;

				if (!explored.contains(elem)) {

					System.out.println(" | ".repeat(index) + " " + elem);

					explored.append(elem);

					for (T adjacent : adjacents(elem).createReverse()) {
						pila.push(new Pair<>(adjacent, index + 1));
					}

				}

			}
		}
	}

	/** Complexity: time O(2m + n) */
	public void bfs(T node) {
		if (exists(node)) {

			// Coda di appoggio per servire gli elementi (conterrà inizialmente l'elemento di partenza)
			Queue<T> coda = new Queue<>();
			coda.push(node);

			// Lista che permette di evitare di servire un elemento già "scoperto"
			LList<T> discovered = new LList<>();
			discovered.append(node);

			// Ogni livello della visita avrà una propria lista contenente gli elementi appartenenti relativo livello
			LList<LList<T>> layers = new LList<>();
			// Inizialmente si inserisce il primo livello
			layers.append(new LList<>());
			// Il numero di elementi da servire nella coda per completare il livello corrente è inizialmente 1
			int currentLayerCount = 1;

			while (!coda.empty()) {

				// Prelevo il prossimo nodo da servire
				T elem = coda.pop();
				// Lo aggiungo al livello corrente
				layers.get(layers.size() - 1).append(elem);
				// Il numero di elementi da servire per completare il livello corrente diminuisce
				currentLayerCount--;

				// Accodo tutti i nodi adiacenti all'elemento estratto se non ancora visitati
				for (T adjacent : adjacents(elem)) {
					if (!discovered.contains(adjacent)) {
						discovered.append(adjacent);
						coda.push(adjacent);
					}
				}

				// Se il numero di elementi da servire per completare il livello si è azzerato, vuol dire che
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
