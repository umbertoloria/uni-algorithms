package tests.algorithms.dynamic_programming;

import algorithms.dynamic_programming.BellmanFord;
import structures.DirectGraph;
import structures.Edge;
import structures.Graph;
import tests.algorithms.greedy.DijkstraTests;

public class BellmanFordTests {

	private static DirectGraph<Character, Integer> test3() {
		DirectGraph<Character, Integer> g = new DirectGraph<>();
		g.link(new Edge<>('a', 'b', -4));
		g.link(new Edge<>('a', 't', -3));
		g.link(new Edge<>('b', 'd', -1));
		g.link(new Edge<>('b', 'e', -2));
		g.link(new Edge<>('c', 'b', 8));
		g.link(new Edge<>('c', 't', 3));
		g.link(new Edge<>('d', 'a', 6));
		g.link(new Edge<>('d', 't', 4));
		g.link(new Edge<>('e', 'c', -3));
		g.link(new Edge<>('e', 't', 2));
		return g;
	}

	public static void main(String[] args) {
		System.out.println("TEST 1");
		show(DijkstraTests.test1(), 1, 8);
		System.out.println("TEST 2");
		show(DijkstraTests.test2(), 'S', 'E');
		System.out.println("TEST 3");
		show(test3(), 'a', 't');
	}

	private static <T> void show(Graph<T, Integer> g, T s, T t) {
		for (Edge<T, Integer> path : BellmanFord.shortestPath(g, s, t)) {
			System.out.println(path);
		}
		System.out.println();
	}

}
