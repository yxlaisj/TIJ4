package containers;

import java.util.*;
import net.mindview.util.*;

public class Exercise23 {

	public static class SimpleHashMap2<K, V> extends SimpleHashMap<K, V> {
		public int size() {
			int sz = 0;
			for(LinkedList<MapEntry<K,V>> bucket : buckets) {
				if(Objects.nonNull(bucket)){
					sz += bucket.size();
				}
			}
			return sz;
		}

		public boolean isEmpty() {
			for(LinkedList<MapEntry<K,V>> bucket : buckets){
				if(Objects.nonNull(bucket))
					return false;
			}
			return true;
		}

		public boolean containsKey(Object key) {
			int index = Math.abs(key.hashCode()) % buckets.length;
			if(null == buckets[index]){
				return false;
			}
			for(MapEntry<K,V> entry : buckets[index]){
				if(entry.getKey().equals(key)){
					return true;
				}
			}
			return false;
		}

	}



	public static void main(String[] args) {
		SimpleHashMap2<String, String> m = new SimpleHashMap2<>();
		m.putAll(Countries.capitals(10));
		System.out.println("m.size() = " + m.size());
		System.out.println("m.isEmpty() = " + m.isEmpty());
		m.clear();
		System.out.println("m.isEmpty() = " + m.isEmpty());
		System.out.println("m.containsKey() = " + m.containsKey("test"));
		m.put("test","value");
		System.out.println("m.containsKey() = " + m.containsKey("test"));
	}
}

