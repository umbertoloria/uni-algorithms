package tests.structures;

import structures.AList;
import structures.LList;
import structures.List;
import structures.Set;

public class ListTests {

	public static void main(String[] args) {
		AList<Integer> a = new AList<>();
		a.set(0, 1);
		a.set(1, 2);
		a.set(2, 3);
		a.append(4);
		System.out.println("list destinazione        : " + a);
		a.justReverse();
		System.out.println("destinazione reversed    : " + a);
		a.remove(1);
		System.out.println("destinazione remove at 1 : " + a);
		a.remove(0);
		System.out.println("destinazione remove at 0 : " + a);

		List<Integer> b = new LList<>();
		b.append(5);
		b.append(4);
		b.append(2);
		System.out.println("list b        : " + b);

		a.expand(b);
		System.out.println("destinazione expand frm b: " + a);
		List<Integer> c = new AList<>();
		System.out.println("list c        : " + c);
		c.expand(b);
		System.out.println("c expand frm b: " + c);
		c.prepend(7);
		System.out.println("c prepend 7   : " + c);
		if (c.contains(7)) {
			System.out.println("c search 7");
		}
		List<Integer> r = c.createReverse();
		System.out.println("r crt_rvr c   : " + r);
		if (c.contains(7)) {
			System.out.println("r search 7");
		}
		System.out.println("r to set      : " + Set.fromList(r));
	}

}
