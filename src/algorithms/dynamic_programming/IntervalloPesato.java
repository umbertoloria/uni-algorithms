package algorithms.dynamic_programming;

public final class IntervalloPesato extends Intervallo {

	final int peso;

	public IntervalloPesato(String nome, int inizio, int fine, int peso) {
		super(nome, inizio, fine);
		this.peso = peso;
	}

	public String toString() {
		return "[" + nome + ": dalle " + inizio + " alle " + fine + ", peso " + peso + "]";
	}

}
