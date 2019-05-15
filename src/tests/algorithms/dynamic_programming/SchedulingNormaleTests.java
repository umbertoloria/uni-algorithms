package tests.algorithms.dynamic_programming;

import algorithms.dynamic_programming.Intervallo;
import algorithms.dynamic_programming.SchedulingNormale;

public class SchedulingNormaleTests {

	public static void main(String[] args) {
		SchedulingNormale sc = new SchedulingNormale();
		sc.add(new Intervallo("B", 1, 4));
		sc.add(new Intervallo("C", 3, 5));
		sc.add(new Intervallo("A", 0, 6));
		sc.add(new Intervallo("E", 4, 7));
		sc.add(new Intervallo("D", 3, 8));
		sc.add(new Intervallo("F", 6, 9));
		sc.add(new Intervallo("G", 6, 10));
		sc.add(new Intervallo("H", 8, 11));
		Intervallo[] soluzione = sc.trovaSoluzione();
		for (Intervallo intervallo : soluzione) {
			System.out.println(intervallo);
		}
	}

}
