package tests.algorithms.greedy;

import algorithms.greedy.Dijkstra;
import structures.DirectGraph;
import structures.Edge;
import structures.Graph;
import structures.UndirectGraph;

public class DijkstraTests {

	public static DirectGraph<Integer, Integer> test1() {
		DirectGraph<Integer, Integer> g = new DirectGraph<>();
		g.link(new Edge<>(1, 2, 9));
		g.link(new Edge<>(1, 6, 14));
		g.link(new Edge<>(1, 7, 15));
		g.link(new Edge<>(2, 3, 24));
		g.link(new Edge<>(3, 5, 2));
		g.link(new Edge<>(3, 8, 19));
		g.link(new Edge<>(4, 3, 6));
		g.link(new Edge<>(4, 8, 6));
		g.link(new Edge<>(5, 4, 11));
		g.link(new Edge<>(5, 8, 16));
		g.link(new Edge<>(6, 3, 18));
		g.link(new Edge<>(6, 5, 30));
		g.link(new Edge<>(6, 7, 5));
		g.link(new Edge<>(7, 5, 20));
		g.link(new Edge<>(7, 8, 44));
		return g;
	}

	public static UndirectGraph<Character, Integer> test2() {
		UndirectGraph<Character, Integer> g = new UndirectGraph<>();
		g.link(new Edge<>('S', 'A', 7));
		g.link(new Edge<>('S', 'B', 1));
		g.link(new Edge<>('A', 'B', 3));
		g.link(new Edge<>('A', 'D', 4));
		g.link(new Edge<>('B', 'D', 4));
		g.link(new Edge<>('B', 'H', 2));
		g.link(new Edge<>('D', 'G', 6));
		g.link(new Edge<>('G', 'H', 4));
		g.link(new Edge<>('H', 'F', 2));
		g.link(new Edge<>('F', 'E', 2));
		g.link(new Edge<>('E', 'J', 2));
		g.link(new Edge<>('J', 'L', 2));
		g.link(new Edge<>('L', 'I', 5));
		g.link(new Edge<>('J', 'I', 5));
		g.link(new Edge<>('I', 'C', 2));
		g.link(new Edge<>('C', 'S', 3));
		return g;
	}

	public static void main(String[] args) {
		System.out.println("TEST 1");
		show(test1(), 1, 8);
		System.out.println("TEST 2");
		show(test2(), 'S', 'E');
	}

	private static <T> void show(Graph<T, Integer> g, T s, T t) {
		for (Edge<T, Integer> path : Dijkstra.shortestPath(g, s, t)) {
			System.out.println(path);
		}
		System.out.println();
	}

}
