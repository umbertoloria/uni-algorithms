package tests.dynamic_programming;

import algorithms.dynamic_programming.scheduling_intervalli_pesati.Intervallo;
import algorithms.dynamic_programming.scheduling_intervalli_pesati.Scheduling;

public class SchedulingTests {

	public static void main(String[] args) {
		Scheduling sc = new Scheduling();
		sc.add(new Intervallo("1", 1, 4, 2));
		sc.add(new Intervallo("2", 2, 7, 4));
		sc.add(new Intervallo("3", 5, 10, 4));
		sc.add(new Intervallo("4", 3, 12, 7));
		sc.add(new Intervallo("5", 11, 15, 2));
		sc.add(new Intervallo("6", 11, 16, 1));
		sc.ottimale();
		Intervallo[] soluzione = sc.trovaSoluzione();
		for (Intervallo intervallo : soluzione) {
			System.out.println(intervallo);
		}
	}

}
