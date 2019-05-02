package structures;

public class Graph<T> {

	private List<T> nodes = new List<>();
	private HashTable<T, List<T>> edges = new HashTable<>();

	public boolean exists(T node) {
		for (T cnode : nodes) {
			if (cnode == node) {
				return true;
			}
		}
		return false;
	}

	public void add(T node) {
		if (!exists(node)) {
			nodes.append(node);
			edges.put(node, new List<>());
		}
	}

//	public void remove (T node) {
//		if (exists(node)) {
//			nodes.remove(nodes.indexOf(node));
//			edges.put(node, new List<>());
//		}
//	}

	public boolean linked(T a, T b) {
		if (!exists(a) || !exists(b)) {
			return false;
		}
		return a == b || edges.get(a).contains(b);
	}

	public void link(T a, T b) {
		if (exists(a) && exists(b) && !linked(a, b)) {
			edges.get(a).append(b);
			edges.get(b).append(a);
		}
	}

	public List<T> adjacents(T a) {
		if (!exists(a)) {
			return null;
		}
		return edges.get(a);
	}

	public void dfs(T node) {
		if (exists(node)) {
			System.out.println("Depth First Search");

			List<T> explored = new List<>();

			Stack<Pair<T, Integer>> pila = new Stack<>();
			pila.push(new Pair<>(node, 0));

			while (!pila.empty()) {

				Pair<T, Integer> stick = pila.pop();
				T elem = stick.first;
				int index = stick.second;

				if (!explored.contains(elem)) {

					System.out.println(" | ".repeat(index) + " " + elem);

					explored.append(elem);

					for (T adjacent : adjacents(elem).reverse()) {
						pila.push(new Pair<>(adjacent, index + 1));
					}

				}

			}
		}
	}

//	public void dfs_rec(T node) {
//		dfs_rec(node, new List<>(), 1);
//	}
//
//	private void dfs_rec(T node, List<T> explored, int index) {
//		if (exists(node)) {
//			explored.append(node);
//			System.out.println(" | ".repeat(index) + " " + node);
//			for (T adjacent : adjacents(node)) {
//				if (!explored.contains(adjacent)) {
//					dfs_rec(adjacent, explored, index + 1);
//				}
//			}
//		}
//	}

	/**
	 Tempo: O(2m + n)
	 */
	public void bfs(T node) {
		if (exists(node)) {

			// Coda di appoggio per servire gli elementi (conterrà inizialmente l'elemento di partenza)
			Queue<T> coda = new Queue<>();
			coda.push(node);

			// Lista che permette di evitare di servire un elemento già "scoperto"
			List<T> discovered = new List<>();
			discovered.append(node);

			// Ogni livello della visita avrà una propria lista contenente gli elementi appartenenti relativo livello
			List<List<T>> layers = new List<>();
			// Inizialmente si inserisce il primo livello
			layers.append(new List<>());
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
						layers.append(new List<>());
					}
				}

			}

			System.out.println("Breadth First Search");
			int layerCount = 1;
			for (List<T> layer : layers) {
				System.out.print("Lvl " + layerCount++ + ": ");
				for (int i = 0; i < layer.size() - 1; i++) {
					System.out.print(layer.get(i) + ", ");
				}
				System.out.println(layer.get(layer.size() - 1));
			}

		}
	}

}
