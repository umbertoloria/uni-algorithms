package algorithms.dynamic_programming;

import structures.Set;

/////////////////////////////////////////////////////////////////////
//    Problema delle mattonelle                                    //
/////////////////////////////////////////////////////////////////////
//                                                                 //
//    MATT(i) = {                                                  //
//                   0,                              if i =  0     //
//                   min {                                         //
//                            1 + MATT(i-m1),        if i >= m1    //
//                            1 + MATT(i-m2),        if i >= m2    //
//                            ...............        ..........    //
//                            1 + MATT(i-mk),        if i >= mk    //
//                   }                                             //
//    }                                                            //
//                                                                 //
/////////////////////////////////////////////////////////////////////

public class Mattonelle {

	private static final int NONE = -1;
	private Set<Integer> lengths = new Set<>();

	public void add(int length) {
		lengths.add(length);
	}

	/** Qual è il numero minimo di mattonelle di lunghezza data per coprire una lunghezza complessiva n? */
	public int copri(int n) {
		int[] m = new int[n + 1];
		m[0] = 0;
		for (int i = 1; i <= n; i++) {
			int v = NONE;
			for (int matt : lengths) {
				if (i == matt) {
					v = 0;
					break;
				} else if (i > matt) {
					if (m[i - matt] > 0) {
						if (v == NONE) {
							v = m[i - matt];
						} else {
							v = Math.min(v, m[i - matt]);
						}
					}
				}
			}
			if (v != NONE) {
				m[i] = 1 + v;
			}
		}
		return m[n];
	}

}
