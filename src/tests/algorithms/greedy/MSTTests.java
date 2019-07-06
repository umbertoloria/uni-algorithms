package tests.algorithms.greedy;

import algorithms.greedy.Kruskal;
import algorithms.greedy.Prim;
import structures.Edge;
import structures.UndirectGraph;

public class MSTTests {

	private static UndirectGraph<Character, Integer> test1() {
		UndirectGraph<Character, Integer> g = new UndirectGraph<>();
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

	private static UndirectGraph<Integer, Integer> test3() {
		UndirectGraph<Integer, Integer> g = new UndirectGraph<>();
		g.link(new Edge<>(1, 2, 3));
		g.link(new Edge<>(1, 3, 4));
		g.link(new Edge<>(1, 4, 5));
		g.link(new Edge<>(2, 3, 5));
		g.link(new Edge<>(3, 4, 7));
		return g;
	}

	private static UndirectGraph<Integer, Integer> test4() {
		UndirectGraph<Integer, Integer> g = new UndirectGraph<>();
		g.link(new Edge<>(1, 2, 5));
		g.link(new Edge<>(1, 5, 3));
		g.link(new Edge<>(2, 3, 1));
		g.link(new Edge<>(2, 4, 9));
		g.link(new Edge<>(2, 6, 7));
		g.link(new Edge<>(3, 5, 6));
		g.link(new Edge<>(4, 2, 9));
		g.link(new Edge<>(4, 5, 2));
		g.link(new Edge<>(5, 6, 8));
		return g;
	}

	public static void main(String[] args) {
		manage(test1(), 's');
		manage(test2(), 1);
		manage(test3(), 1);
		manage(test4(), 1);
	}

	private static <T> void manage(UndirectGraph<T, Integer> graph, T s) {
		System.out.println("Algoritmo di Prim");
		Prim.mst(graph, s).show();
		System.out.println("\nAlgoritmo di Kruskal");
		Kruskal.mst(graph).show();
		System.out.println("\n");
	}

}
