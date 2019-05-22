package algorithms.greedy;

import structures.Edge;
import structures.Set;
import structures.UndirectGraph;
import structures.UnionFind;

public class Kruskal {

	public static <V extends Comparable<V>, W extends Comparable<W>> Set<Edge<V, W>> mst(UndirectGraph<V, W> g, V s) {
		assert g.exists(s);
		UnionFind<V> uf = new UnionFind<>();
		for (V node : g.nodes()) {
			uf.addSet(node);
		}
		Set<Edge<V, W>> mst = new Set<>();
		for (Edge<V, W> edge : g.edges()) {
			if (!uf.find(edge.from).equals(uf.find(edge.to))) {
				uf.union(edge.from, edge.to);
				mst.add(edge);
			}
		}
		return mst;
	}

}
