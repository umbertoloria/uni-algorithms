package structures;

class HashSet<V> {

	private HashTable<V, Object> table = new HashTable<>();

	boolean thisIsNew(V item) {
		if (!table.hasKey(item)) {
			table.put(item, new Object());
			return true;
		} else {
			return false;
		}
	}

}
