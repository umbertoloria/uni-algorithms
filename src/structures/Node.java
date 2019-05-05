package structures;

class Node<T> {

	T value;
	Node<T> next;

	Node(T value) {
		this.value = value;
	}

	Node(T value, Node<T> next) {
		this.value = value;
		this.next = next;
	}

	Node<T> jump(int times) {
		Node<T> result = this;
		for (int i = 0; i < times; i++) {
			result = result.next;
		}
		return result;
	}

	public String toString() {
		return value.toString();
	}

}
