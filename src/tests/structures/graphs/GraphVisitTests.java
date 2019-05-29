package tests.structures.graphs;

import structures.Edge;
import structures.SimpleGraph;

public class GraphVisitTests {

	public static void main(String[] args) {
		SimpleGraph<Integer> g = new SimpleGraph<>();
		g.add(1);
		g.add(2);
		g.add(4);
		g.add(3);
		g.add(5);
		g.add(6);
		g.add(7);
		g.add(8);
		g.link(new Edge<>(1, 2));
		g.link(new Edge<>(1, 3));
		g.link(new Edge<>(2, 3));
		g.link(new Edge<>(2, 4));
		g.link(new Edge<>(2, 5));
		g.link(new Edge<>(3, 5));
		g.link(new Edge<>(3, 7));
		g.link(new Edge<>(3, 8));
		g.link(new Edge<>(4, 5));
		g.link(new Edge<>(5, 6));
		g.link(new Edge<>(7, 8));

		System.out.println("DFS");
		g.dfs(1);
		System.out.println();

		System.out.println("BFS");
		g.bfs(1);
		System.out.println();

		if (g.exists(8)) {
			System.out.println("8 node exists");
		}

		System.out.println("Outgoing from 7: " + g.outgoings(7));
		System.out.println("Incoming to 7: " + g.incomings(7));
		System.out.println("Nodes: " + g.nodes());

	}

}
