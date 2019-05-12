package structures;

public class UndirectGraph<T extends Comparable<T>, V> extends DirectGraph<T, V> {

	public boolean link(T a, T b, V value) {
		return super.link(a, b, value) && super.link(b, a, value);
	}

}
