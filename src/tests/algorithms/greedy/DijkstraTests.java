package tests.algorithms.greedy;

import algorithms.greedy.Dijkstra;
import structures.DirectGraph;
import structures.Edge;

public class DijkstraTests {

	private static DirectGraph<Integer, Integer> test1() {
		DirectGraph<Integer, Integer> g = new DirectGraph<>();
		g.add(1);
		g.add(2);
		g.add(3);
		g.add(5);
		g.add(4);
		g.add(6);
		g.add(7);
		g.add(8);
		g.link(1, 2, 9);
		g.link(1, 6, 14);
		g.link(1, 7, 15);
		g.link(2, 3, 24);
		g.link(3, 5, 2);
		g.link(3, 8, 19);
		g.link(4, 3, 6);
		g.link(4, 8, 6);
		g.link(5, 4, 11);
		g.link(5, 8, 16);
		g.link(6, 3, 18);
		g.link(6, 5, 30);
		g.link(6, 7, 5);
		g.link(7, 5, 20);
		g.link(7, 8, 44);
		return g;
	}

	public static void main(String[] args) {
		System.out.println("TEST 1");
		for (Edge<Integer, Integer> path : Dijkstra.shortestPath(test1(), 1, 8)) {
			System.out.println(path);
		}
		System.out.println();
	}

}
