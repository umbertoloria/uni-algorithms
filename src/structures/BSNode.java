package structures;

public class BSNode<T extends Comparable<T>> {

	private T value;
	private BSNode<T> left, right;

	BSNode(T value) {
		this.value = value;
	}

	void put(T item) {
		int cmp = item.compareTo(value);
		if (cmp < 0) {
			if (left != null) {
				left.put(item);
			} else {
				left = new BSNode<>(item);
			}
		} else if (cmp > 0) {
			if (right != null) {
				right.put(item);
			} else {
				right = new BSNode<>(item);
			}
		}
	}

	boolean contains(T item) {
		if (item.compareTo(value) == 0) {
			return true;
		}
		return left != null && left.contains(item) || right != null && right.contains(item);
	}

	void remove(T item) throws UnsupportedOperationException {
		int cmp = item.compareTo(value);
		if (cmp == 0) {
			if (left == null && right == null) {
				throw new UnsupportedOperationException("Dad kill me!");
			} else if (left != null && right != null) {
				value = left.max();
				left.remove(value, this);
			} else {
				BSNode<T> replaced = left != null ? left : right;
				value = replaced.value;
				left = replaced.left;
				right = replaced.right;
			}
		} else if (cmp < 0) {
			left.remove(item, this);
		} else {
			right.remove(item, this);
		}
	}

	private void remove(T item, BSNode<T> parent) {
		int cmp = item.compareTo(value);
		if (cmp < 0) {
			if (left != null) {
				left.remove(item, this);
			}
		} else if (cmp > 0) {
			if (right != null) {
				right.remove(item, this);
			}
		} else {
			if (left != null && right != null) {
				value = left.max();
				left.remove(value, this);
			} else {
				BSNode<T> replaced = left != null ? left : right;
				if (parent.left == this) {
					parent.left = replaced;
				} else if (parent.right == this) {
					parent.right = replaced;
				}
			}
		}
	}

	private T max() {
		BSNode<T> n = this;
		while (n.right != null) {
			n = n.right;
		}
		return n.value;
	}

	LList<Object[]> positionInfo(int level) {
		LList<Object[]> result = new LList<>();
		if (left != null) {
			result.expand(left.positionInfo(level + 1));
		}
		result.append(new Object[]{level, value});
		if (right != null) {
			result.expand(right.positionInfo(level + 1));
		}
		return result;
	}

	public String toString() {
		String result = "";
		if (left != null) {
			result += left;
		}
		result += ", " + value + ", ";
		if (right != null) {
			result += right;
		}
		if (result.startsWith(", ")) {
			result = result.substring(2);
		}
		if (result.endsWith(", ")) {
			result = result.substring(0, result.length() - 2);
		}
		return result;
	}

	int count() {
		int result = 1;
		if (left != null) {
			result += left.count();
		}
		if (right != null) {
			result += right.count();
		}
		return result;
	}

}
