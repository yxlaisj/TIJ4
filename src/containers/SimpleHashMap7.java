package containers;

import java.util.*;
import net.mindview.util.*;

@SuppressWarnings("unchecked")
public class SimpleHashMap7<K, V> extends SimpleHashMap<K, V> {
	private int count;	//Number of elements
	private static final double loadFactor = 0.75;
	// Use a prime initial capacity; the JDK uses a number which is a power of 2;
	private final static int initialCapacity = 11;
	private int capacity = initialCapacity;
	private int threshold = (int)(capacity * loadFactor);
	{
		buckets = new MapEntry[capacity];
	}
	@Override
	public V put(K key, V value) {
		V oldValue = null;
		int index = Math.abs(key.hashCode()) % capacity;
		boolean found = false;
		MapEntry<K, V> head = buckets[index];
		MapEntry<K, V> current = head;
		while(head != null){
			if (head.getKey().equals(key)) {
				found = true;
				oldValue = head.getValue();
				head.setValue(value);
				break;
			}
			current = head;
			head = head.next;
		}

		if(!found) {
			if(count >= threshold) {
				rehash();
			}
			if(buckets[index] == null) {
				buckets[index] = new MapEntry<K, V>(key, value);
			}else {
				current.next = new MapEntry<K, V>(key, value);
			}
			++count;
		}
		return oldValue;
	}

	private void rehash() {
		Iterator<Map.Entry<K, V>> it = entrySet().iterator();
		capacity = nextPrime(capacity * 2);
		System.out.println("Rehashing new capacity = " + capacity);
		buckets = new MapEntry[capacity];
		threshold = (int)(capacity * loadFactor);
		count = 0;
		// Fill new buckets
		while(it.hasNext()){
			Map.Entry<K,V> me = it.next();
			put(me.getKey(), me.getValue());
		}
	}

	private int nextPrime(int candidate) {
		while(!isPrime(candidate)) {
			candidate++;
		}
		return candidate;
	}

	private boolean isPrime(int candidate) {
		for (int j = 2; j < candidate; j++) {
			if(candidate % j == 0) {
				return false;
			}
		}
		return true;
	}	
}