package tests.structures;

import structures.Graph;

public class GraphTests {

	public static void main(String[] args) {

		Graph<Integer> g = new Graph<>();

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

		g.dfs(1);
		System.out.println();

		g.bfs(1);
		System.out.println();

	}

}
