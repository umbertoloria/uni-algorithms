package structures;

public final class Edge<V, W extends Comparable<W>> implements Comparable<Edge<V, W>> {

	public final V from, to;
	public final W weight;

	public Edge(V from, V to) {
		this(from, to, null);
	}

	public Edge(V from, V to, W weight) {
		if (from.equals(to)) {
			throw new IllegalStateException();
		}
		this.from = from;
		this.to = to;
		this.weight = weight;
	}

	public int compareTo(Edge<V, W> o) {
		return weight.compareTo(o.weight);
	}

	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Edge<?, ?> edge = (Edge<?, ?>) o;
		return from.equals(edge.from) && to.equals(edge.to);
	}

	public String toString() {
		return "(" + from + ", " + to + (weight == null ? "" : ", w=" + weight) + ")";
	}

}
