package structures;

public abstract class Graph<V, W extends Comparable<W>> {

	public abstract boolean contains(V node);

	public abstract void add(V node);

	public abstract List<V> nodes();

	public abstract List<Edge<V, W>> edges();

	public abstract void link(Edge<V, W> edge);

	public abstract List<Edge<V, W>> outgoings(V from);

	public List<Edge<V, Integer>> incomings(V to) {
		List<Edge<V, Integer>> result = new LList<>();
		if (contains(to)) {
			for (V from : nodes().except(to)) {
				if (outgoings(from).contains(new Edge<>(from, to))) {
					result.append(new Edge<>(from, to));
				}
			}
		}
		return result;
	}

	private class InfoNode {
		private final V from, to;
		private final W weight;

		InfoNode(V from, V to, W weight) {
			this.from = from;
			this.to = to;
			this.weight = weight;
		}

	}

	public AlberoRadicato<V, W> dfs(V node) {
		AlberoRadicato<V, W> albero = new AlberoRadicato<>();
		if (contains(node)) {
			HashSet<V> explored = new HashSet<>();
			Stack<InfoNode> pila = new Stack<>(new InfoNode(null, node, null));
			while (!pila.empty()) {
				InfoNode stick = pila.pop();
				V parent = stick.from;
				V u = stick.to;
				W w = stick.weight;
				if (explored.thisIsNew(u)) {
					if (parent == null) {
						albero.addRoot(u);
					} else {
						albero.addChild(parent, u, w);
					}
					for (Edge<V, W> edge : outgoings(u).justReverse()) {
						pila.push(new InfoNode(edge.from, edge.to, edge.weight));
					}
				}
			}
		}
		return albero;
	}

	public AlberoRadicato<V, W> bfs(V node) {
		AlberoRadicato<V, W> albero = new AlberoRadicato<>();
		if (contains(node)) {

			// Coda di appoggio per servire gli elementi (conterrà inizialmente l'elemento di partenza).
			Queue<InfoNode> coda = new Queue<>();
			coda.push(new InfoNode(null, node, null));

			// Lista che permette di evitare di servire un elemento già "scoperto".
			LList<V> discovered = new LList<>();
			discovered.append(node);

			while (!coda.empty()) {

				// Prelevo il prossimo nodo 'u' servire.
				InfoNode pair = coda.pop();
				V parent = pair.from;
				V u = pair.to;
				W w = pair.weight;

				// Lo aggiungo al livello corrente.
				if (parent == null) {
					albero.addRoot(u);
				} else {
					albero.addChild(parent, u, w);
				}

				// Accodo tutti i nodi 'v' adiacenti ad 'u' se non ancora visitati.
				for (Edge<V, W> edge : outgoings(u)) {
					if (!discovered.contains(edge.to)) {
						discovered.append(edge.to);
						coda.push(new InfoNode(edge.from, edge.to, edge.weight));
					}
				}

			}

		}
		return albero;
	}

}
