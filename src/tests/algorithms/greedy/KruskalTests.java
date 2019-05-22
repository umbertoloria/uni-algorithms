package tests.algorithms.greedy;

import algorithms.greedy.Kruskal;
import structures.Edge;
import structures.Set;
import structures.UndirectGraph;

public class KruskalTests {

	public static void main(String[] args) {
		UndirectGraph<Integer, Integer> g = new UndirectGraph<>();
		g.add(8);
		g.add(7);
		g.add(6);
		g.add(5);
		g.add(4);
		g.add(3);
		g.add(2);
		g.add(1);
		g.link(1, 2, 9);
		g.link(1, 6, 14);
		g.link(1, 7, 15);

		g.link(2, 3, 24);

		g.link(3, 4, 6);
		g.link(3, 5, 2);
		g.link(3, 6, 18);
		g.link(3, 8, 19);

		g.link(4, 5, 11);
		g.link(4, 8, 7);

		g.link(5, 6, 30);
		g.link(5, 7, 20);
		g.link(5, 8, 16);

		g.link(6, 7, 5);

		g.link(7, 8, 44);

		Set<Edge<Integer, Integer>> mst = Kruskal.mst(g, 1);
		for (Edge<Integer, Integer> edge : mst) {
			System.out.println(edge);
		}
	}

}
