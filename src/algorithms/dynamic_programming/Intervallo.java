package algorithms.dynamic_programming;

public class Intervallo implements Comparable<Intervallo> {

	final String nome;
	final double inizio, fine;

	public Intervallo(String nome, double inizio, double fine) {
		this.nome = nome;
		this.inizio = inizio;
		this.fine = fine;
	}

	public int compareTo(Intervallo o) {
		double diff = fine - o.fine;
		if (diff < 0) {
			return -1;
		} else if (diff > 0) {
			return 1;
		} else {
			return 0;
		}
	}

	public String toString() {
		return "[" + nome + ": dalle " + inizio + " alle " + fine + "]";
	}

}
