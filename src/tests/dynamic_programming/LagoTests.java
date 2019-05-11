package tests.dynamic_programming;

import algorithms.dynamic_programming.lago.Lago;
import algorithms.dynamic_programming.lago.Viaggio;

public class LagoTests {

	public static void main(String[] args) {
		Lago l = new Lago();
		l.viaggio(new Viaggio(0, 1, 1));
		l.viaggio(new Viaggio(0, 2, 2));
		l.viaggio(new Viaggio(0, 3, 4));
		l.viaggio(new Viaggio(1, 2, 1));
		l.viaggio(new Viaggio(1, 3, 1));
		l.viaggio(new Viaggio(2, 3, 1));
		System.out.println("Prezzo minimo: " + l.vai(3));
	}

}
