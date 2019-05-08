package structures;

class DisplayTrees {

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
		System.out.println();
	}

}
