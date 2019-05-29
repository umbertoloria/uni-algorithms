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
		g.link(new Edge<>('s', 'b', 4));
		g.link(new Edge<>('s', 'h', 8));
		g.link(new Edge<>('b', 'c', 8));
		g.link(new Edge<>('b', 'h', 11));
		g.link(new Edge<>('c', 'd', 7));
		g.link(new Edge<>('c', 'f', 4));
		g.link(new Edge<>('c', 'h', 6));
		g.link(new Edge<>('d', 'f', 14));
		g.link(new Edge<>('d', 'e', 9));
		g.link(new Edge<>('e', 'f', 10));
		g.link(new Edge<>('f', 'g', 2));
		g.link(new Edge<>('g', 'h', 1));
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
		g.link(new Edge<>(1, 2, 9));
		g.link(new Edge<>(1, 7, 15));
		g.link(new Edge<>(1, 6, 14));
		g.link(new Edge<>(2, 3, 24));
		g.link(new Edge<>(3, 4, 6));
		g.link(new Edge<>(3, 5, 2));
		g.link(new Edge<>(3, 6, 18));
		g.link(new Edge<>(3, 8, 19));
		g.link(new Edge<>(4, 5, 11));
		g.link(new Edge<>(4, 8, 7));
		g.link(new Edge<>(5, 6, 30));
		g.link(new Edge<>(5, 7, 20));
		g.link(new Edge<>(5, 8, 16));
		g.link(new Edge<>(6, 7, 5));
		g.link(new Edge<>(7, 8, 44));
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
		for (Edge<T, Integer> edge : Kruskal.mst(graph)) {
			System.out.println(edge);
			weight += edge.weight;
		}
		System.out.println("Final weight: " + weight);
		System.out.println();
		System.out.println();
	}

}
