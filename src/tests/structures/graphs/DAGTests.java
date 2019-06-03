package tests.structures.graphs;

import structures.Edge;
import structures.List;
import structures.SimpleGraph;

public class DAGTests {

	public static void main(String[] args) {
		SimpleGraph<Integer> g1 = new SimpleGraph<>();
		g1.add(1);
		g1.add(2);
		g1.add(3);
		g1.add(4);
		g1.add(5);
		g1.add(6);
		g1.add(7);
		g1.link(new Edge<>(1, 4));
		g1.link(new Edge<>(1, 5));
		g1.link(new Edge<>(1, 7));
		g1.link(new Edge<>(2, 3));
		g1.link(new Edge<>(2, 5));
		g1.link(new Edge<>(2, 6));
		g1.link(new Edge<>(3, 4));
		g1.link(new Edge<>(3, 5));
		g1.link(new Edge<>(4, 5));
		g1.link(new Edge<>(5, 6));
		g1.link(new Edge<>(5, 7));
		g1.link(new Edge<>(6, 7));
		System.out.println("Primo grafo (3)");
		for (List<Integer> topologia : g1.topologie()) {
			System.out.println(topologia);
		}
		System.out.println();
		SimpleGraph<Character> g2 = new SimpleGraph<>();
		g2.add('a');
		g2.add('b');
		g2.add('c');
		g2.add('e');
		g2.add('d');
		g2.link(new Edge<>('a', 'b'));
		g2.link(new Edge<>('a', 'c'));
		g2.link(new Edge<>('c', 'd'));
		g2.link(new Edge<>('d', 'e'));
		g2.link(new Edge<>('e', 'b'));
		System.out.println("Secondo grafo (1)");
		for (List<Character> topologia : g2.topologie()) {
			System.out.println(topologia);
		}
		System.out.println();
		SimpleGraph<Character> g3 = new SimpleGraph<>();
		g3.add('b');
		g3.add('a');
		g3.add('c');
		g3.add('d');
		g3.add('e');
		g3.link(new Edge<>('a', 'c'));
		g3.link(new Edge<>('a', 'b'));
		g3.link(new Edge<>('b', 'e'));
		g3.link(new Edge<>('c', 'd'));
		g3.link(new Edge<>('d', 'e'));
		System.out.println("Terzo grafo (3)");
		for (List<Character> topologia : g3.topologie()) {
			System.out.println(topologia);
		}
		System.out.println();
		SimpleGraph<Character> g4 = new SimpleGraph<>();
		g4.add('a');
		g4.add('b');
		g4.add('c');
		g4.add('d');
		g4.add('e');
		g4.add('f');
		g4.link(new Edge<>('a', 'b'));
		g4.link(new Edge<>('a', 'd'));
		g4.link(new Edge<>('b', 'c'));
		g4.link(new Edge<>('c', 'f'));
		g4.link(new Edge<>('d', 'e'));
		g4.link(new Edge<>('e', 'f'));
		System.out.println("Quarto grafo (6)");
		for (List<Character> topologia : g4.topologie()) {
			System.out.println(topologia);
		}
		System.out.println();
		SimpleGraph<Character> g5 = new SimpleGraph<>();
		g5.add('u');
		g5.add('v');
		g5.add('x');
		g5.add('y');
		g5.add('z');
		g5.link(new Edge<>('u', 'v'));
		g5.link(new Edge<>('v', 'y'));
		g5.link(new Edge<>('x', 'y'));
		g5.link(new Edge<>('v', 'x'));
		g5.link(new Edge<>('z', 'x'));
		g5.link(new Edge<>('z', 'u'));
		System.out.println("Quinto grafo (1)");
		for (List<Character> topologia : g5.topologie()) {
			System.out.println(topologia);
		}
	}

}
