package tests.algorithms.greedy;

import algorithms.greedy.Kruskal;
import algorithms.greedy.Prim;
import structures.Edge;
import structures.UndirectGraph;

public class MSTTests {

	private static UndirectGraph<Character, Integer> test1() {
		UndirectGraph<Character, Integer> g = new UndirectGraph<>();
		g.add('s');
		g.add('b');
		g.add('c');
		g.add('d');
		g.add('e');
		g.add('f');
		g.add('g');
		g.add('h');
		g.link('s', 'b', 4);
		g.link('s', 'h', 8);
		g.link('b', 'c', 8);
		g.link('b', 'h', 11);
		g.link('c', 'd', 7);
		g.link('c', 'f', 4);
		g.link('c', 'h', 6);
		g.link('d', 'f', 14);
		g.link('d', 'e', 9);
		g.link('e', 'f', 10);
		g.link('f', 'g', 2);
		g.link('g', 'h', 1);
		return g;
	}

	private static UndirectGraph<Integer, Integer> test2() {
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
		return g;
	}

	public static void main(String[] args) {
		manage(test1(), 's');
		manage(test2(), 1);
	}

	private static <T> void manage(UndirectGraph<T, Integer> graph, T s) {
		int weight = 0;
		System.out.println("Algoritmo di Prim");
		for (Edge<T, Integer> edge : Prim.mst(graph, s)) {
			System.out.println(edge);
			weight += edge.weight;
		}
		System.out.println("Final weight: " + weight);
		System.out.println();
		weight = 0;
		System.out.println("Algoritmo di Kruskal");
		for (Edge<T, Integer> edge : Kruskal.mst(graph, s)) {
			System.out.println(edge);
			weight += edge.weight;
		}
		System.out.println("Final weight: " + weight);
		System.out.println();
		System.out.println();
	}

}
