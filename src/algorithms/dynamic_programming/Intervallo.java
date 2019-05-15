package algorithms.dynamic_programming;

public class Intervallo implements Comparable<Intervallo> {

	final String nome;
	final int inizio, fine;

	public Intervallo(String nome, int inizio, int fine) {
		this.nome = nome;
		this.inizio = inizio;
		this.fine = fine;
	}

	public int compareTo(Intervallo o) {
		return fine - o.fine;
	}

	public String toString() {
		return "[" + nome + ": dalle " + inizio + " alle " + fine + "]";
	}

}
