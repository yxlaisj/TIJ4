package containers;

import java.util.*;

public class SimpleHashSet<E> {
	
	private final static int SIZE = 997;
	@SuppressWarnings("unchecked")
	private LinkedList<E>[] buckets = new LinkedList[SIZE];

	public boolean add(E e) {
		int index = Math.abs(e.hashCode()) % SIZE;
		if(buckets[index] == null){
			buckets[index] = new LinkedList<E>();
		}
		LinkedList<E> bucket = buckets[index];
		ListIterator<E> lit = bucket.listIterator();
		while(lit.hasNext()) {
			if(lit.next().equals(e))
				return false;
		}
		lit.add(e);
		return true;
	}

	public boolean contains(Object key) {
		int index = Math.abs(key.hashCode()) % SIZE;
		if(buckets[index] != null){
			for(E e : buckets[index]) {
				if(key.equals(e)) {
					return true;
				}
			}
		}
		return false;
	}

	public int size() {
		int sz = 0;
		for(LinkedList<E> list : buckets){
			if (list != null) {
				sz += list.size();
			}
		}
		return sz;
	}

	public Iterator<E> Iterator() {
		return new Iterator<E>() {
			private int count;
			private boolean canRemove;
			private int index1, index2;
			public boolean hasNext() {return count < size();}
			public E next() {
				if(hasNext()) {
					canRemove = true;
					++count;
					for (; ; ) {
						while(buckets[index1] == null){
							++index1;
						}
						try {
							return buckets[index1].get(index2++);
						} catch(IndexOutOfBoundsException e) {
							++index1;
							index2 = 0;
						}
					}
				}
				throw new NoSuchElementException();
			}

			public void remove() {
				if(canRemove) {
					canRemove = false;
					buckets[index1].remove(--index2);
					if (buckets[index1].isEmpty()) {
						buckets[index1++] = null;
					}
					--count;
				}
			}

		};
	}

}