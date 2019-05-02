package structures;

public class BTree<T> {

	private T value;
	private BTree<T> left, right;

	public BTree(T value) {
		this.value = value;
	}

	public T getValue() {
		return value;
	}

}
