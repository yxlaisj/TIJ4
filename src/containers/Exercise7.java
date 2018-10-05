package containers;

import net.mindview.util.*;
import java.util.*;

public class Exercise7 {
	public static void main(String[] args) {
		List<String> arrayList = new ArrayList<String>(Arrays.asList("A", "B", "C", "D"));
		List<String> linkedList = new LinkedList<>(Arrays.asList("a", "b", "c", "d"));
		printList(arrayList);
		printList(linkedList);

		insert(new ArrayList<String>(arrayList), new LinkedList<String>(linkedList));
		reverseInsert(new ArrayList<String>(arrayList), new LinkedList<String>(linkedList));
	}

	public static void printList(List<String> list) {
		Iterator it = list.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}
		System.out.println();
	}

	public static void insert(List<String> from, List<String> to) {
		ListIterator<String> it1 = from.listIterator();
		ListIterator<String> it2 = to.listIterator();
	
		while(it1.hasNext()) {
			it2.add(it1.next());
			if(it2.hasNext()) {
				it2.next();	
			}
		}	
		System.out.println(to);
	}

	public static void reverseInsert(List<String> from, List<String> to) {
		ListIterator<String> it1 = from.listIterator();

		ListIterator<String> it2 = to.listIterator(to.size() - 1 > -1 ? to.size() - 1 : 0);
	
		while(it1.hasNext()) {
			it2.add(it1.next());
			if(it2.hasPrevious()) {
				it2.previous();	
			}
		}	
		System.out.println(to);
	}
}