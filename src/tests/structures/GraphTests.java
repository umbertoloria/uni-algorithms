package tests.structures;

import structures.UndirectGraph;

public class GraphTests {

	public static void main(String[] args) {

		var g = new UndirectGraph<Integer, Integer>();

		g.add(1);
		g.add(2);
		g.add(3);
		g.add(4);
		g.add(5);
		g.add(6);
		g.add(7);
		g.add(8);

		g.link(1, 2, 0);
		g.link(1, 3, 0);

		g.link(2, 3, 0);
		g.link(2, 4, 0);
		g.link(2, 5, 0);

		g.link(3, 5, 0);
		g.link(3, 7, 0);
		g.link(3, 8, 0);

		g.link(4, 5, 0);

		g.link(5, 6, 0);

		g.link(7, 8, 0);

		g.dfs(1);
		System.out.println();

		g.bfs(1);
		System.out.println();

		if (g.exists(8)) {
			System.out.println("8 node exists");
		}

		if (g.linked(5, 6)) {
			System.out.println("5-6 link exists");
		}

		System.out.print("Adjacent with 7:");
		for (Integer adjacent : g.adjacents(7)) {
			System.out.print(" " + adjacent);
		}

	}

}
