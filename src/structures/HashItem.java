package structures;

final class HashItem<K extends Comparable<K>, V> implements Comparable<HashItem<K, V>> {

	final K key;
	final V value;

	HashItem(K key, V value) {
		this.key = key;
		this.value = value;
	}

	public int compareTo(HashItem<K, V> o) {
		return key.compareTo(o.key);
	}

}
