package tests.algorithms;

import algorithms.Permutations;

public class PermutationsTests {

	public static void main(String[] args) {
		for (String abc : Permutations.get("abc")) {
			System.out.println(abc);
		}
	}

}
