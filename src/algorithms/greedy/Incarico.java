package algorithms.greedy;

public final class Incarico implements Comparable<Incarico> {

	final String nome;
	final int durata;
	final int scadenza;

	public Incarico(String nome, int durata, int scadenza) {
		this.nome = nome;
		this.durata = durata;
		this.scadenza = scadenza;
	}

	public int compareTo(Incarico o) {
		return scadenza - o.scadenza;
	}

}
