package algorithms.dynamic_programming.scheduling_intervalli_pesati;

public final class Intervallo implements Comparable<Intervallo> {

	final String nome;
	final int inizio, fine;
	final int peso;

	public Intervallo(String nome, int inizio, int fine, int peso) {
		this.nome = nome;
		this.inizio = inizio;
		this.fine = fine;
		this.peso = peso;
	}

	public int compareTo(Intervallo o) {
		return fine - o.fine;
	}

	public String toString() {
		return "[" + nome + ": dalle " + inizio + " alle " + fine + ", peso " + peso + "]";
	}

}
