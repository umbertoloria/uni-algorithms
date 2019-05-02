package structures;

import java.util.ArrayList;

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
		ArrayList<Object[]> lls = root.positionInfo(1);
		int mm = (int) lls.get(0)[0];
		for (Object[] a : lls) {
			mm = Math.max(mm, (int) a[0]);
		}
		for (int i = 1; i <= mm; i++) {
			for (Object[] ll : lls) {
				if ((int) ll[0] == i) {
					System.out.printf("%3s   ", ll[1]);
				} else {
					System.out.print("       ");
				}
			}
			System.out.println();
		}
		System.out.println();
	}

}
