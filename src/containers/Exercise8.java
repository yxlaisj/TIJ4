package containers;

import java.util.*;

interface SListIterator<T> {
	boolean hasNext();
	T next();
	void remove();
	void add(T element);
}

class SList<T> {
	private final Link header = new Link<T>(null, null);
	SList() {header.next = header;}
	public String toString() {
		StringBuilder buf = new StringBuilder();
		buf.append("[");
		for (SListIterator<T> it = iterator(); it.hasNext();) {
			T element = it.next();
			buf.append(element == this ? "(this SList)" : String.valueOf(element));
			if(it.hasNext()) {
				buf.append(", ");
			}
		}
		buf.append("]");
		return buf.toString();
	}

	public SListIterator<T> iterator() {
		return new SListIteratorImpl();
	}

	private static class Link<T> {
		T element;
		Link<T> next;
		Link(T element, Link<T> next) {
			this.element = element;
			this.next = next;
		}
	}

	private class SListIteratorImpl implements SListIterator<T> {
		private Link<T> lastReturned = header;
		private Link<T> next;
		SListIteratorImpl() {
			next = header.next;
		}
		public boolean hasNext() {
			return next != header;
		}
		public T next() {
			if(next == header) {
				throw new NoSuchElementException();
			}
			lastReturned = next;
			next = next.next;
			return lastReturned.element;
		}
		public void add(T element) {
			lastReturned = header;
			Link<T> newLink = new Link<T>(element, next);
			if(header.next == header) {
				header.next = newLink;
			}else {
				for(Link<T> curr = header; ; curr = curr.next){
					if(curr.next == next){
						curr.next = newLink;
						break;
					}
				}
			}
		}
		public void remove() {
			if(lastReturned == header){
				throw new IllegalStateException();
			}
			for(Link<T> curr = header; ;curr = curr.next){
				if(curr.next == lastReturned){
					curr.next = lastReturned.next;
					break;
				}
			}
		}
	}
}

public class Exercise8 {
	public static void main(String[] args) {
		System.out.println("test");
	}
}



