package structures;

class HashItem<K, V> {

	final K key;
	V value;
	HashItem<K, V> next;

	HashItem(K key, V value) {
		this.key = key;
		this.value = value;
	}

}
