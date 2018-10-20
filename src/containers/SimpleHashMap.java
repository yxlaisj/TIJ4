package containers;

import java.util.*;
import net.mindview.util.*;

public class SimpleHashMap<K, V> extends AbstractMap<K, V> {
	//Choose a prime number for the hash table size,
	//to achieve a uniform distribution:
	private static final int SIZE = 997;

	//You can not hava a physical array of generics,
	//but you can upcast to one:
	// @SuppressWarnings("unchecked")
	// protected LinkedList<MapEntry<K, V>>[] buckets = new LinkedList[SIZE];
	@SuppressWarnings("unchecked")
	protected MapEntry<K,V>[] buckets = new MapEntry[SIZE];

	public Set<Map.Entry<K, V>> entrySet() {
		Set<Map.Entry<K, V>> set = new HashSet<>();
		for (MapEntry<K, V> bucket : buckets) {
			if (Objects.nonNull(bucket)) {
				set.add(bucket);
				for (; bucket.hasNext(); ) {
					set.add(bucket.next);
					bucket = bucket.next;
				}
			}
		}
		return set;
	}

	public V put(K key, V value) {
		V oldValue = null;
		int index = Math.abs(key.hashCode()) % SIZE;
		if (Objects.isNull(buckets[index])) {
			buckets[index] = new MapEntry<K, V>(key, value);
			return null;
		}
		MapEntry<K, V> head = buckets[index];	
		boolean found = false;
		int probes = 0;
		while(head != null) {
			if (head.getKey().equals(key)) {
				found = true;
				oldValue = head.getValue();
				head.setValue(value);
				break;
			}
			head = head.next;
			probes++;
		}

		if (!found) {
			head = new MapEntry<K, V>(key, value);
		}

		if(probes > 0) {
			System.out.println("Probes : " + probes);
		}

		return oldValue;
	}

	public V get(Object key) {
		int index = Math.abs(key.hashCode()) % SIZE;
		System.out.println("get index : " + index);
		MapEntry<K, V> head = buckets[index];
		if(Objects.isNull(head)) {
			return null;
		}
		do {
			if(head.getKey().equals(key)) {
				return head.getValue();
			}
			head = head.next;
		} while(head != null);
		
		return null;
	}

	@SuppressWarnings("unchecked")
	public void clear() {
		buckets = new MapEntry[SIZE];
	}
	@SuppressWarnings("unchecked")
	public V remove(Object key) {
		if(null != key) {
			int index = Math.abs(key.hashCode()) % SIZE;
			System.out.println("remove index : " + index);
			MapEntry<K, V> head = buckets[index];
			if (head == null) {
				System.out.println("Not found key!");
				return null;
			}
			if(key.equals(head.getKey())) {
				V oldValue = head.getValue();
				buckets[index] = head.next;
				return oldValue;
			}
			while(head.hasNext()) {
				if(key.equals(head.next.getKey())){
					V oldValue = head.next.getValue();
					MapEntry<K, V> temp = head.next;
					head.next = null;
					head.next = temp.next;
					return oldValue;
				}
			}

			return null;
		}else {
			return null;
		}
	}

	public static void main(String[] args) {
		SimpleHashMap<String, String> m = new SimpleHashMap<>(); 
		m.putAll(Countries.capitals(25));
		System.out.println(m);
		System.out.println(m.get("GHANA"));
		System.out.println(m.remove("GHANA"));
		System.out.println(m);
	}
}