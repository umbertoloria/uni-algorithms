package tests.structures.graphs;

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
		g1.link(1, 4);
		g1.link(1, 5);
		g1.link(1, 7);
		g1.link(2, 3);
		g1.link(2, 5);
		g1.link(2, 6);
		g1.link(3, 4);
		g1.link(3, 5);
		g1.link(4, 5);
		g1.link(5, 6);
		g1.link(5, 7);
		g1.link(6, 7);
		System.out.println("Primo grafo (3)");
		for (List<Integer> topologia : g1.topologie()) {
			System.out.println(topologia);
		}
		System.out.println();
		SimpleGraph<Character> g2 = new SimpleGraph<>();
		g2.add('a');
		g2.add('b');
		g2.add('c');
		g2.add('d');
		g2.add('e');
		g2.link('a', 'b');
		g2.link('a', 'c');
		g2.link('e', 'b');
		g2.link('c', 'd');
		g2.link('d', 'e');
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
		g3.link('a', 'b');
		g3.link('a', 'c');
		g3.link('b', 'e');
		g3.link('c', 'd');
		g3.link('d', 'e');
		System.out.println("Terzo grafo (3)");
		for (List<Character> topologia : g3.topologie()) {
			System.out.println(topologia);
		}
		System.out.println();
		SimpleGraph<Character> g4 = new SimpleGraph<>();
		g4.add('a');
		g4.add('b');
		g4.add('c');
		g4.add('e');
		g4.add('d');
		g4.add('f');
		g4.link('a', 'b');
		g4.link('b', 'c');
		g4.link('c', 'f');
		g4.link('a', 'd');
		g4.link('d', 'e');
		g4.link('e', 'f');
		System.out.println("Quarto grafo (6)");
		for (List<Character> topologia : g4.topologie()) {
			System.out.println(topologia);
		}
	}

}
