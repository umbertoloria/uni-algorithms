package algorithms.dynamic_programming.zaino;

import algorithms.dynamic_programming.Utils;
import structures.AList;
import structures.LList;
import structures.List;

///////////////////////////////////////////////////////////////////////////////////////
//    Problema dello zaino                                                           //
///////////////////////////////////////////////////////////////////////////////////////
//                                                                                   //
//    ZA(i, w) = {                                                                   //
//                    0,                                     if i = 0                //
//                    ZA(i-1, w)                             if w[i] > w             //
//                    max {                                                          //
//                             v[i] + ZA(i-1, w-w[i])        if w >= w[i] ^ i > 0    //
//                             ZA(i-1, w)                    if w >= w[i] ^ i > 0    //
//                    }                                                              //
//    }                                                                              //
//                                                                                   //
///////////////////////////////////////////////////////////////////////////////////////

public class Zaino {

	private List<Oggetto> oggetti = new AList<>();
	private int[][] lastComputation;

	public void add(Oggetto oggetto) {
		oggetti.append(oggetto);
	}

	/** Complexity: time and space O(nW) */
	public int ruba(int W) {
		int n = oggetti.size();
		int[][] m = new int[n + 1][W + 1];
		for (int w = 0; w <= W; w++) {
			m[0][w] = 0;
		}
		for (int i = 1; i <= n; i++) {
			m[i][0] = 0;
		}
		for (int i = 1; i <= n; i++) {
			for (int w = 1; w <= W; w++) {
				int val = m[i - 1][w];
				Oggetto ogg = oggetti.get(i - 1);
				if (ogg.weight <= w) {
					val = Math.max(val, ogg.value + m[i - 1][w - ogg.weight]);
				}
				m[i][w] = val;
			}
		}
		lastComputation = m;
		return m[n][W];
	}

	public void printTable() {
		String[] oggettiNames = new String[oggetti.size() + 1];
		oggettiNames[0] = "";
		for (int i = 0; i < oggetti.size(); i++) {
			oggettiNames[i + 1] = oggetti.get(i).name;
		}
		String[] pesiNames = new String[lastComputation[0].length];
		for (int i = 0; i < pesiNames.length; i++) {
			pesiNames[i] = i + "";
		}
		Utils.printTable(lastComputation, oggettiNames, pesiNames);
	}

	public Oggetto[] analisi() {
		List<Oggetto> result = new LList<>();
		int w = lastComputation[0].length - 1;
		int i = lastComputation.length - 1;
		while (lastComputation[i][w] > 0) {
			if (lastComputation[i][w] != lastComputation[i - 1][w]) {
				Oggetto oggetto = oggetti.get(i - 1);
				result.append(oggetto);
				w -= oggetto.weight;
			}
			i--;
		}
		return result.toArray(new Oggetto[0]);
	}

}
