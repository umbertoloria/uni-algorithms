package tests.structures.graphs;

import structures.Edge;
import structures.SimpleGraph;

public class GraphVisitTests {

	public static void main(String[] args) {
		SimpleGraph<Integer> g = new SimpleGraph<>();
		g.link(new Edge<>(1, 2, 1));
		g.link(new Edge<>(1, 3, 1));
		g.link(new Edge<>(2, 3, 1));
		g.link(new Edge<>(2, 4, 10));
		g.link(new Edge<>(2, 5, 1));
		g.link(new Edge<>(3, 5, 1));
		g.link(new Edge<>(3, 7, 1));
		g.link(new Edge<>(3, 8, 1));
		g.link(new Edge<>(4, 5, 1));
		g.link(new Edge<>(5, 6, 1));
		g.link(new Edge<>(7, 8, 1));

		System.out.println("Depth First Search");
		g.dfs(1).show();

		System.out.println("\nBreadth First Search");
		g.bfs(1).show();

		System.out.println("\nIncomings from 2: " + g.incomings(2));

	}

}
