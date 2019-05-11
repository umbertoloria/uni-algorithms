package structures;

@SuppressWarnings("unchecked")
public class HashTable<K extends Comparable<K>, V> {

	private static final int MINCAPACITY = 4;
	private Set<HashItem<K, V>>[] data = new Set[MINCAPACITY];
	private int count = 0;

	public void put(K key, V value) {
		int h = hash(key);
		if (data[h] == null) {
			data[h] = new Set<>();
		}
		if (data[h].add(new HashItem<>(key, value))) {
			count++;
			ensureCapacity();
		} else {
			data[h].remove(new HashItem<>(key, null));
			data[h].add(new HashItem<>(key, value));
		}
	}

	private void ensureCapacity() {
		if ((float) count / data.length > 0.7) {
			Set<HashItem<K, V>>[] tmp = data;
			count = 0;
			data = new Set[data.length * 2];
			for (Set<HashItem<K, V>> sublist : tmp) {
				if (sublist != null) {
					for (HashItem<K, V> elem : sublist) {
						put(elem.key, elem.value);
					}
				}
			}
		}
	}

	public V get(K key) {
		Set<HashItem<K, V>> sublist = data[hash(key)];
		if (sublist != null) {
			HashItem<K, V> res = sublist.get(new HashItem<>(key, null));
			if (res != null) {
				return res.value;
			}
		}
		return null;
	}

	public void remove(K key) {
		int h = hash(key);
		Set<HashItem<K, V>> sublist = data[h];
		if (sublist != null) {
			if (sublist.remove(new HashItem<>(key, null))) {
				count--;
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

	public int count() {
		return count;
	}

	public int capacity() {
		return data.length;
	}

	public List<K> keys() {
		List<K> keys = new LList<>();
		for (Set<HashItem<K, V>> sublist : data) {
			if (sublist != null) {
				for (HashItem<K, V> elem : sublist) {
					keys.append(elem.key);
				}
			}
		}
		return keys;
	}

	public boolean hasKey(K key) {
		Set<HashItem<K, V>> sublist = data[hash(key)];
		if (sublist != null) {
			for (HashItem<K, V> elem : sublist) {
				if (elem.key.compareTo(key) == 0) {
					return true;
				}
			}
		}
		return false;
	}

}
