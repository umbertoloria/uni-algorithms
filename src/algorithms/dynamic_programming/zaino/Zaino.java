package algorithms.dynamic_programming.zaino;

import algorithms.dynamic_programming.Utils;
import structures.List;

public class Zaino {

	private List<Oggetto> oggetti = new List<>();
	private int[][] lastComputation;

	public void add(Oggetto oggetto) {
		oggetti.append(oggetto);
	}

	/**
	 Complexity: time and space O(nW)
	 */
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
		Utils.printTable(lastComputation);
	}

	public Oggetto[] analisi() {
		List<Oggetto> result = new List<>();
		int w = lastComputation[0].length - 1;
		int i = lastComputation.length - 1;
		while (w > 0) {
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
