package structures;

public class UndirectGraph<T extends Comparable<T>, V> extends DirectGraph<T, V> {

	public void link(T a, T b, V value) {
		super.link(a, b, value);
		super.link(b, a, value);
	}

}
