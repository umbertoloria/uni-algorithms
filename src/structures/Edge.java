package structures;

public final class Edge<V, W extends Comparable<W>> implements Comparable<Edge<V, W>> {

	public final V from, to;
	public final W weight;

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

	public String toString() {
		String res = String.format("%-2s", from);
		res += " -----( ";
		res += String.format("%-2s", weight);
		res += " )----> ";
		res += String.format("%2s", to);
		return res;
	}

}
