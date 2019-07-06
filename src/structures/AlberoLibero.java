package structures;

public class AlberoLibero<V, W extends Comparable<W>> {

	private UndirectGraph<V, W> g = new UndirectGraph<>();

	public void link(V from, V to, W weight) {
		if (!g.contains(from) || !g.contains(to) || !g.componenteConnessa(from).contains(to)) {
			g.link(new Edge<>(from, to, weight));
		} else {
			throw new IllegalStateException("Collegare " + from + " con " + to + " creerebbe un ciclo");
		}
	}

	public List<Edge<V, W>> edges() {
		return g.edges();
	}

	public void show() {
		for (Edge<V, W> edge : g.edges()) {
			System.out.println(edge);
		}
	}

}
