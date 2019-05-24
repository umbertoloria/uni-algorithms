package tests.algorithms.greedy;

import algorithms.greedy.Dijkstra;
import structures.DirectGraph;
import structures.Edge;
import structures.UndirectGraph;

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

	private static UndirectGraph<Character, Integer> test2() {
		UndirectGraph<Character, Integer> g = new UndirectGraph<>();
		g.add('S');
		g.add('A');
		g.add('B');
		g.add('D');
		g.add('G');
		g.add('H');
		g.add('F');
		g.add('E');
		g.add('L');
		g.add('J');
		g.add('I');
		g.add('C');
		g.link('S', 'A', 7);
		g.link('S', 'B', 1);
		g.link('A', 'B', 3);
		g.link('A', 'D', 4);
		g.link('B', 'D', 4);
		g.link('B', 'H', 2);
		g.link('D', 'G', 6);
		g.link('G', 'H', 4);
		g.link('H', 'F', 2);
		g.link('F', 'E', 2);
		g.link('E', 'J', 2);
		g.link('J', 'L', 2);
		g.link('L', 'I', 5);
		g.link('J', 'I', 5);
		g.link('I', 'C', 2);
		g.link('C', 'S', 3);
		return g;
	}

	public static void main(String[] args) {
		System.out.println("TEST 1");
		show(test1(), 1, 8);
		System.out.println("TEST 2");
		show(test2(), 'S', 'E');
	}

	private static <T extends Comparable<T>> void show(DirectGraph<T, Integer> g, T s, T t) {
		for (Edge path : Dijkstra.shortestPath(g, s, t)) {
			System.out.println(path);
		}
		System.out.println();
	}

}
