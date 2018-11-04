package containers;

import java.util.*;
import net.mindview.util.*;
import static net.mindview.util.Print.*;

public class ReadOnly {
	static Collection<String> data = new ArrayList<>(Countries.names(6));
	public static void main(String[] args) {
		Collection<String> c = Collections.unmodifiableCollection(new ArrayList<String>(data));
		print(c);	//Reading is OK
		//c.add("One");

		List<String> a = Collections.unmodifiableList(new ArrayList<String>(data));
		ListIterator<String> lit = a.listIterator();
		print(lit.next());	//Reading is OK
		//lit.add("one");

		//For a SortedSet:
		Set<String> ss = Collections.unmodifiableSortedSet(new TreeSet<String>(data));

		Map<String, String> m = Collections.unmodifiableMap(new HashMap<String, String>(Countries.capitals(6)));
		print(m);
		//m.put("Ralph","Howdy!");

		// For a SortedMap:
		Map<String, String> sm = Collections.unmodifiableSortedMap(
			new TreeMap<String, String>(Countries.capitals(6)));
		

	}
}