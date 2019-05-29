package structures;

public class UndirectGraph<V, W extends Comparable<W>> extends DirectGraph<V, W> {

	public boolean link(Edge<V, W> edge) {
		return super.link(edge) && super.link(new Edge<>(edge.to, edge.from, edge.weight));
	}

	public List<Edge<V, W>> edges() {
		List<Edge<V, W>> edges = super.edges();
		for (int i = 0; i < edges.size(); i++) {
			for (int j = 1; j < edges.size(); j++) {
				if (edges.get(j).from.equals(edges.get(i).to) && edges.get(j).to.equals(edges.get(i).from)) {
					edges.remove(j);
					j--;
				}
			}
		}
		return edges;
	}

}
