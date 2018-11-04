package containers;

import java.util.*;

public class SlowMap2<K extends Comparable<K>, V> extends AbstractMap<K, V>{
	private List<ComparableMapEntry<K, V>> entryList = new ArrayList<>();

	@SuppressWarnings("unchecked")
	public V get(Object key) {
		if(!(key instanceof Comparable)){
			throw new RuntimeException("key 必须实现Comparable接口!");
		}
		int index = Collections.binarySearch(entryList, new ComparableMapEntry<K, V>((K)key, null));
		if(index < 0) {
			return null;
		}
		ComparableMapEntry<K, V> entry = entryList.get(index);
		return entry.getValue();
	}	

	@SuppressWarnings("unchecked")
	public V put(K key, V value) {
		V oldValue = get(key);
		ComparableMapEntry<K, V> entry = new ComparableMapEntry(key, value);
		if(oldValue != null){
			int index = Collections.binarySearch(entryList, entry);
			entryList.set(index, entry);
		} else {
			entryList.add(entry);
			//重新排序
			Collections.sort(entryList);
		}	
		return oldValue;
	}

	public Set<Map.Entry<K, V>> entrySet() {
		Set<Map.Entry<K, V>> set = new HashSet<>();
		Iterator<ComparableMapEntry<K, V>> it = entryList.iterator();
		while(it.hasNext()) {      
			set.add(it.next());
		}
		return set;
	} 

	public static void main(String[] args) {
		SlowMap2<Integer, Integer> s = new SlowMap2<>();
		s.put(1,200);
		s.put(2,200);
		s.put(3,200);
		System.out.println(s);
	}

}