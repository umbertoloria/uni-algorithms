package structures;

public class BSTree<T extends Comparable<T>> {

	private BSNode<T> root;

	public BSTree(T value) {
		root = new BSNode<>(value);
	}

	public int count() {
		return root.count();
	}

	public void put(T item) {
		root.put(item);
	}

	public boolean contains(T item) {
		return root.contains(item);
	}

	public void remove(T item) {
		try {
			root.remove(item);
		} catch (UnsupportedOperationException e) {
			root = null;
		}
	}

	public String toString() {
		return root.toString();
	}

	public void show() {
		DisplayTrees.showThroughPositionsList(root.positionInfo(1));
	}

}
