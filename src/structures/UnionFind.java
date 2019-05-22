package structures;

public class UnionFind<T> {

	private class MiniSet {

		private Node first, last;

		MiniSet(T value) {
			first = last = new Node(value);
		}

		private boolean contains(T value) {
			if (first.value.equals(value)) {
				return true;
			} else {
				for (Node tmp = first.next; tmp != null; tmp = tmp.next) {
					if (tmp.value.equals(value)) {
						return true;
					}
				}
				return false;
			}
		}

		private void expand(MiniSet second) {
			last = last.next = second.first;
		}

		private void show() {
			for (Node tmp = first; tmp != null; tmp = tmp.next) {
				System.out.println(tmp.value);
			}
		}

		public String toString() {
			StringBuilder res = new StringBuilder("[");
			for (Node tmp = first; tmp != null; tmp = tmp.next) {
				res.append(tmp.value);
				res.append(", ");
			}
			if (res.length() > 1) {
				res.delete(res.length() - 2, res.length());
			}
			res.append("]");
			return res.toString();
		}

	}

	private class Node {

		private Node next;
		private T value;

		Node(T value) {
			this.value = value;
			this.next = null;
		}

		public String toString() {
			return value.toString();
		}

	}

	private List<MiniSet> sets = new LList<>();

	public void addSet(T singleton) {
		sets.append(new MiniSet(singleton));
	}

	public T find(T item) {
		MiniSet res = containing(item);
		return res != null ? res.first.value : null;
	}

	private MiniSet containing(T value) {
		for (MiniSet set : sets) {
			if (set.contains(value)) {
				return set;
			}
		}
		return null;
	}

	public boolean union(T a, T b) {
		MiniSet first = containing(a);
		MiniSet second = containing(b);
		if (first != null && second != null && first != second) {
			first.expand(second);
			for (int i = 0; i < sets.size(); i++) {
				if (sets.get(i).equals(second)) {
					sets.remove(i);
					break;
				}
			}
			return true;
		} else {
			return false;
		}
	}

	public void show() {
		System.out.println("There are " + sets.size() + " sets");
		int i = 1;
		for (MiniSet set : sets) {
			System.out.println("Set number " + i++);
			set.show();
		}
	}

	public String toString() {
		StringBuilder res = new StringBuilder();
		res.append("{");
		for (MiniSet set : sets) {
			res.append(set.toString());
			res.append(", ");
		}
		if (res.length() > 1) {
			res.delete(res.length() - 2, res.length());
		}
		res.append("}");
		return res.toString();
	}

}


