package tests;

import structures.List;

public class ListTests {

	public static void main(String[] args) {
		List<Integer> l = new List<>();
		l.set(0, 5);
		l.set(1, 6);
		l.set(2, 7);
		l.append(10);
		System.out.println(l);
		l.reverse();
		l.remove(1);
		System.out.println(l);
		l.remove(0);
		System.out.println(l);
	}

}
