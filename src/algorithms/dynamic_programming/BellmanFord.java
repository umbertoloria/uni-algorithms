package algorithms.dynamic_programming;

import structures.*;

///////////////////////////////////////////////////////////////////////////////////////////
//    Algoritmo di Bellman-Ford                                                          //
///////////////////////////////////////////////////////////////////////////////////////////
//                                                                                       //
//    SP(i, v) = {                                                                       //
//                    0,                                            if v = t             //
//                    infinito,                                     if i = 0 ^ v != t    //
//                    min {                                                              //
//                             SP(i-1, v),                          if i > 0 ^ v != t    //
//                             min {                                                     //
//                                      SP(i-1, w) + c(v, w)        if (v, w) exists     //
//                             }                                                         //
//                    }                                                                  //
//    }                                                                                  //
//                                                                                       //
///////////////////////////////////////////////////////////////////////////////////////////

public class BellmanFord {

	private static class InfoBox<V> {

		final int distance;
		final Edge<V, Integer> prev;

		InfoBox(int distance, Edge<V, Integer> prev) {
			this.distance = distance;
			this.prev = prev;
		}

	}

	/** Complexity: time O(mn) and space O(n^2) */
	@SuppressWarnings("unchecked")
	public static <V> List<Edge<V, Integer>> shortestPath(Graph<V, Integer> g, V partenza, V destinazione) {
		List<V> nodes = g.nodes();
		int n = nodes.size();
		HashTable<V, InfoBox<V>>[] m = new HashTable[n];
		for (int i = 0; i < m.length; i++) {
			m[i] = new HashTable<>();
		}

		for (V v : nodes) {
			m[0].put(v, new InfoBox<>(Integer.MAX_VALUE, null));
		}
		m[0].put(destinazione, new InfoBox<>(0, null));

		for (int i = 1; i < n; i++) {
			for (V v : nodes) {

				int val = 0;
				Edge<V, Integer> last = null;

				if (!v.equals(destinazione)) {

					val = m[i - 1].get(v).distance;

					for (Edge<V, Integer> edge : g.outgoings(v)) {
						int prevDistance = m[i - 1].get(edge.to).distance;
						if (prevDistance < Integer.MAX_VALUE && val > prevDistance + edge.weight) {
							last = edge;
							val = prevDistance + edge.weight;
						}
					}

				}

				m[i].put(v, new InfoBox<>(val, last));
			}
		}

		V app = partenza;
		List<Edge<V, Integer>> soluzione = new LList<>();
		for (int i = n - 1; i > 0; i--) {
			Edge<V, Integer> rec = m[i].get(app).prev;
			if (rec != null) {
				soluzione.append(m[i].get(app).prev);
				app = m[i].get(app).prev.to;
			}
		}
		return soluzione;
	}

}
