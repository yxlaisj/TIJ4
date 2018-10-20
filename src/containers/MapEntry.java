package containers;

import java.util.*;

public class MapEntry<K, V> implements Map.Entry<K, V> {
	private K key;
	private V value;
	public MapEntry<K, V> next;

	public MapEntry(K key, V value) {
		this.key = key;
		this.value = value;
	}

	public K getKey() {return key;}
	public V getValue() {return value;}
	public boolean hasNext() {return next != null;}
	public V setValue(V v) {
		V result = value;
		value = v;
		return result;
	}

	public int hashCode() {
		return (key == null ? 0 : key.hashCode()) ^ (value == null ? 0: value.hashCode());
	}

	public boolean equals(Object o) {
		if(!(o instanceof MapEntry)) return false;
		MapEntry me = (MapEntry )o;
		return (key == null ? me.getKey() == null : key.equals(me.getKey()))
			&& (value == null ? me.getValue() == null : value.equals(me.getValue()));
	}

	public String toString() {return key + "=" + value;}

	public static void main(String[] args) {
		MapEntry<String, String> e1 = new MapEntry<>("key1", "value1");
		MapEntry<String, String> e2 = new MapEntry<>("key2", "value2");
		MapEntry<String, String> e3 = new MapEntry<>("key3", "value3");
		MapEntry<String, String> e4 = new MapEntry<>("key4", "value4");
		MapEntry<String, String> e5 = new MapEntry<>("key5", "value5");
		e1.next = e2;
		e2.next = e3;
		e3.next = e4;
		e4.next = e5;
		MapEntry<String, String> head = e1;
		while(head.hasNext()){
			System.out.println(head.next);
			head = head.next;
		}
	}

}