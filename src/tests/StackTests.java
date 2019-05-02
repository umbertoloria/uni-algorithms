package tests;

import structures.Stack;

public class StackTests {

	public static void main(String[] args) {
		Stack<Integer> pila = new Stack<>();
		pila.push(5);
		pila.push(4);
		pila.push(3);
		pila.push(2);
		pila.push(1);
		for (Integer i = pila.pop(); i != null; i = pila.pop()) {
			System.out.println(i);
		}
	}

}
