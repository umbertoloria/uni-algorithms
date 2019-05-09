package algorithms.dynamic_programming.scheduling_intervalli_pesati;

import sorting.MergeSort;
import structures.LList;

////////////////////////////////////////////////////////////////////
//    Scheduling di intervalli pesati                             //
////////////////////////////////////////////////////////////////////
//                                                                //
//    WIS(i) = {                                                  //
//                  0,                                if i = 0    //
//                  max {                                         //
//                           v(i) + WIS(p(i)),        if i > 0    //
//                           WIS(i - 1)               if i > 0    //
//                  }                                             //
//    }                                                           //
//                                                                //
////////////////////////////////////////////////////////////////////

public class Scheduling {

	private LList<Intervallo> intervalli = new LList<>();
	private Intervallo[] lastSortedIntervalli;
	private int[] lastPrecedente;
	private int[] lastComputed;

	public void add(Intervallo intervallo) {
		intervalli.append(intervallo);
	}

	public void ottimale() {
		Intervallo[] intervalli = this.intervalli.toArray(new Intervallo[0]);
		assert intervalli != null;
		MergeSort.mergesort(intervalli);
		int[] precedente = new int[intervalli.length];
		for (int i = 0; i < precedente.length; i++) {
			int j;
			for (j = i - 1; j >= 0; j--) {
				if (intervalli[j].fine <= intervalli[i].inizio) {
					break;
				}
			}
			precedente[i] = j;
		}

		int[] m = new int[intervalli.length + 1];
		m[0] = 0;
		for (int i = 1; i < m.length; i++) {
			int v1 = intervalli[i - 1].peso + m[precedente[i - 1] + 1];
			int v2 = m[i - 1];
			m[i] = Math.max(v1, v2);
		}
		lastSortedIntervalli = intervalli;
		lastPrecedente = precedente;
		lastComputed = m;
	}

	public void printTable() {
		for (int i : lastComputed) {
			System.out.printf("| %-2d", i);
		}
		System.out.println("|");
	}

	public Intervallo[] trovaSoluzione() {
		LList<Intervallo> intervalli = new LList<>();
		int i = lastComputed.length - 1;
		while (i > 0) {
			if (lastComputed[i] != lastComputed[i - 1]) {
				Intervallo tmp = lastSortedIntervalli[i - 1];
				System.out.println("Aggiunto intervallo " + tmp.nome);
				intervalli.append(tmp);
				i = lastPrecedente[i - 1] + 1;
			} else {
				i--;
			}
		}
		return intervalli.toArray(new Intervallo[0]);
	}

}
