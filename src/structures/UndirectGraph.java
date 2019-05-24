package structures;

public class UndirectGraph<T extends Comparable<T>, V extends Comparable<V>> extends DirectGraph<T, V> {

	public boolean link(T from, T to, V weight) {
		return super.link(from, to, weight) && super.link(to, from, weight);
	}

	public List<Edge<T, V>> edges() {
		List<Edge<T, V>> edges = super.edges();
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
