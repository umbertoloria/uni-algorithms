package structures;

public class UndirectGraph<T extends Comparable<T>, V extends Comparable<V>> extends DirectGraph<T, V> {

	public boolean link(T from, T to, V weight) {
		return super.link(from, to, weight) && super.link(to, from, weight);
	}

}
