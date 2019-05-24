package structures;

class HashRow<K, V> {

	private HashItem<K, V> first;

	HashRow(K key, V value) {
		this.first = new HashItem<>(key, value);
	}

	boolean put(K key, V value) {
		HashItem<K, V> app = first;
		while (app.next != null && !app.key.equals(key)) {
			app = app.next;
		}
		if (app.key.equals(key)) {
			app.value = value;
			return false;
		} else {
			app.next = new HashItem<>(key, value);
			return true;
		}
	}

	V get(K key) {
		HashItem<K, V> app = first;
		while (app != null) {
			if (app.key.equals(key)) {
				return app.value;
			}
			app = app.next;
		}
		return null;
	}

	boolean remove(K key) {
		if (first.key.equals(key)) {
			first = first.next;
			return true;
		} else {
			HashItem<K, V> app = first;
			while (app.next != null && !app.next.key.equals(key)) {
				app = app.next;
			}
			if (app.next != null) {
				app.next = app.next.next;
				return true;
			} else {
				return false;
			}
		}
	}

	List<K> keys() {
		List<K> keys = new LList<>();
		HashItem<K, V> app = first;
		while (app != null) {
			keys.append(app.key);
			app = app.next;
		}
		return keys;
	}

	boolean hasKey(K key) {
		HashItem<K, V> app = first;
		while (app != null) {
			if (app.key.equals(key)) {
				return true;
			}
			app = app.next;
		}
		return false;
	}

	void fill(HashTable<K, V> hashTable) {
		HashItem<K, V> app = first;
		while (app != null) {
			hashTable.put(app.key, app.value);
			app = app.next;
		}
	}

	boolean empty() {
		return first == null;
	}

}
