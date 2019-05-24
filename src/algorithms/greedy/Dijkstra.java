package algorithms.greedy;

import structures.*;

public class Dijkstra {

	private static class DijNode<V> {

		private V node, closest;

		DijNode(V node, V closest) {
			this.node = node;
			this.closest = closest;
		}

		public boolean equals(Object obj) {
			if (obj instanceof DijNode) {
				return ((DijNode) obj).node.equals(node);
			} else {
				return false;
			}
		}

		public String toString() {
			if (closest != null) {
				return node.toString() + " (closest " + closest.toString() + ")";
			} else {
				return node.toString() + " (no closest)";
			}
		}
	}

	/** Complexity: time O(m log n) */
	public static <V extends Comparable<V>> List<Edge<V, Integer>> shortestPath(DirectGraph<V, Integer> g, V partenza,
	                                                                            V destinazione) {

		assert g.exists(partenza);
		assert g.exists(destinazione);

		MinHeap<Integer, DijNode<V>> heap = new MinHeap<>();
		for (V node : g.nodes()) {
			if (!node.equals(partenza)) {
				heap.insert(Integer.MAX_VALUE, new DijNode<>(node, null));
			}
		}
		heap.insert(0, new DijNode<>(partenza, null));

		// 'partenza' si trova in cima alla heap, che contiene tutti i nodi di 'g'

		Set<V> explored = new Set<>();
		// 'explored' conterrà tutti i nodi che non voglio più considerare.

		List<Edge<V, Integer>> percorsi = new AList<>();
		// 'percorsi' conterrà vari archi e vi si portà estrapolare la soluzione.

		while (!heap.empty()) {

			int distanza = heap.priority(heap.peek());
			DijNode<V> pu = heap.extract();
			V u = pu.node;
			V precedente = pu.closest;

			// Aggiungiamo 'u' ai nodi esplorati.
			explored.add(u);
			// La distanza di un nodo 'x' viene modificata quando si trova un nuovo nodo 'y' entrante in 'x'
			// che mostra la presenza di un nuovo cammino minimale. La nuova distanza sarà il costo del nuovo
			// cammino, e il nodo 'y' diventerà il precedente di 'x'.

			if (precedente != null) {
				percorsi.append(new Edge<>(precedente, u, distanza));
			}

			if (u.equals(destinazione)) {
				break;
			}

			for (V v : g.outgoing(u).difference(explored)) {
				int distanzaV = heap.priority(new DijNode<>(v, null));
				int possibileNuovaDistanza = distanza + g.weight(u, v);
				// Se si trova un nuovo cammino minimale fino a 'v', allora si diminuisce la distanza di 'v'.
				if (possibileNuovaDistanza < distanzaV) {
					heap.remove(new DijNode<>(v, null));
					heap.insert(possibileNuovaDistanza, new DijNode<>(v, u));
					// Il precedente di 'v' sarà 'u'.
				}
			}
		}

		List<Edge<V, Integer>> soluzione = new AList<>();
		V app = destinazione;
		while (!percorsi.empty() && !app.equals(partenza)) {

			for (int i = percorsi.size() - 1; i >= 0; i--) {
				Edge<V, Integer> arco = percorsi.get(i);
				if (arco.to.equals(app)) {
					soluzione.prepend(new Edge<>(arco.from, app, g.weight(arco.from, app)));
					app = arco.from;
					percorsi.remove(i);
					break;
				}
			}

		}
		return soluzione;
	}

}
