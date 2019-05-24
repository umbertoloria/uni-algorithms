package algorithms.greedy;

import structures.*;

public class Prim {

	private static class PrimNode<V> {

		private V node, closest;

		PrimNode(V node) {
			this.node = node;
			this.closest = null;
		}

		PrimNode(V node, V closest) {
			this.node = node;
			this.closest = closest;
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
	public static <V extends Comparable<V>> List<Edge<V, Integer>> mst(UndirectGraph<V, Integer> g, V s) {
		assert g.exists(s);
		MinHeap<Integer, PrimNode<V>> heap = new MinHeap<>();
		for (V node : g.nodes()) {
			if (!node.equals(s)) {
				heap.insert(Integer.MAX_VALUE, new PrimNode<>(node));
			}
		}
		heap.insert(0, new PrimNode<>(s));
		Set<V> explored = new Set<>();
		List<Edge<V, Integer>> mst = new AList<>();
		while (!heap.empty()) {
			PrimNode<V> pu = heap.extract();
			V u = pu.node;
			explored.add(u);
			for (V v : g.outgoing(u).difference(explored)) {
				int newPossibleWeight = g.weight(u, v);
				if (heap.priority(new PrimNode<>(v)) > newPossibleWeight) {
					heap.remove(new PrimNode<>(v));
					heap.insert(newPossibleWeight, new PrimNode<>(v, u));
				}
			}
			if (pu.closest != null) {
				mst.append(new Edge<>(pu.closest, u, g.weight(pu.closest, u)));
			}
		}
		return mst;
	}

}
