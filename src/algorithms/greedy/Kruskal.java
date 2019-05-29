package algorithms.greedy;

import structures.*;

public class Kruskal {

	/** Complexity: time O(m log n) */
	public static <V, W extends Comparable<W>> List<Edge<V, W>> mst(UndirectGraph<V, W> g) {
		UnionFind<V> uf = new UnionFind<>();
		for (V node : g.nodes()) {
			uf.addSet(node);
		}
		List<Edge<V, W>> mst = new AList<>();

		List<Edge<V, W>> edges = new LList<>();
		for (Edge<V, W> edge : g.edges()) {
			edges.append(edge);
		}
		List.sort(edges);

		for (Edge<V, W> edge : edges) {
			if (!uf.find(edge.from).equals(uf.find(edge.to))) {
				uf.union(edge.from, edge.to);
				mst.append(edge);
			}
		}
		return mst;
	}

}
