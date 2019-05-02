package structures;

public class Stack<T> {

	private Node<T> first;
	private int size = 0;

	public void push(T value) {
		first = new Node<>(value, first);
		size++;
	}

	public T pop() {
		if (first == null) {
			return null;
		}
		size--;
		T result = first.value;
		first = first.next;
		return result;
	}

	public T top() {
		return first != null ? first.value : null;
	}

	public boolean empty() {
		return first == null;
	}

	public int size() {
		return size;
	}

}
