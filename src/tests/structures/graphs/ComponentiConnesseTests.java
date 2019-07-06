package tests.structures.graphs;

import structures.Edge;
import structures.UndirectGraph;

public class ComponentiConnesseTests {

	public static void main(String[] args) {
		UndirectGraph<String, Integer> g = new UndirectGraph<>();
		g.add("Campania");
		g.add("Puglia");
		g.add("Lombardia");
		g.add("Veneto");
		g.add("Toscana");
		g.add("Umbria");
		g.link(new Edge<>("Campania", "Puglia"));
		g.link(new Edge<>("Lombardia", "Veneto"));
		g.link(new Edge<>("Toscana", "Umbria"));
		int i = 1;
		for (UndirectGraph<String, Integer> cc : g.componentiConnesse()) {
			System.out.println("COMPONENTE CONNESSA " + i++);
			for (String node : cc.nodes()) {
				System.out.println(node);
			}
		}
		System.out.println("FINE COMPONENTI CONNESSE");
		if (g.componenteConnessa("Campania").contains("Puglia")) {
			System.out.println("Campania e Puglia sono limitrofe");
		}
	}

}
