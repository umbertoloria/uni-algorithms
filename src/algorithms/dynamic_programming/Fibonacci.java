package algorithms.dynamic_programming;

/////////////////////////////////////////////////////////////
//    Successione di Fibonacci                             //
/////////////////////////////////////////////////////////////
//                                                         //
//    Fib(n) = {                                           //
//                  0,                         if i = 0    //
//                  1,                         if i = 1    //
//                  Fib(n-1) + Fib(n-2)        if n > 1    //
//    }                                                    //
//                                                         //
/////////////////////////////////////////////////////////////

public class Fibonacci {

	/** Complexity: time and space O(n) */
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
