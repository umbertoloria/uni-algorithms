package algorithms.greedy;

import sorting.MergeSort;
import structures.AList;

///////////////////////////////////////////////////////////////////////////////////////
//    Minimizzazione del ritardo                                                     //
///////////////////////////////////////////////////////////////////////////////////////
//                                                                                   //
//    Obiettivo: il ritardo massimo deve essere minimale                             //
//    Ipotesi: Si possiede la soluzione greedy ed una soluzione ottimale generica    //
//    Tesi: Anche la soluzione greedy è ottimale                                     //
//    Osservazione: Un'inversione si verifica quando, data una coppia (i, j) di      //
//                  attività adiacenti, i < j ma j viene schedulata prima di i.      //
//                  Risolvere un'inversione significa scambiare le due attività      //
//                  che la formavano, e questo non aumenta il ritardo massimo.       //
//    Dimostrazione:                                                                 //
//                   Partendo dalla soluzione ottimale:                              //
//                    - Se non presenta inversioni allora è uguale alla              //
//                      soluzione greedy, che quindi è ottimale.                     //
//                    - Se presenta delle inversioni allora una volta risolte        //
//                      si avrebbe una soluzione uguale alla soluzione greedy        //
//                      che quindi risulta ottimale.                                 //
//                                                                                   //
///////////////////////////////////////////////////////////////////////////////////////

public class MinimizzazioneRitardo {

	private AList<Incarico> incarichi = new AList<>();

	public void add(Incarico incarico) {
		incarichi.append(incarico);
	}

	public void trovaSoluzione() {
		Incarico[] incarichi = this.incarichi.toArray(new Incarico[0]);
		assert incarichi != null;
		MergeSort.mergesort(incarichi);
		int momento = 0;
		int ritardo = 0;
		for (Incarico incarico : incarichi) {
			System.out.print("Attività " + incarico.nome);
			System.out.print(": dalle " + momento);
			momento += incarico.durata;
			System.out.print(" alle " + momento);
			if (momento - incarico.scadenza > ritardo) {
				ritardo = momento - incarico.scadenza;
				System.out.print(" / ritardata di " + ritardo + " unità");
			}
			System.out.println();
		}
		System.out.println("Ritardo: " + ritardo);
	}

}
