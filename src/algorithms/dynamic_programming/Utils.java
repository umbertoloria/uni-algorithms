package algorithms.dynamic_programming;

public class Utils {

	public static void printTable(int[][] m, String[] rowNames, String[] colNames) {
		int maxRowsName = 0;
		for (String rowName : rowNames) {
			maxRowsName = Math.max(maxRowsName, rowName.length());
		}
		int cols = m[0].length;
		putLine(maxRowsName, cols);
		putHeader(maxRowsName, colNames);
		putLine(maxRowsName, cols);
		int i = 0;
		for (int[] row : m) {
			String managedRowName = " ".repeat(maxRowsName - rowNames[i].length()) + rowNames[i];
			i++;
			System.out.print("| " + managedRowName + " |");
			for (int col : row) {
				System.out.printf(" %-2d ", col);
			}
			System.out.println("|");
		}
		putLine(maxRowsName, cols);
	}

	private static void putHeader(int offset, String[] colNames) {
		System.out.print("|" + " ".repeat(offset + 2) + "|");
		for (String colName : colNames) {
			System.out.printf(" %-2s ", colName);
		}
		System.out.println("|");
	}

	private static void putLine(int offset, int cols) {
		System.out.print("+" + "-".repeat(offset + 2) + "+");
		for (int i = 0; i < cols; i++) {
			System.out.print("----");
		}
		System.out.println("+");
	}

}
