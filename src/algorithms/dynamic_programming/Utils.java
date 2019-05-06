package algorithms.dynamic_programming;

public class Utils {

	public static void printTable(int[][] m) {
		int cols = m[0].length;
		System.out.print("+");
		for (int i = 0; i < cols; i++) {
			System.out.print("----");
		}
		System.out.println("+");
		for (int[] row : m) {
			System.out.print("|");
			for (int col : row) {
				System.out.printf(" %-2d ", col);
			}
			System.out.println("|");
		}
		System.out.print("+");
		for (int i = 0; i < cols; i++) {
			System.out.print("----");
		}
		System.out.println("+");
	}

}
