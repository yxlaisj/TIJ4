package containers;

import java.util.*;

public class ComparableMapEntry<K extends Comparable<K>, V> implements Map.Entry<K, V>, Comparable<ComparableMapEntry<K, V>> {
	private K key;
	private V value;
	private ComparableMapEntry<K, V> next;

	public ComparableMapEntry(K key, V value) {
		this.key = key;
		this.value = value;
	}

	public K getKey() {return this.key;}
	public V getValue() {return this.value;}
	public boolean hasNext(){return null != next;}

	public V setValue(V v) {
		V result = value;
		value = v;
		return result;
	}

	public int hashCode() {
		return (key == null ? 0 : key.hashCode()) ^ (value == null ? 0 : value.hashCode());
	}

	public boolean equals(Object o) {
		if (o.getClass() != getClass()) {
			return false;
		}
		ComparableMapEntry other = (ComparableMapEntry)o;
		return (key == null ? other.key == null : key.equals(other.key)) 
			&& (value == null ? other.value == null : value.equals(other.value));
	}

	public String toString() {
		return "[" + key + ", " + value + "]";
	}


	public int compareTo(ComparableMapEntry<K, V> other) {
		return key.compareTo(other.key);
	}
}