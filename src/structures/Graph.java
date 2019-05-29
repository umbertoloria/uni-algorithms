package structures;

public abstract class Graph<V, W extends Comparable<W>> {

	public abstract boolean exists(V node);

	public abstract void add(V node);

	public abstract List<V> nodes();

	public abstract List<Edge<V, W>> edges();

	public abstract boolean link(Edge<V, W> edge);

	public abstract List<Edge<V, W>> outgoings(V from);

	public List<List<V>> partitions() {
		List<List<V>> partitions = new LList<>();
		for (V node : nodes()) {
			boolean notYetSeen = true;
			for (List<V> partition : partitions) {
				if (partition.contains(node)) {
					notYetSeen = false;
					break;
				}
			}
			if (notYetSeen) {
				List<V> nuova = new LList<>();
				nuova.expand(conn(node, new AList<>()));
				partitions.append(nuova);
			}
		}
		return partitions;
	}

	private List<V> conn(V node, List<V> explored) {
		List<V> res = new AList<>();
		if (exists(node)) {
			res.append(node);
			for (Edge<V, W> outgoing : outgoings(node)) {
				if (!explored.contains(outgoing.to)) {
					List<V> exp2 = new AList<>();
					for (V v : explored) {
						exp2.append(v);
					}
					exp2.append(node);
					res.expand(conn(outgoing.to, exp2));
				}
			}
		}
		return res;
	}

}
