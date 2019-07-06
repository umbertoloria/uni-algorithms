package algorithms.greedy;

import structures.*;

public class Kruskal {

	/** Complexity: time O(m log n) */
	public static <V, W extends Comparable<W>> AlberoLibero<V, W> mst(UndirectGraph<V, W> g) {
		UnionFind<V> uf = new UnionFind<>();
		for (V node : g.nodes()) {
			uf.addSet(node);
		}
		AlberoLibero<V, W> mst = new AlberoLibero<>();

		List<Edge<V, W>> edges = g.edges();
		List.sort(edges);

		for (Edge<V, W> edge : edges) {
			if (!uf.find(edge.from).equals(uf.find(edge.to))) {
				uf.union(edge.from, edge.to);
				mst.link(edge.from, edge.to, edge.weight);
			}
		}
		return mst;
	}

}
