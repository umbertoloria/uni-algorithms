package structures;

public class SimpleDGraph<T extends Comparable<T>> {

	private DirectGraph<T, Object> graph = new DirectGraph<>();

	public boolean exists(T node) {
		return graph.exists(node);
	}

	public void add(T node) {
		graph.add(node);
	}

	public Set<T> nodes() {
		return graph.nodes();
	}

	public boolean linked(T a, T b) {
		return graph.linked(a, b);
	}

	public boolean link(T a, T b) {
		return graph.link(a, b, null);
	}

	public Set<T> outgoing(T a) {
		return graph.outgoing(a);
	}

	public Set<T> incoming(T a) {
		return graph.incoming(a);
	}

	public List<List<T>> topologie() {
		Set<T> uscentiEsclusivi = new Set<>();
		for (T node : graph.nodes()) {
			if (graph.incoming(node).empty()) {
				uscentiEsclusivi.add(node);
			}
		}
		List<List<T>> totalTopologies = new LList<>();
		for (T t : uscentiEsclusivi) {
			List<List<T>> partialTopologies = topologie(t, new LList<>());
			if (partialTopologies != null) {
				totalTopologies.expand(partialTopologies);
			}
		}
		return totalTopologies;
	}

	private List<List<T>> topologie(T nodo, List<T> visitati) {
		visitati.append(nodo);
		// Rimanenti
		Set<T> rimanenti = graph.nodes().remove(visitati);
		rimanenti.remove(nodo);
		// Nodi senza archi entranti
		Set<T> senzaEntranti = new Set<>();
		for (T node : rimanenti) {
			if (graph.incoming(node).remove(visitati).empty()) {
				senzaEntranti.add(node);
			}
		}
		List<List<T>> totalTopologies = new LList<>();
		if (senzaEntranti.empty()) {
			totalTopologies.append(visitati);
//			System.out.println(visitati);
		} else {
			for (T t : senzaEntranti) {
				List<T> tmpPath = new LList<>();
				for (T t1 : visitati) {
					tmpPath.append(t1);
				}
				List<List<T>> partialTopologies = topologie(t, tmpPath);
				if (partialTopologies != null) {
					totalTopologies.expand(partialTopologies);
				}
			}
		}
		return totalTopologies;
	}

}
