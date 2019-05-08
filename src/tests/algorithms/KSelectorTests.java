package tests.algorithms;

import algorithms.KSelector;

public class KSelectorTests {

	public static void main(String[] args) {
		KSelector<Integer> s = new KSelector<>();
		s.add(4);
		s.add(1);
		s.add(5);
		s.add(2);
		s.add(3);
		s.add(0);
		s.add(10);
		Integer[] smallests = s.smallest(3, new Integer[0]);
		System.out.println("The smallests:");
		for (Integer item : smallests) {
			System.out.println(item);
		}
		System.out.println("\nThe greatests:");
		Integer[] greatests = s.greatest(3, new Integer[0]);
		for (Integer item : greatests) {
			System.out.println(item);
		}
	}

}
