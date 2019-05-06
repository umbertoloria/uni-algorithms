package tests.structures;

import structures.List;

public class ListTests {

	public static void main(String[] args) {
		List<Integer> l = new List<>();
		l.set(0, 1);
		l.set(1, 2);
		l.set(2, 3);
		l.append(4);
		System.out.println("list a        : " + l);
		l.reverse();
		System.out.println("a reversed    : " + l);
		l.remove(1);
		System.out.println("a remove at 1 : " + l);
		l.remove(0);
		System.out.println("a remove at 0 : " + l);

		List<Integer> b = new List<>();
		b.append(5);
		b.append(4);
		b.append(2);
		System.out.println("list b        : " + b);

		l.expand(b);
		System.out.println("l expand frm b: " + l);
		List<Integer> c = new List<>();
		System.out.println("list c        : " + c);
		c.expand(b);
		System.out.println("c expand frm b: " + c);
	}

}
