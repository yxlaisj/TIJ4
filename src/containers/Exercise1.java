package containers;

import java.util.*;
import net.mindview.util.*;

public class Exercise1 {
	public static void main(String[] args) {
		List<String> arrayList = new ArrayList<>();
		arrayList.addAll(Countries.names(6));

		List<String> linkedList = new LinkedList<>();
		linkedList.addAll(Countries.names(6));

		System.out.println("ArrayList: " + arrayList);
		System.out.println("linkedList: " + linkedList);

		Collections.shuffle(arrayList);
		System.out.println("ArrayList: " + arrayList);
		Collections.shuffle(linkedList);
		System.out.println("linkedList: " + linkedList);
	}
}