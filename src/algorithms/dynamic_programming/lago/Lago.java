package algorithms.dynamic_programming.lago;

import structures.AList;
import structures.LList;
import structures.List;

//////////////////////////////////////////////////////////////////////////////////////////////
//    Problema del lago                                                                     //
//////////////////////////////////////////////////////////////////////////////////////////////
//                                                                                          //
//    LAGO(i) = {                                                                           //
//                   0,                                  if i = 0                           //
//                   min {                                                                  //
//                            LAGO(j) + p(j, i),        if i > 0 ^ j < i ^ (j, i) esiste    //
//                   }                                                                      //
//    }                                                                                     //
//                                                                                          //
//////////////////////////////////////////////////////////////////////////////////////////////

public class Lago {

	private List<Viaggio> viaggi = new AList<>();

	public void viaggio(Viaggio viaggio) {
		viaggi.append(viaggio);
	}

	private List<Viaggio> incoming(int approdo) {
		List<Viaggio> res = new LList<>();
		for (Viaggio viaggio : viaggi) {
			if (viaggio.destinazione == approdo) {
				res.append(viaggio);
			}
		}
		return res;
	}

	public int vai(int n) {
		int[] m = new int[n + 1];
		m[0] = 0;
		for (int i = 1; i <= n; i++) {
			int min = 0;
			for (Viaggio viaggio : incoming(i)) {
				int contributo = viaggio.prezzo + m[viaggio.partenza];
				if (min == 0 || min > contributo) {
					min = contributo;
				}
			}
			m[i] = min;
		}
		return m[n];
	}

}
