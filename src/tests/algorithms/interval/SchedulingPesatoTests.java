package tests.algorithms.interval;

import algorithms.interval.IntervalloPesato;
import algorithms.interval.SchedulingPesato;

public class SchedulingPesatoTests {

	public static void main(String[] args) {
		SchedulingPesato sc = new SchedulingPesato();
		sc.add(new IntervalloPesato("1", 1, 4, 2));
		sc.add(new IntervalloPesato("2", 2, 7, 4));
		sc.add(new IntervalloPesato("3", 5, 10, 4));
		sc.add(new IntervalloPesato("4", 3, 12, 7));
		sc.add(new IntervalloPesato("5", 11, 15, 2));
		sc.add(new IntervalloPesato("6", 11, 16, 1));
		sc.ottimale();
		IntervalloPesato[] soluzione = sc.trovaSoluzione();
		for (IntervalloPesato intervallo : soluzione) {
			System.out.println(intervallo);
		}
	}

}
