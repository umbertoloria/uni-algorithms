package algorithms.greedy;

import structures.*;

public class Dijkstra {

	private static class DijNode<V> {

		private V node, previous;
		private Integer distancePrevNode;

		DijNode(V node, V previous, Integer distancePrevNode) {
			this.node = node;
			this.previous = previous;
			this.distancePrevNode = distancePrevNode;
		}

		public boolean equals(Object obj) {
			if (obj instanceof DijNode) {
				return ((DijNode) obj).node.equals(node);
			} else {
				return false;
			}
		}

	}

	/** Complexity: time O(m log n) */
	public static <V> List<Edge<V, Integer>> shortestPath(DirectGraph<V, Integer> g, V partenza, V destinazione) {

		assert g.exists(partenza);
		assert g.exists(destinazione);

		MinHeap<Integer, DijNode<V>> coda = new MinHeap<>();
		for (V node : g.nodes()) {
			if (!node.equals(partenza)) {
				coda.insert(Integer.MAX_VALUE, new DijNode<>(node, null, null));
			}
		}
		coda.insert(0, new DijNode<>(partenza, null, null));
		// 'partenza' sarà il primo ad essere processato.

		// 'explored' conterrà i nodi già processati.
		List<DijNode<V>> explored = new AList<>();

		while (!coda.empty()) {

			int costoU = coda.priority(coda.peek());
			DijNode<V> infoNode = coda.extract();
			V corrente = infoNode.node;

			// 'corrente' è adesso un nodo esplorato.
			explored.prepend(infoNode);

			if (!corrente.equals(destinazione)) {

				// Controllo tutti gli archi uscenti da 'corrente' ed entranti in nodi non ancora esplorati.
				for (Edge<V, Integer> edge : g.outgoing(corrente)) {
					DijNode<V> handle = new DijNode<>(edge.to, null, null);
					if (!explored.contains(handle)) {
						// Questo arco potrebbe costituire un percorso meno costoso verso il suo nodo entrante.
						int costoV = coda.priority(handle);
						int nuovoCostoV = costoU + edge.weight;
						if (nuovoCostoV < costoV) {
							// In tal caso, aggiorno il costo di questo nodo usando questo nuovo arco.
							coda.remove(handle);
							coda.insert(nuovoCostoV, new DijNode<>(edge.to, corrente, edge.weight));
						}
					}
				}

			}
		}

		// Ricostruisco la soluzione partendo dai nodi esplorati.
		List<Edge<V, Integer>> soluzione = new AList<>();
		V search = destinazione;
		for (DijNode<V> infoNode : explored) {
			if (infoNode.node.equals(search)) {
				search = infoNode.previous;
				soluzione.prepend(new Edge<>(infoNode.previous, infoNode.node, infoNode.distancePrevNode));
				if (infoNode.previous.equals(partenza)) {
					break;
				}
			}
		}
		return soluzione;
	}

}
