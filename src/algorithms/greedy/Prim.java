package algorithms.greedy;

import structures.*;

public class Prim {

	private static class PrimNode<V> {

		private V node, previous;
		private Integer distancePrevNode;

		PrimNode(V node, V previous, Integer distancePrevNode) {
			this.node = node;
			this.previous = previous;
			this.distancePrevNode = distancePrevNode;
		}

		public boolean equals(Object obj) {
			if (obj instanceof PrimNode) {
				return ((PrimNode) obj).node.equals(node);
			} else {
				return false;
			}
		}

	}

	/** Complexity: time O(m log n) */
	public static <V> List<Edge<V, Integer>> mst(UndirectGraph<V, Integer> g, V s) {
		assert g.exists(s);

		MinHeap<Integer, PrimNode<V>> coda = new MinHeap<>();
		for (V node : g.nodes()) {
			if (!node.equals(s)) {
				coda.insert(Integer.MAX_VALUE, new PrimNode<>(node, null, null));
			}
		}
		coda.insert(0, new PrimNode<>(s, null, null));
		// 'partenza' sarà il primo ad essere processato.

		// Explored conterrà i nodi già processati.
		List<V> explored = new LList<>();

		// MST conterrà tutti gli archi del Minimum Spanning Tree.
		List<Edge<V, Integer>> mst = new AList<>();

		// Processiamo ogni volta il nodo più vicino.
		while (!coda.empty()) {

			PrimNode<V> pu = coda.extract();
			V u = pu.node;
			explored.append(u);

			for (Edge<V, Integer> edge : g.outgoing(u)) {
				if (!explored.contains(edge.to)) {
					PrimNode<V> handle = new PrimNode<>(edge.to, null, null);
					// Processo tutti gli archi che vanno verso nodi non ancora esplorati, aggiornando i loro costi.
					if (edge.weight < coda.priority(handle)) {
						coda.remove(handle);
						coda.insert(edge.weight, new PrimNode<>(edge.to, u, edge.weight));
					}
				}
			}
			if (pu.previous != null) {
				mst.append(new Edge<>(pu.previous, u, pu.distancePrevNode));
			}
		}
		return mst;
	}

}
