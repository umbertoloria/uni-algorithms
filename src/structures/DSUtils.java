package structures;

import java.util.Iterator;

class DSUtils {

	static void showThroughPositionsList(List<Object[]> lls) {
		int mm = (int) lls.get(0)[0];
		for (Object[] a : lls) {
			mm = Math.max(mm, (int) a[0]);
		}
		for (int i = 1; i <= mm; i++) {
			for (Object[] ll : lls) {
				if ((int) ll[0] == i) {
					System.out.printf("%3s   ", ll[1]);
				} else {
					System.out.print("       ");
				}
			}
			System.out.println();
		}
	}

	static String makeString(Iterator it) {
		StringBuilder result = new StringBuilder("[");
		while (it.hasNext()) {
			result.append(it.next());
			result.append(", ");
		}
		if (result.length() > 1) {
			result.delete(result.length() - 2, result.length());
		}
		result.append("]");
		return result.toString();
	}

}
