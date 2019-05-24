package structures;

@SuppressWarnings("unchecked")
public class HashTable<K, V> {

	private static final int MINCAPACITY = 4;
	private HashRow<K, V>[] data = new HashRow[MINCAPACITY];
	private int count = 0;

	public void put(K key, V value) {
		int h = hash(key);
		if (data[h] == null) {
			data[h] = new HashRow<>(key, value);
			count++;
		} else if (data[h].put(key, value)) {
			count++;
			ensureCapacity();
		}
	}

	private void ensureCapacity() {
		if ((float) count / data.length > 0.7) {
			HashRow<K, V>[] tmp = data;
			count = 0;
			data = new HashRow[tmp.length * 2];
			for (HashRow<K, V> sublist : tmp) {
				if (sublist != null) {
					sublist.fill(this);
				}
			}
		}
	}

	public V get(K key) {
		HashRow<K, V> sublist = data[hash(key)];
		if (sublist != null) {
			return sublist.get(key);
		} else {
			return null;
		}
	}

	public void remove(K key) {
		int h = hash(key);
		if (data[h] != null) {
			if (data[h].remove(key)) {
				count--;
				if (data[h].empty()) {
					data[h] = null;
				}
			}
		}
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
		return count;
	}

	public int capacity() {
		return data.length;
	}

	public List<K> keys() {
		List<K> keys = new LList<>();
		for (HashRow<K, V> sublist : data) {
			if (sublist != null) {
				keys.expand(sublist.keys());
			}
		}
		return keys;
	}

	public boolean hasKey(K key) {
		HashRow<K, V> sublist = data[hash(key)];
		if (sublist != null) {
			return sublist.hasKey(key);
		} else {
			return false;
		}
	}

}
