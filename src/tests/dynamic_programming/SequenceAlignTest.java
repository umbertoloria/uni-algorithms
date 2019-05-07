package tests.dynamic_programming;

import algorithms.dynamic_programming.SequenceAlign;

public class SequenceAlignTest {

	public static void main(String[] args) {
		SequenceAlign s1 = new SequenceAlign(2, 1, 1, 3);
		System.out.println("Distanza: " + s1.distance("mean", "name"));
		s1.printTable();
		s1.analisi();
		System.out.println();

		SequenceAlign s2 = new SequenceAlign(5, 3, 4, 7);
		System.out.println("Distanza: " + s2.distance("mamma", "mia"));
		s2.printTable();
		s2.analisi();
		System.out.println();

		SequenceAlign s3 = new SequenceAlign(5, 3, 4, 7);
		System.out.println("Distanza: " + s3.distance("eiao", "aiao"));
		s3.printTable();
		s3.analisi();
	}

}
