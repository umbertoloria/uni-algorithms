package algorithms.dynamic_programming;

import structures.AList;

import java.util.Iterator;

public class Classe implements Iterable<Intervallo> {

	private AList<Intervallo> intervalli = new AList<>();

	public void add(Intervallo intervallo) {
		intervalli.append(intervallo);
	}

	boolean compatibile(Intervallo intervallo) {
		for (Intervallo intervallo1 : intervalli) {
			if (intervallo1.fine > intervallo.inizio) {
				return false;
			}
		}
		return true;
	}

	public String toString() {
		return intervalli.toString();
	}

	public Iterator<Intervallo> iterator() {
		return intervalli.iterator();
	}

}
