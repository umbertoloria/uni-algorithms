package algorithms;

import algorithms.greedy.Kruskal;
import structures.Edge;
import structures.List;
import structures.UndirectGraph;

public class KClustering {

	public static <V, W extends Comparable<W>> List<UndirectGraph<V, W>> cluster(UndirectGraph<V, W> graph, int k) {
		assert k > 0 && k <= graph.nodes().size();
		List<Edge<V, W>> mst = Kruskal.mst(graph).edges();
		while (k > 1) {
			mst.remove(getMaxIndex(mst));
			k--;
		}
		UndirectGraph<V, W> result = new UndirectGraph<>();
		for (V node : graph.nodes()) {
			result.add(node);
		}
		for (Edge<V, W> edge : mst) {
			result.link(edge);
		}
		return result.componentiConnesse();
	}

	private static <V, W extends Comparable<W>> int getMaxIndex(List<Edge<V, W>> mst) {
		int del = 0;
		int i = 0;
		W maxWeight = mst.get(0).weight;
		for (Edge<V, W> edge : mst) {
			if (edge.weight.compareTo(maxWeight) > 0) {
				maxWeight = edge.weight;
				del = i;
			}
			i++;
		}
		return del;
	}

}
