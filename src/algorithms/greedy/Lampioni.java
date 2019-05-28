package algorithms.greedy;

import structures.LList;
import structures.List;

import java.util.Iterator;

public class Lampioni {

	public static List<Integer> minimi(List<Integer> villette, int larghezzaLuce) {
		List.sort(villette);
		Iterator<Integer> it = villette.iterator();
		List<Integer> lampioni = new LList<>();
		Integer last = it.next() + larghezzaLuce / 2;
		lampioni.append(last);
		int fineLuce = last + larghezzaLuce / 2;
		while (it.hasNext()) {
			Integer tmp = it.next();
			if (fineLuce <= tmp) {
				last = tmp + larghezzaLuce / 2;
				lampioni.append(last);
				fineLuce = last + larghezzaLuce / 2;
			}
		}
		return lampioni;
	}

}
