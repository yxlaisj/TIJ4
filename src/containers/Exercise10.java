package containers;

import java.util.*;

@SuppressWarnings("unchecked")
class CustomSortedSet<T> implements SortedSet<T> {
	private List<T> list;
	public CustomSortedSet() {list = new LinkedList<T>();}
	private CustomSortedSet(List<T> list) {
		this.list = list;
	}
	
	public T last() {
		return list.get(list.size() - 1);
	}

	public T first() {
		return list.get(0);
	}
	public SortedSet<T> tailSet(T from) {
		return subSet(from, last());
	}
	public SortedSet<T> headSet(T to) {
		return subSet(first(), to);
	}
	public SortedSet<T> subSet(T from, T to) {
		return new CustomSortedSet(list.subList(list.indexOf(from), list.indexOf(to)));
	}
	public Comparator<T> comparator() {return null;}
	public void clear() {
		list.clear();
	}
	public boolean remove(Object o) {
		return list.remove(o);
	}
	public boolean removeAll(Collection<?> c) {
		return list.removeAll(c);
	}
	public boolean retainAll(Collection<?> c) {
		return list.retainAll(c);
	}
	public boolean add(T e) {
		return list.add(e);
	}
	public boolean addAll(Collection<? extends T> c) {
		return list.addAll(c);
	}
	public boolean containsAll(Collection<?> c) {
		return list.containsAll(c);
	}
	public Object[] toArray() {
		return list.toArray();
	}
	public <T> T[] toArray(T[] a) {
		return list.toArray(a);
	}
	public Iterator<T> iterator() {
		return list.iterator();
	}
	public boolean contains(Object o) {
		return list.contains(o);
	}
	public boolean isEmpty(){
		return list.isEmpty();
	}
	public int size() {
		return list.size();
	}
	public String toString() {
		return list.toString();
	}

}

public class Exercise10 {
	public static void main(String[] args) {
		SortedSet<String> customSortedSet = new CustomSortedSet<>();
		customSortedSet.add("a");
		customSortedSet.add("b");
		customSortedSet.add("c");
		customSortedSet.add("d");
		System.out.println(customSortedSet);
		System.out.println(customSortedSet.first());
		System.out.println(customSortedSet.headSet("c"));
	}
} 