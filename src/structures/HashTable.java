package structures;

public class HashTable<K, V> {

	private static final int MINCAPACITY = 4;
	@SuppressWarnings("unchecked")
	private Node<Pair<K, V>>[] data = new Node[MINCAPACITY];
	private int size = 0;

	public void put(K key, V value) {
		int h = hash(key);
		if (data[h] == null) {
			data[h] = new Node<>(new Pair<>(key, value));
		} else {
			Node<Pair<K, V>> app = data[h];
			while (app.next != null) {
				if (app.value.first.equals(key)) {
					return; // Chiave occupata.
				}
				app = app.next;
			}
			if (app.value.first.equals(key)) {
				return; // Chiave occupata.
			}
			app.next = new Node<>(new Pair<>(key, value));
		}
		size++;
		ensureCapacity();
	}

	@SuppressWarnings("unchecked")
	private void ensureCapacity() {
		if ((float) size / data.length > 0.7) {
			Node<Pair<K, V>>[] tmp = data;
			size = 0;
			data = new Node[data.length*2];
			for (Node<Pair<K, V>> sublist : tmp) {
				while (sublist != null) {
					put(sublist.value.first, sublist.value.second);
					sublist = sublist.next;
				}
			}
		}
	}

	public V get(K key) {
		Node<Pair<K, V>> node = data[hash(key)];
		while (node != null && node.value.first != key) {
			node = node.next;
		}
		if (node != null) {
			return node.value.second;
		}
		return null;
	}

	public void remove(K key) {
		int h = hash(key);
		Node<Pair<K, V>> node = data[h];
		if (node != null) {
			if (node.value.first == key) {
				data[h] = node.next;
			} else if (node.next != null) {
				while (node.next != null && node.next.value.first != key) {
					node = node.next;
				}
				if (node.next != null) {
					node.next = node.next.next;
				}
			}
		}
		size--;
	}

	private int hash(K key) {
		int capacity = data.length;
		int hash = key.hashCode() % data.length;
		while (hash < 0) {
			hash = capacity + hash;
		}
		return hash;
	}

	public int size() {
		return size;
	}

	public int capacity() {
		return data.length;
	}

}
