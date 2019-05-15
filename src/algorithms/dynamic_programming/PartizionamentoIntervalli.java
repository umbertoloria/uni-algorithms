package algorithms.dynamic_programming;

import sorting.MergeSort;
import structures.AList;

///////////////////////////////////////////////////////////////////////////////////////////////////////
//    Partizionamento di intervalli                                                                  //
///////////////////////////////////////////////////////////////////////////////////////////////////////
//                                                                                                   //
//    Obiettivo: Il numero di classi usate deve essere minimale                                      //
//    Tesi: L'algoritmo greedy è ottimale                                                            //
//    Dimostrazione: La classe d è necessaria perché bisognava schedulare un intervallo 'x'          //
//                   che era incompatibile con gli intervalli delle d-1 classi.                      //
//                   Se si verificano incompatibilità è solo per la presenza di intervalli           //
//                   che iniziano prima di x (visto che valutiamo in ordine di inizio crescente).    //
//                   Se ci sono d intervalli incompatibili allora sono necessarie d classi           //
//                   per schedularli, e quindi la nostra soluzione è ottimale.                       //
//                                                                                                   //
///////////////////////////////////////////////////////////////////////////////////////////////////////

public class PartizionamentoIntervalli {

	private AList<Intervallo> intervalli = new AList<>();

	public void add(Intervallo intervallo) {
		intervalli.append(intervallo);
	}

	public Classe[] trovaSoluzione() {
		Intervallo[] intervalli = this.intervalli.toArray(new Intervallo[0]);
		if (intervalli == null || intervalli.length == 0) {
			return null;
		}

		MergeSort.mergesort(intervalli, (o1, o2) -> {
			double diff = o1.inizio - o2.inizio;
			if (diff < 0) {
				return -1;
			} else if (diff > 0) {
				return 1;
			} else {
				return 0;
			}
		});

		AList<Classe> classi = new AList<>();
		for (Intervallo intervallo : intervalli) {
			boolean areClassesBusy = true;
			for (Classe classe : classi) {
				if (classe.compatibile(intervallo)) {
					classe.add(intervallo);
					areClassesBusy = false;
					break;
				}
			}
			if (areClassesBusy) {
				Classe newclasse = new Classe();
				newclasse.add(intervallo);
				classi.append(newclasse);
			}
		}
		return classi.toArray(new Classe[0]);
	}

}
