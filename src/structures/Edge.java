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

	public String toString() {
		if (weight == null) {
			return String.format("%-2s -----------> %2s", from, to);
		} else {
			String we = (weight + "");
			if (we.length() > 3) {
				we = we.substring(0, 3);
			}
			return String.format("%-2s ---( %-3s)--> %2s", from, we, to);
		}
	}

}
