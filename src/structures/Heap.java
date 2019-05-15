package structures;

@SuppressWarnings("unchecked")
class Heap<T extends Comparable<T>> {

	private int ORDER;
	private Object[] data = new Object[200];
	private int size = 0;

	Heap(int order) {
		this.ORDER = order;
	}

	public boolean empty() {
		return size == 0;
	}

	public int size() {
		return size;
	}

	/** Complexity: time O(1) */
	public T peek() {
		return (T) data[0];
	}

	/** Complexity: time O(log n) */
	public void insert(T value) {
		data[size] = value;
		size++;
		heapifyUp();
	}

	/** Complexity: time O(log n) */
	public T extract() {
		T result = (T) data[0];
		size--;
		data[0] = data[size];
		heapifyDown();
		return result;
	}

	private void heapifyUp() {
		int index = size - 1;
		while (hasParent(index) && parent(index).compareTo((T) data[index]) * ORDER > 0) {
			T tmp = (T) data[index];
			data[index] = parent(index);
			data[getParentIndex(index)] = tmp;
			index = getParentIndex(index);
		}
	}

	private void heapifyDown() {
		int index = 0;
		while (hasLeftChild(index)) {
			int smallestChildIndex = getLeftChildIndex(index);
			if (hasRightChild(index) && rightChild(index).compareTo(leftChild(index)) * ORDER < 0) {
				smallestChildIndex++;
			}
			if (((T) data[smallestChildIndex]).compareTo((T) data[index]) * ORDER < 0) {
				T tmp = (T) data[index];
				data[index] = data[smallestChildIndex];
				data[smallestChildIndex] = tmp;
				index = smallestChildIndex;
			} else {
				break;
			}
		}
	}

	public void show() {
		DSUtils.showThroughPositionsList(positionInfo(0, 1));
	}

	private LList<Object[]> positionInfo(int indexNode, int level) {
		if (0 <= indexNode && indexNode < size) {
			LList<Object[]> result = new LList<>();
			result.expand(positionInfo(getLeftChildIndex(indexNode), level + 1));
			result.append(new Object[]{level, data[indexNode]});
			result.expand(positionInfo(getRightChildIndex(indexNode), level + 1));
			return result;
		} else {
			return new LList<>();
		}
	}

	private int getLeftChildIndex(int parentIndex) {
		return 2 * parentIndex + 1;
	}

	private int getRightChildIndex(int parentIndex) {
		return 2 * parentIndex + 2;
	}

	private int getParentIndex(int childIndex) {
		return (childIndex - 1) / 2;
	}

	private boolean hasLeftChild(int index) {
		return getLeftChildIndex(index) < size;
	}

	private boolean hasRightChild(int index) {
		return getRightChildIndex(index) < size;
	}

	private boolean hasParent(int index) {
		return getParentIndex(index) >= 0;
	}

	private T leftChild(int index) {
		return (T) data[getLeftChildIndex(index)];
	}

	private T rightChild(int index) {
		return (T) data[getRightChildIndex(index)];
	}

	private T parent(int index) {
		return (T) data[getParentIndex(index)];
	}

}
