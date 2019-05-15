package algorithms.interval;

import sorting.MergeSort;
import structures.AList;
import structures.List;

/////////////////////////////////////////////////////////////////////////////////
//    Scheduling di intervalli normale                                         //
/////////////////////////////////////////////////////////////////////////////////
//                                                                             //
//    Obiettivo: la somma degli intervalli deve essere massimale               //
//    Ipotesi:                                                                 //
//            Soluzione greedy:     Si = {i1, i2, i3, ..., ik}                 //
//            Soluzione generica:   Sj = {j1, j2, j3, ..., jk, ..., jm}        //
//    Tesi: k = m                                                              //
//    Dimostrazione: Poichè greedy sceglie il primo intervallo compatibile:    //
//                   f(i1) <= f(j1), f(i2) <= f(j2), ..., f(ik) <= f(jk)       //
//                   Se esistesse j[k+1] compatibile con j[k] a maggior        //
//                   ragione sarebbe compatibile con ik, e quindi anche        //
//                   l'algoritmo greedy l'avrebbe considerato.                 //
//                                                                             //
/////////////////////////////////////////////////////////////////////////////////

public class SchedulingNormale {

	private AList<Intervallo> intervalli = new AList<>();

	public void add(Intervallo intervallo) {
		intervalli.append(intervallo);
	}

	public Intervallo[] trovaSoluzione() {
		Intervallo[] intervalli = this.intervalli.toArray(new Intervallo[0]);
		if (intervalli == null || intervalli.length == 0) {
			return null;
		}

		MergeSort.mergesort(intervalli);
		Intervallo last = intervalli[0];
		List<Intervallo> soluzione = new AList<>();
		soluzione.append(last);
		for (int i = 1; i < intervalli.length; i++) {
			if (last.fine <= intervalli[i].inizio) {
				last = intervalli[i];
				soluzione.append(last);
			}
		}
		return soluzione.toArray(new Intervallo[0]);
	}

}
