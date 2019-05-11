package algorithms.dynamic_programming;

//////////////////////////////////////////////////////////////////////////////////////////////
//    Problema dell'allineamento di sequenze                                                //
//////////////////////////////////////////////////////////////////////////////////////////////
//                                                                                          //
//    SA(i, j) = {                                                                          //
//                    j * gap,                                          if i = 0            //
//                    i * gap,                                          if j = 0            //
//                    min {                                                                 //
//                             delta(x[i], y[i]) + SA(i-1, j-1),        if i > 0 ^ j > 0    //
//                             gap + SA(i-1, j),                        if i > 0 ^ j > 0    //
//                             gap + SA(i, j-1),                        if i > 0 ^ j > 0    //
//                    }                                                                     //
//    }                                                                                     //
//                                                                                          //
//////////////////////////////////////////////////////////////////////////////////////////////

public class SequenceAlign {

	private int gap, vv, cc, cv;
	private String lastA, lastB;
	private int[][] lastComputation;

	public SequenceAlign(int gap, int vv, int cc, int cv) {
		this.gap = gap;
		this.vv = vv;
		this.cc = cc;
		this.cv = cv;
	}

	/** Complexity: time and space O(nm) */
	public int distance(String a, String b) {
		int[][] m = new int[a.length() + 1][b.length() + 1];
		for (int j = 0; j <= b.length(); j++) {
			m[0][j] = j * gap;
		}
		for (int i = 0; i <= a.length(); i++) {
			m[i][0] = i * gap;
		}
		for (int i = 1; i <= a.length(); i++) {
			for (int j = 1; j <= b.length(); j++) {
				char x = a.charAt(i - 1);
				char y = b.charAt(j - 1);
				int cost;
				if (x == y) {
					cost = 0;
				} else if (vocale(x) && vocale(y)) {
					cost = vv;
				} else if (!vocale(x) && !vocale(y)) {
					cost = cc;
				} else {
					cost = cv;
				}
				int val = cost + m[i - 1][j - 1];
				val = Math.min(val, gap + m[i - 1][j]);
				val = Math.min(val, gap + m[i][j - 1]);
				m[i][j] = val;
			}
		}
		lastComputation = m;
		lastA = a;
		lastB = b;
		return m[a.length()][b.length()];
	}

	public void analisi() {
		StringBuilder a_composed = new StringBuilder();
		StringBuilder b_composed = new StringBuilder();
		int ai = lastA.length();
		int bi = lastB.length();
		while (ai > 0 || bi > 0) {
			int e = lastComputation[ai][bi];
			if (bi >= 1 && e == lastComputation[ai][bi - 1] + gap) {
				bi--;
				a_composed.append("-");
				b_composed.append(lastB.charAt(bi));
			} else if (ai >= 1 && e == lastComputation[ai - 1][bi] + gap) {
				ai--;
				a_composed.append(lastA.charAt(ai));
				b_composed.append("-");
			} else if (bi > 0 && ai > 0) {
				bi--;
				ai--;
				a_composed.append(lastA.charAt(ai));
				b_composed.append(lastB.charAt(bi));
			}
		}
		a_composed.reverse();
		b_composed.reverse();
		System.out.println(a_composed);
		System.out.println(b_composed);
	}

	public void printTable() {
		String[] aChars = new String[lastA.length() + 1];
		aChars[0] = "";
		for (int i = 0; i < lastA.length(); i++) {
			aChars[i + 1] = lastA.charAt(i) + "";
		}
		String[] bChars = new String[lastB.length() + 1];
		bChars[0] = "";
		for (int i = 0; i < lastB.length(); i++) {
			bChars[i + 1] = lastB.charAt(i) + "";
		}
		Utils.printTable(lastComputation, aChars, bChars);
	}

	private static boolean vocale(char c) {
		c = Character.toLowerCase(c);
		return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
	}

}
