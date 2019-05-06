package algorithms.dynamic_programming;

public class Fibonacci {

	/**
	 Complexity: time and space O(n)
	 */
	public static long fibonacci(int n) {
		if (n == 0) {
			return 0;
		}
		long[] M = new long[n + 1];
		M[0] = 0;
		M[1] = 1;
		for (int i = 2; i <= n; i++) {
			M[i] = M[i - 1] + M[i - 2];
		}
		return M[n];
	}

}
