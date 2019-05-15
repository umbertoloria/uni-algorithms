package tests.algorithms.interval;

import algorithms.interval.Classe;
import algorithms.interval.PartizionamentoIntervalli;
import algorithms.interval.Intervallo;

public class PartizionamentoIntervalliTests {

	public static void main(String[] args) {
		PartizionamentoIntervalli ip = new PartizionamentoIntervalli();
		ip.add(new Intervallo("C", 9, 10.5));
		ip.add(new Intervallo("B", 9, 12.5));
		ip.add(new Intervallo("A", 9, 10.5));
		ip.add(new Intervallo("E", 11, 14));
		ip.add(new Intervallo("D", 11, 12.5));
		ip.add(new Intervallo("G", 13, 14.5));
		ip.add(new Intervallo("F", 13, 14.5));
		ip.add(new Intervallo("H", 14, 16.5));
		ip.add(new Intervallo("J", 15, 16.5));
		ip.add(new Intervallo("I", 15, 16.5));
		Classe[] classi = ip.trovaSoluzione();
		char primaClasse = 'A';
		for (Classe classe : classi) {
			System.out.println("Classe " + primaClasse++);
			for (Intervallo intervallo : classe) {
				System.out.println(intervallo);
			}
			System.out.println();
		}
	}

}
