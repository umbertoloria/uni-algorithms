package tests.algorithms.dynamic_programming;

import algorithms.dynamic_programming.BellmanFord;
import structures.DirectGraph;
import structures.Edge;
import tests.algorithms.greedy.DijkstraTests;

public class BellmanFordTests {

	private static DirectGraph<Character, Integer> test3() {
		DirectGraph<Character, Integer> g = new DirectGraph<>();
		g.add('a');
		g.add('b');
		g.add('c');
		g.add('d');
		g.add('e');
		g.add('t');
		g.link('a', 'b', -4);
		g.link('a', 't', -3);
		g.link('b', 'd', -1);
		g.link('b', 'e', -2);
		g.link('c', 'b', 8);
		g.link('c', 't', 3);
		g.link('d', 'a', 6);
		g.link('d', 't', 4);
		g.link('e', 'c', -3);
		g.link('e', 't', 2);
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

	private static <T> void show(DirectGraph<T, Integer> g, T s, T t) {
		for (Edge<T, Integer> path : BellmanFord.shortestPath(g, s, t)) {
			System.out.println(path);
		}
		System.out.println();
	}

}
