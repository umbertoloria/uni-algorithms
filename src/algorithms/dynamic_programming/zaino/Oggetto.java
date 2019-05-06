package algorithms.dynamic_programming.zaino;

public final class Oggetto {

	public final String name;
	public final int value, weight;

	public Oggetto(String name, int value, int weight) {
		this.name = name;
		this.value = value;
		this.weight = weight;
	}

	public String toString() {
		return "[" + name + ", value: " + value + ", weight: " + weight + "]";
	}

}
