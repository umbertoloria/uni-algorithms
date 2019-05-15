package tests.structures;

import structures.Stack;

public class StackTests {

	public static void main(String[] args) {
		Stack<Integer> pila = new Stack<>();
		pila.push(50);
		pila.push(40);
		pila.push(30);
		pila.push(20);
		pila.push(10);
		System.out.println("Through iterator.");
		for (Integer x : pila) {
			System.out.println(x);
		}
		System.out.println("Through functions.");
		for (Integer i = pila.pop(); i != null; i = pila.pop()) {
			System.out.println(i);
		}
		if (pila.empty()) {
			System.out.println("Now it's empty");
		}
		System.out.println("Inserted 40");
		pila.push(40);
		System.out.println("Topped " + pila.top());
		System.out.println("Its size is " + pila.size());
	}

}
