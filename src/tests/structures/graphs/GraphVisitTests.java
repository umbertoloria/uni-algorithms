package tests.structures.graphs;

import structures.SimpleGraph;

public class GraphVisitTests {

	public static void main(String[] args) {
		var g = new SimpleGraph<Integer>();
		g.add(1);
		g.add(2);
		g.add(3);
		g.add(4);
		g.add(5);
		g.add(6);
		g.add(7);
		g.add(8);
		g.link(1, 2);
		g.link(1, 3);
		g.link(2, 3);
		g.link(2, 4);
		g.link(2, 5);
		g.link(3, 5);
		g.link(3, 7);
		g.link(3, 8);
		g.link(4, 5);
		g.link(5, 6);
		g.link(7, 8);

		System.out.println("DFS");
		g.dfs(1);
		System.out.println();

		System.out.println("BFS");
		g.bfs(1);
		System.out.println();

		if (g.exists(8)) {
			System.out.println("8 node exists");
		}

		if (g.linked(5, 6)) {
			System.out.println("5-6 link exists");
		}

		System.out.println("Outgoing from 7: " + g.outgoing(7));
		System.out.println("Incoming to 7: " + g.incoming(7));
		System.out.println("Nodes: " + g.nodes());

	}

}
