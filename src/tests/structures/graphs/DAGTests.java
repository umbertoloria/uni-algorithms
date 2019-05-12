package tests.structures.graphs;

import structures.List;
import structures.SimpleDGraph;

public class DAGTests {

	public static void main(String[] args) {

		SimpleDGraph<Integer> g = new SimpleDGraph<>();

		g.add(1);
		g.add(2);
		g.add(3);
		g.add(4);
		g.add(5);
		g.add(6);
		g.add(7);

		g.link(1, 4);
		g.link(1, 5);
		g.link(1, 7);

		g.link(2, 3);
		g.link(2, 5);
		g.link(2, 6);

		g.link(3, 4);
		g.link(3, 5);

		g.link(4, 5);

		g.link(5, 6);
		g.link(5, 7);

		g.link(6, 7);

		List<List<Integer>> topologie = g.topologie();
		for (List<Integer> topologia : topologie) {
			System.out.println(topologia);
		}

	}

}
