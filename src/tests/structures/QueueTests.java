package tests.structures;

import structures.Queue;

public class QueueTests {

	public static void main(String[] args) {
		Queue<Integer> coda = new Queue<>();
		coda.push(5);
		coda.push(4);
		coda.push(3);
		coda.push(2);
		coda.push(1);
		System.out.println("Through iterator.");
		for (Integer x : coda) {
			System.out.println(x);
		}
		System.out.println("Through functions.");
		Integer a = coda.pop();
		while (a != null) {
			System.out.println(a);
			a = coda.pop();
		}
	}

}
