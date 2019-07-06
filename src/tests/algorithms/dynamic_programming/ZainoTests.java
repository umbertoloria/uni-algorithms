package tests.algorithms.dynamic_programming;

import algorithms.dynamic_programming.zaino.Oggetto;
import algorithms.dynamic_programming.zaino.Zaino;

public class ZainoTests {

	public static void main(String[] args) {
		Zaino z1 = new Zaino();
		z1.add(new Oggetto("Lampadina LED", 22, 6));
		z1.add(new Oggetto("Fumetto", 6, 2));
		z1.add(new Oggetto("Scacchiera", 28, 7));
		z1.add(new Oggetto("Braccialetto", 18, 5));
		z1.add(new Oggetto("Portachiavi", 1, 1));
		System.out.println("Valore massimo: " + z1.ruba(11));
		z1.printTable();
		Oggetto[] oggetti = z1.analisi();
		for (Oggetto oggetto : oggetti) {
			System.out.println(oggetto.name + " di valore " + oggetto.value + " e di peso " + oggetto.weight);
		}
		System.out.println();

		Zaino z2 = new Zaino();
		z2.add(new Oggetto("1", 12, 5));
		z2.add(new Oggetto("2", 23, 2));
		z2.add(new Oggetto("3", 14, 8));
		z2.add(new Oggetto("4", 15, 7));
		z2.add(new Oggetto("5", 18, 9));
		System.out.println("Valore massimo: " + z2.ruba(16));
		oggetti = z2.analisi();
		z2.printTable();
		for (Oggetto oggetto : oggetti) {
			System.out.println(oggetto.name + " di valore " + oggetto.value + " e di peso " + oggetto.weight);
		}
		System.out.println();

		Zaino z3 = new Zaino();
		z3.add(new Oggetto("1", 1, 1));
		z3.add(new Oggetto("2", 4, 3));
		z3.add(new Oggetto("3", 5, 4));
		z3.add(new Oggetto("4", 7, 2));
		z3.add(new Oggetto("5", 3, 5));
		z3.add(new Oggetto("6", 4, 2));
		System.out.println("Valore massimo: " + z3.ruba(8));
		oggetti = z3.analisi();
		z3.printTable();
		for (Oggetto oggetto : oggetti) {
			System.out.println(oggetto.name + " di valore " + oggetto.value + " e di peso " + oggetto.weight);
		}
	}

}
