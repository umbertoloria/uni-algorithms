package tests;

import algorithms.dynamic_programming.Mattonelle;

public class MattonelleTests {

	public static void main(String[] args) {
		Mattonelle a = new Mattonelle();
		a.add(7);
		a.add(10);
		a.add(2);
		for (int i = 1; i <= 50; i++) {
			System.out.println("n " + i + ": " + a.copri(i));
		}
	}

}
