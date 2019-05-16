package tests.algorithms.greedy;

import algorithms.greedy.Incarico;
import algorithms.greedy.MinimizzazioneRitardo;

public class MinimizzazioneRitardoTests {

	public static void main(String[] args) {
		MinimizzazioneRitardo mr = new MinimizzazioneRitardo();
		mr.add(new Incarico("4", 4, 9));
		mr.add(new Incarico("3", 1, 9));
		mr.add(new Incarico("5", 3, 14));
		mr.add(new Incarico("6", 2, 15));
		mr.add(new Incarico("2", 2, 8));
		mr.add(new Incarico("1", 3, 6));
		mr.trovaSoluzione();
	}

}
